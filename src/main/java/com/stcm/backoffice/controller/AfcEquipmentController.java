package com.stcm.backoffice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.bussines.ApiAfcEquipment;
import com.stcm.backoffice.entity.request.AfcEquipmentRequest;
import com.stcm.backoffice.entity.response.AfcEquipmentResponse;
import com.stcm.backoffice.service.DeviceService;

//import io.swagger.annotations.Api;

//import com.stcm.backoffice.config.SwaggerConfiguration;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
//@Api(tags = {SwaggerConfiguration.STCM_TAG})
public class AfcEquipmentController {

	@Autowired
	private DeviceService deviceService;

	@GetMapping(value = "${constants.api.uri.specificPaths.afc-equipment-get-by}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AfcEquipmentResponse retrieveAfcEquipment(@RequestParam("type") String type) {
		
		return ApiAfcEquipment.getAfcEquipment(type, deviceService);
	}
	
	@PostMapping(value = "${constants.api.uri.specificPaths.afc-equipment-register}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AfcEquipmentResponse insertAfcEquipment(@RequestBody AfcEquipmentRequest equipment) {
		
		return ApiAfcEquipment.registerAfcEquipment(equipment, deviceService);
	}
	
	@PostMapping(value = "${constants.api.uri.specificPaths.afc-equipment-register-list}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AfcEquipmentResponse insertAfcEquipmentList(@RequestParam("quantity") int quantity, @RequestBody AfcEquipmentRequest equipment) {
		
		return ApiAfcEquipment.registerAfcEquipmentList(equipment, quantity, deviceService);
	}
}