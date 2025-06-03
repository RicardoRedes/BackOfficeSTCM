package com.stcm.backoffice.entity;

public class InitializationOrder {

	private String code;
	private int total_cards;
	private int processed_cards;
	private float recharge_amount;
	private String requesting_user;
	private String created_at;
	private String updated_at;
	private int status;
	private int accepted_cards;
	private int declined_cards;
	private int title_cards;
	private int category_cards;
	private int bond_amount;
	private int cost_card;
	private int task_type;
	private String init_task;
	private String equipment_code;
	

	public InitializationOrder() {
	
	}
	//TODO: Crear constructor que reciba un objeto tipo OpeInitializationOrder
	public InitializationOrder (OpeInitializationOrder initOrder) {
		
		this.code = initOrder.getCode();
		this.total_cards = initOrder.getTotal_cards();
		this.processed_cards = initOrder.getProcessed_cards();
		this.recharge_amount = initOrder.getRecharge_amount();
		this.recharge_amount = initOrder.getRecharge_amount();
		this.requesting_user = initOrder.getRequesting_user();
		this.created_at = initOrder.getCreated_at();
		this.updated_at = initOrder.getUpdated_at();
		this.status = initOrder.getStatus();
		this.accepted_cards = initOrder.getAccepted_cards();
		this.declined_cards = initOrder.getDeclined_cards();
		this.title_cards = initOrder.getTitle_cards();
		this.category_cards = initOrder.getCategory_cards();
		this.bond_amount = initOrder.getBond_amount();
		this.cost_card = initOrder.getCost_card();
		this.task_type = initOrder.getTask_type();
		this.init_task = initOrder.getInit_task();
		this.equipment_code = initOrder.getEquipment_code();
		
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getTotal_cards() {
		return total_cards;
	}

	public void setTotal_cards(int total_cards) {
		this.total_cards = total_cards;
	}

	public int getProcessed_cards() {
		return processed_cards;
	}

	public void setProcessed_cards(int processed_cards) {
		this.processed_cards = processed_cards;
	}

	public float getRecharge_amount() {
		return recharge_amount;
	}

	public void setRecharge_amount(float recharge_amount) {
		this.recharge_amount = recharge_amount;
	}

	public String getRequesting_user() {
		return requesting_user;
	}

	public void setRequesting_user(String requesting_user) {
		this.requesting_user = requesting_user;
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

	public int getAccepted_cards() {
		return accepted_cards;
	}

	public void setAccepted_cards(int accepted_cards) {
		this.accepted_cards = accepted_cards;
	}

	public int getDeclined_cards() {
		return declined_cards;
	}

	public void setDeclined_cards(int declined_cards) {
		this.declined_cards = declined_cards;
	}

	public int getTitle_cards() {
		return title_cards;
	}

	public void setTitle_cards(int title_cards) {
		this.title_cards = title_cards;
	}

	public int getCategory_cards() {
		return category_cards;
	}

	public void setCategory_cards(int category_cards) {
		this.category_cards = category_cards;
	}

	public int getBond_amount() {
		return bond_amount;
	}

	public void setBond_amount(int bond_amount) {
		this.bond_amount = bond_amount;
	}

	public int getCost_card() {
		return cost_card;
	}

	public void setCost_card(int cost_card) {
		this.cost_card = cost_card;
	}

	public int getTask_type() {
		return task_type;
	}

	public void setTask_type(int task_type) {
		this.task_type = task_type;
	}

	public String getInit_task() {
		return init_task;
	}

	public void setInit_task(String init_task) {
		this.init_task = init_task;
	}

	public String getEquipment_code() {
		return equipment_code;
	}

	public void setEquipment_code(String equipment_code) {
		this.equipment_code = equipment_code;
	}

}