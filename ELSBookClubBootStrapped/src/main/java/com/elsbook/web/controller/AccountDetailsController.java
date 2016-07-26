package com.elsbook.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class AccountDetailsController {
	
	@RequestMapping(value="/accountdetails", method=RequestMethod.GET)
	public String init(Model model, HttpSession session){
		model.addAttribute("bean", new AccountDetailsBean() );
		return "accountdetails";
	}
	
	@RequestMapping(value="/accountdetails", method=RequestMethod.POST)
	public String submit(Model model, HttpSession session, @ModelAttribute("bean") AccountDetailsBean bean){
		System.out.println(bean.toString());
		return "accountdetails";
	}
}
