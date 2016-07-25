package com.elsbook.web.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.elsbook.web.dao.DataDao;
import com.elsbook.web.model.Employee;
import com.elsbook.web.model.Food;
import com.elsbook.web.model.Items;
import com.elsbook.web.model.Orders;
import com.elsbook.web.model.OrdersItemsAssociation;
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
	public List<User> getUserList() throws Exception {
		return dataDao.getUserList();
	}

	@Override
	public boolean deleteUser(String email) throws Exception {
		return dataDao.deleteUser(email);
	}

	@Override
	public Orders getOrder(long id) throws Exception {
		return dataDao.getOrder(id);
	}

	@Override
	public boolean deleteOrderItemsAssociation(long orderid, long isbn) throws Exception {
		return dataDao.deleteOrderItemsAssociation(orderid, isbn);
	}

	@Override
	public boolean addOrderItemsAssociation(long orderid, long isbn, long amount) throws Exception {
		OrdersItemsAssociation orderitem = new OrdersItemsAssociation();
		//orderitem.setOrderid(orderid);
		//orderitem.setIsbn(isbn);
		orderitem.setAmount(amount);
		return dataDao.addOrderItemsAssociation(orderitem);
	}
	
	/***** Generate order with good order id ****/
	public void generateOrder(String address, String shoppingcart, float pricetotal, int orderstatus, String email, Items item)throws Exception{
		Orders order = new Orders(address, shoppingcart, pricetotal, orderstatus);
		dataDao.addOrder(order, email, item);
		//System.out.println(order.getOrderid());
	}

	public boolean addItems(Items item)throws Exception{
		return dataDao.addItems(item);
	}
	
	public Items getItems(long isbn)throws Exception{
		return dataDao.getItems(isbn);
	}
}
