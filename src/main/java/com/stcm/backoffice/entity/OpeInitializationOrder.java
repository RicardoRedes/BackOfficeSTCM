package com.stcm.backoffice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.stcm.backoffice.entity.request.FullInitializationOrderRequest;
import com.stcm.backoffice.utils.UtilsSTCM;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "ope_initialization_order", catalog = "metrorrey", schema = "sch_pry_mty")
public class OpeInitializationOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
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
	private Long admin_user;

	public OpeInitializationOrder() {
	}

	public OpeInitializationOrder(String code, FullInitializationOrderRequest order) {
		this.code = code;
		this.total_cards = order.getTotalCards();
		this.processed_cards = 0;
		this.recharge_amount = order.getRechargeAmount();
		this.requesting_user = order.getRequestingUser();
		this.created_at = UtilsSTCM.getDateTime();
		this.updated_at = null;
		this.status = order.getStatus();
		this.accepted_cards = 0;
		this.declined_cards = 0;
		this.title_cards = order.getTitleCards();
		this.category_cards = order.getCategoryCards();
		this.bond_amount = order.getBondAmount();
		this.cost_card = order.getCostCard();
		this.task_type = order.getTaskType();
		this.init_task = null;
		this.equipment_code = order.getEquipmentCode();
		this.admin_user = order.getAdminUser();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Long getAdmin_user() {
		return admin_user;
	}

	public void setAdmin_user(Long admin_user) {
		this.admin_user = admin_user;
	}
	
}