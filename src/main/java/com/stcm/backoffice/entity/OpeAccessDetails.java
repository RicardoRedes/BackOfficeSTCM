package com.stcm.backoffice.entity;

import com.stcm.backoffice.entity.request.AccessRequest;

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
@Table(name = "ope_access_details", catalog = "metrorrey", schema = "sch_pry_mty")
public class OpeAccessDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long oa_id;
	private Integer last_transit_1;
	private Integer last_transit_2;
	private Integer last_transit_3;

	public OpeAccessDetails() {
	}
	
	public OpeAccessDetails(OpeAccess tmp, AccessRequest req) {
		this.oa_id = tmp.getId();
		this.last_transit_1 = req.getLastTransit1();
		this.last_transit_2 = req.getLastTransit2();
		this.last_transit_3 = req.getLastTransit3();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOa_id() {
		return oa_id;
	}

	public void setOa_id(long oa_id) {
		this.oa_id = oa_id;
	}

	public Integer getLast_transit_1() {
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
	}

}
