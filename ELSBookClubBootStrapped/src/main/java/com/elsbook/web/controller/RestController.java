package com.elsbook.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elsbook.web.model.Employee;
import com.elsbook.web.model.Food;
import com.elsbook.web.model.Items;
import com.elsbook.web.model.Status;
import com.elsbook.web.services.DataServices;

@Controller
@RequestMapping("/rest")
public class RestController {

	@Autowired
	DataServices dataServices;


	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addEmployee(@RequestBody Employee employee) {
		try {
			dataServices.addEntity(employee);
			return new Status(1, "Employee added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}
	}
	
	@RequestMapping(value = "/food/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Food getFood(@PathVariable("id") long id) {
		Food food = null;
		try {
			food = dataServices.getFood(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return food;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Employee getEmployee(@PathVariable("id") long id) {
		Employee employee = null;
		try {
			employee = dataServices.getEntityById(id);
			System.out.println(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	
	/*@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Food getFood(@PathVariable("id") long id) {
		Food food = null;
		try {
			food = dataServices.getFood(id);
			System.out.println(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return food;
	}*/
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Employee> getEmployee() {

		List<Employee> employeeList = null;
		try {
			employeeList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeList;
	}

	@RequestMapping(value = "/list/items", method = RequestMethod.GET)
	public @ResponseBody
	List<Items> getItems() {

		List<Items> itemList = null;
		try {
			itemList = TestLibrary.dummyItemsList(10);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return itemList;
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteEmployee(@PathVariable("id") long id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Employee deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
