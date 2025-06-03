package com.stcm.backoffice.bussines;

import java.sql.Timestamp;

import com.stcm.backoffice.entity.OpeAfcEquipment;
import com.stcm.backoffice.entity.OpeCollection;
import com.stcm.backoffice.entity.OpeInventoryCard;
import com.stcm.backoffice.entity.OpeTransportStation;
import com.stcm.backoffice.entity.request.CollectionRequest;
import com.stcm.backoffice.entity.response.CollectionResponse;
import com.stcm.backoffice.service.CollectionService;
import com.stcm.backoffice.service.DeviceService;

public class ApiCollection {

	public static CollectionResponse getById(CollectionService collectionService, DeviceService deviceService, long id) {

		CollectionResponse response = new CollectionResponse();
		
		response.setCode(200);
		response.setMessage("ERROR");
		response.setStatus(400);
		response.setIdCde(0);
		response.setIdEquipment(0);
		
		
		OpeCollection collection = collectionService.retrieveCollection(id);
		
		OpeAfcEquipment equipment = deviceService.retrieveAfcEquipmentById(collection.getEquipment());
		
		if(collection != null) {
			response.setIdCde(collection.getId_cde());
			response.setIdEquipment(collection.getEquipment());
			
			CollectionRequest request = new CollectionRequest(collection, equipment);
			
			response.setCollection(request);
			response.setIdCC(collection.getId());
			response.setStatus(200);
			response.setMessage("OK");
			response.setDescription("Registered collection with Id PCE = " + collection.getId_cde());
		}
		
		
		
		return response;
	}

	public static CollectionResponse register(CollectionRequest request, CollectionService collectionService, DeviceService deviceService) {
		CollectionResponse response = new CollectionResponse();

		Timestamp initDate;
		Timestamp endDate;
		Timestamp transactionDate;

		response.setCode(200);
		response.setMessage("ERROR");
		response.setStatus(400);
		response.setIdCde(request.getIdCde());
		response.setIdEquipment(request.getIdEquipment());

		OpeAfcEquipment equipment = deviceService.retrieveAfcEquipmentByCode(request.getCodeEquipment());

		if (equipment == null) {
			response.setDescription("Equipment not found");
			return response;
		}

		OpeTransportStation station = deviceService.retrieveTransportStationById(equipment.getId_station());

		if (request.getUidCard().isBlank()) {
			response.setDescription("Invalid uid card");
			return response;
		}

		if (request.getLogicNumber().isBlank()) {
			response.setDescription("Invalid logic number");
			return response;
		}

		if (request.getSecuritySeal().isBlank()) {
			response.setDescription("Invalid security seal");
			return response;
		}

		if (request.getToken().isBlank()) {
			response.setDescription("Invalid token");
			return response;
		}

		if (request.getName().length() > 40) {
			request.setName(request.getName().substring(0, 41));
		}

		try {
			initDate = Timestamp.valueOf(request.getInitDate());
		} catch (Exception e) {
			initDate = null;
		}

		try {
			endDate = Timestamp.valueOf(request.getEndDate());
		} catch (Exception e) {
			endDate = null;
		}

		try {
			transactionDate = Timestamp.valueOf(request.getTransactionDate());
		} catch (Exception e) {
			transactionDate = null;
		}

		if (initDate == null) {
			response.setDescription("Invalid init date");
			return response;
		}

		if (endDate == null) {
			response.setDescription("Invalid end date");
			return response;
		}

		if (transactionDate == null) {
			response.setDescription("Invalid transaction date");
			return response;
		}

		// revisa lista negra

		// TODO: contruir objeto para guardar en base de datos.
		OpeInventoryCard card = deviceService.retrieveInventoryCard(request.getUidCard(), request.getLogicNumber());

		String pcn = new String();

		if (card == null) {
			pcn = "N/A";
		} else {
			pcn = card.getPcn();
		}

		response.setStatus(200);
		response.setMessage("OK");
		response.setDescription("Registered collection with Id PCE = " + request.getIdCde());
		// TODO: guardar objeto
		OpeCollection collectionTemp = new OpeCollection(request, equipment, station, pcn);

		OpeCollection collection = collectionService.insertCollection(collectionTemp);

		if (collection != null) {
			response.setCollection(request);
			response.setIdCC(collection.getId());
		}
		
		return response;
	}

}
