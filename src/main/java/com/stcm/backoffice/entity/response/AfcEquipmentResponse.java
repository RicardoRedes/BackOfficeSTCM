package com.stcm.backoffice.entity.response;

import java.util.List;

public class AfcEquipmentResponse {

	List<AfcEquipment> equipmentList;

	private int status;
	private int code;
	private String message;
	private String description;

	public List<AfcEquipment> getEquipmentList() {
		return equipmentList;
	}

	public void setEquipmentList(List<AfcEquipment> equipmentList) {
		this.equipmentList = equipmentList;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
