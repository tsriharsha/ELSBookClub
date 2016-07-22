package com.elsbook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
 
@Controller
@SessionAttributes("person")
public class LoginController {
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
            if (loginBean.getUserName().equals("test") && loginBean.getPassword().equals("test")) {
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