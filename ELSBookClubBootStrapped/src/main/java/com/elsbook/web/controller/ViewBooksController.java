package com.elsbook.web.controller;

import java.util.ArrayList;
import java.util.List;
import com.elsbook.web.model.Items;
import com.elsbook.web.services.DataServices;
import com.elsbook.web.controller.TestLibrary;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewBooksController {

	DataServices dataservices;
	
	@RequestMapping(value="/viewbooks", method = RequestMethod.GET)
	public String init(Model model, HttpSession session){
		int numitems = 5;
		List<ViewBooksBean> beanList = new ArrayList<ViewBooksBean>();
		List<Items> itemslist = TestLibrary.dummyItemsList(numitems);
		//System.out.println(itemslist.toString());
		for(int i = 0; i < numitems; i++){
			ViewBooksBean bean = new ViewBooksBean();
			bean.setISBN(itemslist.get(i).getIsbn());
			bean.setTitle(itemslist.get(i).getName());
			bean.setAuthor(itemslist.get(i).getAuthor());
			bean.setPrice(itemslist.get(i).getPrice());
			//System.out.println(bean.toString());
			beanList.add(bean);
		}
		//System.out.println(beanList.toString());
		model.addAttribute("beanList", beanList);
		return "viewbooks";
	}
	
	@RequestMapping(value="/viewbooks/{isbn}", method = RequestMethod.POST)
	public String submit(Model model, @PathVariable("isbn") long isbn){
		dataServices.deleteItems(isbn);
		return "redirect:viewbooks";
	}
}

