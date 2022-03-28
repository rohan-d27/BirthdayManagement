<%@page import="project.entities.FeedbackTable"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>=Feedback List</title>
</head>
<body>
<% 
List<FeedbackTable> list=(List<FeedbackTable>)request.getAttribute("feedbacks");
 for(FeedbackTable a:list)
 {	 
 %>
 <%=a.getFeedbackId()+" "+a.getOrderId()+" "+a.getFeedbackDetails()
 %>
<%} %>

</body>
</html>