package com.stcm.backoffice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.stcm.backoffice.entity.request.AfcEquipmentRequest;
import com.stcm.backoffice.utils.UtilsSTCM;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "ope_afc_equipment", catalog = "metrorrey", schema = "sch_pry_mty")
public class OpeAfcEquipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Long id_company;
	private Long id_station;
	private Long id_unit;
	private String code;
	private String type;
	private String mode;
	private String state;
	private String ip_address;
	private String comment;
	private String created_at;
	private String updated_at;
	private int status;
	private String mac_address;
	private String user_host;
	private String pass_host;
	private String port_host;
	private int telvent_code;

	public OpeAfcEquipment() {
	}
	
	public OpeAfcEquipment(AfcEquipmentRequest tmp) {
		this.id_company = tmp.getIdCompany();
		this.id_station = tmp.getIdStation();
		this.id_unit = tmp.getId_unit();
		this.code = tmp.getCode();
		this.type = tmp.getType();
		this.mode = tmp.getMode();
		this.state = tmp.getState();
		this.ip_address = tmp.getIpAddress();
		this.comment = tmp.getComment();
		this.created_at = UtilsSTCM.getDateTime();
		this.updated_at = null;
		this.status = 1;
		this.mac_address = tmp.getMacAddress();
		this.user_host = tmp.getUserHost();
		this.pass_host = tmp.getPassHost();
		this.port_host = tmp.getPortHost();
		this.telvent_code = tmp.getTelventCode();
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId_company() {
		return id_company;
	}

	public void setId_company(long id_company) {
		this.id_company = id_company;
	}

	public Long getId_station() {
		return id_station;
	}

	public void setId_station(Long id_station) {
		this.id_station = id_station;
	}

	public Long getId_unit() {
		return id_unit;
	}

	public void setId_unit(Long id_unit) {
		this.id_unit = id_unit;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public String getMac_address() {
		return mac_address;
	}

	public void setMac_address(String mac_address) {
		this.mac_address = mac_address;
	}

	public String getUser_host() {
		return user_host;
	}

	public void setUser_host(String user_host) {
		this.user_host = user_host;
	}

	public String getPass_host() {
		return pass_host;
	}

	public void setPass_host(String pass_host) {
		this.pass_host = pass_host;
	}

	public String getPort_host() {
		return port_host;
	}

	public void setPort_host(String port_host) {
		this.port_host = port_host;
	}

	public int getTelvent_code() {
		return telvent_code;
	}

	public void setTelvent_code(int telvent_code) {
		this.telvent_code = telvent_code;
	}
}
