package com.stcm.backoffice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.stcm.backoffice.entity.request.TransportStationRequest;
import com.stcm.backoffice.utils.UtilsSTCM;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "ope_transport_station", catalog = "metrorrey", schema = "sch_pry_mty")
public class OpeTransportStation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int id_line;
	private String code;
	private String name;
	//private BYTE_ARRAY symbol;
	private String type;
	private String comment;
	private String created_at;
	private String updated_at;
	private int status;
	private float latitude;
	private float longitude;
	private int ubication_code;

	public OpeTransportStation() {
	}

	public OpeTransportStation(TransportStationRequest tmp) {
		this.id_line = tmp.getId_line();
		this.code = tmp.getCode();
		this.name = tmp.getName();
		//this.symbol = tmp.getSymbol();
		this.type = tmp.getType();
		this.comment = tmp.getComment();
		this.created_at = UtilsSTCM.getDateTime();
		this.updated_at = null;
		this.status = tmp.getStatus();
		this.latitude = tmp.getLatitude();
		this.longitude = tmp.getLongitude();
		this.ubication_code = tmp.getUbicationCode();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getId_line() {
		return id_line;
	}

	public void setId_line(int id_line) {
		this.id_line = id_line;
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

	/*public BYTE_ARRAY getSymbol() {
		return symbol;
	}

	public void setSymbol(BYTE_ARRAY symbol) {
		this.symbol = symbol;
	}*/

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public int getUbication_code() {
		return ubication_code;
	}

	public void setUbication_code(int ubication_code) {
		this.ubication_code = ubication_code;
	}

}
