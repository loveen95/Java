package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCdelete {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
	      System.out.print("id >");
	      String id = scan.next();
	      
	      //System.out.println("입력 아이디 : " + id + "입력 암호 : " + pw + "입력한 이름 : " + name + "입력한 이메일 : " + email);
	      
	      //DB연결을 위한 변수 
	      String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1"; //oracle URL
	      String uid = "myjsp";
	      String upw = "myjsp";
	      
	      Connection conn = null;
	      Statement stmt = null;
	      //ResultSet 객체는 선언안함...why? select문에서만 사용.
	      
	      //SQL 구문 : insert into member values('id','pw','email');
	      String sql = "Delete from member where id='"+id+"'";
	       
	      try {
	    	  //1.JDBC 드라이버 호출
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	    	  
	    	  //2. 커넥션
	    	  conn = DriverManager.getConnection(url,uid,upw);
	    	  
	    	  //3.SQL 문을 전달한 객체를 생성 Statement객체
	    	  stmt = conn.createStatement();
	    	  
	    	  //4.실행 (성공시 1 을 반환 실패시 0을 반환)
	    	  
	    	  int result = stmt.executeUpdate(sql);
	    	  
	    	  if(result == 1 ) {
	    		  System.out.println("삭제 성공");
	    		  
	    	  }else {
	    		  System.out.println("삭제실패");
	    	  }
	      }catch (ClassNotFoundException cnfe){
	    	  System.out.println("드라이버를 로드하지 못함" + cnfe.toString());
	      }catch (SQLException sqle) {
			System.out.println("DB 연결 or SQL Error " + sqle.toString());
	      } catch (Exception e) {
			e.printStackTrace();
	      }finally {
			try {
				if(conn != null) conn.close();
				if(stmt != null) stmt.close();
                
			}catch (Exception e2) {
				
			}
				
		}
	}
		
}
