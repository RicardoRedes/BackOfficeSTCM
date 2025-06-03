package com.stcm.backoffice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.bussines.ApiOxxo;
import com.stcm.backoffice.entity.request.OxxoStoreRequest;
import com.stcm.backoffice.entity.response.OxxoStoreResponse;
import com.stcm.backoffice.service.DeviceService;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class OxxoController {

	@Autowired
	private DeviceService deviceService;
	/*
	 * 
	 * Oxxo
	 * 
	 */
	@PostMapping(value = "${constants.api.uri.specificPaths.oxxo-store-insert}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public OxxoStoreResponse receiveBuses(@RequestBody OxxoStoreRequest store) {
		return ApiOxxo.insertStore(deviceService,store);
	}
}