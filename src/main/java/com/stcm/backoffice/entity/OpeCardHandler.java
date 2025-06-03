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
@Table(name = "ope_card_handler", catalog = "metrorrey", schema = "sch_pry_mty")
public class OpeCardHandler {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String uid;
	private String pcn;
	private String logic_number;
	private int ope_access_id;
	private int ope_topup_id;
	private int card_sequence;
	private float debit_amount;
	private float recharge_amount;
	private float total_amount;
	private String created_at;
	private String updated_at;
	private int id_status;
	
	public OpeCardHandler() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPcn() {
		return pcn;
	}

	public void setPcn(String pcn) {
		this.pcn = pcn;
	}

	public String getLogic_number() {
		return logic_number;
	}

	public void setLogic_number(String logic_number) {
		this.logic_number = logic_number;
	}

	public int getOpe_access_id() {
		return ope_access_id;
	}

	public void setOpe_access_id(int ope_access_id) {
		this.ope_access_id = ope_access_id;
	}

	public int getOpe_topup_id() {
		return ope_topup_id;
	}

	public void setOpe_topup_id(int ope_topup_id) {
		this.ope_topup_id = ope_topup_id;
	}

	public int getCard_sequence() {
		return card_sequence;
	}

	public void setCard_sequence(int card_sequence) {
		this.card_sequence = card_sequence;
	}

	public float getDebit_amount() {
		return debit_amount;
	}

	public void setDebit_amount(float debit_amount) {
		this.debit_amount = debit_amount;
	}

	public float getRecharge_amount() {
		return recharge_amount;
	}

	public void setRecharge_amount(float recharge_amount) {
		this.recharge_amount = recharge_amount;
	}

	public float getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
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

	public int getId_status() {
		return id_status;
	}

	public void setId_status(int id_status) {
		this.id_status = id_status;
	}

}
