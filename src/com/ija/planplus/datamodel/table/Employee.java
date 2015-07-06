package com.ija.planplus.datamodel.table;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee", schema="ija_planplus")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = -2912693560354598053L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "employeeid", unique = true, nullable = false)
	private Integer employeeId;	
	
	@Column(name = "name",  nullable = true,  length= 80, columnDefinition = "varchar(80) default '' ")
	private String name;
	
	@Column(name = "city",  nullable = true,  length= 80, columnDefinition = "varchar(80) default '' ")
	private String city;
	
	@Column(name = "jobtitle",  nullable = true,  length= 80, columnDefinition = "varchar(100) default '' ")
	private String jobTitle;
		
	public Employee() {
	}
	
	public Integer getEmployeeId() {
		return this.employeeId;
	}
 
	public void setEmployeeId(Integer loginId) {
		this.employeeId = loginId;
	}
	
	public String getName() {
		return this.name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	
	public String getcCity() {
		return this.city;
	}
 
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getJobTitle() {
		return this.jobTitle;
	}
 
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	@Override
	 public String toString() {
	  return "Employee [name=" + name + ", city=" + city
	    + ", jobTitle=" + jobTitle + "]";
	 }


}
