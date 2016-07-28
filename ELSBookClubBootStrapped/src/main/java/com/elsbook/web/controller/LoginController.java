package com.elsbook.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.elsbook.web.model.Items;
import com.elsbook.web.model.Orders;
import com.elsbook.web.model.User;
import com.elsbook.web.services.DataServices;

@Controller
public class LoginController {
	

	@Autowired
	DataServices dataServices;
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(Model model, HttpSession session) {
    	User loginBean = (User) session.getAttribute("loggedin");
    	if(loginBean != null  && loginBean.getEmail() != null & loginBean.getPassword() != null){
    		model.addAttribute("msg", "welcome " + loginBean.getEmail());
            return "redirect:/";
    	}
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "newlogin";
    }
 
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean, HttpSession session) {
    	try{
    		User user = dataServices.getUser(loginBean.getUserName());
    		if(user == null){
    			model.addAttribute("error", "Invalid Details");
    			return "newlogin";
    		}
    		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(15);
    		if(encoder.matches(loginBean.getPassword(), user.getPassword()) && user.getEmail().equalsIgnoreCase(loginBean.getUserName())){
    			model.addAttribute("user",user);
    			session.setAttribute("loggedin",user);
    			return "redirect:/";
    			
    		}else{
    			model.addAttribute("error", "Invalid Details");
    			return "newlogin";
    		}
    			
    	}catch(Exception e){
    		model.addAttribute("error", "Invalid Details");
			return "newlogin";
    	}
    }
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
    	session.invalidate();
    	return "redirect:login";
    }

}