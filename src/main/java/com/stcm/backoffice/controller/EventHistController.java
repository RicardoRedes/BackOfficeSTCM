package com.stcm.backoffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.bussines.ApiEventHist;
import com.stcm.backoffice.entity.request.EventHistRequest;
import com.stcm.backoffice.entity.request.EventHistRequestPut;
import com.stcm.backoffice.entity.response.EventHistResponse;
import com.stcm.backoffice.service.DeviceService;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class EventHistController {

	@Autowired
	private DeviceService deviceService;

	@GetMapping(value = "${constants.api.uri.specificPaths.retrieve-event-hist}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EventHistResponse retrieveEventHist(@RequestParam("id") long id) {
		
		return ApiEventHist.getById(id, deviceService);
	}

	@PostMapping(value = "${constants.api.uri.specificPaths.insert-event-hist}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EventHistResponse insertEventHist(@RequestBody EventHistRequest eventHist) {

		EventHistResponse resp = ApiEventHist.register(eventHist, deviceService);

		return resp;
	}
	
	//
	
	@PutMapping(value = "${constants.api.uri.specificPaths.update-event-hist}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EventHistResponse updateHistory(@RequestBody EventHistRequestPut histPut) {
		
		EventHistResponse apiResp = ApiEventHist.updateHistory(histPut, deviceService);
		
		return apiResp;
	}


}