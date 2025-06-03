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
@Table(name = "ope_company_contract", catalog = "movil_device", schema = "inventory")
public class OpeCompanyContract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String id_contract;
	private String contract_name;
	private String created_at;
	private String updated_at;

	public OpeCompanyContract() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getId_contract() {
		return id_contract;
	}

	public void setId_contract(String id_contract) {
		this.id_contract = id_contract;
	}

	public String getContract_name() {
		return contract_name;
	}

	public void setContract_name(String contract_name) {
		this.contract_name = contract_name;
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

}
