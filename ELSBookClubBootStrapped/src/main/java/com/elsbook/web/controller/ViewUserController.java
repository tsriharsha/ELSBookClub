package com.elsbook.web.controller;

import java.util.ArrayList;
import java.util.List;

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
		List<UserBean> beanList = new ArrayList<UserBean>();
		List<User> userlist = TestLibrary.dummyUserList(numitems);
		//System.out.println(itemslist.toString());
		for(int i = 0; i < numitems; i++){
			UserBean bean = new UserBean();
			bean.setfName(userlist.get(i).getFirstname());
			bean.setlName(userlist.get(i).getLastname());
			bean.setEmail(userlist.get(i).getEmail());
			//System.out.println(bean.toString());
			beanList.add(bean);
		}
		System.out.println(beanList.toString());
		model.addAttribute("beanList", beanList);
		return "viewusers";
	}
	
	
	@RequestMapping(value="/viewusers/delete/{email}", method = RequestMethod.GET)
	public String delete(Model model, @PathVariable("email") String email){
		//Use DAO to remove user
		try{
			dataServices.deleteUser(email);
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		return "viewusers";
	}
	
}
