package com.elsbook.web.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.elsbook.web.model.Employee;
import com.elsbook.web.model.Food;
import com.elsbook.web.model.Items;
import com.elsbook.web.model.OrderItems;
import com.elsbook.web.model.Orders;
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

	@SuppressWarnings("unchecked")
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
			List<User> user = session.createCriteria(User.class)
					.add(Restrictions.like("email", email))
					.list();
			tx = session.getTransaction();
			session.beginTransaction();
			tx.commit();
			if(!user.isEmpty())
				return user.get(0);
			else
				return null;
	}
	
	@Override
	public Set<User> searchUser(Criterion userCriteria) throws Exception {
		//System.out.println("reached here");
		Set<User> userset = new HashSet<User>();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<User> userList = session.createCriteria(User.class)
				.add(userCriteria)
				.list();
		userset.addAll(userList);
		//System.out.println("test");
		tx.commit();
		session.close();
		return userset;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<User> getUserList() throws Exception {
		//System.out.println("reached here");
		Set<User> userset = new HashSet<User>();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<User> userList = session.createCriteria(User.class).list();
		userset.addAll(userList);
		//System.out.println("test");
		tx.commit();
		session.close();
		return userset;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteUser(String email) throws Exception {
		session = sessionFactory.openSession();
		List<User> userList = session.createCriteria(User.class)
				.add(Restrictions.like("email", email))
				.list();
		//Object o = session.load(User.class, );
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(userList.get(0));
		tx.commit();
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
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Items> getItemList() throws Exception {
		Set<Items> itemset = new HashSet<Items>();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Items> itemList = session.createCriteria(Items.class).list();
		itemset.addAll(itemList);
		//System.out.println("test");
		tx.commit();
		session.close();
		return itemset;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Items> searchItems(Criterion itemCriteria) throws Exception {
		//System.out.println("reached here");
		Set<Items> itemset = new HashSet<Items>();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Items> itemList = session.createCriteria(Items.class)
				.add(itemCriteria)
				.list();
		itemset.addAll(itemList);
		//System.out.println("test");
		tx.commit();
		session.close();
		return itemset;
	}
	
	@Override
	public boolean addOrders(Orders order) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(order);
		tx.commit();
		session.close();
		return false;
	}

	@Override
	public boolean deleteOrders(long orderid) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Orders.class, orderid);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Orders> getOrdersList() throws Exception {
		Set<Orders> orderset = new HashSet<Orders>();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Orders> orderList = session.createCriteria(Orders.class).list();
		orderset.addAll(orderList);
		//System.out.println("test");
		tx.commit();
		session.close();
		return orderset;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Orders> searchOrders(Criterion ordersCriteria) throws Exception {
		//System.out.println("reached here");
		Set<Orders> orderset = new HashSet<Orders>();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Orders> orderList = session.createCriteria(Orders.class)
				.add(ordersCriteria)
				.list();
		orderset.addAll(orderList);
		//System.out.println("test");
		tx.commit();
		session.close();
		return orderset;
	}

	@Override
	public boolean addOrderItems(OrderItems orderitem) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(orderitem);
		tx.commit();
		session.close();
		return false;
	}


	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteOrderItems(long orderid, long itemid) throws Exception {
		session = sessionFactory.openSession();
		List<User> userList = session.createCriteria(OrderItems.class)
				.add(Restrictions.and(Restrictions.like("ordeidr", orderid),Restrictions.like("isbn", itemid)))
				.list();
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(userList.get(0));
		tx.commit();
		return false;
	}



	

}
