package com.elsbook.web.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

import com.elsbook.web.dao.DataDao;
import com.elsbook.web.model.Employee;
import com.elsbook.web.model.Food;
import com.elsbook.web.model.Items;
import com.elsbook.web.model.OrderItems;
import com.elsbook.web.model.Orders;
import com.elsbook.web.model.User;

public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;
	
	@Override
	public boolean addEntity(Employee employee) throws Exception {
		return dataDao.addEntity(employee);
	}

	@Override
	public Employee getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}
	

	@Override
	public List<Employee> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}
	
	@Override
	public boolean addFood(Food food) throws Exception {
		return dataDao.addFood(food);
	}

	@Override
	public Food getFood(long id) throws Exception {
		return dataDao.getFood(id);
	}

	@Override
	public List<Food> getFood() throws Exception {
		return dataDao.getFoodList();
	}

	@Override
	public boolean deleteFood(long id) throws Exception {
		return dataDao.deleteFood(id);
	}

	@Override
	public User getUser(String email) throws Exception {
		return dataDao.getUser(email);
	}

	@Override
	public boolean addUser(User user) throws Exception {
		return dataDao.addUser(user);
	}

	@Override
	public Set<User> getUserList() throws Exception {
		return dataDao.getUserList();
	}

	@Override
	public boolean deleteUser(String email) throws Exception {
		return dataDao.deleteUser(email);
	}

	public boolean addItems(Items item)throws Exception{
		return dataDao.addItems(item);
	}
	
	public Items getItems(long isbn)throws Exception{
		return dataDao.getItems(isbn);
	}
	
	@Override
	public boolean deleteItems(long isbn)throws Exception{
		return dataDao.deleteItems(isbn);
	}

	@Override
	public boolean addOrder(Orders order) throws Exception {
		return dataDao.addOrders(order);
	}

	@Override
	public boolean deleteOrder(long orderid) throws Exception {
		return dataDao.deleteOrders(orderid);
	}
	
	@Override
	public Set<Orders> searchOrders(Criterion ordersCriteria) throws Exception {
		return dataDao.searchOrders(ordersCriteria);
	}

	@Override
	public boolean addOrderItems(OrderItems orderitem) throws Exception {
		return dataDao.addOrderItems(orderitem);
	}

	@Override
	public List<String> getItemsRest() throws Exception {
		return dataDao.getItemListRest();
	}

	@Override
	public Set<Items> searchItems(Criterion itemsCriteria) throws Exception {
		return dataDao.searchItems(itemsCriteria);
	}

	


}
