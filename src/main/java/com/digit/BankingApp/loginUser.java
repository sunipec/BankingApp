package com.digit.BankingApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class loginUser extends HttpServlet {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cust_id = Integer.parseInt(req.getParameter("cust_id"));
		int pin = Integer.parseInt(req.getParameter("pin"));
		
		String url = "jdbc:mysql://localhost:3306/bankingapplication";//bankingapplication
		String user = "root";
		String pwd = "1234";
		HttpSession session=req.getSession(true);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");

			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("connection created");

			String sql = "select * from bankApp where cust_id=? and pin=?";

			pstmt = con.prepareStatement(sql);

			
			
			pstmt.setInt(1, cust_id);
			pstmt.setInt(2, pin);

			res = pstmt.executeQuery();

			if(res.next()==true) {
				session.setAttribute("accno", res.getInt("accno"));
				session.setAttribute("customer_name", res.getString("customer_name"));
				session.setAttribute("pin", res.getInt("pin"));
				resp.sendRedirect("/BankingApplication/homePage.jsp");

			} 
			else {
				resp.sendRedirect("/BankingApplication/loginFail.html");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
