package com.stcm.backoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.bussines.ApiGrayList;
import com.stcm.backoffice.entity.OpeGrayListCard;
import com.stcm.backoffice.service.DeviceService;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class GrayListController {

	@Autowired
	private DeviceService deviceService;

	@GetMapping(value = "${constants.api.uri.specificPaths.retrieve-gray-list}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OpeGrayListCard> retrieveGrayList() {
		
		return ApiGrayList.getGrayList(deviceService);
	}

}