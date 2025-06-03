package com.stcm.backoffice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "ope_transport_station", catalog = "metrorrey", schema= "sch_pry_mty")
public class Stations {
	
	@Id
	private int station;
	private int line;
	private String name_station;
	private String name_line;
	
	
	
	public Stations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getLine() {
		return line;
	}
	
	public void setLine(int line) {
		this.line = line;
	}
	
	public int getStation() {
		return station;
	}
	
	public void setStation(int station) {
		this.station = station;
	}
	
	public String getName_station() {
		return name_station;
	}
	
	public void setName_station(String name_station) {
		this.name_station = name_station;
	}
	
	public String getName_line() {
		return name_line;
	}
	
	public void setName_line(String name_line) {
		this.name_line = name_line;
	}
	
	
}
