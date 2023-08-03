package com.digit.BankingApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/checkPassword")
public class changePassword extends HttpServlet {
	private Connection con;
	private PreparedStatement pstmt;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int oldPassword = Integer.parseInt(req.getParameter("password"));
		int newPassword = Integer.parseInt(req.getParameter("newPassword"));
		int confPassword = Integer.parseInt(req.getParameter("confPassword"));

		String url = "jdbc:mysql://localhost:3306/bankingapplication";// bankingapplication
		String user = "root";
		String pwd = "1234";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");

			HttpSession session = req.getSession();
			int accno = (int) session.getAttribute("accno");
			int pin = (int) session.getAttribute("pin");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("connection created");

			String sql = "update bankapp set pin=? where accno=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, confPassword);
			pstmt.setInt(2, accno);

			if (oldPassword==(pin)) {
				int x = pstmt.executeUpdate();
				if(x>0)
					resp.sendRedirect("/BankingApplication/passwordChangeSuccess.html");
			} else {

				resp.sendRedirect("/BankingApplication/passwordChangeFail.html");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
