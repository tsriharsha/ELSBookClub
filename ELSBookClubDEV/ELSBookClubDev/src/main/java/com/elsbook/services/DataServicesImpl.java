package com.elsbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.elsbook.dao.DataDao;
import com.elsbook.model.Employee;
import com.elsbook.model.Food;

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

}
