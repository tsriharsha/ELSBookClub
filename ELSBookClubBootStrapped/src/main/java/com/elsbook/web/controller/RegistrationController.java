
package com.elsbook.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.elsbook.web.model.User;
import com.elsbook.web.services.DataServices;

@Controller
public class RegistrationController 
{
	@Autowired
	DataServices dataServices;
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public String init(Model model, HttpSession session) {
    	//model.addAttribute("bean", new RegistrationBean());
    	return "registration";
    }
	
	@RequestMapping(value="/registration", method = RequestMethod.POST)
    public String submit(Model model, HttpSession session, @ModelAttribute("bean") RegistrationBean bean) {
		String email = bean.getEmail();
		try {
			User user = dataServices.getUser(email);
			if(user != null){
				model.addAttribute("err", "user already exists");
				return "registration"; 
			}else{
				user = new User();
				user.setEmail(bean.getEmail());
				user.setFirstname(bean.getFirstName());
				user.setLastname(bean.getLastName());
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(15);
				user.setPassword(encoder.encode(bean.getPassword()));
				dataServices.addUser(user);
				return "hello";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(bean.toString());
			return "registration";
		}
		
		
        
	}
}
