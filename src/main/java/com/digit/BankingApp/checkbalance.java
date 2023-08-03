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

@WebServlet("/checkbalance")
public class checkbalance extends HttpServlet{

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		int accno=(int)session.getAttribute("accno");
		String url = "jdbc:mysql://localhost:3306/bankingapplication";//bankingapplication
		String user = "root";
		String pwd = "1234";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");

			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("connection created");

			String sql = "select * from bankApp where accno=?";

			pstmt = con.prepareStatement(sql);

			
			
			pstmt.setInt(1, accno);
			

			res = pstmt.executeQuery();

			if(res.next()==true) {
				session.setAttribute("balance", res.getInt("balance"));
				resp.sendRedirect("/BankingApplication/balance.jsp");
				
			} 
			else {
				resp.sendRedirect("/BankingApplication/balanceFail.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
