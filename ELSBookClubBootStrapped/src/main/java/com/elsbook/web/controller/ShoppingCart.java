package com.elsbook.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.elsbook.web.model.User;
import com.elsbook.web.services.DataServices;

public class ShoppingCart {


	@Autowired
	DataServices dataServices;
	
	private ArrayList<String> isbnList = new ArrayList<String>();
	private ArrayList<Integer> amount = new ArrayList<Integer>();
	private float price = 0;
	
	
	
	public void addToCart(String isbn, String price){
		boolean exists = false;
		for(String cartItem : isbnList){
			if(cartItem.equals(isbn)){
				exists = true;
				int index = this.isbnList.indexOf(cartItem);
				amount.add(index, amount.get(index)+1);
			}
		}
		if(exists == false){
			isbnList.add(isbn);
			amount.add(1);
		}
		this.price += new Float(price);
	}
	
	public void removeFromCart(String isbn, String price) {
		boolean exists = false;
		for(String cartItem : isbnList){
			if(cartItem.equals(isbn)){
				exists = true;
				int index = this.isbnList.indexOf(cartItem);
				isbnList.remove(index);
				amount.remove(index);
			}
		}
		if(exists == false){
			this.price -= new Float(price);
		}
	}
	
	public void destroy(){
		isbnList = new ArrayList<String>();
		amount = new ArrayList<Integer>();
	}
	
	public boolean generateOrder(User user, String address){
		return false;
	}

	@Override
	public String toString() {
		return "ShoppingCart [isbnList=" + isbnList + ", amount=" + amount
				+ ", price=" + price + "]";
	}

	public ArrayList<String> getIsbnList() {
		return isbnList;
	}

	public void setIsbnList(ArrayList<String> isbnList) {
		this.isbnList = isbnList;
	}

	public ArrayList<Integer> getAmount() {
		return amount;
	}

	public void setAmount(ArrayList<Integer> amount) {
		this.amount = amount;
	}
	
	
}
