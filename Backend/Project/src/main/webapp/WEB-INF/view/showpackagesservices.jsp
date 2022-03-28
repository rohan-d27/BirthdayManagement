<%@page import="project.entities.PackagesServicesTable"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PackagesServices List</title>
</head>
<body>
<% 
List<PackagesServicesTable> list=(List<PackagesServicesTable>)request.getAttribute("packagesservices");
 for(PackagesServicesTable a:list)
 {	 
 %>
 <%=a.getId()
 %>
<%} %>

</body>
</html>