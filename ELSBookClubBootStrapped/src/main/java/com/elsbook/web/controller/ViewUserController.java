package com.elsbook.web.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.elsbook.web.model.User;
import com.elsbook.web.services.DataServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.elsbook.web.dao.DataDaoImpl;

import com.elsbook.web.model.Items;

@Controller
public class ViewUserController {
	
	@Autowired
	DataServices dataServices;

	@RequestMapping(value="/viewusers", method = RequestMethod.GET)
	public String init(Model model, HttpSession session){
		int numitems = 5;
		Set<User> userlist;
		try {
			userlist = dataServices.getUserList();
			ArrayList<User> userList = new ArrayList<User>();
			userList.addAll(userlist);
			Collections.sort(userList);
			model.addAttribute("userlist", userList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return "viewusers";
	}
	
	
	@RequestMapping(value="/viewusers/delete/{email}", method = RequestMethod.POST)
	public String delete(Model model, @PathVariable("email") String email, HttpServletRequest request){
		//Use DAO to remove user
		System.out.println(email);
		try{
			dataServices.deleteUser(email+".com");
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
	}
	
}
