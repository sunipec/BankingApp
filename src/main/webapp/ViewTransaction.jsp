<%@page import="java.sql.ResultSet"%>

<%@page import="java.sql.PreparedStatement"%>

<%@page import="java.sql.Connection"%>

<%@page import="java.sql.DriverManager"%>
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
	session = request.getSession();

	int accno = (int) session.getAttribute("accno");

	Class.forName("com.mysql.cj.jdbc.Driver");

	String url = "jdbc:mysql://localhost:3306/bankingapplication";
	String user = "root";
	String pwd = "1234";


	Connection con = DriverManager.getConnection(url, user, pwd);

	String sql = "select * from transferstatus where sender_accno=? ";

	PreparedStatement psta = con.prepareStatement(sql);

	psta.setInt(1, accno);

	ResultSet res5 = psta.executeQuery();

	while (res5.next() == true) {

		out.println(" Customer ID" + res5.getInt(1));

		out.println(" Bank Name " + res5.getString(2));

		out.println(" Ifsc" + res5.getString(3));

		out.println(" Sender Account Number" + res5.getInt(4));

		out.println(" Reciever Ifsc" + res5.getString(5));

		out.println(" Reciever Account Number " + res5.getInt(6));
		out.println("Transfered Amount" + res5.getInt(7));
		
		out.println();
		out.println();
		

	}
	%>


</body>
</html>