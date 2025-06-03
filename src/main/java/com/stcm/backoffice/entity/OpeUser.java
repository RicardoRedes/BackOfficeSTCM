package com.stcm.backoffice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "ope_user", catalog = "metrorrey", schema = "sch_pry_mty")
public class OpeUser {

	@Id
	private int id;
	private long employee_identifier;
	private String password;
	private String role;
	private String username;
	private String status;
	private String profile;

	public OpeUser() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getEmployee_identifier() {
		return employee_identifier;
	}

	public void setEmployee_identifier(long employee_identifier) {
		this.employee_identifier = employee_identifier;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	

	
}
