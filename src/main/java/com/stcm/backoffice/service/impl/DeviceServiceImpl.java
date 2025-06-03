package com.stcm.backoffice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stcm.backoffice.entity.OpeEventHist;
import com.stcm.backoffice.entity.OpeEventStatistics;
import com.stcm.backoffice.entity.OpeTransportStation;
import com.stcm.backoffice.entity.OpeTransportType;
import com.stcm.backoffice.entity.OpeTransportUnits;
import com.stcm.backoffice.entity.OpeUser;
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
import com.stcm.backoffice.entity.OpeBusUnits;
import com.stcm.backoffice.entity.OpeBusUnitsDetails;
import com.stcm.backoffice.entity.OpeCompany;
import com.stcm.backoffice.entity.OpeCompanyContract;
import com.stcm.backoffice.entity.OpeCompanyTransport;
import com.stcm.backoffice.entity.OpeDevices;
import com.stcm.backoffice.entity.OpeGrayListCard;
import com.stcm.backoffice.entity.OpeInventory;
import com.stcm.backoffice.entity.OpeInventoryBus;
import com.stcm.backoffice.entity.response.Response;
import com.stcm.backoffice.entity.TransactionQR;
import com.stcm.backoffice.entity.CatCategoryTitle;
import com.stcm.backoffice.entity.CatType;
import com.stcm.backoffice.entity.CatTypeTicketingValidation;
import com.stcm.backoffice.entity.CatTypeTitle;
import com.stcm.backoffice.entity.MetroSchPryDevices;
import com.stcm.backoffice.entity.OpeAccess;
import com.stcm.backoffice.entity.OpeAccessDetails;
import com.stcm.backoffice.repository.OpeBusUnitDetailRepository;
import com.stcm.backoffice.repository.OpeBusUnitRepository;
import com.stcm.backoffice.repository.OpeCompanyContractRepository;
import com.stcm.backoffice.repository.OpeCompanyRepository;
import com.stcm.backoffice.repository.OpeCompanyTransportRepository;
import com.stcm.backoffice.repository.OpeDevicesRepository;
import com.stcm.backoffice.repository.OpeGrayListCardRepository;
import com.stcm.backoffice.repository.OpeInventoryBusRepository;
import com.stcm.backoffice.repository.TransactionQrRepository;
import com.stcm.backoffice.entity.request.DeviceTransactionQR;
import com.stcm.backoffice.entity.request.KeyRequest;
import com.stcm.backoffice.entity.OpeAfcEquipment;
import com.stcm.backoffice.entity.OpeBackofficeControl;
import com.stcm.backoffice.repository.CatCategoryTitleRepository;
import com.stcm.backoffice.repository.CatTypeAfcEquipmentRepository;
import com.stcm.backoffice.repository.CatTypeEquipmentStatusRepository;
import com.stcm.backoffice.repository.CatTypeNodeRepository;
import com.stcm.backoffice.repository.CatTypeTicketingModeRepository;
import com.stcm.backoffice.repository.CatTypeTicketingValidationRepository;
import com.stcm.backoffice.repository.CatTypeTitleRepository;
import com.stcm.backoffice.repository.MetroSchPryDevicesRepository;
import com.stcm.backoffice.repository.OpeAccessDetailsRepository;
import com.stcm.backoffice.repository.OpeAccessRepository;
import com.stcm.backoffice.repository.OpeAfcEquipmentRepository;
import com.stcm.backoffice.repository.OpeBackofficeControlRepository;
import com.stcm.backoffice.repository.OpeEventHistRepository;
import com.stcm.backoffice.repository.OpeEventStatisticsRepository;
import com.stcm.backoffice.repository.OpeInventoryCardRepository;
import com.stcm.backoffice.repository.OpeInventoryRepository;
import com.stcm.backoffice.repository.OpePlacesRepository;
import com.stcm.backoffice.repository.OpeReadersRepository;
import com.stcm.backoffice.repository.OpeRequestKeyLogRepository;
import com.stcm.backoffice.repository.OpeSamRepository;
import com.stcm.backoffice.repository.OpeSimRepository;
import com.stcm.backoffice.repository.OpeStoresRepository;
import com.stcm.backoffice.repository.OpeTransportConfigRepository;
import com.stcm.backoffice.repository.OpeTransportStationRepository;
import com.stcm.backoffice.repository.OpeTransportTypeRepository;
import com.stcm.backoffice.repository.OpeTransportUnitsRepository;
import com.stcm.backoffice.repository.OpeUsersRepository;
import com.stcm.backoffice.service.DeviceService;
import com.stcm.backoffice.repository.OpeTransportLineRepository;
import com.stcm.backoffice.repository.OpeTransportRouteDetailRepository;
import com.stcm.backoffice.repository.OpeTransportRouteRepository;

@Service
public class DeviceServiceImpl implements DeviceService {

	/*
	 * 
	 * Transport Line
	 * 
	 */
	@Autowired
	private OpeTransportLineRepository opeTransportLineRepository;

	@Override
	public List<OpeTransportLine> retrieveLines() {

		return opeTransportLineRepository.findAll();
	}

	@Override
	public OpeTransportLine retrieveLine(int id_line) {

		return opeTransportLineRepository.findById(id_line);
	}

	@Override
	public OpeTransportLine insertLine(OpeTransportLine line) {
		return opeTransportLineRepository.save(line);
	}

	/*
	 * 
	 * OpeTransportStation
	 * 
	 */
	@Autowired
	OpeTransportStationRepository opeTransportStationRepository;

	@Override
	public OpeTransportStation retrieveTransportStationById(long id) {

		return opeTransportStationRepository.getById(id);
	}
	
	@Override
	public OpeTransportStation retrieveTransportStationByName(String name) {

		return opeTransportStationRepository.getByName(name);
	}

	@Override
	public List<OpeTransportStation> retrieveStations() {
		return opeTransportStationRepository.retrieveStations();
	}

	@Override
	public OpeTransportStation insertStation(OpeTransportStation station) {
		return opeTransportStationRepository.save(station);
	}

	@Override
	public int updateStation(long id, String code, String updated_at) {
		return opeTransportStationRepository.update(id, code, updated_at);
	}

	/*
	 * 
	 * Transport Units
	 * 
	 */
	@Autowired
	OpeTransportUnitsRepository opeTransportUnitsRepository;

	@Override
	public OpeTransportUnits retrieveTransportUnitById(long id) {

		return opeTransportUnitsRepository.findById(id);
	}

	@Override
	public List<OpeTransportUnits> retrieveAllTransportUnit() {

		return opeTransportUnitsRepository.getAll();
	}

	/*
	 * 
	 * Bus Units
	 * 
	 */
	@Autowired
	OpeBusUnitRepository opeBusRepository;

	public List<OpeBusUnits> retrieveAllBusUnit() {

		return opeBusRepository.getAll();
	}

	@Autowired
	OpeBusUnitDetailRepository opeBusUnitDetailRepository;

	public List<OpeBusUnitsDetails> retrieveAllBusUnitDetails() {

		return opeBusUnitDetailRepository.getAllDetails();
	}

	public OpeBusUnits insertBusUnit(OpeBusUnits tempBusUnit) {

		return opeBusRepository.save(tempBusUnit);
	}

	public int updateBusUnit(long id, String code) {
		return opeBusRepository.update(id, code);
	}

	public OpeBusUnits existsBus(String eco, String marca, String vin) {
		return opeBusRepository.checkIfBusExists(eco, marca, vin);

	}

	/*
	 * 
	 * metrorrey.sch_pry_mty.ope_inventory_bus
	 * 
	 */

	@Autowired
	OpeInventoryBusRepository opeInventoryBusRepository;

	public OpeInventoryBus existInventoryBusRegister(String eco, String vin) {
		return opeInventoryBusRepository.checkIfBusExists(eco, vin);

	}

	public int updateInventoryBus(long id, String ramal, String ruta, String tipoRuta, String equipment_code) {
		return opeInventoryBusRepository.updateBus(id, ramal, ruta, tipoRuta, equipment_code);
	}

	public OpeInventoryBus insertInventoryBus(OpeInventoryBus tpm) {
		return opeInventoryBusRepository.save(tpm);
	}

	public int updateInventoryBusFromDevice(long idBus, String nsd, String sam, String sim, String validatorId,
			String marca) {

		return opeInventoryBusRepository.updateInventoryBusFromDevice(idBus, nsd, sam, sim, validatorId, marca);
	}

	/*
	 * 
	 * Inventory
	 * 
	 */

	@Autowired
	OpeInventoryRepository opeInventoryRepository;

	public OpeInventory insertInventory(OpeInventory tmp) {

		return opeInventoryRepository.save(tmp);
	}

	public int updateOpeInventory(long idBus, long idDevice, int idSam, int idSim) {
		return opeInventoryRepository.updateInventory(idBus, idDevice, idSam, idSim);
	}

	/*
	 * 
	 * Transport Routes
	 * 
	 */
	@Autowired
	OpeTransportRouteRepository opeTransportRouteRepository;

	@Override
	public List<OpeTransportRoutes> retrieveAllTransportRoute() {

		return opeTransportRouteRepository.getAll();
	}

	@Override
	public OpeTransportRoutes existsRutaAndRamal(String ruta, String ramal) {

		return opeTransportRouteRepository.checkIfRouteExists(ruta, ramal);

	}

	@Autowired
	OpeTransportRouteDetailRepository opeTransportRouteDetailsRepository;

	@Override
	public List<OpeTransportRoutesDetails> retrieveAllTransportRouteDetails() {

		return opeTransportRouteDetailsRepository.getAll();
	}

	@Override
	public List<OpeTransportRoutesDetails> retrieveTransportRouteDetailsBy(String route_code, String transport_code,
			String contract_code) {

		return opeTransportRouteDetailsRepository.findFilter(route_code, transport_code, contract_code);
	}

	/*
	 * 
	 * Company Contract
	 * 
	 */

	@Autowired
	OpeCompanyContractRepository opeCompanyContractRepository;

	@Override
	public List<OpeCompanyContract> retrieveAllCompanyContract() {

		return opeCompanyContractRepository.getAll();
	}

	@Override
	public OpeCompanyContract existsTipoRuta(String tipoRuta) {

		return opeCompanyContractRepository.existsTipoRuta(tipoRuta);

	}

	/*
	 * 
	 * Company Transport
	 * 
	 */

	@Autowired
	OpeCompanyTransportRepository opeCompanyTransportRepository;

	@Override
	public List<OpeCompanyTransport> retrieveAllCompanyTransport() {

		return opeCompanyTransportRepository.getAll();
	}

	/*
	 * 
	 * Devices
	 * 
	 */

	@Autowired
	OpeDevicesRepository opeDevicesRepository;

	@Override
	public List<OpeDevices> retrieveAllDevices() {
		return opeDevicesRepository.getAll();
	}

	@Override
	public OpeDevices insertDevice(OpeDevices entity) {
		return opeDevicesRepository.save(entity);
	}

	public OpeDevices existDevice(String id_urbani, String id_validator) {
		return opeDevicesRepository.existDevice(id_urbani, id_validator);

	}

	/*
	 * 
	 * movil_device.inventory.ope_sam
	 * 
	 */
	@Autowired
	OpeSamRepository opeSamRepository;

	@Override
	public OpeSam insertSam(OpeSam entity) {
		return opeSamRepository.save(entity);
	}
	
	public OpeSam existSam(String sam) {
		return opeSamRepository.existsByUiSam(sam);
		
	}
	

	/*
	 * 
	 * movil_device.inventory.ope_sim
	 * 
	 */
	@Autowired
	OpeSimRepository opeSimRepository;

	@Override
	public OpeSim insertSim(OpeSim entity) {
		return opeSimRepository.save(entity);
	}
	
	public OpeSim existSim(String sim) {
		return opeSimRepository.existsByIdSim(sim);
		
	}

	/*
	 * 
	 * AfcEquipment
	 * 
	 */
	@Autowired
	OpeAfcEquipmentRepository afcEquipmentRepository;

	@Override
	public OpeAfcEquipment retrieveAfcEquipmentById(long id) {
		return afcEquipmentRepository.getById(id);
	}

	@Override
	public OpeAfcEquipment retrieveEquipmentByCodeAndStatus(String code, int status) {
		return afcEquipmentRepository.getByCodeAndStatus(code, status);
		
	}
	
	@Override
	public OpeAfcEquipment retrieveAfcEquipmentByCode(String code) {
		return afcEquipmentRepository.getByCode(code);
	}

	@Override
	public List<OpeAfcEquipment> retrieveAfcEquipmentByType(String type) {
		return afcEquipmentRepository.getByType(type);
	}

	@Override
	public OpeAfcEquipment insertAfcEquipment(OpeAfcEquipment equipment) {
		return afcEquipmentRepository.save(equipment);
	}

	@Override
	public String obtenerIP(String idStation) {
		return afcEquipmentRepository.obtenerUltimoConsecutivo(idStation);
	}
	
	@Override
	public List<OpeAfcEquipment> retrieveAfcEquipmentByStationName(String name) {
		return afcEquipmentRepository.getByStationName(name);
	}
	/*
	 * 
	 * Cat Type: Node Station
	 * 
	 */

	@Autowired
	CatTypeNodeRepository catTypeNodeRepository;

	@Autowired
	CatTypeTicketingModeRepository catTypeTicketingModeRepository;

	@Autowired
	CatTypeEquipmentStatusRepository catTypeEquipmentStatusRepository;

	@Autowired
	CatTypeAfcEquipmentRepository catTypeAfcEquipmentRepository;

	@Override
	public CatType retrieveTypeNode(String code) {

		return catTypeNodeRepository.findByCode(code);
	}

	@Override
	public CatType retrieveTypeTicketingMode(String code) {

		return catTypeTicketingModeRepository.findByCode(code);
	}

	@Override
	public CatType retrieveTypeEquipmentStatus(String code) {

		return catTypeEquipmentStatusRepository.findByCode(code);
	}

	@Override
	public CatType retrieveTypeAfcEquipment(String code) {

		return catTypeAfcEquipmentRepository.findByCode(code);
	}

	/*
	 * CatTicketingValidation
	 * 
	 */
	@Autowired
	CatTypeTicketingValidationRepository catTicketingValidationRepository;
	
	@Override
	public CatTypeTicketingValidation retrieveCatTicketingValidation(String code, int status) {
		return catTicketingValidationRepository.findCatTicketingByCodeAndStatus(code, status);
	}
	
	/*
	 * 
	 * Ope Company
	 * 
	 */
	@Autowired
	OpeCompanyRepository opeCompanyRepository;

	@Override
	public OpeCompany retrieveCompany(long id) {

		return opeCompanyRepository.getById(id);
	}

	/*
	 * 
	 * CatTitleType
	 * 
	 */

	@Autowired
	CatTypeTitleRepository catTypeTitleRepository;

	@Override
	public List<CatTypeTitle> retrieveTitleType() {

		return catTypeTitleRepository.getList();
	}

	@Override
	public CatTypeTitle retrieveTypeTitleByCodeAndStatus(String code, int status) {
		
		return catTypeTitleRepository.getTypeTitleByCodeAndStatus(code, status);
	}
	
	/*
	 * 
	 * CatCategoryTitle
	 * 
	 */

	@Autowired
	CatCategoryTitleRepository catCategoryTitleRepository;

	@Override
	public List<CatCategoryTitle> retrieveTitleCategory() {

		return catCategoryTitleRepository.getList();
	}

	/*
	 * 
	 * InventoryCards
	 * 
	 */
	@Autowired
	private OpeInventoryCardRepository inventoryCardRepository;

	@Override
	public OpeInventoryCard retrieveInventoryCard(long id) {
		return inventoryCardRepository.retrieveInventoryCard(id);
	}

	@Override
	public OpeInventoryCard retrieveInventoryCard(String uid, String logic_number) {
		return inventoryCardRepository.retrieveInventoryCard(uid, logic_number);
	}

	@Override
	public List<OpeInventoryCard> retrieveInventoryCards(long id, long top) {
		return inventoryCardRepository.retrieveInventoryCards(id, top);
	}

	@Override
	public OpeInventoryCard retrieveInventoryCard(String logic_number) {
		return inventoryCardRepository.retrieveInventoryCard(logic_number);
	}

	/*
	 * 
	 * User
	 * 
	 */
	@Autowired
	private OpeUsersRepository usersRepository;

	@Override
	public List<OpeUser> retrieveUsers(String code) {
		return usersRepository.retrieveUsers(code);
	}

	/*
	 * 
	 * EventHist
	 * 
	 */
	@Autowired
	private OpeEventHistRepository opeEventHistRepository;

	@Override
	public OpeEventHist retrieveEventHist(long id) {
		return opeEventHistRepository.retrieveEventHist(id);
	}

	@Override
	public OpeEventHist insertEventHist(OpeEventHist opeEventHist) {

		OpeEventHist event = opeEventHistRepository.saveAndFlush(opeEventHist);
		return event;
	}

	public OpeEventHist retrieveEventHist(long id, int event_state, long id_equipment, int event_type, long id_company,
			int event_code, int equipment_type) {

		return opeEventHistRepository.retrieveEventHist(id, event_state, id_equipment, event_type, id_company,
				event_code, equipment_type);
	}

	@Override
	public int updateEventHist(long id, int event_state) {
		return opeEventHistRepository.updateEventHist(id, event_state);
	}

	@Autowired
	private OpeEventStatisticsRepository opeEventStatisticsRepository;

	@Override
	public OpeEventStatistics retrieveEventStatistics(int id_company, int event_type, int event_code,
			int equipment_type, long id_equipment) {
		return opeEventStatisticsRepository.retrieveEventStatistics(id_company, event_type, event_code, equipment_type,
				id_equipment);

	}

	@Override
	public int updateEventstatistics(long id, int active) {
		return opeEventStatisticsRepository.updateEventStatistics(id, active);
	}

	@Override
	public OpeEventStatistics insertEventStatistics(OpeEventStatistics stadistic) {
		OpeEventStatistics event = opeEventStatisticsRepository.saveAndFlush(stadistic);
		return event;
	}



	/*
	 * 
	 * Gray List
	 * 
	 */
	@Autowired
	private OpeGrayListCardRepository grayListRepository;

	@Override
	public List<OpeGrayListCard> retrieveGrayList() {
		return grayListRepository.findAll();
	}

	/*
	 * 
	 * Gray List
	 * 
	 */
	@Autowired
	private TransactionQrRepository transactionQrRepository;

	@Override
	public Response insertTransactionQr(DeviceTransactionQR transaction) {
		Response res = new Response();
		TransactionQR temp = new TransactionQR(transaction);
		TransactionQR trans = transactionQrRepository.save(temp);

		if (temp.getId() == trans.getId()) {
			res.setSucceeded(true);
			res.setMessage("Successful Save Transaction");
			res.setTrace("");
			res.setErrors("");
			return res;
		} else {
			res.setSucceeded(false);
			res.setMessage("");
			res.setTrace("");
			res.setErrors("Error, Duplicated Transaction");
			return res;
		}
	}

	/*
	 * metrorrey.sch_pry_mty.devices
	 */
	@Autowired
	private MetroSchPryDevicesRepository metroSchPryDevicesRepository;

	@Override
	public MetroSchPryDevices existMetroSchPryDevices(String nsd) {
		return metroSchPryDevicesRepository.existMetroSchPryDevices(nsd);
	}

	@Override
	public MetroSchPryDevices metroSchPryDevicesInsert(MetroSchPryDevices entitySchPryDevices) {
		return metroSchPryDevicesRepository.save(entitySchPryDevices);
	}

	/*
	 * movil_device.inventory.ope_transport_type
	 */
	@Autowired
	private OpeTransportTypeRepository opeTransportTypeRepository;

	@Override
	public OpeTransportType getTipoRuta(String tipoRuta) {
		return opeTransportTypeRepository.getTipoRuta(tipoRuta);
	}

	/*
	 * movil_device.configs.ope_transport_config
	 */
	@Autowired
	private OpeTransportConfigRepository opeTransportConfigRepository;

	@Override
	public OpeTransportConfig getTransportConfig(int transportLineId) {
		return opeTransportConfigRepository.getTransportConfig(transportLineId);

	}

	/*
	 * Access
	 * 
	 */
	@Autowired
	OpeAccessRepository opeAccessRepository;

	@Override
	public OpeAccess retrieveAccess(long id, long id_station, String transaction_date) {
		
		return opeAccessRepository.retrieveAccess(id, id_station, transaction_date);
	}
	
	@Override
	public OpeAccess insertAccess(OpeAccess opeAccess) {
		
		return opeAccessRepository.saveAndFlush(opeAccess);
	}

	/*
	 * Access
	 * 
	 */
	@Autowired
	OpeAccessDetailsRepository opeAccessDetailsRepository;

	@Override
	public OpeAccessDetails insertAccessDetails(OpeAccessDetails opeAccess) {
		
		return opeAccessDetailsRepository.saveAndFlush(opeAccess);
	}
	
	@Autowired
	OpeRequestKeyLogRepository opeRequestKeyLogRepository;
	
	@Override
	public OpeRequestKeyLog insertRequestKeyLog(KeyRequest request) {
		
		OpeRequestKeyLog toSave = new OpeRequestKeyLog(request);
		
		return opeRequestKeyLogRepository.saveAndFlush(toSave);
	}
	
	@Autowired
	OpeStoresRepository opeStoresRepository;
	
	@Override
	public OpeStores retrieveStoresByCode(String code) {
		return opeStoresRepository.getStoreByCode(code);
		
	}
	
	@Override
	public OpeStores insertStore(OpeStores store) {
		return opeStoresRepository.saveAndFlush(store);
		
	}
	
	@Autowired
	OpePlacesRepository opePlacesRepository;
	
	@Override
	public OpePlaces retrievePlacesByCode(String code) {
		return opePlacesRepository.getByCode(code);
		
	}
	
	@Autowired
	OpeReadersRepository opeReadersRepository;
	
	public OpeReaders insertReaders(OpeReaders reader) {
		
		return opeReadersRepository.saveAndFlush(reader);
	}
	
	@Autowired
	OpeBackofficeControlRepository opeBackofficeControlRepository ;
	
	public OpeBackofficeControl insertBackofficeControl(OpeBackofficeControl backoffice) {
		
		return opeBackofficeControlRepository.saveAndFlush(backoffice);
	}
}