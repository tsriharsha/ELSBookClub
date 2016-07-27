package com.elsbook.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elsbook.web.model.Items;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String init(Model model, HttpSession session){
		int numitems = 5;
		List<OrderBean> beanList = new ArrayList<OrderBean>();
		List<Items> itemslist = TestLibrary.dummyItemsList(numitems);
		//System.out.println(itemslist.toString());
		for(int i = 0; i < numitems; i++){
			OrderBean bean = new OrderBean();
			bean.setISBN(itemslist.get(i).getIsbn());
			bean.setTitle(itemslist.get(i).getName());
			bean.setAuthor(itemslist.get(i).getAuthor());
			bean.setPrice(itemslist.get(i).getPrice());
			//System.out.println(bean.toString());
			beanList.add(bean);
		}
		//System.out.println(beanList.toString());
		model.addAttribute("beanList", beanList);
		return "shoppingcart";
	}
	
	@RequestMapping(value="/orders/{isbn}", method = RequestMethod.POST)
	public String submit(Model model, @PathVariable("isbn") long isbn){
		System.out.println(isbn);
		return "redirect:/orders";
	}
	
}
