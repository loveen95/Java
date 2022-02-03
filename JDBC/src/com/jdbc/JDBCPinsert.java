package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCPinsert {

	public static void main(String[] args) {
		//입력 값 받는 처리(member)
		Scanner scan = new Scanner(System.in);
		  System.out.print("id >");
	      String id = scan.next();
	      System.out.print("pw >");
	      String pw = scan.next();
	      System.out.print("name >");
	      String name = scan.next();
	      System.out.print("email >");
	      String email = scan.next();
	      
	      String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	      String user = "myjsp";
	      String password = "myjsp";
	      
	      Connection conn = null;
	      PreparedStatement pstmt = null; //preparedStatement 는 sql문을 단순히 하기위해서 사용한다.
	      
	      String sql = "insert into member values(?,?,?,?)";
	      
	      try {
	    	  
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	    	  conn = DriverManager.getConnection(url,user,password);
	    	  
	    	  pstmt = conn.prepareStatement(sql);
	    	  //pstmt 객체에 값을 설정시setString ,setInt, setDouble,,,,,
	    	  // 값을 불러올때엔 getString , getInt, getDouble,,,,, 
	    	  pstmt.setString(1, id); //인덱스를 이용한다(1번부터 시작) 
	    	  pstmt.setString(2, pw);  
	    	  pstmt.setString(3, name);
	    	  pstmt.setString(4, email);
	    	  
	    	  //pstmt 실행(성공시 1 실패시 0)  delete,update,insert 는 executeUpdate를 사용한다.
	    	 int result = pstmt.executeUpdate(); //주의!!!!!인자로 SQL로 전달하지 않는다. 
	    	  if(result ==1) {
	    		  System.out.println("입력성공");
	    	  }else {
	    		  System.out.println("입력실패");
	    	  } 
	    	  
	      }catch(ClassNotFoundException cnfe) {
	    	  System.out.println("드라이버 로딩 실패");
	    	  
	      }catch (SQLException sqle){
	    	  System.out.println("sql error");
	    	  
	      }catch (Exception e){
	    	  e.printStackTrace();
	    	  
	      }finally {
	    	  try {
	    		  if(conn != null) conn.close();
	    		  if(pstmt != null) pstmt.close();
	    		  if(scan != null) scan.close();
	      }catch(Exception e2){
	    	  
	      }
	
	}

 }
}

