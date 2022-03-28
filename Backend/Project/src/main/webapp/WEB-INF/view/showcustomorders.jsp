<%@page import="project.entities.CustomOrderTable"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CustomOrdersList</title>
</head>
<body>
<% 
List<CustomOrderTable> list=(List<CustomOrderTable>)request.getAttribute("customorders");
 for(CustomOrderTable a:list)
 {	 
 %>
 <%=a.getId()+" "+a.getOrdersInfoTable()+" "+a.getServicesInfoTable()%>
<%} %>

</body>
</html>