package com.elsbook.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
public class ViewBooksController {

	@Autowired
	DataServices dataServices;
	
	@RequestMapping(value="/viewbooks", method = RequestMethod.GET)
	public String init(Model model, HttpSession session){
		int numitems = 5;
		Set<Items> itemslist;
		try {
			itemslist = dataServices.getItemsList();
			model.addAttribute("itemslist", itemslist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "viewbooks";
	}
	
	@RequestMapping(value="/deletebook/{isbn}", method = RequestMethod.POST)
	public String submit(Model model, @PathVariable("isbn") long isbn,  HttpServletRequest request){
		try {
			dataServices.deleteItems(isbn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
	}
}

