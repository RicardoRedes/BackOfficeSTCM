package com.stcm.backoffice.service;

import java.util.List;

import com.stcm.backoffice.entity.OpeEventHist;
import com.stcm.backoffice.entity.OpeEventStatistics;
import com.stcm.backoffice.entity.OpeTransportStation;
import com.stcm.backoffice.entity.OpeTransportType;
import com.stcm.backoffice.entity.OpeTransportUnits;
import com.stcm.backoffice.entity.OpeUser;
import com.stcm.backoffice.entity.CatCategoryTitle;
import com.stcm.backoffice.entity.CatType;
import com.stcm.backoffice.entity.CatTypeTicketingValidation;
import com.stcm.backoffice.entity.CatTypeTitle;
import com.stcm.backoffice.entity.MetroSchPryDevices;
import com.stcm.backoffice.entity.OpeAccess;
import com.stcm.backoffice.entity.OpeAccessDetails;
import com.stcm.backoffice.entity.OpeInventoryCard;
import com.stcm.backoffice.entity.OpePlaces;
import com.stcm.backoffice.entity.OpeReaders;
import com.stcm.backoffice.entity.OpeRequestKeyLog;
import com.stcm.backoffice.entity.OpeSam;
import com.stcm.backoffice.entity.OpeSim;
import com.stcm.backoffice.entity.OpeStores;
import com.stcm.backoffice.entity.OpeTransportConfig;
import com.stcm.backoffice.entity.OpeTransportLine;
import com.stcm.backoffice.entity.OpeTransportRoutes;
import com.stcm.backoffice.entity.OpeTransportRoutesDetails;
import com.stcm.backoffice.entity.response.Response;
import com.stcm.backoffice.entity.request.DeviceTransactionQR;
import com.stcm.backoffice.entity.request.KeyRequest;
import com.stcm.backoffice.entity.OpeBusUnits;
import com.stcm.backoffice.entity.OpeBusUnitsDetails;
import com.stcm.backoffice.entity.OpeCompany;
import com.stcm.backoffice.entity.OpeCompanyContract;
import com.stcm.backoffice.entity.OpeCompanyTransport;
import com.stcm.backoffice.entity.OpeDevices;
import com.stcm.backoffice.entity.OpeGrayListCard;
import com.stcm.backoffice.entity.OpeInventory;
import com.stcm.backoffice.entity.OpeInventoryBus;
import com.stcm.backoffice.entity.OpeAfcEquipment;
import com.stcm.backoffice.entity.OpeBackofficeControl;

public interface DeviceService {

	/*
	 * 
	 * Transport Line
	 * 
	 */
	List<OpeTransportLine> retrieveLines();

	OpeTransportLine retrieveLine(int id_line);

	OpeTransportLine insertLine(OpeTransportLine line);

	/*
	 * 
	 * Transport Station
	 * 
	 */
	OpeTransportStation retrieveTransportStationById(long id);
	OpeTransportStation retrieveTransportStationByName(String name);

	List<OpeTransportStation> retrieveStations();

	OpeTransportStation insertStation(OpeTransportStation station);

	int updateStation(long id, String code, String updated_at);

	/*
	 * 
	 * Transport Units
	 * 
	 */
	OpeTransportUnits retrieveTransportUnitById(long id);

	List<OpeTransportUnits> retrieveAllTransportUnit();

	/*
	 * 
	 * Bus Units
	 * 
	 */
	List<OpeBusUnits> retrieveAllBusUnit();

	List<OpeBusUnitsDetails> retrieveAllBusUnitDetails();

	OpeBusUnits insertBusUnit(OpeBusUnits tempBusUnit);
	
	int updateBusUnit(long id, String code);
	
	OpeBusUnits existsBus(String eco, String marca, String vin);
	
	/*
	 * 
	 * metrorrey.sch_pry_mty.ope_inventory_bus
	 * 
	 */
	OpeInventoryBus existInventoryBusRegister(String eco, String vin);
	
	int updateInventoryBus(long id, String ramal, String ruta, String tipoRuta, String equipment_code);
	
	OpeInventoryBus insertInventoryBus(OpeInventoryBus tpm);
	
	int updateInventoryBusFromDevice(long idBus, String nsd, String sam, String sim, String validatorId, String marca);
	

	/*
	 * 
	 * movil_device.inventory.ope_inventory
	 * 
	 */
	OpeInventory insertInventory(OpeInventory tmp);
	
	int updateOpeInventory(long idBus, long idDevice, int idSam, int idSim);

	
	/*|
	 * 
	 * Transport Routes
	 * 
	 */
	List<OpeTransportRoutes> retrieveAllTransportRoute();
	
	OpeTransportRoutes existsRutaAndRamal(String ruta, String ramal);

	List<OpeTransportRoutesDetails> retrieveAllTransportRouteDetails();

	List<OpeTransportRoutesDetails> retrieveTransportRouteDetailsBy(String route_code, String transport_code,
			String contract_code);

	/*
	 * movil_device.inventory.ope_company_contract
	 * Company Contract
	 * 
	 */
	List<OpeCompanyContract> retrieveAllCompanyContract();
	
	OpeCompanyContract existsTipoRuta(String tipoRuta);

	/*
	 * 
	 * Company Transport
	 * 
	 */
	List<OpeCompanyTransport> retrieveAllCompanyTransport();

	/*
	 * 
	 * movil_device.inventory.ope_devices
	 * 
	 */
	List<OpeDevices> retrieveAllDevices();
	
	OpeDevices insertDevice(OpeDevices entity);
	
	OpeDevices existDevice(String id_urbani, String id_validator);
	
	
	/*
	 * 
	 * movil_device.inventory.ope_sam
	 * 
	 */
	OpeSam insertSam(OpeSam entity);
	OpeSam existSam(String sam);
	

	/*
	 * 
	 * movil_device.inventory.ope_sim
	 * 
	 */
	OpeSim insertSim(OpeSim entity);
	OpeSim existSim(String sim);
	
	
	/*
	 * 
	 * OpeAfcEquipments
	 * 
	 */
	OpeAfcEquipment retrieveAfcEquipmentById(long id);
	
	OpeAfcEquipment retrieveEquipmentByCodeAndStatus(String code, int status);

	OpeAfcEquipment retrieveAfcEquipmentByCode(String code);

	List<OpeAfcEquipment> retrieveAfcEquipmentByType(String type);

	OpeAfcEquipment insertAfcEquipment(OpeAfcEquipment equipment);
	
	String obtenerIP(String idStation);
	
	List<OpeAfcEquipment> retrieveAfcEquipmentByStationName(String type);

	/*
	 * 
	 * Cat Type: Node Station Ticketing Mode Equipment Status Afc Equipment
	 * 
	 */
	CatType retrieveTypeNode(String code);

	CatType retrieveTypeTicketingMode(String code);

	CatType retrieveTypeEquipmentStatus(String code);

	CatType retrieveTypeAfcEquipment(String code);

	/*
	 * CatTypeTicketingValidation
	 * 
	 */
	
	CatTypeTicketingValidation retrieveCatTicketingValidation(String code, int status);
	
	/*
	 * 
	 * OpeCompany
	 * 
	 */
	OpeCompany retrieveCompany(long id);

	/*
	 * 
	 * CatTitleType
	 * 
	 */
	List<CatTypeTitle> retrieveTitleType();
	CatTypeTitle retrieveTypeTitleByCodeAndStatus(String code, int status);

	/*
	 * 
	 * CatCategoryTitle
	 * 
	 */
	List<CatCategoryTitle> retrieveTitleCategory();

	/*
	 * 
	 * InventoryCards
	 * 
	 */
	OpeInventoryCard retrieveInventoryCard(long id);

	OpeInventoryCard retrieveInventoryCard(String uid, String logic_number);

	List<OpeInventoryCard> retrieveInventoryCards(long id, long top);

	OpeInventoryCard retrieveInventoryCard(String logic_number);

	/*
	 * 
	 * User
	 * 
	 */

	List<OpeUser> retrieveUsers(String code);

	/*
	 * 
	 * EventHist
	 * 
	 */
	OpeEventHist retrieveEventHist(long id);

	OpeEventHist insertEventHist(OpeEventHist opeEventHist);

	OpeEventHist retrieveEventHist(long id, int event_state, long id_equipment, int event_type, long id_company,
			int event_code, int equipment_type);

	int updateEventHist(long id, int event_state);

	OpeEventStatistics retrieveEventStatistics(int id_company, int event_type, int event_code, int equipment_type,
			long id_equipment);

	int updateEventstatistics(long id, int active);

	OpeEventStatistics insertEventStatistics(OpeEventStatistics stadistic);

	List<OpeGrayListCard> retrieveGrayList();

	

	Response insertTransactionQr(DeviceTransactionQR transaction);
	
	/*
	 * metrorrey.sch_pry_mty.devices
	 */

	MetroSchPryDevices existMetroSchPryDevices(String idUrbani);

	MetroSchPryDevices metroSchPryDevicesInsert(MetroSchPryDevices entitySchPryDevices);
	
	
	/*
	 * movil_device.inventory.ope_transport_type
	 */

	OpeTransportType getTipoRuta(String tipoRuta);
	
	/*
	 * movil_device.configs.ope_transport_config
	 */

	OpeTransportConfig getTransportConfig(int id);
	
	OpeAccess retrieveAccess(long id, long id_station, String transaction_date);
	
	OpeAccess insertAccess(OpeAccess opeAccess);
	
	OpeAccessDetails insertAccessDetails(OpeAccessDetails opeAccess);
	
	OpeRequestKeyLog insertRequestKeyLog(KeyRequest request);
	
	
	/*
	 * Oxxo
	 * 
	 * */
	
	OpeStores retrieveStoresByCode(String code);
	OpeStores insertStore(OpeStores store);
	OpePlaces retrievePlacesByCode(String code);
	OpeReaders insertReaders(OpeReaders reader);
	OpeBackofficeControl insertBackofficeControl(OpeBackofficeControl backoffice);
}
