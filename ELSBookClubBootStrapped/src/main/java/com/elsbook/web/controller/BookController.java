package com.elsbook.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elsbook.web.model.Items;
import com.elsbook.web.services.DataServices;

@Controller
public class BookController {
	
	@Autowired
	DataServices dataServices;
	
	@RequestMapping(value="/addbook", method = RequestMethod.GET)
	public String init(Model model, HttpSession session){
		model.addAttribute("bean", new AddBookBean());
		return "addbook";
	}
	
	@RequestMapping(value="/addbook", method = RequestMethod.POST)
	public String submit(Model model, HttpSession session, @ModelAttribute("bean") AddBookBean bean){
		System.out.println(bean.toString());
		Items item = new Items();
		item.setAuthor(bean.getAuthor());
		item.setDetails(bean.getDetails());
		item.setGenre(bean.getGenre());
		item.setIsbn(new Long(bean.getISBN()));
		item.setName(bean.getTitle());
		item.setPrice(new Float(bean.getPrice()));
		System.out.println(item);
		try{
			dataServices.addItems(item);
			return "addbook";
		}catch(Exception e){
           
			model.addAttribute("error", "Please enter correct Details or Book already exists.");
			return "addbook";
		}
	}
}
