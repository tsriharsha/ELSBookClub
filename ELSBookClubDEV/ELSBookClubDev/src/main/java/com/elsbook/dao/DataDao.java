package com.elsbook.dao;

import java.util.List;

import com.elsbook.model.Employee;
import com.elsbook.model.Food;

public interface DataDao {

	public boolean addEntity(Employee employee) throws Exception;
	public Employee getEntityById(long id) throws Exception;
	public List<Employee> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	
	public boolean addFood(Food food) throws Exception;
	public Food getFood(long id) throws Exception;
	public List<Food> getFoodList() throws Exception;
	public boolean deleteFood(long id) throws Exception;
}
