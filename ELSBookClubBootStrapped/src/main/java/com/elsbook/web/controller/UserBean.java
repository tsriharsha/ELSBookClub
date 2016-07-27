package com.elsbook.web.controller;

public class UserBean {
	private String fName;
	private String lName;
	private String email;
	private String password;
	
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pass) {
		password = pass;
	}
	@Override
	public String toString() {
		return "UserBean [fName=" + fName + ", lName=" + lName + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
