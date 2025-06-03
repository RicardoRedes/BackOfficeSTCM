package com.stcm.backoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.bussines.ApiBusUnit;
import com.stcm.backoffice.entity.request.BusUnitRequest;
import com.stcm.backoffice.entity.response.BusUnitResponse;
import com.stcm.backoffice.entity.response.BusUnits;
import com.stcm.backoffice.entity.response.BusUnitsDetails;
import com.stcm.backoffice.service.DeviceService;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class BusUnitController {

	@Autowired
	private DeviceService deviceService;
	/*
	 * 
	 * Bus
	 * 
	 */
	@GetMapping(value = "${constants.api.uri.specificPaths.bus-unit-get-all}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BusUnits> retrieveAllBusUnits() {

		return ApiBusUnit.getAll(deviceService);
	}

	@GetMapping(value = "${constants.api.uri.specificPaths.bus-unit-get-all-detail}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BusUnitsDetails> retrieveAllBusUnitsDetails() {

		return ApiBusUnit.getAllDetails(deviceService);
	}

	@PostMapping(value = "${constants.api.uri.specificPaths.bus-unit-insert}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BusUnitResponse receiveBuses(@RequestBody List<BusUnitRequest> buses) {
		return ApiBusUnit.insertBusUnit(deviceService, buses);
	}

}