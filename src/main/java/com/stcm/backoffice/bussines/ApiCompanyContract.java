package com.stcm.backoffice.bussines;

import java.util.ArrayList;
import java.util.List;

import com.stcm.backoffice.entity.OpeCompanyContract;
import com.stcm.backoffice.entity.response.CompanyContract;
import com.stcm.backoffice.service.DeviceService;

public class ApiCompanyContract {

	public static List<CompanyContract> getAllSimple(DeviceService deviceService) {

		List<OpeCompanyContract> transportRoutesList = deviceService.retrieveAllCompanyContract();

		List<CompanyContract> routesResponse = new ArrayList<CompanyContract>();

		int size = transportRoutesList.size();

		for (int i = 0; i < size; i++) {

			CompanyContract temp = new CompanyContract(transportRoutesList.get(i));

			routesResponse.add(temp);
		}

		return routesResponse;

	}

}
