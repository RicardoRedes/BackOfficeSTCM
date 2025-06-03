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
@Table(name = "ope_inventory_bus", catalog = "metrorrey", schema = "sch_pry_mty")
public class Ope_inventory_bus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long col_id;
	public String col_bus_id;
	public String col_company;
	public String col_branch;
	public String col_eco;
	public String col_route;
	public String col_sam_id;
	public String col_sim_id;
	public String col_validator;
	public String col_phone_number;
	public String col_nomenclature;
	public String col_serie;
	public String col_placa_icv;
	public String col_client;
	public String col_created_at;
	public String col_last_connect;
	public int col_count_connect;
	public String col_meid;
	public String col_type;
	public String col_brand;
	public String col_company_service;
	public String col_maintenance_provider;
	public int status;
	public String equipment_code;
	
	Ope_inventory_bus(){}
	
	public Ope_inventory_bus(Ope_inventory_bus tmp) {
		super();
		this.col_id = tmp.col_id;
		this.col_bus_id = tmp.col_bus_id;
		this.col_company = tmp.col_company;
		this.col_branch = tmp.col_branch;
		this.col_eco = tmp.col_eco;
		this.col_route = tmp.col_route;
		this.col_sam_id = tmp.col_sam_id;
		this.col_sim_id = tmp.col_sim_id;
		this.col_validator = tmp.col_validator;
		this.col_phone_number = tmp.col_phone_number;
		this.col_nomenclature = tmp.col_nomenclature;
		this.col_serie = tmp.col_serie;
		this.col_placa_icv = tmp.col_placa_icv;
		this.col_client = tmp.col_client;
		this.col_created_at = tmp.col_created_at;
		this.col_last_connect = tmp.col_last_connect;
		this.col_count_connect = tmp.col_count_connect;
		this.col_meid = tmp.col_meid;
		this.col_type = tmp.col_type;
		this.col_brand = tmp.col_brand;
		this.col_company_service = tmp.col_company_service;
		this.col_maintenance_provider = tmp.col_maintenance_provider;
		this.status = tmp.status;
		this.equipment_code = tmp.equipment_code;
	}

	public long getCol_id() {
		return col_id;
	}
	public void setCol_id(long col_id) {
		this.col_id = col_id;
	}
	public String getCol_bus_id() {
		return col_bus_id;
	}
	public void setCol_bus_id(String col_bus_id) {
		this.col_bus_id = col_bus_id;
	}
	public String getCol_company() {
		return col_company;
	}
	public void setCol_company(String col_company) {
		this.col_company = col_company;
	}
	public String getCol_branch() {
		return col_branch;
	}
	public void setCol_branch(String col_branch) {
		this.col_branch = col_branch;
	}
	public String getCol_eco() {
		return col_eco;
	}
	public void setCol_eco(String col_eco) {
		this.col_eco = col_eco;
	}
	public String getCol_route() {
		return col_route;
	}
	public void setCol_route(String col_route) {
		this.col_route = col_route;
	}
	public String getCol_sam_id() {
		return col_sam_id;
	}
	public void setCol_sam_id(String col_sam_id) {
		this.col_sam_id = col_sam_id;
	}
	public String getCol_sim_id() {
		return col_sim_id;
	}
	public void setCol_sim_id(String col_sim_id) {
		this.col_sim_id = col_sim_id;
	}
	public String getCol_validator() {
		return col_validator;
	}
	public void setCol_validator(String col_validator) {
		this.col_validator = col_validator;
	}
	public String getCol_phone_number() {
		return col_phone_number;
	}
	public void setCol_phone_number(String col_phone_number) {
		this.col_phone_number = col_phone_number;
	}
	public String getCol_nomenclature() {
		return col_nomenclature;
	}
	public void setCol_nomenclature(String col_nomenclature) {
		this.col_nomenclature = col_nomenclature;
	}
	public String getCol_serie() {
		return col_serie;
	}
	public void setCol_serie(String col_serie) {
		this.col_serie = col_serie;
	}
	public String getCol_placa_icv() {
		return col_placa_icv;
	}
	public void setCol_placa_icv(String col_placa_icv) {
		this.col_placa_icv = col_placa_icv;
	}
	public String getCol_client() {
		return col_client;
	}
	public void setCol_client(String col_client) {
		this.col_client = col_client;
	}
	public String getCol_created_at() {
		return col_created_at;
	}
	public void setCol_created_at(String col_created_at) {
		this.col_created_at = col_created_at;
	}
	public String getCol_last_connect() {
		return col_last_connect;
	}
	public void setCol_last_connect(String col_last_connect) {
		this.col_last_connect = col_last_connect;
	}
	public int getCol_count_connect() {
		return col_count_connect;
	}
	public void setCol_count_connect(int col_count_connect) {
		this.col_count_connect = col_count_connect;
	}
	public String getCol_meid() {
		return col_meid;
	}
	public void setCol_meid(String col_meid) {
		this.col_meid = col_meid;
	}
	public String getCol_type() {
		return col_type;
	}
	public void setCol_type(String col_type) {
		this.col_type = col_type;
	}
	public String getCol_brand() {
		return col_brand;
	}
	public void setCol_brand(String col_brand) {
		this.col_brand = col_brand;
	}
	public String getCol_company_service() {
		return col_company_service;
	}
	public void setCol_company_service(String col_company_service) {
		this.col_company_service = col_company_service;
	}
	public String getCol_maintenance_provider() {
		return col_maintenance_provider;
	}
	public void setCol_maintenance_provider(String col_maintenance_provider) {
		this.col_maintenance_provider = col_maintenance_provider;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getEquipment_code() {
		return equipment_code;
	}
	public void setEquipment_code(String equipment_code) {
		this.equipment_code = equipment_code;
	}


}
