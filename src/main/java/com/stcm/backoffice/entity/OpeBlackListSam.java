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
@Table(name = "ope_blacklist_sam", catalog = "metrorrey", schema = "sch_pry_mty")
public class OpeBlackListSam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String uid_sam;
	private String reason;
	private String comment;
	private String created_at;
	private String updated_at;
	private int status;
	private int is_sent;
	
	public OpeBlackListSam() {
		
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUid_sam() {
		return uid_sam;
	}

	public void setUid_sam(String uid_sam) {
		this.uid_sam = uid_sam;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public int getIs_sent() {
		return is_sent;
	}

	public void setIs_sent(int is_sent) {
		this.is_sent = is_sent;
	}

}
