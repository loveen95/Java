package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
				//try - catch 사용한 방법
public class JDBCselect2 {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "myjsp";
		String upw = "myjsp";
		
		//DB연동을 위한 필요 클래스를 변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		//SQL 구문
		String sql = "select * from member";
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");	
		
		conn = DriverManager.getConnection(url,uid,upw);
		
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(sql);
	    int i = 1;
		while(rs.next()) {
			String id1 = rs.getString("id");  
			String pw1 = rs.getString("pw");
			String name1 = rs.getString("name");
			String email1 = rs.getString("email");
			System.out.println(i +"번째------------------------------------------------");
			System.out.println("DB로 부터 받은 id 값 : " + id1);
			System.out.println("DB로 부터 받은 pw 값 : " + pw1);
			System.out.println("DB로 부터 받은 name 값 : " + name1);
			System.out.println("DB로 부터 받은 email 값 : " + email1);
			i++;
				
		   }
		}catch (ClassNotFoundException cnfe) {
			System.out.println("드라이버를 로드하지 못함" + cnfe);
		}catch (SQLException sqle) {
			System.out.println("DB 연결 or SQL Error" + sqle);
		}catch (Exception e) {
			System.out.println("Unkwown 에러");
			e.printStackTrace();
		}finally { //생성된 객체를 정리 
			try {
				if(conn != null) conn.close();
				if(stmt != null) stmt.close();
				if(rs != null) rs.close();

			}catch (Exception e2) {
				
			}
		}
	
	}
}


	
				
		
		

	


