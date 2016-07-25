package com.elsbook.web.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.elsbook.web.model.Employee;
import com.elsbook.web.model.Food;
import com.elsbook.web.model.Items;
import com.elsbook.web.model.Orders;
import com.elsbook.web.model.OrdersItemsAssociation;
import com.elsbook.web.model.User;

@Transactional
public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(Employee employee) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();
		return false;
	}

	@Override
	public Employee getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Employee employee = (Employee) session.load(Employee.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Employee> employeeList = session.createCriteria(Employee.class)
				.list();
		tx.commit();
		session.close();
		return employeeList;
	}
	
	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Employee.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

	@Override
	public boolean addFood(Food food) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(food);
		tx.commit();
		session.close();
		return false;
	}

	@Override
	public Food getFood(long id) throws Exception {
		session = sessionFactory.openSession();
		Food food = (Food) session.load(Food.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return food;
	}

	@Override
	public List<Food> getFoodList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Food> foodList = session.createCriteria(Food.class).list();
		tx.commit();
		session.close();
		return foodList;
	}

	@Override
	public boolean deleteFood(long id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Food.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

	@Override
	public boolean addUser(User user) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		return false;
	}

	@Override
	public User getUser(String email) throws Exception {
			session = sessionFactory.openSession();
			//System.out.println(email);
			User user = null;
			if(session.get(User.class, new String(email))!=null)
			user = (User) session.load(User.class,
					new String(email));
			//System.out.println(user);
			tx = session.getTransaction();
			session.beginTransaction();
			tx.commit();
			return user;
	}

	@Override
	public List<User> getUserList() throws Exception {
		//System.out.println("reached here");
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<User> userList = session.createCriteria(User.class).list();
		//System.out.println("test");
		tx.commit();
		session.close();
		return userList;
	}

	@Override
	public boolean deleteUser(String email) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(User.class, email);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

	@Override
	public boolean addOrder(Orders order, String email, Items item) throws Exception {
		session = sessionFactory.openSession();
		System.out.println(email);
		User user1 = (User) session.createCriteria(User.class).add(Restrictions.like("email", email)).list().get(0);
		System.out.println(user1.getEmail());
		User user = (User) session.load(User.class,
				user1.getId());
		user.addOrder(order);
		order.setUser(user);
		tx = session.beginTransaction();
		
		session.save(order);
		session.save(user);
		tx.commit();
		session.close();
		return false;
	}
	
	@Override
	public Orders getOrder(long id) throws Exception {
		session = sessionFactory.openSession();
		Orders order = (Orders) session.load(Orders.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return order;
	}

	@Override
	public boolean deleteOrderItemsAssociation(long orderid, long isbn) throws Exception {
		session = sessionFactory.openSession();
		List<OrdersItemsAssociation> orderitem = session.createCriteria(OrdersItemsAssociation.class)
				.add(Restrictions.like("orderid", new Long(orderid)))
				.add(Restrictions.like("isbn", new Long(isbn) ) )
				.list();
		//System.out.println(orderitem.get(0).getAmount());
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(orderitem.get(0));
		tx.commit();
		return false;
	}

	@Override
	public boolean addOrderItemsAssociation(OrdersItemsAssociation orderitem) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(orderitem);
		tx.commit();
		session.close();
		return false;
	}
	
	@Override
	public Items getItems(Long isbn) throws Exception {
		session = sessionFactory.openSession();
		Items item = (Items) session.load(Items.class,
				new Long(isbn));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return item;
	}
	
	@Override
	public boolean addItems(Items item) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(item);
		tx.commit();
		session.close();
		return false;
	}
	

}
