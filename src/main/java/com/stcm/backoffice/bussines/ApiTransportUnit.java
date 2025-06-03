package com.stcm.backoffice.bussines;

import java.util.List;

import com.stcm.backoffice.entity.OpeTransportUnits;
import com.stcm.backoffice.service.DeviceService;



public class ApiTransportUnit {
	
	public static List<OpeTransportUnits> getAll (DeviceService deviceService){
		
		List<OpeTransportUnits> transportUnitList = deviceService.retrieveAllTransportUnit();
		
	return transportUnitList;
	
   }
	
}
