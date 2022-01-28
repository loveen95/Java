package com.ok;

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


@WebServlet("/login_ok")
public class login_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public login_ok() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String user = "myjsp";
		String password = "myjsp";
		String driver = "oracle.jdbc.driver.OracleDriver";
				
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from testusers where id= ? and pw= ?";
		try {
			Class.forName(driver);
		conn = DriverManager.getConnection(url,user,password);
		pstmt =conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		
		
		rs = pstmt.executeQuery();
		
		if (rs.next()) { 
			HttpSession session = request.getSession(); //session 객체 생성
			session.setAttribute("id", id);
			
			response.sendRedirect("mypage.jsp");
		}else {
			response.sendRedirect("login_fail.jsp");
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
				
			}catch(Exception e2) {
				
			}
		}
		
	}

}
