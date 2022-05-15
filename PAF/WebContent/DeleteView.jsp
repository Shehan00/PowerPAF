<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
// view and delete
<%@page import="model.Feedback" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/main.js"></script>
<meta charset="ISO-8859-1">
<title>Delete And View</title>
</head>
<body>
<h1>User Details</h1>
<%



//Delete user----------------------------------
if (request.getParameter("Id") != null)
{
	Feedback userObj = new Feedback();
String stsMsg = userObj.deleteUser(request.getParameter("Id"));
session.setAttribute("statusMsg", stsMsg);
}



Feedback userObj = new Feedback();
out.print(userObj.readFeedback());
%>
</body>
</html>