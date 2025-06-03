package com.stcm.backoffice.bussines;

import java.util.ArrayList;
import java.util.List;

import com.stcm.backoffice.entity.CatType;
import com.stcm.backoffice.entity.OpeAfcEquipment;
import com.stcm.backoffice.entity.OpeCompany;
import com.stcm.backoffice.entity.OpeTransportStation;
import com.stcm.backoffice.entity.OpeTransportUnits;
import com.stcm.backoffice.entity.request.AfcEquipmentRequest;
import com.stcm.backoffice.entity.response.AfcEquipment;
import com.stcm.backoffice.entity.response.AfcEquipmentResponse;
import com.stcm.backoffice.service.DeviceService;

public class ApiAfcEquipment {

	public static AfcEquipmentResponse getAfcEquipment(String type, DeviceService deviceService) {

		AfcEquipmentResponse response = new AfcEquipmentResponse();

		response.setCode(200);
		response.setMessage("ERROR");
		response.setStatus(400);
		response.setDescription("Request Invalid");

		List<OpeAfcEquipment> equipmentList = deviceService.retrieveAfcEquipmentByType(type);

		if ((equipmentList != null) && (!equipmentList.isEmpty())) {

			int size = equipmentList.size();

			List<AfcEquipment> listResponse = new ArrayList<AfcEquipment>();

			for (int i = 0; i < size; i++) {
				AfcEquipment temp = new AfcEquipment(equipmentList.get(i));
				listResponse.add(temp);
			}

			response.setEquipmentList(listResponse);

			response.setCode(200);
			response.setMessage("OK");
			response.setStatus(200);
			response.setDescription("Successful");
		}

		return response;
	}

	public static AfcEquipmentResponse registerAfcEquipment(AfcEquipmentRequest equipment,
			DeviceService deviceService) {

		AfcEquipmentResponse response = new AfcEquipmentResponse();

		response.setCode(200);
		response.setMessage("ERROR");
		response.setStatus(400);
		response.setDescription("Request Invalid");

		OpeCompany company = deviceService.retrieveCompany(equipment.getIdCompany());

		OpeTransportStation station = deviceService.retrieveTransportStationById(equipment.getIdStation());
		
		OpeTransportUnits transportUnit = new OpeTransportUnits();
				
		if(equipment.getId_unit() != null) {
			transportUnit = deviceService.retrieveTransportUnitById(equipment.getId_unit());
		} else {
			transportUnit = null;
		}
		
		@SuppressWarnings("unused")
		CatType typeTicketingMode = deviceService.retrieveTypeTicketingMode(equipment.getMode());

		CatType typeEquipmentState = deviceService.retrieveTypeEquipmentStatus(equipment.getState());

		CatType typeAfcEquipment = deviceService.retrieveTypeAfcEquipment(equipment.getType());

		if (typeAfcEquipment == null || typeEquipmentState == null || company == null) {
			response.setStatus(401);
			response.setDescription("Equipment Type, Equipment State or company Invalid");
			return response;
		}

		if (equipment.getIpAddress() == null || equipment.getMacAddress() == null) {
			response.setStatus(402);
			response.setDescription("Ip Address or  Mac Address Invalid");
			return response;
		}

		String provisionalCode = new String();

		if (station != null || transportUnit != null) {

			if (station != null) {
				provisionalCode = String.format("%s%02d%03d", typeAfcEquipment.getAbbreviation(), station.getId_line(),
						station.getId());
			}

			if (transportUnit != null) {
				provisionalCode = String.format("%s%04d%03d", typeAfcEquipment.getAbbreviation(),
						transportUnit.getNum_unit());
			}

		} else {
			response.setStatus(403);
			response.setDescription("Station or unit Invalid");
			return response;
		}

		String[] tempStr = equipment.getIpAddress().toString().split("\\.");
				
		switch(typeAfcEquipment.getAbbreviation().length()) {
		
		case 2:
			provisionalCode = provisionalCode.concat(String.format("%06d", Integer.valueOf(tempStr[tempStr.length-1])));
			break;
		
		case 3:
			provisionalCode = provisionalCode.concat(String.format("%05d", Integer.valueOf(tempStr[tempStr.length-1])));
			break;
		
		case 4: 
			provisionalCode = provisionalCode.concat(String.format("%04d", Integer.valueOf(tempStr[tempStr.length-1])));
			break;
		
		default:
			provisionalCode = provisionalCode.concat(String.format("%05d", Integer.valueOf(tempStr[tempStr.length-1])));
			break;
		
		}
		
		equipment.setTelventCode(Integer.valueOf(tempStr[tempStr.length-1]));
		
		//TODO: equipmentForm.macAddress = equipmentForm.macAddress!!.replace("-", ":")
		
		OpeAfcEquipment temp = new OpeAfcEquipment(equipment);
		
		temp.setCode(provisionalCode);
		
		OpeAfcEquipment saved = deviceService.insertAfcEquipment(temp);
		
		if(saved != null) {
			List<AfcEquipment> equipmentResp = new ArrayList<AfcEquipment>();
			AfcEquipment tmp = new AfcEquipment(saved);
			equipmentResp.add(tmp);
			
			response.setEquipmentList(equipmentResp);
			response.setMessage("OK");
			response.setStatus(200); 
			response.setDescription("Save Successful");
		}

		return response;
	}
	
	public static AfcEquipmentResponse registerAfcEquipmentList(AfcEquipmentRequest equipment, int quantity,
			DeviceService deviceService) {

		AfcEquipmentResponse response = new AfcEquipmentResponse();

		response.setCode(200);
		response.setMessage("ERROR");
		response.setStatus(400);
		response.setDescription("Request Invalid");

		OpeCompany company = deviceService.retrieveCompany(equipment.getIdCompany());

		OpeTransportStation station = deviceService.retrieveTransportStationById(equipment.getIdStation());
		
		OpeTransportUnits transportUnit = new OpeTransportUnits();
				
		if(equipment.getId_unit() != null) {
			transportUnit = deviceService.retrieveTransportUnitById(equipment.getId_unit());
		} else {
			transportUnit = null;
		}
		
		@SuppressWarnings("unused")
		CatType typeTicketingMode = deviceService.retrieveTypeTicketingMode(equipment.getMode());

		CatType typeEquipmentState = deviceService.retrieveTypeEquipmentStatus(equipment.getState());

		CatType typeAfcEquipment = deviceService.retrieveTypeAfcEquipment(equipment.getType());

		if (typeAfcEquipment == null || typeEquipmentState == null || company == null) {
			response.setStatus(401);
			response.setDescription("Equipment Type, Equipment State or company Invalid");
			return response;
		}

		if (equipment.getIpAddress() == null || equipment.getMacAddress() == null) {
			response.setStatus(402);
			response.setDescription("Ip Address or  Mac Address Invalid");
			return response;
		}

		List<AfcEquipment> equipmentResp = new ArrayList<AfcEquipment>();
		
		// Aqui empezaria el for
		for(int i = 0; i < quantity; i++) {
			String provisionalCode = new String();
	
			if (station != null || transportUnit != null) {
	
				if (station != null) {
					provisionalCode = String.format("%s%02d%03d", typeAfcEquipment.getAbbreviation(), station.getId_line(),
							station.getId());
				}
	
				if (transportUnit != null) {
					provisionalCode = String.format("%s%04d%03d", typeAfcEquipment.getAbbreviation(),
							transportUnit.getNum_unit());
				}
	
			} else {
				response.setStatus(403);
				response.setDescription("Station or unit Invalid");
				return response;
			}
	
			String[] tempStr = equipment.getIpAddress().toString().split("\\.");
			
			int tempInt = Integer.valueOf(tempStr[tempStr.length-1]) + 1;
			
			/* Se calcula la IP incremental */
			String newIp = String.format("%s.%s.%s.%d", 
					tempStr[0],
					tempStr[1],
					tempStr[2],
					tempInt);
			
			equipment.setIpAddress(newIp);
			
			/* Se calcula la mac address incremental */
			
			String[] tempMacAdd = equipment.getMacAddress().toString().split("\\:");
			
			String newMacAdd = String.format("%s:%s:%s:%s:%s:%d", 
					tempMacAdd[0],
					tempMacAdd[1],
					tempMacAdd[2],
					tempMacAdd[3],
					tempMacAdd[4],
					tempInt);
			
			equipment.setMacAddress(newMacAdd);
			
			switch(typeAfcEquipment.getAbbreviation().length()) {
			
			case 2:
				
				provisionalCode = provisionalCode.concat(String.format("%06d", tempInt));
				break;
			
			case 3:
				provisionalCode = provisionalCode.concat(String.format("%05d", tempInt));
				break;
			
			case 4: 
				provisionalCode = provisionalCode.concat(String.format("%04d", tempInt));
				break;
			
			default:
				provisionalCode = provisionalCode.concat(String.format("%05d", tempInt));
				break;
			
			}
			
			equipment.setTelventCode(Integer.valueOf(tempStr[tempStr.length-1]));
			
			//TODO: equipmentForm.macAddress = equipmentForm.macAddress!!.replace("-", ":")
			
			OpeAfcEquipment temp = new OpeAfcEquipment(equipment);
			
			temp.setCode(provisionalCode);
			
			OpeAfcEquipment saved = deviceService.insertAfcEquipment(temp);
			
			if(saved != null) {
				
				AfcEquipment tmp = new AfcEquipment(saved);
				equipmentResp.add(tmp);
				
				response.setEquipmentList(equipmentResp);
				response.setMessage("OK");
				response.setStatus(200); 
				response.setDescription("Save Successful");
			}
		}
		// Aqui terminaria el for
		
		return response;
	}

}
