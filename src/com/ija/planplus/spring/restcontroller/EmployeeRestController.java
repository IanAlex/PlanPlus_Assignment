package com.ija.planplus.spring.restcontroller;

import java.util.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 

import org.springframework.beans.factory.annotation.Autowired;

import com.ija.planplus.datamodel.dao.*;
import com.ija.planplus.datamodel.table.*;


@RestController 
public class EmployeeRestController {     
	
	@Autowired 
	private EmployeeDao employeeDao;

	
	
	@RequestMapping(value="/saveEmployee", method=RequestMethod.POST)
	public String saveEmployee(@RequestParam("name") String name,
								@RequestParam("city") String city,
								@RequestParam("jobTitle") String jobTitle)
	{
		Employee employee = new Employee();
		employee.setName(name);
		employee.setCity(city);
		employee.setJobTitle(jobTitle);
		
		employeeDao.store(employee);
		return "Saved employee -- " + employee.toString();
	}
	

@RequestMapping(value = "service/employees/{name}", method = RequestMethod.GET,headers="Accept=application/json")
 public List<Employee> getEmployeesByName(@PathVariable String name) { 
	List<Employee> employees = employeeDao.findForName(name);
    return employees; 
 } 

 @RequestMapping(value = "service/employees", method = RequestMethod.GET,headers="Accept=application/json") 
 public List<Employee> getAllEmployees() { 
    List<Employee> employees= employeeDao.findAll();
    return employees; 
 } 

	


}
