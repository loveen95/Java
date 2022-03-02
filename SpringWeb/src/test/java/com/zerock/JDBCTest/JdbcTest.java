package com.zerock.JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JdbcTest {

	String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	String uid = "spring";
	String password ="spring";
	
	//src/test/java 폴더에는 자바 클래스를 이용하여 여러 작업을 테스트할 용도로 사용됨
	//Run as ->JUnitTest을 사용하여 실행
	//@Test 어노테이션을 사용하여 테스트할 메서드를 지정
	
	@Test
	public void JdbcTests() {
		try {
			//JDBC드라이버를 호출
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url,uid,password);
			System.out.println(">>>>>>>>connection객체생성"+ conn);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
