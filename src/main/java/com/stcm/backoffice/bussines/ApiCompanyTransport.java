package com.stcm.backoffice.bussines;

import java.util.ArrayList;
import java.util.List;

import com.stcm.backoffice.entity.OpeCompanyTransport;
import com.stcm.backoffice.entity.response.CompanyTransport;
import com.stcm.backoffice.service.DeviceService;

public class ApiCompanyTransport {

	public static List<CompanyTransport> getAllSimple(DeviceService deviceService) {

		List<OpeCompanyTransport> transportRoutesList = deviceService.retrieveAllCompanyTransport();

		List<CompanyTransport> routesResponse = new ArrayList<CompanyTransport>();

		int size = transportRoutesList.size();

		for (int i = 0; i < size; i++) {

			CompanyTransport temp = new CompanyTransport(transportRoutesList.get(i));

			routesResponse.add(temp);
		}

		return routesResponse;

	}

}
