package com.stcm.backoffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.bussines.ApiTitleType;
import com.stcm.backoffice.entity.response.TypeTitleResponse;
import com.stcm.backoffice.service.DeviceService;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class TitleTypeController {

	@Autowired
	private DeviceService deviceService;

	@GetMapping(value = "${constants.api.uri.specificPaths.title-type}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public TypeTitleResponse retrieveTitleType() {
		
		return ApiTitleType.getList(deviceService);
	}
	
	@GetMapping(value = "${constants.api.uri.specificPaths.title-type-cat}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public TypeTitleResponse retrieveTitleTypeByCategory(@RequestParam("category") String category) {
		
		return ApiTitleType.getList(deviceService,category);
	}

}