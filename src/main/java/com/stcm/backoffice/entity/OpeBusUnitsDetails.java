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
@Table(name = "ope_bus_units", catalog = "movil_device", schema = "inventory")
public class OpeBusUnitsDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String equipment_code;
	private String nomenclature;
	private String license_plate_icv;
	private String eco_number;
	private String bus_niv;
	private String created_at;
	private String updated_at;
	private String bus_brand;
	private String route_branch;
	private String pcn_sam;
	private String uid_sam;
	private String id_sim;
	private String phone_number;
	private String company_name;

	public OpeBusUnitsDetails() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEquipment_code() {
		return equipment_code;
	}

	public void setEquipment_code(String equipment_code) {
		this.equipment_code = equipment_code;
	}

	public String getNomenclature() {
		return nomenclature;
	}

	public void setNomenclature(String nomenclature) {
		this.nomenclature = nomenclature;
	}

	public String getLicense_plate_icv() {
		return license_plate_icv;
	}

	public void setLicense_plate_icv(String license_plate_icv) {
		this.license_plate_icv = license_plate_icv;
	}

	public String getEco_number() {
		return eco_number;
	}

	public void setEco_number(String eco_number) {
		this.eco_number = eco_number;
	}

	public String getBus_niv() {
		return bus_niv;
	}

	public void setBus_niv(String bus_niv) {
		this.bus_niv = bus_niv;
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

	public String getBus_brand() {
		return bus_brand;
	}

	public void setBus_brand(String bus_brand) {
		this.bus_brand = bus_brand;
	}

	public String getRoute_branch() {
		return route_branch;
	}

	public void setRoute_branch(String route_branch) {
		this.route_branch = route_branch;
	}

	public String getPcn_sam() {
		return pcn_sam;
	}

	public void setPcn_sam(String pcn_sam) {
		this.pcn_sam = pcn_sam;
	}

	public String getUid_sam() {
		return uid_sam;
	}

	public void setUid_sam(String uid_sam) {
		this.uid_sam = uid_sam;
	}

	public String getId_sim() {
		return id_sim;
	}

	public void setId_sim(String id_sim) {
		this.id_sim = id_sim;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

}
