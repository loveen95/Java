package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCtest {
	public static void main(String[] args) {
		//Oracle 설정
		String driver_oracle = "oracle.jdbc.driver.OracleDriver";
		String url_oracle = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		//@localhost:1521/XEPDB1 이 부분은 변경되고 도메인이나 IP로 변경도 가능함.
		
		//MariaDB 설정
		String driver_mariadb = "org.mariadb.jdbc.Driver";
		String url_mariadb = "jdbc:mysql://localhost:3306/testdb";
		
		//MySQL 버전 6 이상인 경우
		String driver_mysql = "com.mysql.cj.jdbc.Driver";
		String url_mysql = "jdbc:mysql://localhost:3306/testdb?serverTimezone=Asia/Seoul";
		              //jdbc:mysql://[서버주소(IP 또는 도메인)]:[서비스포트(3306)]/DB이름]?serverTimezone=UTC
					  //서울의 UTC : Asia/Seoul
		//MySQL 버전 6 이전인 경우
		String driver_mysql_pre6 = "com.mysql.jdbc.Driver";
		String url_mysql_pre6 = "jdbc:mysql://localhost:3306/testdb";
		              //jdbc:mysql://[서버주소(IP 또는 도메인)]:[서비스포트(3306)]/DB이름]
		//DB접속 계정 정보
		String user = "myjsp";
		String password = "myjsp";
		
		//mariadb 사용자
		String m_user = "root";
		String m_password = "0000";
		
		//연결을 위한 객체 생성
		Connection conn = null;
		//java.sql로 임포트
		
		//connection값을 판별하는 boolean값
		Boolean connect = false;
		
		try {
			//1.driver 로딩
			Class.forName(driver_mariadb);
			
			//2.DB연결
			conn = DriverManager.getConnection(url_mariadb, m_user, m_password);
			connect = true;
		}catch (ClassNotFoundException cnfe) {
			//드라이버 로딩 실패시 예외
			connect = false;
			System.out.println("DB 드라이버 로딩 실패 : " + cnfe.toString());
		}catch (SQLException sqle) {
			// connection 실패시 에러(sqlexception)
			connect = false; 
			System.out.println("DB 접속 실패 : "+sqle.toString());
		}catch (Exception e) {
			// unknown 에러
			connect = false;
			System.out.println("Unknokn Error");
			e.printStackTrace(); //에러 출력해주는 메서드
		}
		if(connect) {
			System.out.println("연결성공");
		}else {
			System.out.println("연결실패");
		}
		
	}

}
