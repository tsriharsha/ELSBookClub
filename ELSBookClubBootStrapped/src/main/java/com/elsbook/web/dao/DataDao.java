package com.elsbook.web.dao;

import java.util.List;

import com.elsbook.web.model.Employee;
import com.elsbook.web.model.Food;
import com.elsbook.web.model.Items;
import com.elsbook.web.model.Orders;
import com.elsbook.web.model.OrdersItemsAssociation;
import com.elsbook.web.model.User;

public interface DataDao {

	public boolean addEntity(Employee employee) throws Exception;
	public Employee getEntityById(long id) throws Exception;
	public List<Employee> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	
	public boolean addFood(Food food) throws Exception;
	public Food getFood(long id) throws Exception;
	public List<Food> getFoodList() throws Exception;
	public boolean deleteFood(long id) throws Exception;
	
	public boolean addUser(User user) throws Exception;
	public User getUser(String email) throws Exception;
	public List<User> getUserList() throws Exception;
	public boolean deleteUser(String email) throws Exception;
	
	public boolean addOrder(Orders order, String email, Items item) throws Exception;
	public Orders getOrder(long id) throws Exception;
	
	public boolean addOrderItemsAssociation(OrdersItemsAssociation orderitem) throws Exception;
	public boolean deleteOrderItemsAssociation(long orderid, long isbn) throws Exception;
	
	public boolean addItems(Items item) throws Exception;
	public Items getItems(Long isbn) throws Exception;
}
