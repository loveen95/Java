package com.ok;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join_ok")
public class join_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public join_ok() {

         
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);
		//1. 입력값 처리(form)
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String gender = request.getParameter("gender");
		//2. DB 연동 처리	
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	    String driver = "oracle.jdbc.driver.OracleDriver";
	    String uid = "myjsp";
	    String upw = "myjsp";
		
	    Connection conn = null;
	    PreparedStatement stmt = null;
	   
	    
	    String sql = "insert into testusers values (?,?,?,?,?,?,?)";
        	    
	    try {
	    	Class.forName(driver);
	    	
	    	conn = DriverManager.getConnection(url,uid,upw);
	    	
	    	stmt = conn.prepareStatement(sql);
	    	
	    	stmt.setString(1, id);
	    	stmt.setString(2, pw);
	    	stmt.setString(3, name);
	    	stmt.setString(4, phone1);
	    	stmt.setString(5, phone2);
	    	stmt.setString(6, email);
	    	stmt.setString(7, gender);    
	    	
	    	int result = stmt.executeUpdate();
	    	
	    	if(result == 1 ) {
	    		response.sendRedirect("join_success.jsp");
	    	}else {
	    		response.sendRedirect("join_fail.jsp");
	    	}
	    	
	    }catch(ClassNotFoundException cnfe){
	    	System.out.println("드라이버 로딩 실패");
	    	
	    }catch (SQLException sqle) {
	    	System.out.println("sql 에러");
	    }catch (Exception e) {
	   
	    	e.printStackTrace();
	    }finally {
	    	try {
	    		if (conn != null) conn.close();
	    		if (stmt != null) stmt.close();
	    	
	    	
	    }catch(Exception e2){
	    	
	    }
	 }

	}

}			
		
		
		//3. 처리결과에 따른 뷰를 선택
		//   성공 : Success -> 성공 메세지를 출력
		//   실패 : Fail -> 실패 메시지 전송 -> 로그인 or 회원가입 페이지

