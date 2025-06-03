package com.stcm.backoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.bussines.ApiCompanyContract;
import com.stcm.backoffice.entity.response.CompanyContract;
import com.stcm.backoffice.service.DeviceService;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class CompanyContractController {

	@Autowired
	private DeviceService deviceService;

	
	/*
	 * 
	 * Bus
	 * 
	 */
	@GetMapping(value = "${constants.api.uri.specificPaths.company-contract-get-all-simple}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CompanyContract> retrieveAllCompanyContract() {

		return ApiCompanyContract.getAllSimple(deviceService);
	}
	
	
}