
package com.elsbook.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class RegistrationController {
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public String init(Model model, HttpSession session) {
    	//model.addAttribute("bean", new RegistrationBean());
    	return "registration";
    }
	
	@RequestMapping(value="/registration", method = RequestMethod.POST)
    public String submit(Model model, HttpSession session, @ModelAttribute("bean") RegistrationBean bean) {
        //System.out.println(bean.toString());
		return "registration";
	}
}
