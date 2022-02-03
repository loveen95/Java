package com.ok;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;


@WebServlet("/delete_ok")
public class delete_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public delete_ok() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. delete
		//2. redirect 성공(success->login페이지)&실패(fail->mypage) 경우
        //3. id를 통해서 탈퇴를 하고 id는 session을 이용한다.
		//4. 세션 날리기 
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String driver = "oracle.jdbc.driver.OracleDriver";
        String user = "myjsp";
        String password ="myjsp";
            
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        String sql = " Delete from testusers where id = ?";
        
        try {
        	
        	Class.forName(driver);
        	
        	conn = DriverManager.getConnection(url,user,password);
        	pstmt = conn.prepareStatement(sql);
        	pstmt.setString(1,id);
        	
        	int result = pstmt.executeUpdate(); 
       
        	if (result == 1) {
        		//성공시
        		session.invalidate(); //정보를 모두 없애야 하므로 세션객체를 전부다 삭제한다.
        	 		
        		response.sendRedirect("login.jsp");
        		
        	}else {
        		//실패시
        	
        		response.sendRedirect("mypage.jsp");
        	}
        	
        
        }catch(ClassNotFoundException cnfe) {
        	System.out.println("드라이버 로딩실패");
        }catch(SQLException sqle){
        	System.out.println("sql 에러");
        }catch(Exception e) {
        	e.printStackTrace();
        
        }finally {
        	try {
        		if (conn!=null)conn.close();
        		if (pstmt!=null)pstmt.close();
        		 
        	}catch(Exception e2){
        		
        	}
        	
        }
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response, Object PreparedStatement) throws ServletException, IOException {

		
	}

}
