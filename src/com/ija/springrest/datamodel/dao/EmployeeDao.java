package com.ija.springrest.datamodel.dao;

import java.util.*;

import com.ija.springrest.datamodel.table.*;

public interface EmployeeDao {
	
	List<Employee> findAll();
	List<Employee> findForName(String name);
	void store(Employee employee);	

}
