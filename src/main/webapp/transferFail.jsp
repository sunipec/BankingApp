<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session=request.getSession();
out.println("Error is: "+session.getAttribute("error"));
%>
<br><br>

<a href="homePage.jsp">click to Try Again..</a>

</body>
</html>