package com.stcm.backoffice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.stcm.backoffice.entity.request.TransportLineRequest;
import com.stcm.backoffice.utils.UtilsSTCM;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "ope_transport_line", catalog = "metrorrey", schema= "sch_pry_mty")
public class OpeTransportLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int id_company;
	private String code;
	private String name;
	private int num_station;
	private String color;
	private String comment;
	private String created_at;
	private String updated_at;
	private int status;
	private int ubication_code;
	

	
	public OpeTransportLine() {

	}
	
	public OpeTransportLine(TransportLineRequest tmp) {
		this.id_company = tmp.getIdCompany();
		this.code = tmp.getCode();
		this.name = tmp.getName();
		this.num_station = tmp.getNumStation();
		this.color = tmp.getColor();
		this.comment = tmp.getComment();
		this.created_at = UtilsSTCM.getDateTime();
		this.updated_at = null;
		this.status = tmp.getStatus();
		this.ubication_code = tmp.getUbicationCode();
		

	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getId_company() {
		return id_company;
	}
	
	public void setId_company(int id_company) {
		this.id_company = id_company;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNum_station() {
		return num_station;
	}
	
	public void setNum_station(int num_station) {
		this.num_station = num_station;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
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
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getUbication_code() {
		return ubication_code;
	}
	
	public void setUbication_code(int ubication_code) {
		this.ubication_code = ubication_code;
	}


}
