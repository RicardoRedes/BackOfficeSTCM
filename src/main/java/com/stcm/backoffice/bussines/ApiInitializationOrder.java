package com.stcm.backoffice.bussines;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.stcm.backoffice.entity.InitializationOrder;
import com.stcm.backoffice.entity.OpeInitializationOrder;
import com.stcm.backoffice.entity.request.FullInitializationOrderRequest;
import com.stcm.backoffice.entity.request.InitializationOrderRequest;
import com.stcm.backoffice.entity.response.InitializationOrderResponse;
import com.stcm.backoffice.service.InitializationOrderService;
import com.stcm.backoffice.utils.UtilsSTCM;

public class ApiInitializationOrder {

	public static InitializationOrderResponse getPreAssessedOrders(String code, Boolean isOpen, Timestamp from,
			Timestamp to, String equipmentCode, InitializationOrderService initializationOrderService) {

		InitializationOrderResponse response = new InitializationOrderResponse();

		response.setCode(200);
		response.setMessage("ERROR");
		response.setStatus(400);
		response.setDescription("Request Invalid");

		List<OpeInitializationOrder> initializationOrderList = initializationOrderService.findFilterInitializationOrder(code, isOpen,
				from, to, equipmentCode);

		if (initializationOrderList != null) {

			// Crear lista InitializationOrder para guardar dentro de ella los objetos
			// de la lista OpeInitializationOrder

			List<InitializationOrder> listResp = new ArrayList<InitializationOrder>();

			for (int i = 0; i < initializationOrderList.size(); i++) {

				InitializationOrder respTemp = new InitializationOrder(initializationOrderList.get(i));

				listResp.add(respTemp);
			}

			response.setOrders(listResp);

			response.setCode(200);
			response.setMessage("OK");
			response.setStatus(200);
			response.setDescription("Initialization Order List");

		}

		return response;
	}

	public static InitializationOrderResponse updatePreAssessedOrder(String code,
			InitializationOrderRequest orderRequest, InitializationOrderService initializationOrderService) {

		InitializationOrderResponse response = new InitializationOrderResponse();

		response.setMessage("ERROR");
		response.setCode(200);

		try {
			OpeInitializationOrder order = initializationOrderService.findByCodeInitializationOrder(code);

			if (order == null) {
				response.setStatus(404);
				response.setMessage("Order not found");
				return response;
			}

			order.setProcessed_cards(orderRequest.getProcessedCards());
			order.setUpdated_at(UtilsSTCM.getDateTime());
			order.setAccepted_cards(orderRequest.getAcceptedCards());
			order.setDeclined_cards(orderRequest.getDeclinedCards());
			order.setInit_task(orderRequest.getInitTask());

			// realizar el update en la transaccion.
			int i = initializationOrderService.updateInitializationOrder(order.getId(), order.getProcessed_cards(),
					order.getUpdated_at(), order.getAccepted_cards(), order.getDeclined_cards(), order.getInit_task());

			System.out.println("Update = " + i);

			List<InitializationOrder> listResp = new ArrayList<InitializationOrder>();

			InitializationOrder respTemp = new InitializationOrder(order);

			listResp.add(respTemp);

			response.setOrders(listResp);

			response.setStatus(200);
			response.setDescription("OK");
			response.setMessage("OK");
		} catch (Exception e) {
			response.setStatus(500);
			response.setDescription(e.getMessage().toString());
		}

		return response;
	}

	public static InitializationOrderResponse insertPreAssessedOrder(String code, FullInitializationOrderRequest orderRequest, int quantity,
			InitializationOrderService initializationOrderService) {
		
		InitializationOrderResponse response = new InitializationOrderResponse();
		response.setMessage("ERROR");
		response.setCode(200);

		OpeInitializationOrder order = initializationOrderService.findByCodeInitializationOrder(code);

		if (order != null) {
			response.setStatus(404);
			response.setMessage("Order Code duplicated");
			return response;
		}
		
		List<OpeInitializationOrder> orderList = new ArrayList<OpeInitializationOrder>(); 
		
		int codeTemp = Integer.valueOf(code);
		
		for(int i = 0; i < quantity; i++) {
			
			OpeInitializationOrder orderTemp = new OpeInitializationOrder(String.valueOf(codeTemp++),orderRequest);
			
			
			OpeInitializationOrder orderSave = initializationOrderService.insertInitializationOrder(orderTemp);
			
			if (orderSave != null) {
				response.setStatus(200);
				response.setMessage("OK");
			}
			
			orderList.add(orderTemp);
		}

		response.setStatus(200);
		response.setMessage("OK");
		return response;
	}
	
	public static InitializationOrderResponse insertPreAssessedOrders(FullInitializationOrderRequest orderRequest, int quantity,
			InitializationOrderService initializationOrderService) {
		
		InitializationOrderResponse response = new InitializationOrderResponse();
		response.setMessage("ERROR");
		response.setCode(200);

		OpeInitializationOrder order = initializationOrderService.findLastInitializationOrder();

		if (order == null) {
			response.setStatus(404);
			response.setMessage("Order Not Found");
			return response;
		}
		
		String code = order.getCode();
		
		List<OpeInitializationOrder> orderList = new ArrayList<OpeInitializationOrder>(); 
		
		int codeTemp = Integer.valueOf(code) + 1;
		
		for(int i = 0; i < quantity; i++) {
			
			OpeInitializationOrder orderTemp = new OpeInitializationOrder(String.valueOf(codeTemp++),orderRequest);
			
			
			OpeInitializationOrder orderSave = initializationOrderService.insertInitializationOrder(orderTemp);
			
			if (orderSave != null) {
				response.setStatus(200);
				response.setMessage("OK");
			}
			
			orderList.add(orderTemp);
		}

		response.setStatus(200);
		response.setMessage("OK");
		return response;
	}
}
