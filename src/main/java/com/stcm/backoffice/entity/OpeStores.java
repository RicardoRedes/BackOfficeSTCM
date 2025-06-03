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

import com.stcm.backoffice.entity.request.OxxoStoreRequest;
import com.stcm.backoffice.utils.UtilsSTCM;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "ope_stores", catalog = "oxxo_prepago", schema = "dbo")
public class OpeStores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code_store;
	private String name;
	private String phone;
	private String street;
	private String external_number;
	private String neighborhood;
	private String zip_code;
	private String surrounding_streets;
	private double latitud;
	private double longitud;
	private String city;
	private String state;
	private int status;
	private long id_place;
	private String created_at;
	private String updated_at;
	private long id_station;
	private int id_register_user;
	private String updated_register;

	public OpeStores() {
		super();
	}

	public OpeStores(OxxoStoreRequest tmp, long stationId, long placeId) {
		this.code_store = tmp.getCodeStore();
		this.name = tmp.getName();
		this.phone = tmp.getPhone();
		this.street = tmp.getStreet();
		this.external_number = tmp.getExternalNumber();
		this.neighborhood = tmp.getNeighborhood();
		this.zip_code = tmp.getZipCode();
		this.surrounding_streets = tmp.getSurroundingStreets();
		this.latitud = tmp.getLatitud();
		this.longitud = tmp.getLongitud();
		this.city = tmp.getCity();
		this.state = tmp.getState();
		this.status = 0;
		this.id_place = placeId; // TODO
		this.created_at = UtilsSTCM.getDateTime();
		this.updated_at = null;
		this.id_station = stationId;
		this.id_register_user = tmp.getIdRegisterUser();
		this.updated_register = null;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode_store() {
		return code_store;
	}

	public void setCode_store(String code_store) {
		this.code_store = code_store;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getExternal_number() {
		return external_number;
	}

	public void setExternal_number(String external_number) {
		this.external_number = external_number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getSurrounding_streets() {
		return surrounding_streets;
	}

	public void setSurrounding_streets(String surrounding_streets) {
		this.surrounding_streets = surrounding_streets;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getId_place() {
		return id_place;
	}

	public void setId_place(long id_place) {
		this.id_place = id_place;
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

	public long getId_station() {
		return id_station;
	}

	public void setId_station(long id_station) {
		this.id_station = id_station;
	}

	public int getId_register_user() {
		return id_register_user;
	}

	public void setId_register_user(int id_register_user) {
		this.id_register_user = id_register_user;
	}

	public String getUpdated_register() {
		return updated_register;
	}

	public void setUpdated_register(String updated_register) {
		this.updated_register = updated_register;
	}

}
