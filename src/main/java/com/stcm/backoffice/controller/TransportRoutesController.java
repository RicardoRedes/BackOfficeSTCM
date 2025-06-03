package com.stcm.backoffice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.bussines.ApiTransportRoute;
import com.stcm.backoffice.entity.response.TransportRoute;
import com.stcm.backoffice.entity.response.TransportRouteDetails;
import com.stcm.backoffice.entity.response.TransportRouteSimple;
import com.stcm.backoffice.service.DeviceService;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class TransportRoutesController {

	@Autowired
	private DeviceService deviceService;

	
	/*
	 * 
	 * Bus
	 * 
	 */
	@GetMapping(value = "${constants.api.uri.specificPaths.transport-routes-get-all}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TransportRoute> retrieveAllTransportRoutes() {

		return ApiTransportRoute.getAll(deviceService);
	}
	
	@GetMapping(value = "${constants.api.uri.specificPaths.transport-routes-get-all-simple}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TransportRouteSimple> retrieveAllTransportRoutesSimple() {

		return ApiTransportRoute.getAllSimple(deviceService);
	}
	
	@GetMapping(value = "${constants.api.uri.specificPaths.transport-routes-get-all-detail}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TransportRouteDetails> retrieveAllTransportRoutesDetails() {

		return ApiTransportRoute.getAllDetails(deviceService);
	}
	
	@GetMapping(value = "${constants.api.uri.specificPaths.transport-routes-get-all-by}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TransportRouteDetails> retrieveAllTransportRoutesDetailsByCompany(@RequestParam("routeCode") Optional<String> routeCode,
			@RequestParam("transportCompanyCode") Optional<String> transportCode,
			@RequestParam("companyServiceCode") Optional<String> contractCode) {
		
		String route_code = routeCode.orElse("");
		if(route_code.isEmpty()) {
			route_code = null;
		}
		
		String transport_code = transportCode.orElse("");
		if(transport_code.isEmpty()) {
			transport_code = null;
		}
		
		String contract_code = contractCode.orElse("");
		if(contract_code.isEmpty()) {
			contract_code = null;
		}

		return ApiTransportRoute.getAllBy(route_code, transport_code, contract_code, deviceService);
	}
}