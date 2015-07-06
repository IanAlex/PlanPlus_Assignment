package com.ija.planplus.datamodel.dao;

import java.util.*;
import com.ija.planplus.datamodel.table.*;

public interface EmployeeDao {
	
	List<Employee> findAll();
	List<Employee> findForName(String name);
	void store(Employee employee);	

}
