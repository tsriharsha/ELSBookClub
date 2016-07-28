package com.elsbook.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elsbook.web.model.Items;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String init(Model model, HttpSession session){
		int numitems = 5;
		List<Items> shoppingcartlist = TestLibrary.dummyItemsList(numitems);
		model.addAttribute("shoppingcartlist", shoppingcartlist);
		return "shoppingcart";
	}
	
	@RequestMapping(value="/{isbn}", method = RequestMethod.POST)
	public String submit(Model model, @PathVariable("isbn") long isbn){
		System.out.println(isbn);
		return "redirect:/shoppingcart";
	}
	
}
