# Spring Rest Sample Project

This project is a web application which uses Spring 4.0 Rest so that form data can be entered and visually retrieved (on a web page) using the Spring 
Rest Service and the database.

From a user's perspective it works as follows (from my local environment) after starting Tomcat and deploying the IanPlanPlus.war file:

User enters Employee information (name, city, jobTitle) in the form on URL http://localhost:8080/IanPlanPlus/employeeEntryForm.jsp 
and upon submit the information is saved to the Employee table in the MySQL database.   The information saved is summarized when the user is directed to
http://localhost:8080/IanPlanPlus/saveEmployee.   The process can be repeated as many times as he/she wants.  Note that this web page incorporates the 'Hello World'
message.

User can retrieve (using the REST web service) either:

(1) list of all records in employee table by going to URL:  http://localhost:8080/IanPlanPlus/service/employees
OR
(2) list of all records in employee table corresponding to name='aname' by going to URL: http://localhost:8080/IanPlanPlus/service/employees/aname

From a technical perspective the working is as follows:

(1) Hibernate is used for database access.  So the Employee table is represented by an entity.  I also set up an EmployeeDaoImpl class for some methods used for retrieval and saving.
(2) The Rest Web Service is used for the Employee representational object via a class employed in Spring REST MVC.   The core spring framework 
    is utilize to autowire the EmployeeDaoImpl into it's methods which are as follows:
	     (a) saveEmployee - to save Employee information from form and output to a message page.  
                       		 Please note that there are no validations made so null data and/or duplicates can be saved
         (b) getEmployeesByName - get list of Employee table records by name as described in (2) of user's perspective above.  Returns empty list if name doesn't correspond
		        to any records in Employee table
		 (c) getAllEmployees - get list of all Employee table records.   Empty list if the table is empty.
(3) the spring app configuration and servlet config are taken care of restExample-servlet.xml (which also incorporates the Hibernate stuff).   
(4) web.xml also was wired to enable Spring Core and Spring REST MVC.
(5) incorporating 3rd party libaries (e.g. Spring, Hibernate, etc.) into the app build and deployment was achieved via Maven (see pom.xml).