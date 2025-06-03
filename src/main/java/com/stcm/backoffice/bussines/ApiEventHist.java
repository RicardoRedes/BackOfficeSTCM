package com.stcm.backoffice.bussines;

import com.stcm.backoffice.entity.OpeEventHist;
import com.stcm.backoffice.entity.OpeEventStatistics;
import com.stcm.backoffice.entity.request.EventHistRequest;
import com.stcm.backoffice.entity.request.EventHistRequestPut;
import com.stcm.backoffice.entity.response.EventHistResponse;
import com.stcm.backoffice.service.DeviceService;

public class ApiEventHist {

	// falta añadir columna id_cde en tabla OpeEventHist
	public static EventHistResponse register(EventHistRequest eventHist, DeviceService deviceService) {
		// Validar datos de request

		// guardar el request
		EventHistResponse response = new EventHistResponse();

		response.setCode(200);
		response.setMessage("ERROR");
		response.setStatus(400);
		response.setIdCde(0);
		response.setIdEquipment(0);

		// buscar evento en estadistica
		OpeEventStatistics stat = deviceService.retrieveEventStatistics(eventHist.getIdCompany(),
				eventHist.getEventType(), eventHist.getEventCode(), eventHist.getEquipmentType(),
				eventHist.getIdEquipment());

		if (stat == null) {
			System.out.println("Evento no encontrado");
			// insert
			OpeEventStatistics tempStat = new OpeEventStatistics(eventHist);
			/*OpeEventStatistics saveStat =*/ deviceService.insertEventStatistics(tempStat);

		} else {
			System.out.println("Evento Encontrado");
			// update
			/*int upStat =*/ deviceService.updateEventstatistics(stat.getId(), 1);
		}

		// insertar o actualizar evento de estadisticas

		OpeEventHist temp = new OpeEventHist(eventHist);
		OpeEventHist event = deviceService.insertEventHist(temp);

		if (temp.getId() == event.getId()) {
			response.setEvent(eventHist);
			response.setIdCC(event.getId());
			response.setStatus(200);
			response.setMessage("OK");
			response.setDescription("Registered event with Id PCE = " /* + event.getid */);
			return response;
		} else {
			return response;
		}
	}

	// devolver EventHistResponse
	public static EventHistResponse getById(long id, DeviceService deviceService) {
		EventHistResponse response = new EventHistResponse();

		response.setCode(200);
		response.setMessage("ERROR");
		response.setStatus(400);
		response.setIdCde(0);
		response.setIdEquipment(0);

		OpeEventHist eventHist = deviceService.retrieveEventHist(id);

		if (eventHist != null) {
			response.setEvent(null);
			response.setIdCC(eventHist.getId());
			response.setStatus(200);
			response.setMessage("OK");
			response.setDescription("Registered event with Id PCE = " /* + event.getid */);
			return response;
		}
		return response;
	}

	public static EventHistResponse updateHistory(EventHistRequestPut hisPut, DeviceService deviceService) {

		EventHistResponse response = new EventHistResponse();

		response.setIdCC(0);
		response.setCode(200);
		response.setMessage("ERROR");
		response.setStatus(400);
		response.setIdEquipment(0);

		OpeEventHist eventHist = deviceService.retrieveEventHist(hisPut.getId_cc(), hisPut.getEvent_state(),
				hisPut.getId_equipment(), hisPut.getEvent_type(), hisPut.getId_company(), hisPut.getEvent_code(),
				hisPut.getEquipment_type());

		if (eventHist == null) {
			System.out.println("Evento no encontrado");
			// Retornar respuesta con error que describa que no se encontro el evento
			response.setCode(400);
			response.setMessage("Evento no encontrado, error al actualizar");
			response.setStatus(400);
			return response;
		} else {

			System.out.println("Evento Encontrado");
			/*int updateEvent =*/ deviceService.updateEventHist(eventHist.getId(), 2);
		}
		
		
		OpeEventStatistics eventStat = deviceService.retrieveEventStatistics(eventHist.getId_company(), eventHist.getEvent_type(), 
				eventHist.getEvent_code(), eventHist.getEquipment_type(), eventHist.getId_equipment()); 
		
		if (eventStat == null) {
			System.out.println("Evento no Encontrado");
			response.setCode(400);
			response.setMessage("Evento no encontrado, error al actualizar");
			response.setStatus(400);
			return response;

		} else {
			System.out.println("Evento Actualizado");
			/*int upStat =*/ deviceService.updateEventstatistics(eventStat.getId(), 0);
		}

		response.setMessage("OK");
		response.setStatus(200);
		return response;
		
	}
	
	
}
