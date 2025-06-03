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
@Table(name = "ope_transport_routes", catalog = "movil_device", schema = "inventory")
public class OpeTransportRoutes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "code_stcm")
	private String code_stcm;
	
	@Column(name = "start_point")
	private String start_point;
	
	@Column(name = "end_point")
	private String end_point;
	
	@Column(name = "route_code")
	private String route_code;
	
	@Column(name = "route_branch")
	private String route_branch;
	
	@Column(name = "route_size")
	private String route_size;
	
	@Column(name = "created_at")
	private String created_at;
	
	@Column(name = "updated_at")
	private String updated_at;
	
	@Column(name = "id_company_transport")
	private String id_company_transport;
	
	@Column(name = "id_company_contract")
	private String id_company_contract;

	public OpeTransportRoutes() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode_stcm() {
		return code_stcm;
	}

	public void setCode_stcm(String code_stcm) {
		this.code_stcm = code_stcm;
	}

	public String getStart_point() {
		return start_point;
	}

	public void setStart_point(String start_point) {
		this.start_point = start_point;
	}

	public String getEnd_point() {
		return end_point;
	}

	public void setEnd_point(String end_point) {
		this.end_point = end_point;
	}

	public String getRoute_code() {
		return route_code;
	}

	public void setRoute_code(String route_code) {
		this.route_code = route_code;
	}

	public String getRoute_branch() {
		return route_branch;
	}

	public void setRoute_branch(String route_branch) {
		this.route_branch = route_branch;
	}

	public String getRoute_size() {
		return route_size;
	}

	public void setRoute_size(String route_size) {
		this.route_size = route_size;
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

	public String getId_company_transport() {
		return id_company_transport;
	}

	public void setId_company_transport(String id_company_transport) {
		this.id_company_transport = id_company_transport;
	}

	public String getId_company_contract() {
		return id_company_contract;
	}

	public void setId_company_contract(String id_company_contract) {
		this.id_company_contract = id_company_contract;
	}

}
