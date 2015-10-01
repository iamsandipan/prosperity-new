package com.prosperity.dao.model;

public class User {
	private String id;
	private String login;
	private String hashPassword;
	private String phone;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getHashPassword() {
		return hashPassword;
	}
	public void setHashPassword(String password) {
		this.hashPassword = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
