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

import com.stcm.backoffice.utils.UtilsSTCM;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name="ope_backoffice_control",catalog="oxxo_prepago", schema="dbo")
public class OpeBackofficeControl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long id_store;
	private long id_cde_ticket;
	private long id_cde_topup;
	private String created_at;
	private String updated_at;
	private long id_cde_collection;
	
	
	public OpeBackofficeControl() {
		super();
	}

	public OpeBackofficeControl(long id_store) {
		this.id_store = id_store;
		this.id_cde_ticket = 1;
		this.id_cde_topup = 1;
		this.id_cde_collection = 1;
		this.created_at = UtilsSTCM.getDateTime();
		this.updated_at = null;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId_store() {
		return id_store;
	}

	public void setId_store(long id_store) {
		this.id_store = id_store;
	}

	public long getId_cde_ticket() {
		return id_cde_ticket;
	}

	public void setId_cde_ticket(long id_cde_ticket) {
		this.id_cde_ticket = id_cde_ticket;
	}

	public long getId_cde_topup() {
		return id_cde_topup;
	}

	public void setId_cde_topup(long id_cde_topup) {
		this.id_cde_topup = id_cde_topup;
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

	public long getId_cde_collection() {
		return id_cde_collection;
	}

	public void setId_cde_collection(long id_cde_collection) {
		this.id_cde_collection = id_cde_collection;
	}
}
