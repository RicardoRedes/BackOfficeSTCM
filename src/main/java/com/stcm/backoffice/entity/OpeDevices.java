package com.stcm.backoffice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "ope_devices", catalog = "movil_device", schema = "inventory")
public class OpeDevices {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String manuf_serial_number;
	private String id_urbani;
	private String id_validator;
	private String last_connection;
	private long count_connection;
	private String device_type;
	private String created_at;
	private String updated_at;
	private int status;

	public OpeDevices() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getManuf_serial_number() {
		return manuf_serial_number;
	}

	public void setManuf_serial_number(String manuf_serial_number) {
		this.manuf_serial_number = manuf_serial_number;
	}

	public String getId_urbani() {
		return id_urbani;
	}

	public void setId_urbani(String id_urbani) {
		this.id_urbani = id_urbani;
	}

	public String getId_validator() {
		return id_validator;
	}

	public void setId_validator(String id_validator) {
		this.id_validator = id_validator;
	}

	public String getLast_connection() {
		return last_connection;
	}

	public void setLast_connection(String last_connection) {
		this.last_connection = last_connection;
	}

	public long getCount_connection() {
		return count_connection;
	}

	public void setCount_connection(long count_connection) {
		this.count_connection = count_connection;
	}

	public String getDevice_type() {
		return device_type;
	}

	public void setDevice_type(String device_type) {
		this.device_type = device_type;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
