package com.stcm.backoffice.bussines;

import java.util.ArrayList;
import java.util.List;

import com.stcm.backoffice.entity.CatType;
import com.stcm.backoffice.entity.OpeTransportLine;
import com.stcm.backoffice.entity.OpeTransportStation;
import com.stcm.backoffice.entity.request.TransportStationRequest;
import com.stcm.backoffice.entity.response.TransportStation;
import com.stcm.backoffice.entity.response.TransportStationFixed;
import com.stcm.backoffice.entity.response.TransportStationResponse;
import com.stcm.backoffice.service.DeviceService;
import com.stcm.backoffice.utils.UtilsSTCM;

public class ApiTransportStation {

	public static List<TransportStationFixed> getStations(DeviceService deviceService) {

		// Descargar lista de estaciones
		List<OpeTransportStation> stations = deviceService.retrieveStations();

		// Descargar lista de lineas
		List<OpeTransportLine> lines = deviceService.retrieveLines();

		// Crear lista de Objetos TransportStationResponse a devolver
		List<TransportStationFixed> responseList = new ArrayList<TransportStationFixed>();

		int size = stations.size();

		for (int i = 0; i < size; i++) {

			TransportStationFixed response = new TransportStationFixed(stations.get(i), lines);

			responseList.add(response);

		}

		return responseList;

	}

	public static List<TransportStation> getAllStations(DeviceService deviceService) {

		// Descargar lista de estaciones
		List<OpeTransportStation> stationsList = deviceService.retrieveStations();

		// Crear lista de Objetos TransportStationResponse a devolver
		List<TransportStation> responseList = new ArrayList<TransportStation>();

		int size = stationsList.size();

		for (int i = 0; i < size; i++) {

			TransportStation station = new TransportStation(stationsList.get(i));

			responseList.add(station);
		}

		return responseList;
	}

	public static TransportStationResponse registerStation(TransportStationRequest station, DeviceService deviceService) {

		TransportStationResponse response = new TransportStationResponse();

		response.setCode(200);
		response.setMessage("ERROR");
		response.setStatus(400);
		response.setDescription("Request Invalid");

		// TODO: buscar por id de linea
		OpeTransportLine line = deviceService.retrieveLine(station.getId_line());
		
		// buscar tipo de estacion
		CatType typeNode = deviceService.retrieveTypeNode(station.getType());
		
		if(line == null) {
			response.setStatus(401);
			response.setDescription("line Invalid");
			return response;
		}
		
		
		if(typeNode == null) {
			response.setStatus(402);
			response.setDescription("type node Invalid");
			return response;
		}
		
		String tempCode = String.format("%02d", station.getId_line());
		
		station.setCode(tempCode);
		
		OpeTransportStation temp = new OpeTransportStation(station);
		
		OpeTransportStation saved = deviceService.insertStation(temp);
		
		tempCode = String.format("%s%02d", tempCode, saved.getId());
		
		deviceService.updateStation(saved.getId(), tempCode, UtilsSTCM.getDateTime());
		
		if(saved != null) {
			List<OpeTransportStation> stationResp = new ArrayList<OpeTransportStation>();
			stationResp.add(saved);
			
			response.setStation(stationResp);
			response.setMessage("OK");
			response.setStatus(200); 
			response.setDescription("Save Successful");
		}

		return response;
	}
}
