package com.stcm.backoffice.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.stcm.backoffice.entity.request.DeviceTransactionQR;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name="ope_access_qr",catalog="metrorrey", schema="sch_pry_mty")
public class TransactionQR {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long 	id;
	private String 	device_id;
	private String 	meid;
	private String equipment_code;
	private String 	date_now;
	private String 	date_access;
	private String 	date_qr;
	private int		access_counter;
	private int		balance;
	private int		balance_new;
	private int		discount;
	private String	discount_concept;
	private double	latitud;
	private double	longitud;
	private int		passengers;
	private String	company;
	private String	company_id;
	private String	method;
	private String	method_id;
	private int		qr_version;
	private String	status_transaction;
	private String	subscription;
	private int		subtotal;
	private long	ticket_id;
	private String	user_category;
	private int		total;
	private String	user_id;
	private String	profile;
	private String	title;
	private int 	status;
	
	public TransactionQR () {}
	
	public TransactionQR (DeviceTransactionQR transaction) {
		this.device_id 			= transaction.getDevice_id();//
		this.meid 				= transaction.getMeid();//
		this.equipment_code 	= transaction.getEquipment_code(); 
		this.date_now 			= getDateTime();
		this.date_access 		= transaction.getDate_access();//
		this.date_qr			= transaction.getDate_qr();//
		this.access_counter 	= transaction.getAccess_counter();//
		this.balance			= transaction.getBalance();//
		this.balance_new		= transaction.getBalance_new();//
		this.discount			= transaction.getDiscount();//
		this.discount_concept	= transaction.getDiscount_concept();//
		this.latitud			= transaction.getLatitud();//
		this.longitud			= transaction.getLongitud();//
		this.passengers			= transaction.getPassengers();//
		this.company			= transaction.getCompany();//
		this.company_id			= transaction.getCompany_id();//
		this.method				= transaction.getMethod();//
		this.method_id			= transaction.getMethod_id(); // falta
		this.qr_version			= transaction.getQr_version();
		this.status_transaction = transaction.getStatus_transaction();
		this.subscription		= transaction.getSubscription();// falta
		this.subtotal			= transaction.getSubtotal();// algun error
		this.ticket_id			= transaction.getTicket_id();//
		this.total				= transaction.getTotal();//
		this.user_id			= transaction.getUser_id(); //
		this.profile			= transaction.getProfile();//
		this.title				= transaction.getTitle();//
		this.status				= 0;
	}
	
	private String getDateTime() {
		Date time_now = new Date();
		@SuppressWarnings("deprecation")
		String moment = String.format("%04d-%02d-%02d %d:%d:%d", 
				(time_now.getYear()+1900),
				(time_now.getMonth()+1), 
				time_now.getDate(),
				time_now.getHours(),
				time_now.getMinutes(),
				time_now.getSeconds());
		return moment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	public String getMeid() {
		return meid;
	}

	public void setMeid(String meid) {
		this.meid = meid;
	}

	public String getEquipment_code() {
		return equipment_code;
	}

	public void setEquipment_code(String equipment_code) {
		this.equipment_code = equipment_code;
	}

	public String getDate_now() {
		return date_now;
	}

	public void setDate_now(String date_now) {
		this.date_now = date_now;
	}

	public String getDate_access() {
		return date_access;
	}

	public void setDate_access(String date_access) {
		this.date_access = date_access;
	}

	public String getDate_qr() {
		return date_qr;
	}

	public void setDate_qr(String date_qr) {
		this.date_qr = date_qr;
	}

	public int getAccess_counter() {
		return access_counter;
	}

	public void setAccess_counter(int access_counter) {
		this.access_counter = access_counter;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getBalance_new() {
		return balance_new;
	}

	public void setBalance_new(int balance_new) {
		this.balance_new = balance_new;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getDiscount_concept() {
		return discount_concept;
	}

	public void setDiscount_concept(String discount_concept) {
		this.discount_concept = discount_concept;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getMethod_id() {
		return method_id;
	}

	public void setMethod_id(String method_id) {
		this.method_id = method_id;
	}

	public int getQr_version() {
		return qr_version;
	}

	public void setQr_version(int qr_version) {
		this.qr_version = qr_version;
	}

	public String getStatus_transaction() {
		return status_transaction;
	}

	public void setStatus_transaction(String status_transaction) {
		this.status_transaction = status_transaction;
	}

	public String getSubscription() {
		return subscription;
	}

	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public long getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(long ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getUser_category() {
		return user_category;
	}

	public void setUser_category(String user_category) {
		this.user_category = user_category;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
