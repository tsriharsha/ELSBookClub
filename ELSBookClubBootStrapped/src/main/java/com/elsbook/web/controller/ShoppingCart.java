package com.elsbook.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.elsbook.web.services.DataServices;

public class ShoppingCart {

	@Autowired
	DataServices dataServices;
	
	private ArrayList<String> isbnList;
	private ArrayList<Integer> amount;
	private float price;
	
	public void add(String isbn, long price){
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
	}
	
	public void destroy(){
		isbnList = new ArrayList<String>();
		amount = new ArrayList<Integer>();
	}
	
	public void generateOrder(ArrayList<String> list, ArrayList<Integer> amount, long price, String address){
		
	}
	
	
}
