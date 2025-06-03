package com.stcm.backoffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.bussines.ApiCollection;
import com.stcm.backoffice.entity.request.CollectionRequest;
import com.stcm.backoffice.entity.response.CollectionResponse;
import com.stcm.backoffice.service.CollectionService;
import com.stcm.backoffice.service.DeviceService;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class CollectionController {

	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private CollectionService collectionService;

	@GetMapping(value = "${constants.api.uri.specificPaths.retrieve-collection}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CollectionResponse retrieveCollection(@RequestParam("id") long id) {
		
		return ApiCollection.getById(collectionService,deviceService, id);
	}

	@PostMapping(value = "${constants.api.uri.specificPaths.insert-collection}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CollectionResponse insertCollection(@RequestBody CollectionRequest collectionRequest) {

		CollectionResponse response = ApiCollection.register(collectionRequest, collectionService, deviceService);

		return response;
	}

}