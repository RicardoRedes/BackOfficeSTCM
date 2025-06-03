package com.stcm.backoffice.entity;

public class Settings {

	private int max_recharge_num;
	private double max_recharge_amount;
	private int validity;
	private int blocking_time;

	public Settings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMax_recharge_num() {
		return max_recharge_num;
	}

	public void setMax_recharge_num(int max_recharge_num) {
		this.max_recharge_num = max_recharge_num;
	}

	public double getMax_recharge_amount() {
		return max_recharge_amount;
	}

	public void setMax_recharge_amount(double max_recharge_amount) {
		this.max_recharge_amount = max_recharge_amount;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public int getBlocking_time() {
		return blocking_time;
	}

	public void setBlocking_time(int blocking_time) {
		this.blocking_time = blocking_time;
	}

}
