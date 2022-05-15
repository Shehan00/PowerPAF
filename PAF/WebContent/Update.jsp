<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="model.Feedback" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/main.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<%

//Update user data----------------------------------
if (request.getParameter("Id") != null)
{
	Feedback userObj = new Feedback();
String stsMsg = userObj.EditUserDetails(request.getParameter("Id"),

request.getParameter("Name"),
request.getParameter("Email"),
request.getParameter("contact_no"),
request.getParameter("account_no"),
request.getParameter("Feedback"));
session.setAttribute("statusMsg", stsMsg);
}
%>

<h1> Update User Details</h1>

<form method="post" action="UpdateComplain.jsp">
User ID: <input name="Id" type="text"
			class="form-control form-control-sm"> Id:
<input name="address" type="text"
class="form-control form-control-sm">
<br> Email:
<input name="email" type="text"
class="form-control form-control-sm">
<br> Contact Number:
<input name="contact_no" type="text"
class="form-control form-control-sm">
<br> contact_no:
<input name="account_no" type="text"
class="form-control form-control-sm">
<br> account_no:
<input name="Feedback" type="text"
class="form-control form-control-sm">
<br> Feedback
<input name="btnsubmit" type="submit" value="update"
class="btn btn-primary">
</form>



<%
out.print(session.getAttribute("statusMsg"));
%>
<br>
<%
Feedback userObj = new Feedback();
out.print(userObj.readFeedback());
%>


</body>
</html>