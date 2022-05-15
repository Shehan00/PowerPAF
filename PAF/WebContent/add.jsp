<%@page import="model.Feedback" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/main.js"></script>
<meta charset="ISO-8859-1">
<title>Add Your Feedback</title>
</head>
<body>


<h1>Add Your Feedback</h1>

<form method="post" action="Feedback.java">

User Full Name: <input name="name" type="text"><br><br>
Email: <input name="email" type="text"><br><br>
Contact Number: <input name="contact_no" type="text"><br><br>
Account No: <input name="account_no" type="text"><br><br>
Feedback: <input name="feedback" type="text"><br><br>



<input name="btnSubmit" type="submit" value="Submit"><br><br>
</form>

<%
out.print(session.getAttribute("statusMsg"));
%>

<br>





</body>
</html>