package com.stcm.backoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.bussines.ApiUser;
import com.stcm.backoffice.entity.response.UserResponse;
import com.stcm.backoffice.service.DeviceService;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class UserController {

	@Autowired
	private DeviceService deviceService;

	
	/*
	 * 
	 * User
	 * 
	 */
	@GetMapping(value = "${constants.api.uri.specificPaths.retrieve-users}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserResponse> retrieveUsers(@RequestParam("code") String code) {

		return ApiUser.getUsers(code, deviceService);
	}
}