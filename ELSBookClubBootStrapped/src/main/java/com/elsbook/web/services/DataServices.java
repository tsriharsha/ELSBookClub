package com.elsbook.web.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Criterion;

import com.elsbook.web.model.Employee;
import com.elsbook.web.model.Food;
import com.elsbook.web.model.Items;
import com.elsbook.web.model.OrderItems;
import com.elsbook.web.model.Orders;
import com.elsbook.web.model.User;

public interface DataServices {
	public boolean addEntity(Employee employee) throws Exception;
	public Employee getEntityById(long id) throws Exception;
	public List<Employee> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	
	public Food getFood(long id) throws Exception;
	public boolean addFood(Food food) throws Exception;
	public List<Food> getFood() throws Exception;
	public boolean deleteFood(long id) throws Exception;
	
	public User getUser(String email) throws Exception;
	public boolean addUser(User user) throws Exception;
	public Set<User> getUserList() throws Exception;
	public boolean deleteUser(String email) throws Exception;
	
	
	public boolean addItems(Items item) throws Exception;
	public Items getItems(long isbn) throws Exception;
	public List<Items> getItemsRest()throws Exception;
	
	public boolean addOrder(Orders order) throws Exception;
	public boolean deleteOrder(long orderid) throws Exception;
	public Set<Orders> searchOrders(Criterion ordersCriteria) throws Exception;
	
	public boolean addOrderItems(OrderItems orderitem) throws Exception;
}
