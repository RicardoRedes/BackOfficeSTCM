package com.stcm.backoffice.entity.response;

import com.stcm.backoffice.entity.OpeAfcEquipment;

public class AfcEquipment {

	private long id;
	private long idCompany;
	private Long idStation;
	private String code;
	private String state;
	private String ipAddress;
	private String comment;
	private String macAddress;
	private String user_host;
	private String pass_host;
	private String port_host;
	private int telvent_code;
	
	public AfcEquipment() {}
	
	public AfcEquipment(OpeAfcEquipment tmp) {
		this.id = tmp.getId();
		this.idCompany = tmp.getId_company();
		this.idStation = tmp.getId_station();
		this.code = tmp.getCode();
		this.state = tmp.getState();
		this.ipAddress = tmp.getIp_address();
		this.comment = tmp.getComment();
		this.macAddress = tmp.getMac_address();
		this.user_host = tmp.getUser_host();
		this.pass_host = tmp.getPass_host();
		this.port_host = tmp.getPort_host();
		this.telvent_code = tmp.getTelvent_code();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(long idCompany) {
		this.idCompany = idCompany;
	}
	public Long getIdStation() {
		return idStation;
	}
	public void setIdStation(Long idStation) {
		this.idStation = idStation;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
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
