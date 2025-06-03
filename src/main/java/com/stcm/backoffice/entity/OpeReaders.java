/*
 * Autor: Marcela Cecilia Gómez Bautista
 * Fecha: 19/06/2024
 * Departamento: Desarrollo Tecnológico
 * 
 */
package com.stcm.backoffice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.stcm.backoffice.utils.UtilsSTCM;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "ope_readers", catalog = "oxxo_prepago", schema = "dbo")
public class OpeReaders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String serial_num;
	private String uid_sam; // esta contenido en el modificador
	private String general_key;
	private long request_count;
	private long id_store; // must be integer
	private String code_cash_register;
	private int id_setting;
	private String created_at;
	private String updated_at;
	private long id_equipment;
	private String code_equipment;
	private long id_register_user;
	private String updated_register;
	private int status;

	public OpeReaders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OpeReaders(long id_store, long idEquipment, String equipmentCode, long id_register_user, int idSettings) {
		this.serial_num = null;
		this.uid_sam = null;
		this.general_key = null;
		this.request_count = 0;
		this.id_store = id_store;
		this.code_cash_register = null;
		this.id_setting = idSettings;
		this.created_at = UtilsSTCM.getDateTime();
		this.updated_at = null;
		this.id_equipment = idEquipment;
		this.code_equipment = equipmentCode;
		this.id_register_user = id_register_user;
		this.updated_register = null;
		this.status = 0;

	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSerial_num() {
		return serial_num;
	}

	public void setSerial_num(String serial_num) {
		this.serial_num = serial_num;
	}

	public String getUid_sam() {
		return uid_sam;
	}

	public void setUid_sam(String uid_sam) {
		this.uid_sam = uid_sam;
	}

	public String getGeneral_key() {
		return general_key;
	}

	public void setGeneral_key(String general_key) {
		this.general_key = general_key;
	}

	public long getRequest_count() {
		return request_count;
	}

	public void setRequest_count(long request_count) {
		this.request_count = request_count;
	}

	public long getId_store() {
		return id_store;
	}

	public void setId_store(long id_store) {
		this.id_store = id_store;
	}

	public String getCode_cash_register() {
		return code_cash_register;
	}

	public void setCode_cash_register(String code_cash_register) {
		this.code_cash_register = code_cash_register;
	}

	public int getId_setting() {
		return id_setting;
	}

	public void setId_setting(int id_setting) {
		this.id_setting = id_setting;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public long getId_equipment() {
		return id_equipment;
	}

	public void setId_equipment(long id_equipment) {
		this.id_equipment = id_equipment;
	}

	public String getCode_equipment() {
		return code_equipment;
	}

	public void setCode_equipment(String code_equipment) {
		this.code_equipment = code_equipment;
	}

	public long getId_register_user() {
		return id_register_user;
	}

	public void setId_register_user(long id_register_user) {
		this.id_register_user = id_register_user;
	}

	public String getUpdated_register() {
		return updated_register;
	}

	public void setUpdated_register(String updated_register) {
		this.updated_register = updated_register;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
