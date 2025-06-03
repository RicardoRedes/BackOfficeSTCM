package com.stcm.backoffice.bussines;

import java.util.List;

import com.stcm.backoffice.entity.OpeInventoryCard;
import com.stcm.backoffice.entity.response.InventoryCardResponse;
import com.stcm.backoffice.service.DeviceService;



public class ApiInventoryCard {
	
	public static InventoryCardResponse getAllUpId(long id, long top, DeviceService deviceService) {
		
		InventoryCardResponse response = new InventoryCardResponse();
		
		response.setCode(200);
		response.setMessage("ERROR");
		response.setStatus(400);
		response.setDescription("Request Invalid");
		
		List<OpeInventoryCard> cardList = deviceService.retrieveInventoryCards(id,top);
		
		if(!cardList.isEmpty()) {
			
			response.setCards(cardList);
			
			response.setCode(200);
			response.setMessage("OK");
			response.setStatus(200);
			response.setDescription("Inventory Card List");
		} else {
			
			OpeInventoryCard card = deviceService.retrieveInventoryCard(id);
			
			if(card != null) {
				response.setCode(200);
				response.setMessage("Accepted");
				response.setStatus(202);
				response.setDescription("Inventory Card List Empty");
			} else { 
				response.setCode(200);
				response.setMessage("No Content");
				response.setStatus(204);
				response.setDescription("Inventory Card List Out of range ");
			}
		}
		
		return response;
	}

}
