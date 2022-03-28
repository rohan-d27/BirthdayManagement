<%@page import="project.entities.PackagesInfoTable"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Packages List</title>
</head>
<body>
<% 
List<PackagesInfoTable> list=(List<PackagesInfoTable>)request.getAttribute("admins");
 for(PackagesInfoTable a:list)
 {	 
 %>
 <%=a.getPackageId()+" "+a.getPackageName()+" "+a.getPackageDesc()+" "+a.getPackagePrice()
 %>
<%} %>

</body>
</html>