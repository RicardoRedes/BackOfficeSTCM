package com.stcm.backoffice.bussines;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stcm.backoffice.entity.OpeBusUnits;
import com.stcm.backoffice.entity.OpeBusUnitsDetails;
import com.stcm.backoffice.entity.OpeInventory;
import com.stcm.backoffice.entity.OpeInventoryBus;
import com.stcm.backoffice.entity.OpeTransportRoutes;
import com.stcm.backoffice.entity.OpeTransportStation;
import com.stcm.backoffice.entity.request.AfcEquipmentRequest;
import com.stcm.backoffice.entity.request.BusUnitRequest;
import com.stcm.backoffice.entity.response.AfcEquipmentResponse;
import com.stcm.backoffice.entity.response.BusUnitResponse;
import com.stcm.backoffice.entity.response.BusUnits;
import com.stcm.backoffice.entity.response.BusUnitsDetails;
import com.stcm.backoffice.service.DeviceService;
import com.stcm.backoffice.utils.UtilsSTCM;

public class ApiBusUnit {

	public static List<BusUnits> getAll(DeviceService deviceService) {

		List<OpeBusUnits> opeBusUnitsList = deviceService.retrieveAllBusUnit();

		List<BusUnits> busUnitResponse = new ArrayList<BusUnits>();

		int size = opeBusUnitsList.size();

		for (int i = 0; i < size; i++) {

			BusUnits temp = new BusUnits(opeBusUnitsList.get(i));

			busUnitResponse.add(temp);
		}

		return busUnitResponse;

	}

	public static List<BusUnitsDetails> getAllDetails(DeviceService deviceService) {

		List<OpeBusUnitsDetails> opeBusUnitsList = deviceService.retrieveAllBusUnitDetails();

		List<BusUnitsDetails> busUnitResponse = new ArrayList<BusUnitsDetails>();

		int size = opeBusUnitsList.size();

		for (int i = 0; i < size; i++) {

			BusUnitsDetails temp = new BusUnitsDetails(opeBusUnitsList.get(i));

			busUnitResponse.add(temp);
		}

		return busUnitResponse;

	}

	@Transactional
	// Buses registration
	public static BusUnitResponse insertBusUnit(DeviceService deviceService, List<BusUnitRequest> buses) {

		BusUnitResponse response = new BusUnitResponse();

		try {
			for (BusUnitRequest bus : buses) {
				// Step 1: Validate input values
				validateBusRequest(bus);

				// Step 2: Create the entity and set basic details
				OpeBusUnits entity = createBusUnitEntity(bus);

				// Step 3: Validate route and retrieve associated station
				OpeTransportRoutes route = deviceService.existsRutaAndRamal(bus.getRuta(), bus.getRamal());
				if (route == null) {
					throw new IllegalArgumentException("La ruta no existe.");
				}
				OpeTransportStation station = deviceService
						.retrieveTransportStationById(Long.parseLong(route.getCode_stcm(), 10));
				if (station == null) {
					throw new IllegalStateException("Estación no encontrada.");
				}
				// Step 4: Save the bus unit
				// validate if the bus already exist if the already exist dont insert
				OpeBusUnits busExistResponse = deviceService.existsBus(entity.getEco_number(), entity.getBus_brand(),
						entity.getBus_niv());
				if (busExistResponse != null) {
					throw new IllegalArgumentException("El bus ya existe.");
				}
				OpeBusUnits savedBusUnit = deviceService.insertBusUnit(entity);
				if (savedBusUnit == null) {
					throw new RuntimeException("Error al guardar en bus_units.");
				}
				// Step 5: Insert inventory
				insertInventory(deviceService, savedBusUnit);

				// Step 6: Register AFC Equipment and update 'equipment_code in ope_bus_unit'
				AfcEquipmentRequest afcEquipmentRequest = createAfcEquipmentRequest(deviceService, route, station);
				AfcEquipmentResponse afcResponse = ApiAfcEquipment.registerAfcEquipment(afcEquipmentRequest,
						deviceService);

				updateBusUnitWithEquipmentCode(deviceService, savedBusUnit, afcResponse);

				// Step 7: Update 'ope_inventory_bus'
				// TODO: terminar esta implementacion, se tiene que actualizar esta tabla con
				// los valores del excel que sean posibles y con equipment_code
				// primero checar si existe el registro y si existe hacer un update y si no es
				// in insert
				OpeInventoryBus existBus = deviceService.existInventoryBusRegister(String.valueOf(bus.getEco()),
						bus.getVin());
				String equipmentCode = afcResponse.getEquipmentList().get(0).getCode();

				if (existBus == null) {

					// "El bus no existe, crearlo"
					OpeInventoryBus opeInventoryBus = new OpeInventoryBus();
					// opeInventoryBus.setCol_bus_id(null);
					// opeInventoryBus.setCol_company(null);
					opeInventoryBus.setCol_branch(bus.getRamal());
					opeInventoryBus.setCol_eco(String.valueOf(bus.getEco()));
					opeInventoryBus.setCol_route(String.valueOf(bus.getRuta()));
					// opeInventoryBus.setCol_sam_id(null);
					// opeInventoryBus.setCol_sim_id(null);
					// opeInventoryBus.setCol_validator(null);
					// opeInventoryBus.setCol_phone_number(null);
					// opeInventoryBus.setCol_nomenclature(null);
					opeInventoryBus.setCol_serie(bus.getVin());
					// opeInventoryBus.setCol_placa_icv(null);
					// opeInventoryBus.setCol_client(null);
					opeInventoryBus.setCol_created_at(UtilsSTCM.getDateTime());
					// opeInventoryBus.setCol_last_connect(null);
					// opeInventoryBus.setCol_count_connect(null);
					// opeInventoryBus.setCol_meid(null);
					// opeInventoryBus.setCol_type(null);
					// opeInventoryBus.setCol_brand(null);
					opeInventoryBus.setCol_company_service(bus.getNombreTipoRuta());
					// opeInventoryBus.setCol_maintenance_provider(null);
					// opeInventoryBus.setStatus(null);
					opeInventoryBus.setEquipment_code(equipmentCode);

					@SuppressWarnings("unused")
					OpeInventoryBus savedInventoryBus = deviceService.insertInventoryBus(opeInventoryBus);
				} else {
					// actualizar
					@SuppressWarnings("unused")
					int updateInventoryBusResponse = deviceService.updateInventoryBus(existBus.getCol_id(),
							bus.getRamal(), String.valueOf(bus.getRuta()), bus.getNombreTipoRuta(), equipmentCode);
				}

				// success response
				response.setStatus(200);
				response.setCode(100);
				response.setMessage("Éxito");
				response.setDescription("Buses guardados correctamente");
			}
		} catch (Exception e) {
			response.setStatus(500);
			response.setCode(101);
			response.setMessage("Error");
			response.setDescription("Ocurrió un error al guardar los buses: " + e.getMessage());
		}

		return response;
	}

	private static void validateBusRequest(BusUnitRequest bus) {
		if (bus == null) {
			throw new IllegalArgumentException("El cuerpo de la solicitud está vacío.");
		}
		if (bus.getEco() == 0) {
			throw new IllegalArgumentException("El campo ECO es obligatorio.");
		}
		if (bus.getMarca() == null || bus.getMarca().isEmpty()) {
			throw new IllegalArgumentException("El campo Marca es obligatorio.");
		}
		if (bus.getVin() == null || bus.getVin().isEmpty()) {
			throw new IllegalArgumentException("El campo VIN es obligatorio.");
		}
		if (bus.getRuta() == null || bus.getRamal() == null || bus.getRuta().isEmpty() || bus.getRamal().isEmpty()) {
			throw new IllegalArgumentException("Ruta y Ramal son obligatorios.");
		}
	}

	private static OpeBusUnits createBusUnitEntity(BusUnitRequest bus) {
		OpeBusUnits entity = new OpeBusUnits();
		entity.setEco_number(String.valueOf(bus.getEco()));
		entity.setBus_brand(bus.getMarca());
		entity.setBus_niv(bus.getVin());
		entity.setCreated_at(UtilsSTCM.getDateTime());
		return entity;
	}

	private static void insertInventory(DeviceService deviceService, OpeBusUnits savedBusUnit) {
		OpeInventory inventory = new OpeInventory();
		inventory.setId_device(1);
		inventory.setId_bus(savedBusUnit.getId());
		inventory.setId_route(1);
		inventory.setId_company_contract(1);
		inventory.setId_company_transport(1);
		inventory.setId_sim(1);
		inventory.setId_sam(1);
		inventory.setStart_date(UtilsSTCM.getDateTime());
		inventory.setUpdated_at(UtilsSTCM.getDateTime());
		deviceService.insertInventory(inventory);
	}

	private static AfcEquipmentRequest createAfcEquipmentRequest(DeviceService deviceService, OpeTransportRoutes route,
			OpeTransportStation station) {
		String prefixIp = "172.15.30.";
		String ip = deviceService.obtenerIP(String.valueOf(station.getId()));
		String lastOctet = ip.split("\\.")[3]; // Extract the last octet
		String nextIp = prefixIp + (Integer.parseInt(lastOctet) + 1);
		String mac = parseIpToMac(nextIp);

		AfcEquipmentRequest request = new AfcEquipmentRequest();
		request.setIdCompany(1);
		request.setIdStation(Long.parseLong(route.getCode_stcm(), 10));
		request.setType("0009");
		request.setMode("0001");
		request.setState("0001");
		request.setIpAddress(nextIp);
		request.setMacAddress(mac);
		request.setUserHost("ddt");
		request.setPassHost("metroxyz");
		request.setPortHost("22");
		return request;
	}

	private static void updateBusUnitWithEquipmentCode(DeviceService deviceService, OpeBusUnits savedBusUnit,
			AfcEquipmentResponse response) {
		if (response.getEquipmentList().isEmpty()) {
			throw new IllegalStateException("No se generó el código del equipo.");
		}
		String equipmentCode = response.getEquipmentList().get(0).getCode();
		deviceService.updateBusUnit(savedBusUnit.getId(), equipmentCode);
	}

	public static String parseIpToMac(String ip) {
		// Split the IP into its 4 octets
		String[] segments = ip.split("\\.");

		// validate we have at least 4 octets
		if (segments.length != 4) {
			throw new IllegalArgumentException("Invalid IP format");
		}

		StringBuilder macBuilder = new StringBuilder("01:72:15:");

		// last two octets (2182 and 15) are separated and included in the format
		String lastOctet1 = String.format("%02d", Integer.parseInt(segments[2]) / 256); // Obtiene el primer valor (ej.
																						// 2182 / 256 = 21)
		String lastOctet2 = String.format("%02d", Integer.parseInt(segments[2]) % 256); // Obtiene el segundo valor (ej.
																						// 2182 % 256 = 82)
		// Construct the MAC with the octet values
		macBuilder.append(lastOctet1).append(":");
		macBuilder.append(lastOctet2).append(":");
		macBuilder.append(String.format("%02d", Integer.parseInt(segments[3]))); // El último octeto

		return macBuilder.toString();
	}
}
