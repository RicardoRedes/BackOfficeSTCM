package com.stcm.backoffice.bussines;

import java.util.ArrayList;
import java.util.List;

import com.stcm.backoffice.entity.CatCategoryTitle;
import com.stcm.backoffice.entity.response.CategoryTitle;
import com.stcm.backoffice.entity.response.CategoryTitleResponse;
import com.stcm.backoffice.service.DeviceService;

public class ApiTitleCategory {

	public static CategoryTitleResponse getList(DeviceService deviceService) {
		CategoryTitleResponse response = new CategoryTitleResponse();
		
		response.setCode(200);
		response.setMessage("ERROR");
		response.setStatus(400);
		response.setDescription("Request Invalid");

		List<CatCategoryTitle> categoryList = deviceService.retrieveTitleCategory();

		if ((categoryList != null) && (!categoryList.isEmpty())) {
			
			int size = categoryList.size();

			List<CategoryTitle> listResponse = new ArrayList<CategoryTitle>();

			for (int i = 0; i < size; i++) {
				CategoryTitle temp = new CategoryTitle(categoryList.get(i));
				listResponse.add(temp);
			}

			response.setCategoryList(listResponse);
			
			response.setCode(200);
			response.setMessage("OK");
			response.setStatus(200);
			response.setDescription("Successful");
		}
		
		return response;

	}

}
