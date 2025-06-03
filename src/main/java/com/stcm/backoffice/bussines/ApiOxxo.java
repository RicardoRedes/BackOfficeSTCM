package com.stcm.backoffice.bussines;

import java.util.List;

import com.stcm.backoffice.entity.OpeAfcEquipment;
import com.stcm.backoffice.entity.OpeBackofficeControl;
import com.stcm.backoffice.entity.OpePlaces;
import com.stcm.backoffice.entity.OpeReaders;
import com.stcm.backoffice.entity.OpeStores;
import com.stcm.backoffice.entity.OpeTransportStation;
import com.stcm.backoffice.entity.request.AfcEquipmentRequest;
import com.stcm.backoffice.entity.request.OxxoStoreRequest;
import com.stcm.backoffice.entity.request.TransportStationRequest;
import com.stcm.backoffice.entity.response.AfcEquipmentResponse;
import com.stcm.backoffice.entity.response.OxxoStoreResponse;
import com.stcm.backoffice.entity.response.TransportStationResponse;
import com.stcm.backoffice.service.DeviceService;

public class ApiOxxo {
	
	public static OxxoStoreResponse insertStore(DeviceService deviceService, OxxoStoreRequest store){
		TransportStationResponse stationResponse = new TransportStationResponse();
		// TODO: clase respuesta
		
		OxxoStoreResponse response = new OxxoStoreResponse();
		
		OpeStores storeTmp = new OpeStores();
		OpeStores storeToSave = new OpeStores();
		OpeStores storeSaved = new OpeStores();
		
		OpeReaders readerToSave = new OpeReaders(); 
		
		OpeBackofficeControl backofficeControlToSave = new OpeBackofficeControl();
		
		response.setCode(200);
		response.setMessage("ERROR");
		response.setStatus(400);
		response.setDescription("Request Invalid");
		
		long stationId = 0;
		long idEquipment = 0;
		String equipmentCode = new String();
		int idSettings = 1;
		long id_store = 0;
		
		/* Verificar si la tienda ya esta dada de alta en el backoffice 	*/
		OpeTransportStation stationTmp = deviceService.retrieveTransportStationByName(store.getCodeStore());
		
		if(stationTmp != null) {
			System.out.println("Tienda ya dada de alta en ope_transpor_station");
			stationId = stationTmp.getId();
			
			//return false;
		} else {
			
			/* Si la tienda no existe, dar de alta			*/
			// Dar de alta tienda en ope_transport_station
			TransportStationRequest station = new TransportStationRequest();
			
			station.setId_line(14);
			station.setName(store.getCodeStore());
			station.setSymbol(null);
			station.setType("0002");
			station.setComment(null);
			station.setStatus(1);
			station.setLatitude((float)0);
			station.setLongitude((float)0);
			station.setUbicationCode(0);
			
			stationResponse = ApiTransportStation.registerStation(station, deviceService);
			
			if(stationResponse.getStatus() != 200) {
				System.out.println("status: " + stationResponse.getStatus()
									+ ", message: " + stationResponse.getMessage()
									+ ", description: " + stationResponse.getDescription());
				
				response.setMessage(stationResponse.getMessage());
				response.setStatus(stationResponse.getStatus());
				response.setDescription(stationResponse.getDescription());
				return response;
			}
			
			stationId = stationResponse.getStation().get(0).getId();
			
		}
		
		
		/* Verificar si existen equipos en esa tienda	*/		
		// getByStationName
		List<OpeAfcEquipment> devicesTemp = deviceService.retrieveAfcEquipmentByStationName(store.getCodeStore());
		
		if(devicesTemp.isEmpty() == false) {
			System.out.println("Tienda ya tiene equipos dados de alta");
			idEquipment = devicesTemp.get(0).getId();
			equipmentCode = devicesTemp.get(0).getCode();
			
		} else {
			/* Si el equipo no exite, dar de alta			*/
			
			
			AfcEquipmentRequest equipment = new AfcEquipmentRequest();
			
			equipment.setIdCompany(1);
			equipment.setIdStation(stationId);
			equipment.setId_unit(null);
			equipment.setCode(null);
			equipment.setType("0010");
			equipment.setMode(null);
			equipment.setState("0001");
			//
			String ip = "172.14."+stationId+".1";
			equipment.setIpAddress(ip);
			equipment.setComment(null);
			//
			String mac = "01:72:14:"+ (int)(stationId/100)+ ":"+ (int)(stationId%100) +":01";
			equipment.setMacAddress(mac);
			equipment.setUserHost("ddt");
			equipment.setPassHost("metroxyz");
			equipment.setPortHost("22");
			equipment.setTelventCode(0);
			
			
			AfcEquipmentResponse equipmentResponse = ApiAfcEquipment.registerAfcEquipment(equipment, deviceService);
			
			if(equipmentResponse.getStatus() != 200) {
				System.out.println("status: " + equipmentResponse.getStatus()
									+ ", message: " + equipmentResponse.getMessage()
									+ ", description: " + equipmentResponse.getDescription());
				
				response.setMessage(stationResponse.getMessage());
				response.setStatus(stationResponse.getStatus());
				response.setDescription(stationResponse.getDescription());
				return response;
			}

			idEquipment = equipmentResponse.getEquipmentList().get(0).getId();
			equipmentCode = equipmentResponse.getEquipmentList().get(0).getCode();
		}
		
		storeTmp = deviceService.retrieveStoresByCode(store.getCodeStore());
		OpePlaces placeTmp = deviceService.retrievePlacesByCode(store.getPlace());
		
		if(placeTmp == null) {
			System.out.println("Plaza no existe");
			
			response.setMessage("ERROR");
			response.setStatus(410);
			response.setDescription("Place not found");
			return response;
		}
		
		if(storeTmp != null) {
			System.out.println("Tienda ya dada de alta en ope_stores");
			
			response.setStore(storeTmp);
			
			response.setMessage("ERROR");
			response.setStatus(411);
			response.setDescription("Store previus registered");
			return response;
		} else {
			// Dar de alta tienda en ope_stores
			
			storeToSave = new OpeStores(store,stationId,placeTmp.getId());
			
			storeSaved = deviceService.insertStore(storeToSave);
			
			if(storeSaved == null) {
				System.out.println("Error en el guardado de la tienda");
				
				response.setStore(storeToSave);
				
				response.setMessage("ERROR");
				response.setStatus(412);
				response.setDescription("Register store failed");
				return response;
			}
			
			id_store = storeSaved.getId();
			
		}
		
		// Dar de alta el lector
		// long idEquipment, String equipmentCode, long id_register_user, int idSettings
		readerToSave = new OpeReaders(id_store, idEquipment, equipmentCode, store.getIdRegisterUser(), idSettings);
		
		OpeReaders readerSaved = deviceService.insertReaders(readerToSave);
		
		if(readerSaved == null) {
			System.out.println("Error en el guardado del lector");
			
			response.setStore(storeToSave);
			response.setReader(readerToSave);
			
			response.setMessage("ERROR");
			response.setStatus(413);
			response.setDescription("Register reader failed");
			return response;
		}
		
		backofficeControlToSave = new OpeBackofficeControl(id_store);
		
		OpeBackofficeControl backofficeControlSaved = deviceService.insertBackofficeControl(backofficeControlToSave);
		
		if(backofficeControlSaved == null) {
			System.out.println("Error en el guardado del control ids");
			
			response.setStore(storeToSave);
			response.setReader(readerToSave);
			response.setControl(backofficeControlToSave);
			
			response.setMessage("ERROR");
			response.setStatus(414);
			response.setDescription("Register control id failed");
			return response;
		}
		// Dar de alta control ids
		
		response.setStore(storeSaved);
		response.setReader(readerSaved);
		response.setControl(backofficeControlSaved);
		
		response.setMessage("OK");
		response.setStatus(200);
		response.setDescription("Save Successful");
		
		return response;
	}

}
