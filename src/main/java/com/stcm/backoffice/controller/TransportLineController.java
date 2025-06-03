package com.stcm.backoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.stcm.backoffice.bussines.ApiTransportLine;
import com.stcm.backoffice.entity.request.TransportLineRequest;
import com.stcm.backoffice.entity.response.TransportLine;
import com.stcm.backoffice.entity.response.TransportLineResponse;
import com.stcm.backoffice.service.DeviceService;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class TransportLineController {

	@Autowired
	private DeviceService deviceService;


	/*
	 * 
	 * Get All Lines
	 * 
	 */
	@GetMapping(value = "${constants.api.uri.specificPaths.transport-line}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TransportLine> retrieveLines() {

		return ApiTransportLine.getAllLines(deviceService);
	}
	
	@PostMapping(value = "${constants.api.uri.specificPaths.transport-line}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public TransportLineResponse registerLine(@RequestBody TransportLineRequest line) {

		return ApiTransportLine.registerLine(line, deviceService);
	}
	
}