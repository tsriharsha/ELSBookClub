package com.elsbook.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elsbook.web.model.Items;
import com.elsbook.web.services.DataServices;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
	
	@Autowired
	DataServices dataServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public String init(Model model, HttpSession session){
		
		ShoppingCart cart = (ShoppingCart) session.getAttribute("shoppingcart");
		System.out.println(cart);
		List<Items> shoppingcartlist = new ArrayList<Items>();
		for(String i : cart.getIsbnList()){
			try {
				shoppingcartlist.add(dataServices.getItems(new Long(i)));
				System.out.println(dataServices.getItems(new Long(i)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//List<Items> shoppingcartlist = cart.generateCart();//TestLibrary.dummyItemsList(numitems);
		model.addAttribute("shoppingcartlist", shoppingcartlist);
		return "shoppingcart";
	}
	
	@RequestMapping(value="/{isbn}", method = RequestMethod.POST)
	public String submit(Model model, @PathVariable("isbn") long isbn){
		System.out.println(isbn);
		return "redirect:/shoppingcart";
	}
	
}
