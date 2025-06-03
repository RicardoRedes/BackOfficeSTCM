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
@Table(name = "ope_event_statistics", catalog = "metrorrey", schema = "sch_pry_mty")
public class OpeEventStatistics {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Necesario para generar valor autoincremental
	private int id;
	private int id_company;
	private String created_at;
	private int event_type;
	private int event_code;
	private int equipment_type;
	private int id_equipment;
	private int active;
	private int counter;
	private String updated_at;

	public OpeEventStatistics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OpeEventStatistics(EventHistRequest request) {

		this.id_company = request.getIdCompany();
		this.created_at = UtilsSTCM.getDateTime();
		this.event_type = request.getEventType();
		this.event_code = request.getEventCode();
		this.equipment_type = request.getEquipmentType();
		this.id_equipment = request.getIdEquipment();
		this.active = 1;
		this.counter = 1;
		this.updated_at = request.getUpdatedAt();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_company() {
		return id_company;
	}

	public void setId_company(int id_company) {
		this.id_company = id_company;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
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

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

}
