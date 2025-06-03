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
@Table(name = "ope_company_transport", catalog = "movil_device", schema = "inventory")
public class OpeCompanyTransport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String id_company;
	private String company_name;
	private String created_at;
	private String updated_at;

	public OpeCompanyTransport() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getId_company() {
		return id_company;
	}

	public void setId_company(String id_company) {
		this.id_company = id_company;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
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
