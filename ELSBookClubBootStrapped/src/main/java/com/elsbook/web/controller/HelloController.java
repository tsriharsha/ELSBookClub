package com.elsbook.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", name);

		return model;

	}
	
	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public String addbook(ModelMap model) {
		return "addbook";

	}
	
	@RequestMapping(value = "/newlogin", method = RequestMethod.GET)
	public String newLogin(ModelMap model) {
		return "newlogin";

	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(ModelMap model) {
		return "registration";

	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public String adduser(ModelMap model) {
		return "adduser";
	}
	
	@RequestMapping(value = "/viewbooks", method = RequestMethod.GET)
	public String viewbooks(ModelMap model) {
		return "viewbooks";
	}
	
	@RequestMapping(value = "/viewusers", method = RequestMethod.GET)
	public String viewusers(ModelMap model) {
		return "viewusers";
	}
	
}