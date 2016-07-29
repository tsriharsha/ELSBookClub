package com.elsbook.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elsbook.web.model.OrderItems;
import com.elsbook.web.model.Orders;
import com.elsbook.web.model.User;
import com.elsbook.web.services.DataServices;

@Controller
public class CheckOutController {
	
	@Autowired
	DataServices dataServices;
	
	@RequestMapping(value="/checkout", method = RequestMethod.GET)
	public String init(Model model, HttpSession session){
		User user = (User) session.getAttribute("loggedin");
		if(user == null){
			return "redirect:login";
		}
		return "checkout";
	}
	
	@RequestMapping(value="/checkout", method = RequestMethod.POST)
	public String submit(Model model, HttpSession session, @ModelAttribute("bean") CheckOutBean bean){
		ShoppingCart cart = (ShoppingCart) session.getAttribute("shoppingcart");
		String address = bean.getName()+","+bean.getAddress()+","+bean.getState()+","+bean.getZip()+","+bean.getCountry();
		User user = (User) session.getAttribute("loggedin");
		Orders order = new Orders();
		order.setAddress(address);
		order.setPrice(cart.getPrice());
		order.setUser(user);
		try {
			dataServices.addOrder(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < cart.getIsbnList().size(); i++){
			OrderItems orderitems = new OrderItems();
			try {
				orderitems.setItem(dataServices.getItems(new Long(cart.getIsbnList().get(i))));
				orderitems.setAmount(new Long(cart.getAmount(i)));
				orderitems.setOrder(order);
				dataServices.addOrderItems(orderitems);
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cart = new ShoppingCart();
		session.setAttribute("shoppingcart", cart);
		return "redirect:/";
	}
}
