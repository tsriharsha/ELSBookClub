package com.elsbook.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
    	LoginBean loginBean = (LoginBean) session.getAttribute("MEMBER");
    	if(loginBean != null  && loginBean.getUserName() != null & loginBean.getPassword() != null){
    		model.addAttribute("msg", "welcome " + loginBean.getUserName());
            return "success";
    	}
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "login";
    }
 
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean, HttpSession session) {
        if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
        	User user = null;
        	try {
        		Items item = new Items();
        		item.setIsbn(124241);
        		item.setName("hellorld");

			} catch (Exception e) {
				System.out.println(e);
			}
            if (/*loginBean.getUserName().equals("test") && loginBean.getPassword().equals("test")*/user != null && loginBean.getPassword().equals(user.getPassword())) {
                model.addAttribute("msg", "welcome " + loginBean.getUserName());
                session.setAttribute("MEMBER", loginBean);
                return "success";
            } else {
                model.addAttribute("error", "Invalid Details");
                return "login";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "login";
        }
    }
}