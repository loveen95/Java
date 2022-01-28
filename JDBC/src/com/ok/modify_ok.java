package com.ok;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/modify_ok")
public class modify_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public modify_ok() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 
		//정보 수정을 위한 페이지
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String user = "myjsp";
		String password = "myjsp";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		String sql = "select * from testusers where id = ?";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user, password); 
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			/*
			 * rs.next()를 이용하여 레코드 정보를 조회
			 * rs.getString() ....pw,name,phone1 등등
			 * request를 이용하여 강제로 저장한 후에 포워드로 update.jsp로 이동 
			 * 
			 * */
			
			if(rs.next()) {
				String name = rs.getString("name");
				String pw = rs.getString("pw");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				
				//request 객체에 강제 저장 
				request.setAttribute("user_name", name);
				request.setAttribute("user_pw", pw);
				request.setAttribute("user_phone1", phone1);
				request.setAttribute("user_phone2", phone2);
				request.setAttribute("user_gender", gender);
				request.setAttribute("user_email", email);
				
				System.out.println(id);
				System.out.println(pw);
				System.out.println(name);
				System.out.println(phone1);
				System.out.println(phone2);
				System.out.println(gender);
				System.out.println(email);
				
				//포워드
				RequestDispatcher dp = request.getRequestDispatcher("update.jsp");
			    dp.forward(request, response);
			} else {
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn !=null) conn.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch (Exception e2) {
				
			}
			
		}

	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	}

}
