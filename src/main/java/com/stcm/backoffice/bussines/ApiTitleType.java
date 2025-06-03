package com.stcm.backoffice.bussines;

import java.util.ArrayList;
import java.util.List;

import com.stcm.backoffice.entity.CatTypeTitle;
import com.stcm.backoffice.entity.response.TypeTitle;
import com.stcm.backoffice.entity.response.TypeTitleResponse;
import com.stcm.backoffice.service.DeviceService;

public class ApiTitleType {
	
	public static TypeTitleResponse getList(DeviceService deviceService) {
		
		TypeTitleResponse  response = new TypeTitleResponse();
		
		response.setCode(200);
		response.setMessage("ERROR");
		response.setStatus(400);
		response.setDescription("Request Invalid");
		
		
		List<CatTypeTitle> titleList = deviceService.retrieveTitleType();
		
		if ((titleList != null) && (!titleList.isEmpty())) {
			
			int size = titleList.size();
			
			List<TypeTitle> listResponse = new ArrayList<TypeTitle>();
			
			for (int i = 0; i < size; i++) {
				TypeTitle temp = new TypeTitle(titleList.get(i));
				listResponse.add(temp);
			}
			
			response.setTitleList(listResponse);
			
			response.setCode(200);
			response.setMessage("OK");
			response.setStatus(200);
			response.setDescription("Successful");
			
		}
		
		
		return response;
	}
	
public static TypeTitleResponse getList(DeviceService deviceService, String category) {
		
		TypeTitleResponse  response = new TypeTitleResponse();
		
		response.setCode(200);
		response.setMessage("ERROR");
		response.setStatus(400);
		response.setDescription("Request Invalid");
		
		
		List<CatTypeTitle> titleList = deviceService.retrieveTitleType();
		
		if ((titleList != null) && (!titleList.isEmpty())) {
			
			int size = titleList.size();
			
			List<TypeTitle> listResponse = new ArrayList<TypeTitle>();
			
			for (int i = 0; i < size; i++) {
				
				if(titleList.get(i).getCategory().compareTo(category) == 0) {
					TypeTitle temp = new TypeTitle(titleList.get(i));
					listResponse.add(temp);
				}
			}
			
			response.setTitleList(listResponse);
			
			response.setCode(200);
			response.setMessage("OK");
			response.setStatus(200);
			response.setDescription("Successful");
			
		}
		
		
		return response;
	}
	
}
