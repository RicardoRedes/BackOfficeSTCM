package com.stcm.backoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.bussines.ApiDevices;
import com.stcm.backoffice.entity.request.DeviceRequest;
import com.stcm.backoffice.entity.response.Devices;
import com.stcm.backoffice.entity.response.DevicesResponse;
import com.stcm.backoffice.service.DeviceService;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class DevicesController {

	@Autowired
	private DeviceService deviceService;
	/*
	 * 
	 * Bus
	 * 
	 */
	@GetMapping(value = "${constants.api.uri.specificPaths.devices-get-all}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Devices> retrieveAllDevices() {

		return ApiDevices.getAll(deviceService);
	}
	
	@PostMapping(value = "${constants.api.uri.specificPaths.devices-insert}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public DevicesResponse receiveBuses(@RequestBody List<DeviceRequest> devices) {
		return ApiDevices.insertDevices(deviceService, devices);
	}
}