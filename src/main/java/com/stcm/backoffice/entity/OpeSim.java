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
@Table(name = "ope_sim", catalog = "movil_device", schema = "inventory")
public class OpeSim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name = "id_sim")
	String id_sim;

	public OpeSim() {
	}

	public OpeSim(OpeSim tmp) {
		this.id = tmp.getId();
		this.id_sim = tmp.getId_sim();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getId_sim() {
		return id_sim;
	}

	public void setId_sim(String id_sim) {
		this.id_sim = id_sim;
	}

}
