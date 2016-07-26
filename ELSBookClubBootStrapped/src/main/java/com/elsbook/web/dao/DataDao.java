package com.elsbook.web.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Criterion;

import com.elsbook.web.model.Employee;
import com.elsbook.web.model.Food;
import com.elsbook.web.model.Items;
import com.elsbook.web.model.OrderItems;
import com.elsbook.web.model.Orders;
import com.elsbook.web.model.User;

public interface DataDao {
	/*CRUD FUNCTIONS FOR THE TABLES*/
	
	//employee example functions
	public boolean addEntity(Employee employee) throws Exception;
	public Employee getEntityById(long id) throws Exception;
	public List<Employee> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	
	//food example functions
	public boolean addFood(Food food) throws Exception;
	public Food getFood(long id) throws Exception;
	public List<Food> getFoodList() throws Exception;
	public boolean deleteFood(long id) throws Exception;
	
	//USER TABLE DAO FUNCTIONS FOR BOOKCLUB USERS
	public boolean addUser(User user) throws Exception;
	public User getUser(String email) throws Exception;
	public Set<User> searchUser(Criterion userCriteria) throws Exception;
	public Set<User> getUserList() throws Exception;
	public boolean deleteUser(String email) throws Exception;
	
	//ITEMS TABLE DAO FUNCTIONS FOR BOOK CLUB ADMINS
	public boolean addItems(Items item) throws Exception;
	public Items getItems(Long isbn) throws Exception;
	public Set<Items> getItemList() throws Exception;
	public Set<Items> searchItems(Criterion itemCriteria) throws Exception;
	
	//ORDERS TABLE DAO FUNCTIONS FOR BOOK CLUB ADMINS
	public boolean addOrders(Orders order) throws Exception;
	public boolean deleteOrders(long orderid) throws Exception;
	public Set<Orders> getOrdersList() throws Exception;
	public Set<Orders> searchOrders(Criterion ordersCriteria) throws Exception;
	
	//ORDERITEMS TABLE DAO FUNCTIONS FOR BOOK CLUB ADMINS
	public boolean addOrderItems(OrderItems orderitem) throws Exception;
	public boolean deleteOrderItems(long orderid, long itemid) throws Exception;
	
}
