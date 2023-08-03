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

@WebServlet("/loan")
public class loan extends HttpServlet{
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int option=Integer.parseInt(req.getParameter("option"));
		
		String url = "jdbc:mysql://localhost:3306/bankingapplication";//bankingapplication
		String user = "root";
		String pwd = "1234";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");

			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("connection created");

			String sql = "select * from loan where loan_id=?";

			pstmt = con.prepareStatement(sql);

			HttpSession session=req.getSession();
			
			pstmt.setInt(1, option);
			
			res = pstmt.executeQuery();

			if(res.next()==true) {
				session.setAttribute("loan_id", res.getInt("loan_id"));
				session.setAttribute("loan_type", res.getString("loan_type"));
				session.setAttribute("tenure", res.getInt("tenure"));
				session.setAttribute("interest", res.getFloat("interest"));
				session.setAttribute("loan_type", res.getString("description"));

				resp.sendRedirect("/BankingApplication/loanDetails.jsp");

			} 
			else {
				resp.sendRedirect("/BankingApplication/loanDetailsFail.html");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
