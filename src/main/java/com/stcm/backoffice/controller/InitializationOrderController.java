package com.stcm.backoffice.controller;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.entity.request.FullInitializationOrderRequest;
import com.stcm.backoffice.entity.request.InitializationOrderRequest;
import com.stcm.backoffice.service.InitializationOrderService;
import com.stcm.backoffice.bussines.ApiInitializationOrder;
import com.stcm.backoffice.entity.response.InitializationOrderResponse;
import com.stcm.backoffice.utils.UtilsSTCM;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class InitializationOrderController {

	
	@Autowired
	private InitializationOrderService initializationOrderService; 

	@GetMapping(value = "${constants.api.uri.specificPaths.preassessed-orders}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public InitializationOrderResponse retrieveInitOrder(@RequestParam("code") Optional<String> code,
			@RequestParam("from") Optional<String> from, @RequestParam("to") Optional<String> to,
			@RequestParam("isOpen") Optional<Boolean> isOpen,
			@RequestParam("equipmentCode") Optional<String> equipmentCode) {

		String _code = code.orElse("");
		if (_code.isEmpty()) {
			_code = null;

		}
		
		String _equipmentCode = equipmentCode.orElse("");
		if(_equipmentCode.isEmpty()) {
			_equipmentCode = null;
		}
		
		Boolean open = isOpen.orElse(false);
		
		String strInitDate = from.orElse("1970-01-01 00:00:00");

		if (strInitDate.isEmpty())
			strInitDate = "1970-01-01 00:00:00";

		System.out.println("Length: " + strInitDate.length());
		
		if(strInitDate.length() == 10)
			strInitDate = strInitDate + " 00:00:00";
		
		String strEndDate = to.orElse(UtilsSTCM.getDateTime());

		if (strEndDate.isEmpty())
			strEndDate = UtilsSTCM.getDateTime();

		Timestamp initDate = UtilsSTCM.stringToTimestamp(strInitDate);
		Timestamp endDate = UtilsSTCM.stringToTimestamp(strEndDate);

		InitializationOrderResponse response = ApiInitializationOrder.getPreAssessedOrders(_code, open, initDate, endDate,_equipmentCode,
				initializationOrderService);

		return response;
	}
	
	@PutMapping(value = "${constants.api.uri.specificPaths.preassessed-orders}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public InitializationOrderResponse updateInitOrder(@RequestParam("code") String code, @RequestBody InitializationOrderRequest orderRequest) {

		InitializationOrderResponse response = ApiInitializationOrder.updatePreAssessedOrder(code, orderRequest, initializationOrderService);

		return response;
	}

	/*@PostMapping(value = "${constants.api.uri.specificPaths.preassessed-orders}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public InitializationOrderResponse insertInitOrders(@RequestParam("code") String code, @RequestParam("quantity") int quantity, @RequestBody FullInitializationOrderRequest orderRequest) {

		InitializationOrderResponse response = ApiInitializationOrder.insertPreAssessedOrder(code, orderRequest, quantity, initializationOrderService);

		return response;
	}*/
	
	@PostMapping(value = "${constants.api.uri.specificPaths.preassessed-orders}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public InitializationOrderResponse insertInitOrdersVer2(@RequestParam("quantity") int quantity, @RequestBody FullInitializationOrderRequest orderRequest) {

		InitializationOrderResponse response = ApiInitializationOrder.insertPreAssessedOrders(orderRequest, quantity, initializationOrderService);

		return response;
	}
}