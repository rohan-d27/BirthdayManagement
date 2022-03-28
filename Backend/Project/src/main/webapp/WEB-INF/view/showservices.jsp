<%@page import="project.entities.ServicesInfoTable"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Services List</title>
</head>
<body>
<% 
List<ServicesInfoTable> list=(List<ServicesInfoTable>)request.getAttribute("services");
 for(ServicesInfoTable a:list)
 {	 
 %>
 <%=a.getServiceName()+" "+a.getServiceDesc()+" "+a.getServicePrice()
 %>
<%} %>

</body>
</html>