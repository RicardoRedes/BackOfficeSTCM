package com.stcm.backoffice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "ope_inventory_card", catalog = "metrorrey", schema= "sch_pry_mty")
public class OpeInventoryCard {
	
	@Id
	private int id;
	private String uid;
	private String type_card;
	private int id_lot;
	private String inventory_status;
	private String model;
	private String brand;
	private String created_at;
	private String updated_at;
	private int status;
	private String logic_number;
	private String pcn;
	
	
	public OpeInventoryCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUid() {
		return uid;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String getType_card() {
		return type_card;
	}
	
	public void setType_card(String type_card) {
		this.type_card = type_card;
	}
	
	public int getId_lot() {
		return id_lot;
	}
	
	public void setId_lot(int id_lot) {
		this.id_lot = id_lot;
	}
	
	public String getInventory_status() {
		return inventory_status;
	}
	
	public void setInventory_status(String inventory_status) {
		this.inventory_status = inventory_status;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
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
	
	public String getLogic_number() {
		return logic_number;
	}
	
	public void setLogic_number(String logic_number) {
		this.logic_number = logic_number;
	}
	
	public String getPcn() {
		return pcn;
	}
	
	public void setPcn(String pcn) {
		this.pcn = pcn;
	}
	
	

}