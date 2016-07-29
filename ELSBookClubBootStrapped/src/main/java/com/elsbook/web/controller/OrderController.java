package com.elsbook.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.elsbook.web.model.Items;
import com.elsbook.web.model.OrderItems;
import com.elsbook.web.model.Orders;
import com.elsbook.web.model.User;
import com.elsbook.web.services.DataServices;
import com.elsbook.web.controller.TestLibrary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {

	@Autowired
	DataServices dataServices;
	@RequestMapping(value="/orders", method = RequestMethod.GET)
	public String init(Model model, HttpSession session){
		User user = (User) session.getAttribute("loggedin");
		List<Items> itemslist = new ArrayList<Items>();
		List<String> orderidlist = new ArrayList<String>();
		Set<Orders> orderSet;
		try {
			orderSet = dataServices.getUser(user.getEmail()).getOrders();
			//System.out.println(orderSet);
			List<Orders> orderlist = new ArrayList<Orders>();
			orderlist.addAll(orderSet);
			//System.out.println(orderlist.size());
			for(int i = 0; i < orderlist.size(); i++){
				Orders order = orderlist.get(i);
				List<OrderItems> orderitemslist = new ArrayList<OrderItems>();
				orderitemslist.addAll(order.getOrderItems());
				for(int j = 0; j < orderitemslist.size(); j++){
					orderidlist.add(""+order.getOrderid());
					itemslist.add(orderitemslist.get(j).getItem());
				}
			}
			/*while(orderSet.iterator().hasNext()){
				Orders order = orderSet.iterator().next();
				Set <OrderItems> orderItemsSet = order.getOrderItems();
				System.out.println(orderItemsSet);
				Orders order = orderSet.iterator().next();
				orderidlist.add(""+order.getOrderid());
				Set <OrderItems> orderItemsSet = order.getOrderItems();
				while(orderItemsSet.iterator().hasNext()){
					OrderItems orderitem = orderItemsSet.iterator().next();
					itemslist.add(orderitem.getItem());
				}
			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(orderidlist);
		model.addAttribute("itemList", itemslist);
		model.addAttribute("orderidlist", orderidlist);
		return "orders";
	}
	
	@RequestMapping(value="/orders/{isbn}", method = RequestMethod.POST)
	public String submit(Model model, @PathVariable("isbn") long isbn, HttpServletRequest request){
		System.out.println(isbn);
		String referer = request.getHeader("Referer");
		return "redirect:"+referer;
	}
}
