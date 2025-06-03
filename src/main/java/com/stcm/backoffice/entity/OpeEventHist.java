package com.stcm.backoffice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.stcm.backoffice.entity.request.EventHistRequest;
import com.stcm.backoffice.utils.UtilsSTCM;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "ope_event_hist", catalog = "metrorrey", schema = "sch_pry_mty")
public class OpeEventHist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// TODO: Anadir idCDE
	private long id_cde;
	private int id_company;
	private String message_version;
	private String created_at;
	private String software_version;
	private String working_mode;
	private int operator_id;
	private int operator_profile;
	private int event_type;
	private int event_code;
	private int equipment_type;
	private int id_equipment; // Cambiar por equipment_code
	private int event_state;
	private int counter_event;
	private String updated_at;
	private int device_state;
	private int action_type;
	private int id_station;
	private String param;
	private String event_date;
	

	public OpeEventHist() {
		super();
		//
	}

	public OpeEventHist(EventHistRequest request) {

		this.id_cde = request.getIdCde();
		this.id_company = request.getIdCompany();
		this.message_version = request.getMessageVersion();
		this.created_at = UtilsSTCM.getDateTime();
		this.software_version = request.getSoftwareVersion();
		this.working_mode = request.getSoftwareVersion();
		this.operator_id = request.getOperatorId();
		this.operator_profile = request.getOperatorProfile();
		this.event_type = request.getEventType();
		this.event_code = request.getEventCode();
		this.equipment_type = request.getEquipmentType();
		this.id_equipment = request.getIdEquipment();
		this.event_state = request.getEventState();
		this.counter_event = request.getCounterEvent();
		this.device_state = request.getDeviceState();
		this.action_type = request.getActionType();
		this.id_station = request.getIdStation();
		this.param = request.getParam();
		this.event_date = request.getEventDate();
		

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getId_cde() {
		return id_cde;
	}

	public void setId_cde(int id_cde) {
		this.id_cde = id_cde;
	}

	public int getId_company() {
		return id_company;
	}

	public void setId_company(int id_company) {
		this.id_company = id_company;
	}

	public String getMessage_version() {
		return message_version;
	}

	public void setMessage_version(String message_version) {
		this.message_version = message_version;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getSoftware_version() {
		return software_version;
	}

	public void setSoftware_version(String software_version) {
		this.software_version = software_version;
	}

	public String getWorking_mode() {
		return working_mode;
	}

	public void setWorking_mode(String working_mode) {
		this.working_mode = working_mode;
	}

	public int getOperator_id() {
		return operator_id;
	}

	public void setOperator_id(int operator_id) {
		this.operator_id = operator_id;
	}

	public int getOperator_profile() {
		return operator_profile;
	}

	public void setOperator_profile(int operator_profile) {
		this.operator_profile = operator_profile;
	}

	public int getEvent_type() {
		return event_type;
	}

	public void setEvent_type(int event_type) {
		this.event_type = event_type;
	}

	public int getEvent_code() {
		return event_code;
	}

	public void setEvent_code(int event_code) {
		this.event_code = event_code;
	}

	public int getEquipment_type() {
		return equipment_type;
	}

	public void setEquipment_type(int equipment_type) {
		this.equipment_type = equipment_type;
	}

	public int getId_equipment() {
		return id_equipment;
	}

	public void setId_equipment(int id_equipment) {
		this.id_equipment = id_equipment;
	}

	public int getEvent_state() {
		return event_state;
	}

	public void setEvent_state(int event_state) {
		this.event_state = event_state;
	}

	public int getCounter_event() {
		return counter_event;
	}

	public void setCounter_event(int counter_event) {
		this.counter_event = counter_event;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public int getDevice_state() {
		return device_state;
	}

	public void setDevice_state(int device_state) {
		this.device_state = device_state;
	}

	public int getAction_type() {
		return action_type;
	}

	public void setAction_type(int action_type) {
		this.action_type = action_type;
	}

	public int getId_station() {
		return id_station;
	}

	public void setId_station(int id_station) {
		this.id_station = id_station;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getEvent_date() {
		return event_date;
	}

	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}

	

}
