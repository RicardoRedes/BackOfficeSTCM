/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stcm.backoffice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.stcm.backoffice.entity.request.CollectionRequest;
import com.stcm.backoffice.utils.UtilsSTCM;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Isaac Vasconcelos
 */
@Data
@Entity
@AllArgsConstructor
@Table(name = "ope_collection", catalog = "metrorrey", schema = "sch_pry_mty")
public class OpeCollection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	private long id_cde;
	private long id_line;
	private long id_station;
	private long equipment;
	private String uid_card;
	private String type;
	private double total_050c;
	private double total_001p;
	private double total_002p;
	private double total_005p;
	private double total_010p;
	private double total_020p;
	private double total_050p;
	private double total_100p;
	private double total_200p;
	private double total_500p;
	private double amount_coin;
	private double amount_bill;
	private String init_date;
	private String end_date;
	private String created_at;
	private String updated_at;
	private boolean status;
	private String logic_number;
	private String security_seal;
	private String transaction_date;
	private long id_equipment;
	private String token;
	private boolean sent;
	private String pcn;
	private String cashbox_number;
	private String name;
	private long id_cde_topup_begin;
	private long id_cde_topup_finish;

	public OpeCollection() {
	}

	public OpeCollection(CollectionRequest request, OpeAfcEquipment equipment, OpeTransportStation station, String pcn) {
		
		this.id_cde = request.getIdCde();
		this.id_equipment = request.getIdEquipment();
		this.equipment = equipment.getId();
		this.id_station = equipment.getId_station();
		this.id_line = station.getId_line();
		this.pcn = pcn; 
		this.uid_card = request.getUidCard();
		this.logic_number = request.getLogicNumber();
		this.security_seal = request.getSecuritySeal();
		this.token = request.getToken();
		this.cashbox_number = request.getCashboxNumber();
		this.name = request.getName();
		this.type = request.getType();
		this.total_050c = request.getTotal050c();
		this.total_001p = request.getTotal001p();
		this.total_002p = request.getTotal002p();
		this.total_005p = request.getTotal005p();
		this.total_010p = request.getTotal010p();
		this.total_020p = request.getTotal020p();
		this.total_050p = request.getTotal050p();
		this.total_100p = request.getTotal100p();
		this.total_500p = request.getTotal500p();
		this.amount_coin = request.getAmountCoin();
		this.amount_bill = request.getAmountBill();
		this.init_date = request.getInitDate();
		this.end_date = request.getEndDate();
		this.id_cde_topup_begin = request.getIdCdeTopupBegin();
		this.id_cde_topup_finish = request.getIdCdeTopupFinish();
		this.transaction_date = request.getTransactionDate();
		this.created_at = UtilsSTCM.getDateTime();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId_cde() {
		return id_cde;
	}

	public void setId_cde(long id_cde) {
		this.id_cde = id_cde;
	}

	public long getId_line() {
		return id_line;
	}

	public void setId_line(long id_line) {
		this.id_line = id_line;
	}

	public long getId_station() {
		return id_station;
	}

	public void setId_station(long id_station) {
		this.id_station = id_station;
	}

	public long getEquipment() {
		return equipment;
	}

	public void setEquipment(long equipment) {
		this.equipment = equipment;
	}

	public String getUid_card() {
		return uid_card;
	}

	public void setUid_card(String uid_card) {
		this.uid_card = uid_card;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getTotal_050c() {
		return total_050c;
	}

	public void setTotal_050c(double total_050c) {
		this.total_050c = total_050c;
	}

	public double getTotal_001p() {
		return total_001p;
	}

	public void setTotal_001p(double total_001p) {
		this.total_001p = total_001p;
	}

	public double getTotal_002p() {
		return total_002p;
	}

	public void setTotal_002p(double total_002p) {
		this.total_002p = total_002p;
	}

	public double getTotal_005p() {
		return total_005p;
	}

	public void setTotal_005p(double total_005p) {
		this.total_005p = total_005p;
	}

	public double getTotal_010p() {
		return total_010p;
	}

	public void setTotal_010p(double total_010p) {
		this.total_010p = total_010p;
	}

	public double getTotal_020p() {
		return total_020p;
	}

	public void setTotal_020p(double total_020p) {
		this.total_020p = total_020p;
	}

	public double getTotal_050p() {
		return total_050p;
	}

	public void setTotal_050p(double total_050p) {
		this.total_050p = total_050p;
	}

	public double getTotal_100p() {
		return total_100p;
	}

	public void setTotal_100p(double total_100p) {
		this.total_100p = total_100p;
	}

	public double getTotal_200p() {
		return total_200p;
	}

	public void setTotal_200p(double total_200p) {
		this.total_200p = total_200p;
	}

	public double getTotal_500p() {
		return total_500p;
	}

	public void setTotal_500p(double total_500p) {
		this.total_500p = total_500p;
	}

	public double getAmount_coin() {
		return amount_coin;
	}

	public void setAmount_coin(double amount_coin) {
		this.amount_coin = amount_coin;
	}

	public double getAmount_bill() {
		return amount_bill;
	}

	public void setAmount_bill(double amount_bill) {
		this.amount_bill = amount_bill;
	}

	public String getInit_date() {
		return init_date;
	}

	public void setInit_date(String init_date) {
		this.init_date = init_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getLogic_number() {
		return logic_number;
	}

	public void setLogic_number(String logic_number) {
		this.logic_number = logic_number;
	}

	public String getSecurity_seal() {
		return security_seal;
	}

	public void setSecurity_seal(String security_seal) {
		this.security_seal = security_seal;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	public long getId_equipment() {
		return id_equipment;
	}

	public void setId_equipment(long id_equipment) {
		this.id_equipment = id_equipment;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isSent() {
		return sent;
	}

	public void setSent(boolean sent) {
		this.sent = sent;
	}

	public String getPcn() {
		return pcn;
	}

	public void setPcn(String pcn) {
		this.pcn = pcn;
	}

	public String getCashbox_number() {
		return cashbox_number;
	}

	public void setCashbox_number(String cashbox_number) {
		this.cashbox_number = cashbox_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId_cde_topup_begin() {
		return id_cde_topup_begin;
	}

	public void setId_cde_topup_begin(long id_cde_topup_begin) {
		this.id_cde_topup_begin = id_cde_topup_begin;
	}

	public long getId_cde_topup_finish() {
		return id_cde_topup_finish;
	}

	public void setId_cde_topup_finish(long id_cde_topup_finish) {
		this.id_cde_topup_finish = id_cde_topup_finish;
	}

}
