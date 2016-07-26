package com.elsbook.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.elsbook.web.model.Items;
import com.elsbook.web.model.Orders;
import com.elsbook.web.model.User;

public class TestLibrary {

	public static String generateString(Random rng, String characters, int length){
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    return new String(text);
	}
	public static String text = "abcdefghijklmnopqrstuvwxys";
	public static String integer = "1234567890";
	public static List<User> dummyUserList(int size) {
		List<User> userlist = new ArrayList<User>(); 
		for(int i = 0; i < size; i++){
			User user = new User();
			user.setEmail(generateString(new java.util.Random(), text, 10));
			user.setFirstname(generateString(new java.util.Random(), text, 10));
			user.setLastname(generateString(new java.util.Random(), text, 10));
			user.setPassword(generateString(new java.util.Random(), text, 10));
			userlist.add(user);
		}
		// TODO Auto-generated method stub
		return userlist;
	}
	
	public static List<Items> dummyItemsList(int size) {
		List<Items> itemlist = new ArrayList<Items>(); 
		for(int i = 0; i < size; i++){
			Items item = new Items();
			item.setIsbn(new Long(generateString(new java.util.Random(), integer, 10)));
			item.setName(generateString(new java.util.Random(), text, 10));
			item.setAuthor(generateString(new java.util.Random(), text, 10));
			item.setGenre(generateString(new java.util.Random(), text, 10));
			item.setDetails(generateString(new java.util.Random(), text, 10));
			item.setPrice(new Float(generateString(new java.util.Random(), integer, 3)));
			itemlist.add(item);
		}
		// TODO Auto-generated method stub
		return itemlist;
	}

}
