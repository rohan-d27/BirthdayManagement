<%@page import="project.entities.OrdersInfoTable"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders List</title>
</head>
<body>
<% 
List<OrdersInfoTable> list=(List<OrdersInfoTable>)request.getAttribute("admins");
 for(OrdersInfoTable a:list)
 {	 
 %>
 <%=a.getCustomerInfoTable()+" "+a.getEventVenue()+" "+a.getNumberOfGuests()+" "+a.getOrderAmount()+" "+a.getOrderStatus()
 %>
<%} %>

</body>
</html>