
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
@Table(name = "ope_inventory", catalog = "movil_device", schema = "inventory")

public class OpeInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "id_device")
	private long id_device;
	
	@Column(name = "id_bus")
	private long id_bus;
	
	@Column(name = "id_route")
	private long id_route;
	
	@Column(name = "id_company_contract")
	private long id_company_contract;
	
	@Column(name = "id_company_transport")
	private long id_company_transport;
	
	@Column(name = "id_sim")
	private long id_sim;
	
	@Column(name = "id_sam")
	private long id_sam;
	
	@Column(name = "start_date")
	private String start_date;
	
	@Column(name = "updated_at")
	private String updated_at;

	public OpeInventory() {
	}

	public OpeInventory(OpeInventory tmp) {
		super();
		this.id = tmp.id;
		this.id_device = tmp.id_device;
		this.id_bus = tmp.id_bus;
		this.id_route = tmp.id_route;
		this.id_company_contract = tmp.id_company_contract;
		this.id_company_transport = tmp.id_company_transport;
		this.id_sim = tmp.id_sim;
		this.id_sam = tmp.id_sam;
		this.start_date = tmp.start_date;
		this.updated_at = tmp.updated_at;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId_device() {
		return id_device;
	}

	public void setId_device(long id_device) {
		this.id_device = id_device;
	}

	public long getId_bus() {
		return id_bus;
	}

	public void setId_bus(long id_bus) {
		this.id_bus = id_bus;
	}

	public long getId_route() {
		return id_route;
	}

	public void setId_route(long id_route) {
		this.id_route = id_route;
	}

	public long getId_company_contract() {
		return id_company_contract;
	}

	public void setId_company_contract(long id_company_contract) {
		this.id_company_contract = id_company_contract;
	}

	public long getId_company_transport() {
		return id_company_transport;
	}

	public void setId_company_transport(long id_company_transport) {
		this.id_company_transport = id_company_transport;
	}

	public long getId_sim() {
		return id_sim;
	}

	public void setId_sim(long id_sim) {
		this.id_sim = id_sim;
	}

	public long getId_sam() {
		return id_sam;
	}

	public void setId_sam(long id_sam) {
		this.id_sam = id_sam;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	


}
