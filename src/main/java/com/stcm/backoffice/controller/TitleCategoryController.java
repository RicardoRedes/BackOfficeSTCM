package com.stcm.backoffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.bussines.ApiTitleCategory;
import com.stcm.backoffice.entity.response.CategoryTitleResponse;
import com.stcm.backoffice.service.DeviceService;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class TitleCategoryController {

	@Autowired
	private DeviceService deviceService;

	@GetMapping(value = "${constants.api.uri.specificPaths.title-category}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CategoryTitleResponse retrieveTitleCategory() {
		
		return ApiTitleCategory.getList(deviceService);
	}
}