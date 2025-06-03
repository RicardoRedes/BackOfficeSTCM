package com.stcm.backoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.bussines.ApiBlackList;
import com.stcm.backoffice.entity.OpeBlackListCard;
import com.stcm.backoffice.service.BlackListService;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class BlackListController {

	@Autowired
	private BlackListService blackListService;

	@GetMapping(value = "${constants.api.uri.specificPaths.retrieve-black-list}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OpeBlackListCard> retrieveBlackList() {
		
		return ApiBlackList.getBlackList(blackListService);
	}

	@GetMapping(value = "${constants.api.uri.specificPaths.retrieve-black-list-xml}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public String retrieveBlackListXml(@RequestParam("type") String type) {
		
		return ApiBlackList.getBlackListXml(blackListService);
	}
	
	

}