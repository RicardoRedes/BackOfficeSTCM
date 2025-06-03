package com.stcm.backoffice.bussines;

import java.util.ArrayList;
import java.util.List;

import com.stcm.backoffice.entity.CatTypeTicketingValidation;
import com.stcm.backoffice.entity.CatTypeTitle;
import com.stcm.backoffice.entity.OpeAccess;
import com.stcm.backoffice.entity.OpeAccessDetails;
import com.stcm.backoffice.entity.OpeAfcEquipment;
import com.stcm.backoffice.entity.OpeBlackListSam;
import com.stcm.backoffice.entity.OpeInventoryCard;
import com.stcm.backoffice.entity.OpeTransportStation;
import com.stcm.backoffice.entity.request.AccessRequest;
import com.stcm.backoffice.entity.request.AccessRequest2;
import com.stcm.backoffice.entity.response.AccessResponse;
import com.stcm.backoffice.entity.response.AccessResponse2;
import com.stcm.backoffice.service.BlackListService;
import com.stcm.backoffice.service.DeviceService;
import com.stcm.backoffice.utils.UtilsSTCM;

public class ApiAccess {
	
	public static AccessResponse registerAccess(AccessRequest accessRequest, DeviceService deviceService, BlackListService blackListService) {
		
		AccessResponse response = new AccessResponse();
		
		response.setCode(200);
		response.setStatus(400);
		response.setMessage("ERROR");
		response.setIdCde(accessRequest.getId());
		
		OpeAccess access = deviceService.retrieveAccess(accessRequest.getId(), accessRequest.getStationId(), accessRequest.getDate());
		
		if(access != null) {
			
			response.setIdCde(accessRequest.getId());
			response.setMessage("OK");
			response.setStatus(200);
			response.setDescription("Previous registered access with ID CDE: " + accessRequest.getId() +  ", and ID CC: " + access.getId());
			return response;
		}
		
		
		//OpeTransportStation station = deviceService.retrieveTransportStationById(accessRequest.getStationId());
		OpeAfcEquipment equipment = deviceService.retrieveEquipmentByCodeAndStatus(accessRequest.getEquipmentCode(), 1);
		CatTypeTitle typeTitle = deviceService.retrieveTypeTitleByCodeAndStatus(accessRequest.getTypeTitleCode(), 1);
		CatTypeTicketingValidation typeTicketing = deviceService.retrieveCatTicketingValidation(accessRequest.getTicketingValidationCode(), 1);
		OpeInventoryCard invCard = deviceService.retrieveInventoryCard(accessRequest.getUidCard(), accessRequest.getLogicNumber());
		
		
		if(accessRequest.getId() < 1) {
			response.setDescription("Invalid ID");
			return response;
		}
		
		/*if(station == null) {
			response.setDescription("Station ID is not found");
			return response;
		}
		*/
		if(equipment == null) {
			response.setDescription("Equipment not found");
			return response;
		}
		
		if(typeTitle == null) {
			response.setDescription("Type Title not found");
			return response;
		}
		
		if(typeTicketing == null) {
			//System.out.println("Wait Configuration Cat");
			response.setDescription("Ticketing validation not found");
			return response;
			
		}
		
		if(invCard == null) {
			invCard = new OpeInventoryCard();
			invCard.setUid(accessRequest.getUidCard());
			invCard.setLogic_number(accessRequest.getLogicNumber());
			invCard.setPcn("N/A");
			
		}
		
		//
		
		if(accessRequest.getLogicNumber().isEmpty() || accessRequest.getLogicNumber() == null) {
			response.setDescription("Invalid logic number");
			return response;
		}
		
		
		//Validaciones de uid_card y uid_sam
		if(UtilsSTCM.isHexadecimal(accessRequest.getUidCard()) == false) {
			response.setDescription("Invalid Uid Card");
			return response;
		}
		
		if(UtilsSTCM.isHexadecimal(accessRequest.getUidSam()) == false) {
			response.setDescription("Invalid Uid Sam");
			return response;
			
		}
		
		UtilsSTCM.isHexadecimal(accessRequest.getUidCard());
		
		
		//payment seq
		if(accessRequest.getPaymentSeq() == null) {
			response.setDescription("Invalid payment seq");
			return response;
		}
		
		
		if(accessRequest.getDate() == null) {
			response.setDescription("Invalid transaction date");
			return response;
		}
		
		//hacer constructor en OpeAccess /
		//Crear objeto opeAccess
		
		OpeAccess accesstmp = new OpeAccess(accessRequest, equipment, typeTitle, invCard, typeTicketing);
		
		OpeAccess accessResp = deviceService.insertAccess(accesstmp);
		
		if(accessResp != null) {
			
			OpeAccessDetails accessDetailsTmp = new OpeAccessDetails(accessResp,accessRequest);
			
			OpeAccessDetails accessDetailsResp = deviceService.insertAccessDetails(accessDetailsTmp);
			
			if(accessDetailsResp != null) {
			
				response.setIdCC(accessResp.getId());
				response.setCode(200);
				response.setStatus(200);
				response.setMessage("OK");
				response.setDescription("Registered access with ID CDE: " + accessRequest.getId() + ", and ID CC: " + accessResp.getId());
			}
			
			OpeBlackListSam samInBlackList = blackListService.retrieveBlackListByUidSam(accessRequest.getUidSam());
			
			
			if(invCard.getUid().isEmpty() || invCard.getLogic_number().isEmpty()) {
			   
				ApiBlackList.insertBlackListCard(blackListService, accessRequest, invCard.getPcn(), "STC METRORREY", "0002");
				
			    response.setDescription("Registered access with ID CDE: " + accessRequest.getId() + ", and ID CC: " + accessResp.getId() + "ADDED TO BLCKLIST: 0002");
			
			} else if(samInBlackList != null) {
				
				ApiBlackList.insertBlackListCard(blackListService, accessRequest, invCard.getPcn(), "STC METRORREY", "0002");
				
			    response.setDescription("Registered access with ID CDE: " + accessRequest.getId() + ", and ID CC: " + accessResp.getId() + "ADDED TO BLCKLIST: 0002");

				
			} else if (accessRequest.getBalanceTrips() < 0.0 || accessRequest.getFinalBalanceTrips() < 0.0) {
			
				ApiBlackList.insertBlackListCard(blackListService, accessRequest, invCard.getPcn(), "STC METRORREY", "0006");
			    
				response.setDescription("Registered access with ID CDE: " + accessRequest.getId() + ", and ID CC: " + accessResp.getId() + " ADDED TO BLACKLIST: 0006");
			
			} else if (accessRequest.getBalanceTrips() > 600.0 || accessRequest.getFinalBalanceTrips() > 600.0) {

				ApiBlackList.insertBlackListCard(blackListService, accessRequest, invCard.getPcn(), "STC METRORREY", "0006");
				
				response.setDescription("Registered access with ID CDE: " + accessRequest.getId() + ", and ID CC: " + accessResp.getId() + "ADDED TO BLACKLIST: 0006");
			       
			
			} else if (accessRequest.getBalanceEWallet() < 0.0 || accessRequest.getFinalBalanceEWallet() < 0.0) {
			    
				ApiBlackList.insertBlackListCard(blackListService, accessRequest, invCard.getPcn(), "STC METRORREY", "0006");
			    
				response.setDescription("Registered access with ID CDE: " + accessRequest.getId() + ", and ID CC: " + accessResp.getId() + "ADDED TO BLACKLIST: 0006");

			
			} else if (accessRequest.getBalanceEWallet() > 600.0 || accessRequest.getFinalBalanceEWallet() > 600.0) {
			  
				ApiBlackList.insertBlackListCard(blackListService, accessRequest, invCard.getPcn(), "STC METRORREY", "0006");
				
				response.setDescription("Registered access with ID CDE: " + accessRequest.getId() + ", and ID CC: " + accessResp.getId() + "ADDED TO BLACKLIST: 0006");

			} 
			
		}		
		
		return response;
		
	}

public static AccessResponse2 registerAccess2(AccessRequest2 accessRequest, DeviceService deviceService, BlackListService blackListService) {
		
		AccessResponse2 response = new AccessResponse2();
		
		response.setCode(200);
		response.setStatus(400);
		response.setMessage("ERROR");
		response.setIdCde(accessRequest.getId());
		

		// TODO: se movio esta validacion para antes de realizar la consulta		
		if(accessRequest.getId() < 1) {
			response.setDescription("Invalid ID");
			return response;
		}
		
		if(accessRequest.getLogicNumber().isEmpty() || accessRequest.getLogicNumber() == null) {
			response.setDescription("Invalid logic number");
			return response;
		}

		//Validaciones de uid_card y uid_sam TODO: Se movieron antes de realizar la consulta
		if(UtilsSTCM.isHexadecimal(accessRequest.getUidCard()) == false) {
			response.setDescription("Invalid Uid Card");
			return response;
		}
		
		if(UtilsSTCM.isHexadecimal(accessRequest.getUidSam()) == false) {
			response.setDescription("Invalid Uid Sam");
			return response;
			
		}

		//payment seq
		if(accessRequest.getPaymentSeq() == null) {
			response.setDescription("Invalid payment seq");
			return response;
		}
		
		
		if(accessRequest.getDate() == null) {
			response.setDescription("Invalid transaction date");
			return response;
		}

		// TODO: Eliminarlo
		// UtilsSTCM.isHexadecimal(accessRequest.getUidCard());

		//OpeTransportStation station = deviceService.retrieveTransportStationById(accessRequest.getStationId());
		OpeAfcEquipment equipment = deviceService.retrieveEquipmentByCodeAndStatus(accessRequest.getEquipmentCode(), 1);
		CatTypeTitle typeTitle = deviceService.retrieveTypeTitleByCodeAndStatus(accessRequest.getTypeTitleCode(), 1);
		//CatTypeTicketingValidation typeTicketing = deviceService.retrieveCatTicketingValidation(accessRequest.getTicketingValidationCode(), 1); TODO: se puede quitar esta validacion
		
		OpeInventoryCard invCard = deviceService.retrieveInventoryCard(accessRequest.getUidCard(), accessRequest.getLogicNumber());
		
		/*if(station == null) {
			response.setDescription("Station ID is not found");
			return response;
		}
		*/
		
		if(equipment == null) {
			response.setDescription("Equipment not found");
			return response;
		}
		
		if(typeTitle == null) {
			response.setDescription("Type Title not found");
			return response;
		}
		/* TODO: se quita esta validacion porque no se usa 
		if(typeTicketing == null) {
			//System.out.println("Wait Configuration Cat");
			response.setDescription("Ticketing validation not found");
			return response;
			
		}
		*/

		if(invCard == null) {
			invCard = new OpeInventoryCard();
			invCard.setUid(accessRequest.getUidCard());
			invCard.setLogic_number(accessRequest.getLogicNumber());
			invCard.setPcn("N/A");
			
		}

		// TODO: Revisar esto hasta el ultimo
		/* 
		OpeAccess access = deviceService.retrieveAccess(accessRequest.getId(), accessRequest.getStationId(), accessRequest.getDate());
		
		if(access != null) {
			
			response.setIdCde(accessRequest.getId());
			response.setMessage("OK");
			response.setStatus(200);
			response.setDescription("Previous registered access with ID CDE: " + accessRequest.getId() +  ", and ID CC: " + access.getId());
			return response;
		}
		*/
		

		//hacer constructor en OpeAccess /
		//Crear objeto opeAccess
		// Revisar si code es lo mismo que id
		// TODO: Porque se crea un opeAccess temporal?
		OpeAccess accesstmp = new OpeAccess(accessRequest, equipment, typeTitle, invCard/* , typeTicketing se puede omitir este campo*/);
		
		OpeAccess accessResp = deviceService.insertAccess(accesstmp);
		
		if(accessResp != null) {
			
			//OpeAccessDetails accessDetailsTmp = new OpeAccessDetails(accessResp,accessRequest);
			
			//OpeAccessDetails accessDetailsResp = deviceService.insertAccessDetails(accessDetailsTmp);
			
			/*if(accessDetailsResp != null) {
			
				
			}
			*/

			response.setIdCC((int)accessResp.getId());
			response.setCode(200);
			response.setStatus(200);
			response.setMessage("OK");
			response.setDescription("Registered access with ID CDE: " + accessRequest.getId() + ", and ID CC: " + accessResp.getId());
			// TODO: Estas validaciones se pueden mover al principio?
			
			
			// TODO: codigo muerto nunca va a llegar hasta aqui
			if(invCard.getUid().isEmpty() || invCard.getLogic_number().isEmpty()) {
			   
				ApiBlackList.insertBlackListCard(blackListService, accessRequest, invCard.getPcn(), "STC METRORREY", "0002");
				
			    response.setDescription("Registered access with ID CDE: " + accessRequest.getId() + ", and ID CC: " + accessResp.getId() + "ADDED TO BLCKLIST: 0002");
			
			} else if (accessRequest.getBalanceTrips() < 0.0 || accessRequest.getFinalBalanceTrips() < 0.0) {
			
				ApiBlackList.insertBlackListCard(blackListService, accessRequest, invCard.getPcn(), "STC METRORREY", "0006");
			    
				response.setDescription("Registered access with ID CDE: " + accessRequest.getId() + ", and ID CC: " + accessResp.getId() + " ADDED TO BLACKLIST: 0006");
			
			} else if (accessRequest.getBalanceTrips() > 600.0 || accessRequest.getFinalBalanceTrips() > 600.0) {

				ApiBlackList.insertBlackListCard(blackListService, accessRequest, invCard.getPcn(), "STC METRORREY", "0006");
				
				response.setDescription("Registered access with ID CDE: " + accessRequest.getId() + ", and ID CC: " + accessResp.getId() + "ADDED TO BLACKLIST: 0006");
			       
			
			} else if (accessRequest.getBalanceEWallet() < 0.0 || accessRequest.getFinalBalanceEWallet() < 0.0) {
			    
				ApiBlackList.insertBlackListCard(blackListService, accessRequest, invCard.getPcn(), "STC METRORREY", "0006");
			    
				response.setDescription("Registered access with ID CDE: " + accessRequest.getId() + ", and ID CC: " + accessResp.getId() + "ADDED TO BLACKLIST: 0006");

			
			} else if (accessRequest.getBalanceEWallet() > 600.0 || accessRequest.getFinalBalanceEWallet() > 600.0) {
			  
				ApiBlackList.insertBlackListCard(blackListService, accessRequest, invCard.getPcn(), "STC METRORREY", "0006");
				
				response.setDescription("Registered access with ID CDE: " + accessRequest.getId() + ", and ID CC: " + accessResp.getId() + "ADDED TO BLACKLIST: 0006");

			} 
			
			OpeBlackListSam samInBlackList = blackListService.retrieveBlackListByUidSam(accessRequest.getUidSam());

			if(samInBlackList != null) {
				
				ApiBlackList.insertBlackListCard(blackListService, accessRequest, invCard.getPcn(), "STC METRORREY", "0002");
				
			    response.setDescription("Registered access with ID CDE: " + accessRequest.getId() + ", and ID CC: " + accessResp.getId() + "ADDED TO BLCKLIST: 0002");
			} 
			// 
			
			
		}		
		
		return response;
		
	}

	


}
