package com.stcm.backoffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.bussines.ApiInventoryCard;
import com.stcm.backoffice.entity.response.InventoryCardResponse;
import com.stcm.backoffice.service.DeviceService;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class InventoryCardController {

	@Autowired
	private DeviceService deviceService;

	/*
	 * 
	 * InventoryCards
	 * 
	 */
	@GetMapping(value = "${constants.api.uri.specificPaths.retrieve-inventory-cards}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public InventoryCardResponse retrieveInventoryCards(@RequestParam("id") long id, @RequestParam("top") long top) {
		return ApiInventoryCard.getAllUpId(id, top, deviceService);
	}

}