package com.stcm.backoffice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ope_gray_list_card", catalog = "bitshield", schema = "dbo")
public class OpeGrayListCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	private String uid;
	private String logic_number;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getLogic_number() {
		return logic_number;
	}
	public void setLogic_number(String logic_number) {
		this.logic_number = logic_number;
	}
}
