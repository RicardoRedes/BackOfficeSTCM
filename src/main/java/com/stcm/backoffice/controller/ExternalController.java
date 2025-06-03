package com.stcm.backoffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stcm.backoffice.entity.OpeAfcEquipment;
import com.stcm.backoffice.entity.OpeTransportLine;
import com.stcm.backoffice.entity.OpeTransportStation;
import com.stcm.backoffice.entity.Settings;
import com.stcm.backoffice.entity.request.KeyRequest;
import com.stcm.backoffice.entity.response.Detail;
import com.stcm.backoffice.entity.response.GenerateKeyResponse;
import com.stcm.backoffice.entity.response.Header;
import com.stcm.backoffice.entity.response.Status;
import com.stcm.backoffice.service.DeviceService;
import com.stcm.backoffice.service.SettingsService;
import com.stcm.backoffice.utils.UtilsSTCM;


@RestController
@RequestMapping("${constants.api.uri.basePath}")
public class ExternalController {

	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private SettingsService settingsService;

	@GetMapping(value = "${constants.api.uri.specificPaths.retrieve-generate-key}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public GenerateKeyResponse retrieveGenerateKey(@RequestParam("linea") String linea_id,
			@RequestParam("estacion") String estacion_id, @RequestParam("equipo") String equipo_id,
			@RequestParam("lector") String serial_num, @RequestParam("modificador") String modificador) {

		int error = 0;
		int control = 0;
		
		GenerateKeyResponse response = new GenerateKeyResponse();
		
		OpeTransportLine linea = new OpeTransportLine();
		OpeTransportStation estacion = new OpeTransportStation();
		OpeAfcEquipment equipo = new OpeAfcEquipment();
		Settings config = new Settings();

		Header header = new Header(linea_id,estacion_id,equipo_id,serial_num);
		Detail detail = new Detail(0, 0, 0, 0, "0", "0");
		Status status = new Status(null, null);
		String key = new String();

		// Se revisa si la plaza existe en la base de datos y si esta habilitada para su
		// uso.
		linea = deviceService.retrieveLine(Integer.valueOf(linea_id));

		if (linea != null) { // plaza

			estacion = deviceService.retrieveTransportStationById(Integer.valueOf(estacion_id));

			if ((estacion != null) && linea.getId() == estacion.getId_line()) { // tienda

				equipo = deviceService.retrieveAfcEquipmentById(Integer.valueOf(equipo_id));

				if ((equipo != null) && (estacion.getId() == equipo.getId_station())) { // Lector

					config.setMax_recharge_num(Integer.valueOf(settingsService.getSettingsByName("maxRechargeNum").getValue()));
					config.setMax_recharge_amount(Integer.valueOf(settingsService.getSettingsByName("maxRechargeAmount").getValue()));
					config.setValidity(Integer.valueOf(settingsService.getSettingsByName("expirationTime").getValue()));
					config.setBlocking_time(Integer.valueOf(settingsService.getSettingsByName("blockingTime").getValue()));
					
					//deviceService.updateReaderCount(lector.getId());
				} else {
					// Si no existe muestra mensaje de error
					System.out.println("Equipo No pertenece a estacion");
					error = 3;
				}

			} else {
				// Si no existe muestra mensaje de error
				System.out.println("Estacion No pertenece a linea");
				error = 2;
			}
		} else {
			// Si no existe la plaza se manda mensaje de error de plaza no existe
			System.out.println("Linea no existe");
			error = 4;
		}

		switch (error) {
		case 0:
			/*
			 * Se obtienen los datos actualizados directamende de la bd para mostrarlos en
			 * el xml utilizando el objeto
			 */
			key = UtilsSTCM.getRandomHex();
			String integridad = UtilsSTCM.getRandomInt();
			detail = new Detail(config.getMax_recharge_amount(), config.getValidity(), config.getMax_recharge_num(),
					config.getBlocking_time(), key, integridad);
			status = new Status("00", "OK");
			break;
		case 2:
			// Evaluacion del status y muestra del mensaje
			status = new Status("02", "La estacion no pertenece a la linea solicitada");
			break;
		case 3:
			status = new Status("03", "El dispositivo no pertenece a estacion");
			break;
		case 4:
			status = new Status("04", "La linea no existe");
			break;
		default:
			status = new Status("99", "Excepción general");
			break;

		}

		if (control != 0)
			error = control;
		// String linea_id, String estacion_id, String equipo_id, String serial_num, String modificador, String key, int error
		KeyRequest request = new KeyRequest(linea_id, estacion_id, equipo_id, serial_num, modificador, key, error);

		response.setDetail(detail);
		response.setStatus(status);
		response.setHeader(header);
		
		deviceService.insertRequestKeyLog(request);

		return response;
	}

}
