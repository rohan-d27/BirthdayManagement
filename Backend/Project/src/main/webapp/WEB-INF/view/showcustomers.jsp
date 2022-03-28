<%@page import="project.entities.CustomerInfoTable"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
</head>
<body>
<% 
List<CustomerInfoTable> list=(List<CustomerInfoTable>)request.getAttribute("customers");
 for(CustomerInfoTable a:list)
 {	 
 %>
 <%=a.getCustomerFname()+" "+a.getCustomerLname()+" "+a.getCustomerMobno()+" "+a.getCustomerEmail()+" "+a.getCustomerUsername()+" "+a.getCustomerPassword()+a.getCustomerAddress()+" "+a.getCustomerCity()+" "+a.getCustomerZipcode()
 %>
<%} %>

</body>
</html>