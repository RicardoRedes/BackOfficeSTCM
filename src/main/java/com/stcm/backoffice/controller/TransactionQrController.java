package com.stcm.backoffice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.entity.request.DeviceTransactionQR;
import com.stcm.backoffice.entity.response.Response;
import com.stcm.backoffice.service.DeviceService;

@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class TransactionQrController {

	@Autowired
	private DeviceService deviceService;

	@PostMapping(value = "${constants.api.uri.specificPaths.insert-transaction-qr}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response insertTransactionQr(@RequestBody DeviceTransactionQR transaction) {
		return deviceService.insertTransactionQr(transaction);
	}

}