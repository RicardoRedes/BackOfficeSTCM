package com.stcm.backoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.bussines.ApiTransportStation;
import com.stcm.backoffice.entity.request.TransportStationRequest;
import com.stcm.backoffice.entity.response.TransportStation;
import com.stcm.backoffice.entity.response.TransportStationFixed;
import com.stcm.backoffice.entity.response.TransportStationResponse;
import com.stcm.backoffice.service.DeviceService;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class TransportStationController {

	@Autowired
	private DeviceService deviceService;


	/*
	 * 
	 * Stations
	 * 
	 */
	@GetMapping(value = "${constants.api.uri.specificPaths.retrieve-stations}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TransportStationFixed> retrieveStationsFixed() {

		return ApiTransportStation.getStations(deviceService);
	}
	
	@GetMapping(value = "${constants.api.uri.specificPaths.transport-station}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TransportStation> retrieveStations() {

		return ApiTransportStation.getAllStations(deviceService);
	}
	
	@PostMapping(value = "${constants.api.uri.specificPaths.transport-station}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public TransportStationResponse insertStation(@RequestBody TransportStationRequest station) {

		return ApiTransportStation.registerStation(station, deviceService);
		
	}
}