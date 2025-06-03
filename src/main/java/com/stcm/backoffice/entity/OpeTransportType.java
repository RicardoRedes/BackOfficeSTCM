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
@Table(name = "ope_transport_type", catalog = "movil_device", schema = "inventory")
public class OpeTransportType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	@Column(name = "moment")
	public String moment;

	@Column(name = "linea")
	public int linea;

	@Column(name = "tipo_ruta")
	public String tipo_ruta;

	@Column(name = "status")
	public int status;

	public OpeTransportType() {
	}

	public OpeTransportType(OpeTransportType tmp) {
		this.id = tmp.id;
		this.moment = tmp.moment;
		this.linea = tmp.linea;
		this.tipo_ruta = tmp.tipo_ruta;
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

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}

	public String getTipo_ruta() {
		return tipo_ruta;
	}

	public void setTipo_ruta(String tipo_ruta) {
		this.tipo_ruta = tipo_ruta;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}