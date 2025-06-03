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
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ope_black_list_card", catalog = "bitshield", schema = "dbo")
public class OpeBlackListCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String uid;
	private long id_lot;
	private String created_at;
	private String updated_at;
	private String logic_number;
	private String pcn;
	private String requesting_user;
	private String reason;
	private int status;
	
	public OpeBlackListCard(AccessRequest arTmp, String pcn, String requesting_user, String reason) {
		
		this.uid = arTmp.getUidCard();
		this.id_lot = 0;
		this.created_at = UtilsSTCM.getDateTime();
		this.updated_at = null;
		this.logic_number = arTmp.getLogicNumber();
		this.pcn = pcn;
		this.requesting_user = requesting_user;
		this.reason = reason;
		this.status = 1;
		
	}
	
	public OpeBlackListCard(AccessRequest2 arTmp, String pcn, String requesting_user, String reason) {
		
		this.uid = arTmp.getUidCard();
		this.id_lot = 0;
		this.created_at = UtilsSTCM.getDateTime();
		this.updated_at = null;
		this.logic_number = arTmp.getLogicNumber();
		this.pcn = pcn;
		this.requesting_user = requesting_user;
		this.reason = reason;
		this.status = 1;
		
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

	public long getId_lot() {
		return id_lot;
	}

	public void setId_lot(long id_lot) {
		this.id_lot = id_lot;
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

	public String getLogic_number() {
		return logic_number;
	}

	public void setLogic_number(String logic_number) {
		this.logic_number = logic_number;
	}

	public String getPcn() {
		return pcn;
	}

	public void setPcn(String pcn) {
		this.pcn = pcn;
	}

	public String getRequesting_user() {
		return requesting_user;
	}

	public void setRequesting_user(String requesting_user) {
		this.requesting_user = requesting_user;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
