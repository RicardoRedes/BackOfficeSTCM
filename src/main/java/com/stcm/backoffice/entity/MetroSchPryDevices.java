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
@Table(name = "devices_tmp", catalog = "metrorrey", schema = "sch_pry_mty")
public class MetroSchPryDevices {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	@Column(name = "meid")
	public String meid;

	@Column(name = "nsd")
	public String nsd;

	@Column(name = "url")
	public String url;

	@Column(name = "moment")
	public String moment;

	@Column(name = "comp")
	public int comp;

	@Column(name = "linea")
	public int linea;

	@Column(name = "estacion")
	public int estacion;

	@Column(name = "trayecto")
	public int trayecto;

	@Column(name = "tipo")
	public int tipo;

	@Column(name = "num_disp")
	public int num_disp;

	@Column(name = "equipment_code")
	public String equipment_code;

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

	@Column(name = "device_type")
	public int device_type;

	@Column(name = "status")
	public int status;

	public MetroSchPryDevices() {}
	
	public MetroSchPryDevices(MetroSchPryDevices tmp) {
		tmp.id = tmp.id;
		tmp.meid = tmp.meid;
		tmp.nsd = tmp.nsd;
		tmp.url = tmp.url;
		tmp.moment = tmp.moment;
		tmp.comp = tmp.comp;
		tmp.linea = tmp.linea;
		tmp.estacion = tmp.estacion;
		tmp.trayecto = tmp.trayecto;
		tmp.tipo = tmp.tipo;
		tmp.num_disp = tmp.num_disp;
		tmp.equipment_code = tmp.equipment_code;
		tmp.fare_version = tmp.fare_version;
		tmp.tpm_version = tmp.tpm_version;
		tmp.bl_version = tmp.bl_version;
		tmp.gl_version = tmp.gl_version;
		tmp.bgl_pooling = tmp.bgl_pooling;
		tmp.cpr_version = tmp.cpr_version;
		tmp.pooling = tmp.pooling;
		tmp.device_type = tmp.device_type;
		tmp.status = tmp.status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMeid() {
		return meid;
	}

	public void setMeid(String meid) {
		this.meid = meid;
	}

	public String getNsd() {
		return nsd;
	}

	public void setNsd(String nsd) {
		this.nsd = nsd;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMoment() {
		return moment;
	}

	public void setMoment(String moment) {
		this.moment = moment;
	}

	public int getComp() {
		return comp;
	}

	public void setComp(int comp) {
		this.comp = comp;
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}

	public int getEstacion() {
		return estacion;
	}

	public void setEstacion(int estacion) {
		this.estacion = estacion;
	}

	public int getTrayecto() {
		return trayecto;
	}

	public void setTrayecto(int trayecto) {
		this.trayecto = trayecto;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getNum_disp() {
		return num_disp;
	}

	public void setNum_disp(int num_disp) {
		this.num_disp = num_disp;
	}

	public String getEquipment_code() {
		return equipment_code;
	}

	public void setEquipment_code(String equipment_code) {
		this.equipment_code = equipment_code;
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

	public int getDevice_type() {
		return device_type;
	}

	public void setDevice_type(int device_type) {
		this.device_type = device_type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
