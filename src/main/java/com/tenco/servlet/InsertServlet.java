package com.tenco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("InsertServlet 초기화");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	// http://localhost:8080/InsertServlet
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		// 유효성 검사 생략

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/demo5?serverTimezone=Asia/Seoul";
			try {
				Connection conn = DriverManager.getConnection(dbUrl, "root", "asd123");
				String sql = " INSERT INTO users(name,email) values (?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, email);
				pstmt.executeUpdate();

				pstmt.close();
				conn.close();

				response.sendRedirect("result.jsp?message=success");
			}  catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("result.jsp?mesaage=error");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		// 데이터 베이스에 접근새허 데이터 저장
	}
}
	


