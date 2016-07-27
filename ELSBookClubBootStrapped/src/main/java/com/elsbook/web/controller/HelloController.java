package com.elsbook.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.elsbook.web.model.Items;
import com.elsbook.web.model.User;
import com.elsbook.web.services.DataServices;

@Controller
public class HelloController {

	@Autowired
	DataServices dataServices;

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
	
	/*
	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public String addbook(ModelMap model) {
		return "addbook";

	}
	*/
	
	@RequestMapping(value = "/newlogin", method = RequestMethod.GET)
	public String newLogin(ModelMap model) {
		return "newlogin";

	}
	
	/*@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(ModelMap model) {
		return "registration";

	}*/
	
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public String adduser(ModelMap model) {
		return "adduser";
	}
	@RequestMapping(value="/adduser", method = RequestMethod.POST)
    public String submit(Model model, HttpSession session, @ModelAttribute("bean") RegistrationBean bean) {
		String email = bean.getEmail();
		try {
			User user = dataServices.getUser(email);
			if(user != null){
				model.addAttribute("err", "user already exists");
				return "adduser"; 
			}else{
				user = new User();
				user.setEmail(bean.getEmail());
				user.setFirstname(bean.getFirstName());
				user.setLastname(bean.getLastName());
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(15);
				user.setPassword(encoder.encode(bean.getPassword()));
				dataServices.addUser(user);
				return "redirect:hello";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(bean.toString());
			return "registration";
		}
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchQuery(ModelMap model) {
		
		int numitems = 5;
		List<Items> itemslist = TestLibrary.dummyItemsList(numitems);
		//System.out.println(itemslist.toString());
		//System.out.println(beanList.toString());
		//System.out.println(itemslist);
		model.addAttribute("searchlist", itemslist);
		return "search";
	}
	
	@RequestMapping(value = "/addtocart/{query}", method = RequestMethod.GET)
	public String addtocart(ModelMap model, @PathVariable("query") String query, HttpSession session) {
		ShoppingCart cart = (ShoppingCart) session.getAttribute("shoppingcart");
		if(cart == null){
			cart = new ShoppingCart();
		}
		
		String[] arr = query.split("\\+");
		cart.addToCart(arr[0], arr[1]);
		session.setAttribute("shoppingcart", cart);
		if(cart.getIsbnList().size()>5)
			session.invalidate();
		System.out.println(cart);
		return "redirect:/search";
	}
	

	
	@RequestMapping(value="/testingbcrypt", method = RequestMethod.GET)
	public String testBcrypt(){
		String testing = "helloworld";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(15);
		String etesting = encoder.encode(testing);
		System.out.println(etesting);
		System.out.println(encoder.matches(testing, etesting));
		return "hello";
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