package com.stcm.backoffice.bussines;

import java.util.ArrayList;
import java.util.List;

import com.stcm.backoffice.entity.OpeTransportLine;
import com.stcm.backoffice.entity.request.TransportLineRequest;
import com.stcm.backoffice.entity.response.TransportLine;
import com.stcm.backoffice.entity.response.TransportLineResponse;
import com.stcm.backoffice.service.DeviceService;

public class ApiTransportLine {

	public static List<TransportLine> getAllLines(DeviceService deviceService) {
		List<OpeTransportLine> lineList = deviceService.retrieveLines();

		if ((lineList != null) && (!lineList.isEmpty())) {

			int size = lineList.size();

			List<TransportLine> listResponse = new ArrayList<TransportLine>();

			for (int i = 0; i < size; i++) {
				TransportLine temp = new TransportLine(lineList.get(i));
				listResponse.add(temp);
			}
			return listResponse;
		} else {
			return null;
		}

	}

	public static TransportLineResponse registerLine(TransportLineRequest line, DeviceService deviceService) {
		
		TransportLineResponse response = new TransportLineResponse();

		response.setCode(200);
		response.setMessage("ERROR");
		response.setStatus(400);
		response.setDescription("Request Invalid");
		
		if(line.getIdCompany() == null) {
			response.setStatus(401);
			response.setDescription("IdCompany Invalid");
			return response;
		}
		
		if(line.getCode().isEmpty()) {
			response.setStatus(402);
			response.setDescription("code Invalid");
			return response;
		}
		
		if(line.getName().isEmpty()) {
			response.setStatus(403);
			response.setDescription("name Invalid");
			return response;
		}

		if(line.getNumStation() == null) {
			response.setStatus(404);
			response.setDescription("NumStation Invalid");
			return response;
		}
		
		if(line.getColor().isEmpty()) {
			response.setStatus(405);
			response.setDescription("color Invalid");
			return response;
		}
		
		if(line.getStatus() == null) {
			response.setStatus(406);
			response.setDescription("status Invalid");
			return response;
		}
		
		if(line.getUbicationCode() == null) {
			response.setStatus(407);
			response.setDescription("ubication code Invalid");
			return response;
		}
		
		
		
		OpeTransportLine temp = new OpeTransportLine(line);
		
		OpeTransportLine saved = deviceService.insertLine(temp);
		
		if(saved != null) {
			List<OpeTransportLine> lineResp = new ArrayList<OpeTransportLine>();
			lineResp.add(saved);
			
			response.setLine(lineResp);
			response.setMessage("OK");
			response.setStatus(200);
			response.setDescription("Save Successful");
			
		}
		
		return response;

	}

}
