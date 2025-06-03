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
@Table(name = "ope_transport_config", catalog = "movil_device", schema = "configs")
public class OpeTransportConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	@Column(name = "moment")
	public String moment;

	@Column(name = "id_line")
	public int id_line;

	@Column(name = "fare_version")
	public int fare_version;

	@Column(name = "tpm_version")
	public int tpm_version;

	@Column(name = "bl_version")
	public int bl_version;

	@Column(name = "gl_version")
	public int gl_version;

	@Column(name = "bgl_pooling")
	public int bgl_pooling;

	@Column(name = "cpr_version")
	public int cpr_version;

	@Column(name = "pooling")
	public int pooling;

	@Column(name = "status")
	public int status;

	public OpeTransportConfig() {
	}

	public OpeTransportConfig(OpeTransportConfig tmp) {
		this.id = tmp.id;
		this.moment = tmp.moment;
		this.id_line = tmp.id_line;
		this.fare_version = tmp.fare_version;
		this.tpm_version = tmp.tpm_version;
		this.bl_version = tmp.bl_version;
		this.gl_version = tmp.gl_version;
		this.bgl_pooling = tmp.bgl_pooling;
		this.cpr_version = tmp.cpr_version;
		this.pooling = tmp.pooling;
		this.status = tmp.status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMoment() {
		return moment;
	}

	public void setMoment(String moment) {
		this.moment = moment;
	}

	public int getId_line() {
		return id_line;
	}

	public void setId_line(int id_line) {
		this.id_line = id_line;
	}

	public int getFare_version() {
		return fare_version;
	}

	public void setFare_version(int fare_version) {
		this.fare_version = fare_version;
	}

	public int getTpm_version() {
		return tpm_version;
	}

	public void setTpm_version(int tpm_version) {
		this.tpm_version = tpm_version;
	}

	public int getBl_version() {
		return bl_version;
	}

	public void setBl_version(int bl_version) {
		this.bl_version = bl_version;
	}

	public int getGl_version() {
		return gl_version;
	}

	public void setGl_version(int gl_version) {
		this.gl_version = gl_version;
	}

	public int getBgl_pooling() {
		return bgl_pooling;
	}

	public void setBgl_pooling(int bgl_pooling) {
		this.bgl_pooling = bgl_pooling;
	}

	public int getCpr_version() {
		return cpr_version;
	}

	public void setCpr_version(int cpr_version) {
		this.cpr_version = cpr_version;
	}

	public int getPooling() {
		return pooling;
	}

	public void setPooling(int pooling) {
		this.pooling = pooling;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}