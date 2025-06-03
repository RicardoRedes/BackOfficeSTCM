package com.stcm.backoffice.bussines;

import java.util.ArrayList;
import java.util.List;

import com.stcm.backoffice.entity.OpeUser;
import com.stcm.backoffice.entity.response.UserResponse;
import com.stcm.backoffice.service.DeviceService;



public class ApiUser {
	
	public static List<UserResponse> getUsers (String code, DeviceService deviceService){
		
		List<OpeUser> opeUsers = deviceService.retrieveUsers(code);
		
		// inicializamos vacio
		List<UserResponse> responseList = new ArrayList<UserResponse>();
		
		for(int i = 0; i < opeUsers.size(); i++) {
			UserResponse response = new UserResponse(opeUsers.get(i));
			
			responseList.add(response);
		}
		
	return responseList;
	
   }
	
}
