package com.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
	@Id
	private int accountNumber;
	private String name;
	private String password;
	private String confirm_password;
	private double amount;
	private String address;
	private String mobileNumber;
	public Account() {
		super();
	}
	public Account(int accountNumber, String name, String password, String confirm_password, double amount,
			String address, String mobileNumber) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.confirm_password = confirm_password;
		this.amount = amount;
		this.address = address;
		this.mobileNumber = mobileNumber;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", password=" + password
				+ ", confirm_password=" + confirm_password + ", amount=" + amount + ", address=" + address
				+ ", mobileNumber=" + mobileNumber + "]";
	}
	

}
