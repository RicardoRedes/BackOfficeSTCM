/*
 * Autor: Marcela Cecilia Gómez Bautista
 * Fecha: 19/06/2024
 * Departamento: Desarrollo Tecnológico
 * 
 */
package com.stcm.backoffice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name="ope_places",catalog="oxxo_prepago", schema="dbo")
public class OpePlaces {
	
	@Id
	private long id; 
	private String code_place;
	private String name;
	private String country;
	private int status;
	private String created_at;
	private String updated_at;
	private int id_line;
	private int id_register_user;
	private String updated_register;

	public OpePlaces() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode_place() {
		return code_place;
	}

	public void setCode_place(String code_place) {
		this.code_place = code_place;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public int getId_line() {
		return id_line;
	}

	public void setId_line(int id_line) {
		this.id_line = id_line;
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
