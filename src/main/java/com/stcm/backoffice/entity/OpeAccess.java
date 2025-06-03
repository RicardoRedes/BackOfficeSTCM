package com.stcm.backoffice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.stcm.backoffice.entity.request.AccessRequest;
import com.stcm.backoffice.entity.request.AccessRequest2;
import com.stcm.backoffice.utils.UtilsSTCM;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "ope_access", catalog = "metrorrey", schema = "sch_pry_mty")
public class OpeAccess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long id_cde;
	private long id_station;
	private long id_equipment;
	private String type_title;
	private String uid_card;
	private String uid_sam;
	private float fare;
	private long payment_seq;
	private float balance_ewallet;
	private float final_balance_ewallet;
	private float balance_trips;
	private float final_balance_trips;
	private String ticketing_validation;
	private String created_at;
	private String updated_at;
	private int status;
	private String logic_number;
	private String transaction_date;
	private int is_sent;
	private String pcn;
	/*private Integer last_transit_1;
	private Integer last_transit_2;
	private Integer last_transit_3;*/

	public OpeAccess() {
		super();
	}

	public OpeAccess(AccessRequest accessTmp, OpeAfcEquipment eqTmp, CatTypeTitle titleTmp, OpeInventoryCard invTmp, CatTypeTicketingValidation ticketTmp) {
		this.id_cde = accessTmp.getId();
		this.id_station = accessTmp.getStationId();
		this.id_equipment = eqTmp.getId();
		this.type_title = titleTmp.getCode();
		this.pcn = invTmp.getPcn();
		this.uid_card = accessTmp.getUidCard();
		this.uid_sam = accessTmp.getUidSam();
		this.fare = accessTmp.getFare();
		this.payment_seq = accessTmp.getPaymentSeq();
		this.setBalance_ewallet(accessTmp.getBalanceEWallet());
		this.final_balance_ewallet = accessTmp.getFinalBalanceEWallet();
		this.balance_trips = accessTmp.getBalanceTrips();
		this.final_balance_trips = accessTmp.getFinalBalanceTrips();
		this.ticketing_validation = accessTmp.getTicketingValidationCode();
		this.logic_number = accessTmp.getLogicNumber();
		this.transaction_date = accessTmp.getDate();
		this.created_at = UtilsSTCM.getDateTime();
		/*this.last_transit_1 = accessTmp.getLastTransit1();
		this.last_transit_2 = accessTmp.getLastTransit2();
		this.last_transit_3 = accessTmp.getLastTransit3();*/
		
	}
	
	public OpeAccess(AccessRequest2 accessTmp, OpeAfcEquipment eqTmp, CatTypeTitle titleTmp, OpeInventoryCard invTmp/*, CatTypeTicketingValidation ticketTmp se puede comentar esta recepcion*/) {
		this.id_cde = accessTmp.getId();
		this.id_station = accessTmp.getStationId();
		this.id_equipment = eqTmp.getId();
		this.type_title = titleTmp.getCode();
		this.pcn = invTmp.getPcn();
		this.uid_card = accessTmp.getUidCard();
		this.uid_sam = accessTmp.getUidSam();
		this.fare = accessTmp.getFare();
		this.payment_seq = accessTmp.getPaymentSeq();
		this.setBalance_ewallet(accessTmp.getBalanceEWallet());
		this.final_balance_ewallet = accessTmp.getFinalBalanceEWallet();
		this.balance_trips = accessTmp.getBalanceTrips();
		this.final_balance_trips = accessTmp.getFinalBalanceTrips();
		this.ticketing_validation = accessTmp.getTicketingValidationCode();
		this.logic_number = accessTmp.getLogicNumber();
		this.transaction_date = accessTmp.getDate();
		this.created_at = UtilsSTCM.getDateTime();
		/*this.last_transit_1 = accessTmp.getLastTransit1();
		this.last_transit_2 = accessTmp.getLastTransit2();
		this.last_transit_3 = accessTmp.getLastTransit3();*/
		
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

	public long getId_station() {
		return id_station;
	}

	public void setId_station(long id_station) {
		this.id_station = id_station;
	}

	public long getId_equipment() {
		return id_equipment;
	}

	public void setId_equipment(long id_equipment) {
		this.id_equipment = id_equipment;
	}

	public String getType_title() {
		return type_title;
	}

	public void setType_title(String type_title) {
		this.type_title = type_title;
	}

	public String getUid_card() {
		return uid_card;
	}

	public void setUid_card(String uid_card) {
		this.uid_card = uid_card;
	}

	public String getUid_sam() {
		return uid_sam;
	}

	public void setUid_sam(String uid_sam) {
		this.uid_sam = uid_sam;
	}

	public float getFare() {
		return fare;
	}

	public void setFare(float fare) {
		this.fare = fare;
	}

	public long getPayment_seq() {
		return payment_seq;
	}

	public void setPayment_seq(long payment_seq) {
		this.payment_seq = payment_seq;
	}

	public float getFinal_balance_ewallet() {
		return final_balance_ewallet;
	}

	public void setFinal_balance_ewallet(float final_balance_ewallet) {
		this.final_balance_ewallet = final_balance_ewallet;
	}

	public float getFinal_balance_trips() {
		return final_balance_trips;
	}

	public void setFinal_balance_trips(float final_balance_trips) {
		this.final_balance_trips = final_balance_trips;
	}

	public String getTicketing_validation() {
		return ticketing_validation;
	}

	public void setTicketing_validation(String ticketing_validation) {
		this.ticketing_validation = ticketing_validation;
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

	public float getBalance_trips() {
		return balance_trips;
	}

	public void setBalance_trips(float balance_trips) {
		this.balance_trips = balance_trips;
	}

	public String getLogic_number() {
		return logic_number;
	}

	public void setLogic_number(String logic_number) {
		this.logic_number = logic_number;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	public int getIs_sent() {
		return is_sent;
	}

	public void setIs_sent(int is_sent) {
		this.is_sent = is_sent;
	}

	public String getPcn() {
		return pcn;
	}

	public void setPcn(String pcn) {
		this.pcn = pcn;
	}

	/*public Integer getLast_transit_1() {
		return last_transit_1;
	}

	public void setLast_transit_1(Integer last_transit_1) {
		this.last_transit_1 = last_transit_1;
	}

	public Integer getLast_transit_2() {
		return last_transit_2;
	}

	public void setLast_transit_2(Integer last_transit_2) {
		this.last_transit_2 = last_transit_2;
	}

	public Integer getLast_transit_3() {
		return last_transit_3;
	}

	public void setLast_transit_3(Integer last_transit_3) {
		this.last_transit_3 = last_transit_3;
	}*/

	public float getBalance_ewallet() {
		return balance_ewallet;
	}

	public void setBalance_ewallet(float balance_ewallet) {
		this.balance_ewallet = balance_ewallet;
	}

}
