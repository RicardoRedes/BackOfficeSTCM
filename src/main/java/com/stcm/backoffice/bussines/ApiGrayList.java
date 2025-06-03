package com.stcm.backoffice.bussines;

import java.util.List;

import com.stcm.backoffice.entity.OpeGrayListCard;
import com.stcm.backoffice.service.DeviceService;

public class ApiGrayList {
	
	public static List<OpeGrayListCard> getGrayList(DeviceService deviceService) {
		List<OpeGrayListCard> grayList = deviceService.retrieveGrayList();

		if (grayList.isEmpty()) {
			return null;
		} else {
			return grayList;
		}
		
	}

}
