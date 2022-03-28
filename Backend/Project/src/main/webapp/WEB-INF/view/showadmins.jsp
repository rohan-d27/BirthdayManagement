<%@page import="project.entities.AdminInfoTable"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin List</title>
</head>
<body>
<% 
List<AdminInfoTable> list=(List<AdminInfoTable>)request.getAttribute("admins");
 for(AdminInfoTable a:list)
 {	 
 %>
 <%=a.getAdminFname()+" "+a.getAdminLname()+" "+a.getAdminMobno()+" "+a.getAdminEmail()+" "+a.getAdminUsername()+" "+a.getAdminPassword()
 %>
<%} %>

</body>
</html>