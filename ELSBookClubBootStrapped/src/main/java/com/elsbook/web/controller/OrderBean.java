package com.elsbook.web.controller;

public class OrderBean {
	private String title;
	private String author;
	private long ISBN;
	private double price;
	private long orderID;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public long getISBN() {
		return ISBN;
	}
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	@Override
	public String toString() {
		return "OrderBean [title=" + title + ", author=" + author + ", ISBN=" + ISBN + ", price=" + price + ", orderID="
				+ orderID + "]";
	}
	
	
}
