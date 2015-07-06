
<!DOCTYPE HTML> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html> 
  <head> 
  </head>
  <body>
    
    <h2>PlanPlus Test (Ian Alex) Hello World 9999 Employee Entry Form</h2>
    <br/>
  	<form action="/IanPlanPlus/saveEmployee" method="POST"> 
  		Name: 
  		<input type="text" name="name"/>
        <br/>      
        City: 
  		<input type="text" name="city"/>
  		<br/>      
        Job Title: 
  		<input type="text" name="jobTitle"/>
  	    <input type="submit" value="Submit" />
  	</form>
  	 <div id="employeeFormResponse" style="color:red"></div>
  	<form id="jsonId" name=jsonForm method="POST" action="/IanPlanPlus/saveEmployee">
  		<input type="hidden" name="jsonString" /> 
    </form>
  	
  	<c:if test="${not empty message}">
  	  <div style="color:red">${message}</div>
  	</c:if>
  	
 <script type = 'text/javascript'>
/*
   $(document).ready(function() {
	      $('newEmployeeForm').submit(function(e) {
		      alert("hi ian 52.01");
	          // will pass the form data using the jQuery serialize function
	          $.post('/IanPlanPlus/saveEmployee', $(this).serialize(), function(response) {
	            $('#employeeFormResponse').text(response);
	          });
	           
	          e.preventDefault(); // prevent actual form submit and page reload
	        });
	  	   
   });
*/
    function jsonSubmit() {
         alert("hi ian 51.01");
         var name = document.forms["newEmployeeForm"]["name"].value;
         var city = document.forms["newEmployeeForm"]["city"].value;
         var jobTitle = document.forms["newEmployeeForm"]["jobTitle"].value;
         alert("hi ian 51.012");
      // create JSON
         var jsonObj = {
             "name": name,
             "city": city,
             "jobTitle": jobTitle
         };
         alert("hi ian 51.03");
         // convert JSON to string
         var jsonString = JSON.stringify(jsonObj);
         alert("hi ian 51.04");
         alert("hi ian JSON --" + jsonString);
         document.forms["jsonForm"]["jsonString"].value = jsonString;
         alert("hi ian 51.05 " + document.forms["jsonForm"]["jsonString"].value );    
         document.forms["jsonForm"]["jsonString"].submit();   
         alert("hi ian 51.06");        
         return false;
        }
 
 </script>
  
  
  </body>
</html>
