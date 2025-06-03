package com.stcm.backoffice.bussines;

import java.util.ArrayList;
import java.util.List;

import com.stcm.backoffice.entity.OpeTransportRoutes;
import com.stcm.backoffice.entity.OpeTransportRoutesDetails;
import com.stcm.backoffice.entity.response.TransportRoute;
import com.stcm.backoffice.entity.response.TransportRouteDetails;
import com.stcm.backoffice.entity.response.TransportRouteSimple;
import com.stcm.backoffice.service.DeviceService;

public class ApiTransportRoute {

	public static List<TransportRoute> getAll(DeviceService deviceService) {

		List<OpeTransportRoutes> transportRoutesList = deviceService.retrieveAllTransportRoute();

		List<TransportRoute> routesResponse = new ArrayList<TransportRoute>();

		int size = transportRoutesList.size();

		for (int i = 0; i < size; i++) {

			TransportRoute temp = new TransportRoute(transportRoutesList.get(i));

			routesResponse.add(temp);
		}

		return routesResponse;

	}
	
	public static List<TransportRouteSimple> getAllSimple(DeviceService deviceService) {

		List<OpeTransportRoutes> transportRoutesList = deviceService.retrieveAllTransportRoute();

		List<TransportRouteSimple> routesResponse = new ArrayList<TransportRouteSimple>();

		int size = transportRoutesList.size();

		for (int i = 0; i < size; i++) {

			TransportRouteSimple temp = new TransportRouteSimple(transportRoutesList.get(i));

			routesResponse.add(temp);
		}

		return routesResponse;

	}

	public static List<TransportRouteDetails> getAllDetails(DeviceService deviceService) {

		List<OpeTransportRoutesDetails> transportRoutesList = deviceService.retrieveAllTransportRouteDetails();

		List<TransportRouteDetails> routesResponse = new ArrayList<TransportRouteDetails>();

		int size = transportRoutesList.size();

		for (int i = 0; i < size; i++) {

			TransportRouteDetails temp = new TransportRouteDetails(transportRoutesList.get(i));

			routesResponse.add(temp);
		}

		return routesResponse;

	}
	
	public static List<TransportRouteDetails> getAllBy(String route_code, String transport_code, String contract_code, DeviceService deviceService) {

		List<OpeTransportRoutesDetails> transportRoutesList = deviceService.retrieveTransportRouteDetailsBy(route_code,transport_code,contract_code);

		List<TransportRouteDetails> routesResponse = new ArrayList<TransportRouteDetails>();

		int size = transportRoutesList.size();

		for (int i = 0; i < size; i++) {

			TransportRouteDetails temp = new TransportRouteDetails(transportRoutesList.get(i));

			routesResponse.add(temp);
		}

		return routesResponse;

	}

}
