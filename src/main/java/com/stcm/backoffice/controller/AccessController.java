package com.stcm.backoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.bussines.ApiAccess;
import com.stcm.backoffice.entity.request.AccessRequest;
import com.stcm.backoffice.entity.request.AccessRequest2;
import com.stcm.backoffice.entity.response.AccessResponse;
import com.stcm.backoffice.entity.response.AccessResponse2;
import com.stcm.backoffice.service.BlackListService;
import com.stcm.backoffice.service.DeviceService;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class AccessController {
	
	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private BlackListService blackListService;
	
	
	@PostMapping(value = "${constants.api.uri.specificPaths.insert-access}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AccessResponse insertAccess(@RequestBody AccessRequest accessRequest) {
		
		AccessResponse respAccess = ApiAccess.registerAccess(accessRequest, deviceService, blackListService);
		
		return respAccess;	
	}
	
	
	@PostMapping(value = "${constants.api.uri.specificPaths.insert-access2}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AccessResponse2 insertAccess2(@RequestBody AccessRequest2 accessRequest) {
		
		AccessResponse2 respAccess = ApiAccess.registerAccess2(accessRequest, deviceService, blackListService);
		
		return respAccess;	
	}
	
	/*@PostMapping(value = "${constants.api.uri.specificPaths.insert-access2}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AccessResponse2> insertAccess2(@RequestBody List<AccessRequest2> accessRequest) {
		
		List<AccessResponse2> respAccess = ApiAccess.registerAllAccess2(accessRequest, deviceService, blackListService);
		
		return respAccess;	
	}
	*/

}
