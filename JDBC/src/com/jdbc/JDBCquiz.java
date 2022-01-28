package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCquiz {

	public static void main(String[] args) {
		
		//id 를 입력받아 해당ID 에 속한 정보만 출력하는 코드 작성
		
		 Scanner scan = new Scanner(System.in);
	      System.out.print("id >");
	      String id = scan.next();
	      
	     
	      String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	      String driver = "oracle.jdbc.driver.OracleDriver";
	      String uid = "myjsp";
	      String upw = "myjsp";
	      
	      ResultSet rs = null;
	      Connection conn = null;
	      Statement stmt = null;
	     
	      
	      String sql = "select * from member where id='"+id+"'";
	      
	      try {	  
	      Class.forName(driver);  //1. 드라이버 연동
	      
	      conn = DriverManager.getConnection(url,uid,upw); //2.connection 객체 생성
	      
	      stmt = conn.createStatement();
	      
	      rs = stmt.executeQuery(sql);
	      
	      
	    
	      if (rs.next()) {
	    	  	String id1 = rs.getString("id");  
				String pw1 = rs.getString("pw");
				String name1 = rs.getString("name");
				String email1 = rs.getString("email");
				System.out.println("------------------------------------------------");
				System.out.println("검색한  ID : " + id);
				System.out.println("아이디는  " + id1);
				System.out.println("패스워드는  " + pw1);
				System.out.println("이름은  " + name1);
				System.out.println("email은 " + email1);

	      } else {
	    	  System.out.println(id +"는 없습니다.");
	      }
	      }catch (ClassNotFoundException cnfe){
	    	  System.out.println("드라이버 로딩 실패");
	      }catch (SQLException sqle) {
	    	  System.out.println("sql error");
	      }catch (Exception e) {
	    	  System.out.println("unknown 에러");
	    	  e.printStackTrace();
	      }finally {
	    	  try {
	    	  if(conn != null) conn.close();
	    	  if(stmt != null) stmt.close();
	    	  if(rs != null) rs.close();
	    	  } catch (Exception e2 ) {
	    		  
	    	  }
	      }

	}

}
