package com.elsbook.web.controller;

public class CheckOutBean {
	private String name;
	private String CCN;
	private String expires;
	private String country;
	private String state;
	private String address;
	private String zip;
	
	
	@Override
	public String toString() {
		return "CheckOutBean [name=" + name + ", CCN=" + CCN + ", expires=" + expires + ", country=" + country
				+ ", state=" + state + ", address=" + address + ", zip=" + zip + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCCN() {
		return CCN;
	}
	public void setCCN(String cCN) {
		CCN = cCN;
	}
	public String getExpires() {
		return expires;
	}
	public void setExpires(String expires) {
		this.expires = expires;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
}
