<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance Page </title>

<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #DBF9FC;
    margin: 0;
    padding: 0;
  }

  /* Center the content */
  .container {
    max-width: 600px;
    margin: 50px auto;
    padding: 20px;
    background-color: #fff;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }

  /* Style the balance text */
  .balance-text {
    text-align: center;
    color: #007bff;
    font-size: 24px;
    margin-bottom: 30px;
  }

  /* Style the redirect link */
  .redirect-link {
    display: block;
    text-align: center;
    color: #007bff;
    text-decoration: none;
    margin-top: 20px;
  }

  .redirect-link:hover {
    text-decoration: underline;
  }
</style>




</head>
<body  >
<div class="container">

	<%
	session =request.getSession();
	out.println("balance = "+session.getAttribute("accno"));
	%>
	
	
</div>
<a href="homePage.jsp" align="center">Click here to redirect</a>
</body>
</html>