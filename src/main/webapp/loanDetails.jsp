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
	int loan_id=(int)session.getAttribute("loan_id");
	int tenure=(int)session.getAttribute("tenure");
	float interest=(float)session.getAttribute("interest");
	String loan_type=(String)session.getAttribute("loan_type");
	String description=(String)session.getAttribute("description");
	
	out.println("Loan details are: ");
	out.println("loan_id : "+loan_id);
	out.println("loan_type : "+loan_type);
	out.println("tenure : "+tenure);
	out.println("interest : "+interest);
	out.println("description : "+description);

	
	
	%>
	<a href="homePage.jsp">Click here to go to Home page</a>
</body>
</html>