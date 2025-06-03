package com.stcm.backoffice.bussines;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stcm.backoffice.entity.MetroSchPryDevices;
import com.stcm.backoffice.entity.OpeBusUnits;
import com.stcm.backoffice.entity.OpeCompanyContract;
import com.stcm.backoffice.entity.OpeDevices;
import com.stcm.backoffice.entity.OpeInventoryBus;
import com.stcm.backoffice.entity.OpeSam;
import com.stcm.backoffice.entity.OpeSim;
import com.stcm.backoffice.entity.OpeTransportConfig;
import com.stcm.backoffice.entity.OpeTransportRoutes;
import com.stcm.backoffice.entity.OpeTransportType;
import com.stcm.backoffice.entity.request.DeviceRequest;
import com.stcm.backoffice.entity.response.Devices;
import com.stcm.backoffice.entity.response.DevicesResponse;
import com.stcm.backoffice.service.DeviceService;
import com.stcm.backoffice.utils.UtilsSTCM;

public class ApiDevices {

	public static List<Devices> getAll(DeviceService deviceService) {

		List<OpeDevices> devicesList = deviceService.retrieveAllDevices();

		List<Devices> devicesResponse = new ArrayList<Devices>();

		int size = devicesList.size();

		for (int i = 0; i < size; i++) {

			Devices temp = new Devices(devicesList.get(i));

			devicesResponse.add(temp);
		}

		return devicesResponse;

	}

	@Transactional
	public static DevicesResponse insertDevices(DeviceService deviceService, List<DeviceRequest> devices) {
		DevicesResponse response = new DevicesResponse();

		try {
			for (DeviceRequest device : devices) {
				// Step 1: Validate input values
				validateDeviceRequest(device);

				// Step 2: Create the entity and set basic details
				OpeDevices entity = createDeviceEntity(device);

				// Step 3: Validate data before insert(tipoRuta,ruta,ramal, eco, marca,vin)
				OpeCompanyContract tipoDeRuta = deviceService.existsTipoRuta(device.getTipoRuta());
				if (tipoDeRuta == null) {
					throw new IllegalArgumentException("El tipo de ruta no existe.");
				}
				OpeTransportRoutes route = deviceService.existsRutaAndRamal(device.getRuta(), device.getRamal());
				if (route == null) {
					throw new IllegalArgumentException("La ruta no existe.");
				}
				OpeBusUnits bus = deviceService.existsBus(device.getEco(), device.getMarca(), device.getVin());
				if (bus == null) {
					throw new IllegalArgumentException("El bus no existe.");
				}

				OpeDevices existDeviceResponse = deviceService.existDevice(device.getBusID(), device.getValidatorId());
				if (existDeviceResponse != null) {
					throw new IllegalArgumentException("El dispositivo ya existe.");
				}

				// Step 4: insert in movil_device.inventory.ope_devices
				OpeDevices deviceInsertResponse = deviceService.insertDevice(entity);

				// TODO: validar que se haya insertado el dispositivo si no no crear entidades
				// sim y sam

				// Step 5: save 'sim and sam' value from excel to ope_sim and ope_sam
				//valide if exist sim and sam
				OpeSam existSam = deviceService.existSam(device.getSam());
				OpeSim existSim = deviceService.existSim(device.getSim());
				
				if (existSam != null) {
					throw new IllegalArgumentException("El SAM ya existe.");
				}
				if (existSim != null) {
					throw new IllegalArgumentException("El SIM ya existe.");
				}
				
				OpeSam entityOpeSam = createSimEntity(device.getSam());
				OpeSim entityOpeSim = createSamEntity(device.getSim());
				
				OpeSam responseSamInsert = deviceService.insertSam(entityOpeSam);
				OpeSim responseSimInsert = deviceService.insertSim(entityOpeSim);

				// Step 6: look the register in movil_device.inventory.ope_inventory and update
				// ope_inventory.id_device = ope_devices.id
				// ope_inventory.id_sim = ope_sim.id
				// ope_inventory.id_sam = ope_sam.id

				@SuppressWarnings("unused")
				int responseOpeUpdate = deviceService.updateOpeInventory(bus.getId(), deviceInsertResponse.getId(),
						responseSamInsert.getId(), responseSimInsert.getId());

				// Step 7: insert row metrorrey.sch_pry_mty.devices
				// Solo insertar si no existe el nsd
				// TODO: despues se tendria que actualizar la tabla
				// movil_device.configs.ope_devices_config
				MetroSchPryDevices metroSchPryDevicesExistsResponse = deviceService
						.existMetroSchPryDevices(deviceInsertResponse.getId_urbani());
				if (metroSchPryDevicesExistsResponse != null) {
					throw new IllegalArgumentException("El dispositivo ya existe en devices db.");
				}

				MetroSchPryDevices entitySchPryDevices = createSchPryDevicesEntity(deviceService, device, route, bus);

				@SuppressWarnings("unused")
				MetroSchPryDevices metroSchPryDevices = deviceService.metroSchPryDevicesInsert(entitySchPryDevices);

				OpeInventoryBus existBus = deviceService.existInventoryBusRegister(String.valueOf(bus.getEco_number()),
						bus.getBus_niv());

				if (existBus == null) {

					// "El bus no existe, crearlo"
					OpeInventoryBus opeInventoryBus = new OpeInventoryBus();

					opeInventoryBus.setCol_bus_id(deviceInsertResponse.getId_urbani());
					// opeInventoryBus.setCol_company(null);

					// opeInventoryBus.setCol_branch(bus.getRamal());
					// opeInventoryBus.setCol_eco(String.valueOf(bus.getEco()));
					// opeInventoryBus.setCol_route(String.valueOf(bus.getRuta()));

					opeInventoryBus.setCol_sam_id(device.getSam());
					opeInventoryBus.setCol_sim_id(device.getSim());
					opeInventoryBus.setCol_validator(device.getValidatorId());
					// opeInventoryBus.setCol_phone_number(null);
					// opeInventoryBus.setCol_nomenclature(null);

					// opeInventoryBus.setCol_serie(bus.getVin());

					// opeInventoryBus.setCol_placa_icv(null);
					// opeInventoryBus.setCol_client(null);

					// opeInventoryBus.setCol_created_at(UtilsSTCM.getDateTime());

					// opeInventoryBus.setCol_last_connect(null);
					// opeInventoryBus.setCol_count_connect(null);
					// opeInventoryBus.setCol_meid(null);
					// opeInventoryBus.setCol_type(null);
					opeInventoryBus.setCol_brand(device.getMarca());

					// opeInventoryBus.setCol_company_service(bus.getNombreTipoRuta());

					// opeInventoryBus.setCol_maintenance_provider(null);
					// opeInventoryBus.setStatus(null);

					// opeInventoryBus.setEquipment_code(equipmentCode);

					@SuppressWarnings("unused")
					OpeInventoryBus savedInventoryBus = deviceService.insertInventoryBus(opeInventoryBus);
				} else {
					// actualizar
					@SuppressWarnings("unused")
					int updateInventoryBusResponse = deviceService.updateInventoryBusFromDevice(existBus.getCol_id(),
							deviceInsertResponse.getId_urbani(), device.getSam(), device.getSim(), device.getValidatorId(),
							device.getMarca());
				}

				// success response
				response.setStatus(200);
				response.setCode(100);
				response.setMessage("Éxito");
				response.setDescription("Dispositivos guardados correctamente");
			}
		} catch (Exception e) {
			response.setStatus(500);
			response.setCode(101);
			response.setMessage("Error");
			response.setDescription("Ocurrió un error al guardar los dispositivos: " + e.getMessage());
		}

		return response;

	}

	private static MetroSchPryDevices createSchPryDevicesEntity(DeviceService deviceService, DeviceRequest device,
			OpeTransportRoutes route, OpeBusUnits bus) {
		MetroSchPryDevices metroSchPryDevicesEntity = new MetroSchPryDevices();

		OpeTransportType OpeTransportLine = deviceService.getTipoRuta(device.getTipoRuta());
		OpeTransportConfig opeTransportConfig = deviceService.getTransportConfig(OpeTransportLine.getId());

		metroSchPryDevicesEntity.setMeid(null);
		metroSchPryDevicesEntity.setUrl(null);
		metroSchPryDevicesEntity.setMoment(UtilsSTCM.getDateTime());
		metroSchPryDevicesEntity.setComp(1); // valor compañia metrorrey = 1
		metroSchPryDevicesEntity.setLinea(OpeTransportLine.getLinea()); // sacar de la tabla ope_transport_line
		metroSchPryDevicesEntity.setEstacion(Integer.parseInt(route.getCode_stcm())); // get from ope_transport_routes
																						// 'code_stcm'
		metroSchPryDevicesEntity.setTrayecto(1);
		metroSchPryDevicesEntity.setTipo(0);
		metroSchPryDevicesEntity.setNum_disp(getLastTwoDigitsEco(bus.getEco_number())); // last 2 digit from ECO number
		metroSchPryDevicesEntity.setEquipment_code(bus.getEquipment_code()); // get from ope_bus_id

		metroSchPryDevicesEntity.setFare_version(opeTransportConfig.getFare_version());
		metroSchPryDevicesEntity.setTpm_version(opeTransportConfig.getTpm_version());
		metroSchPryDevicesEntity.setBl_version(opeTransportConfig.getBl_version());
		metroSchPryDevicesEntity.setGl_version(opeTransportConfig.getGl_version());
		metroSchPryDevicesEntity.setBgl_pooling(opeTransportConfig.getBgl_pooling());
		metroSchPryDevicesEntity.setCpr_version(opeTransportConfig.getCpr_version());
		metroSchPryDevicesEntity.setPooling(opeTransportConfig.getPooling());

		metroSchPryDevicesEntity.setDevice_type(0); // get from excel
		metroSchPryDevicesEntity.setStatus(1); // by default is 1
		return metroSchPryDevicesEntity;
	}

	public static int getLastTwoDigitsEco(String input) {
		if (input == null || input.length() < 2) {
			throw new IllegalArgumentException("String must have at least two characters.");
		}

		// Extract the last two characters
		String lastTwo = input.substring(input.length() - 2);

		// Convert to integer
		try {
			return Integer.parseInt(lastTwo);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("The last two characters are not digits.");
		}
	}

	private static OpeSim createSamEntity(String sim) {
		OpeSim opeSimEntity = new OpeSim();
		opeSimEntity.setId_sim(sim);

		return opeSimEntity;
	}

	private static OpeSam createSimEntity(String sam) {
		OpeSam opeSamEntity = new OpeSam();
		opeSamEntity.setId_sam(sam);
		opeSamEntity.setCompany_name("metrorrey");

		return opeSamEntity;
	}

	private static OpeDevices createDeviceEntity(DeviceRequest device) {
		OpeDevices entity = new OpeDevices();
		entity.setId_urbani(device.getBusID());
		entity.setId_validator(device.getValidatorId());

		return entity;
	}

	private static void validateDeviceRequest(DeviceRequest device) {
		if (device == null) {
			throw new IllegalArgumentException("El cuerpo de la solicitud está vacío.");
		}
		if (device.getBusID() == null || device.getBusID().isEmpty()) {
			throw new IllegalArgumentException("El campo BusID es obligatorio.");
		}
		if (device.getTipoRuta() == null || device.getTipoRuta().isEmpty()) {
			throw new IllegalArgumentException("El campo TipoRuta  es obligatorio.");
		}
		if (device.getRuta() == null) {
			throw new IllegalArgumentException("El campo Ruta es obligatorio.");
		}
		if (device.getRamal() == null || device.getRamal().isEmpty()) {
			throw new IllegalArgumentException("El campo Ramal es obligatorio.");
		}
		if (device.getEco() == null || device.getEco().isEmpty()) {
			throw new IllegalArgumentException("El campo Eco es obligatorio.");
		}
		if (device.getMarca() == null || device.getMarca().isEmpty()) {
			throw new IllegalArgumentException("El campo Marca es obligatorio.");
		}
		if (device.getVin() == null || device.getVin().isEmpty()) {
			throw new IllegalArgumentException("El campo Vin es obligatorio.");
		}
		if (device.getValidatorId() == null || device.getValidatorId().isEmpty()) {
			throw new IllegalArgumentException("El campo ValidatorId es obligatorio.");
		}
		if (device.getSim() == null || device.getSim().isEmpty()) {
			throw new IllegalArgumentException("El campo Sim es obligatorio.");
		}
		if (device.getSam() == null || device.getSam().isEmpty()) {
			throw new IllegalArgumentException("El campo Sam es obligatorio.");
		}

	}

}
