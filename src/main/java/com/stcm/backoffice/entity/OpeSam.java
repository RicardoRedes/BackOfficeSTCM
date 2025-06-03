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
@Table(name = "ope_sam", catalog = "movil_device", schema = "inventory")
public class OpeSam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name = "uid_sam")
	String id_sam;
	@Column(name = "company_name")
	String company_name;
	
	
	public OpeSam() {
	}

	public OpeSam(OpeSam tmp) {
		super();
		this.id = tmp.getId();
		this.id_sam = tmp.getId_sam();
		this.company_name = tmp.getCompany_name();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getId_sam() {
		return id_sam;
	}

	public void setId_sam(String id_sam) {
		this.id_sam = id_sam;
	}
	
	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

}
