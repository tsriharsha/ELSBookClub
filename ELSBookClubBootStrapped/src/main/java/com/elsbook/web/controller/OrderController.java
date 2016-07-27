package com.elsbook.web.controller;

import java.util.ArrayList;
import java.util.List;
import com.elsbook.web.model.Items;
import com.elsbook.web.services.DataServices;
import com.elsbook.web.controller.TestLibrary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {

	@Autowired
	DataServices dataServices;
	@RequestMapping(value="/orders", method = RequestMethod.GET)
	public String init(Model model, HttpSession session){
		int numitems = 5;
		List<Items> itemslist = TestLibrary.dummyItemsList(numitems);
		model.addAttribute("itemList", itemslist);
		return "orders";
	}
	
	@RequestMapping(value="/orders/{isbn}", method = RequestMethod.POST)
	public String submit(Model model, @PathVariable("isbn") long isbn, HttpServletRequest request){
		System.out.println(isbn);
		String referer = request.getHeader("Referer");
		return "redirect:"+referer;
	}
}
