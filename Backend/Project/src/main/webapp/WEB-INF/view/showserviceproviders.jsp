<%@page import="project.entities.ServiceProviderInfoTable"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ServiceProviders List</title>
</head>
<body>
<% 
List<ServiceProviderInfoTable> list=(List<ServiceProviderInfoTable>)request.getAttribute("serviceproviders");
 for(ServiceProviderInfoTable a:list)
 {	 
 %>
 <%=a.getServiceProviderFname()+" "+a.getServiceProviderLname()+" "+a.getServiceProviderMobno()+" "+a.getServiceProviderEmail()+" "+a.getServiceProviderAddress()+" "+a.getServiceProviderCity()
 %>
<%} %>

</body>
</html>