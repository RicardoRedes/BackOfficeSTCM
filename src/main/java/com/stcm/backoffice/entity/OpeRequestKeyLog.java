package com.stcm.backoffice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.stcm.backoffice.entity.request.KeyRequest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "ope_request_key_log", catalog = "metrorrey", schema = "sch_pry_mty")
public class OpeRequestKeyLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	private String id_line;
	private String id_station;
	private String id_equipment;
	private String serial_num;
	private String modificador;
	private String created_at;
	private String updated_at;
	private String generated_key;
	private int status;
	
	public OpeRequestKeyLog(KeyRequest tmp) {
		this.id_line = tmp.getLinea_id();
		this.id_station = tmp.getEstacion_id();
		this.id_equipment = tmp.getDispositivo_id();
		this.serial_num = tmp.getSerial_num();
		this.modificador = tmp.getModificador();
		this.created_at = tmp.getCreated_at();
		this.updated_at = null;
		this.generated_key = tmp.getGenerated_key();
		this.status = tmp.getStatus();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getId_line() {
		return id_line;
	}

	public void setId_line(String id_line) {
		this.id_line = id_line;
	}

	public String getId_station() {
		return id_station;
	}

	public void setId_station(String id_station) {
		this.id_station = id_station;
	}

	public String getId_equipment() {
		return id_equipment;
	}

	public void setId_equipment(String id_equipment) {
		this.id_equipment = id_equipment;
	}

	public String getSerial_num() {
		return serial_num;
	}

	public void setSerial_num(String serial_num) {
		this.serial_num = serial_num;
	}

	public String getModificador() {
		return modificador;
	}

	public void setModificador(String modificador) {
		this.modificador = modificador;
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

	public String getGenerated_key() {
		return generated_key;
	}

	public void setGenerated_key(String generated_key) {
		this.generated_key = generated_key;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
