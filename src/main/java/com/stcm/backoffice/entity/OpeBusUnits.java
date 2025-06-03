package com.stcm.backoffice.entity;

import javax.persistence.Column;
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
public class OpeBusUnits {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "equipment_code")
	private String equipment_code;
	
	@Column(name = "nomenclature")
	private String nomenclature;
	
	@Column(name = "license_plate_icv")
	private String license_plate_icv;
	
	@Column(name = "eco_number")
	private String eco_number;
	
	@Column(name = "bus_niv")
	private String bus_niv;
	
	@Column(name = "created_at")
	private String created_at;
	
	@Column(name = "updated_at")
	private String updated_at;
	
	@Column(name = "bus_brand")
	private String bus_brand;

	public OpeBusUnits() {
	}
	
	
	public OpeBusUnits(OpeBusUnits tmp) {
		super();
		this.id = tmp.id;
		this.equipment_code = tmp.equipment_code;
		this.nomenclature = tmp.nomenclature;
		this.license_plate_icv = tmp.license_plate_icv;
		this.eco_number = tmp.eco_number;
		this.bus_niv = tmp.bus_niv;
		this.created_at = tmp.created_at;
		this.updated_at = tmp.updated_at;
		this.bus_brand = tmp.bus_brand;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
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

}
