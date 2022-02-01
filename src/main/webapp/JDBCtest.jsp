<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
 
    		//Oracle 설정
    		String driver = "oracle.jdbc.driver.OracleDriver"; //DB드라이버
    		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1"; //DB connection 작업중 url값
    		              //jdbc:oracle:thin:[서버주소(IP 또는 도메인)]:[서비스포트]/[세션]
    		            		  
    		//DB접속 계정 정보
    		String user = "hr";
    		String pw = "hr";
    		
    		//연결을 위한 객체 생성
    		Connection conn = null;
    		//java.sql로 임포트
    		
    		//connection값을 판별하는 boolean값
    		Boolean connect = false;
    		
    		/*
    		//MariaDB 설정
    		String driver_mariadb = "org.mariadb.jdbc.Driver";
    		String url_mariadb = "jdbc:mysql://localhost:3306/testdb";
    		
    		//mariadb 사용자
    		String m_user = "root";
    		String m_password = "0000";
    		*/
    		
    		
    		try {
    			//1.driver 로딩
    			Class.forName(driver);
    			
    			//2.DB연결
    			conn = DriverManager.getConnection(url, user, pw);
    			connect = true;
    		}catch (ClassNotFoundException cnfe) {
    			//Driver 로딩 실패시 예외
    			connect = false;
    			System.out.println("DB 드라이버 로딩 실패 : " + cnfe.toString());
    		}catch (SQLException sqle) {
    			// DB 연결 connection 실패시 에러(sqlexception)
    			connect = false; 
    			System.out.println("DB 접속 실패 : "+sqle.toString());
    		}catch (Exception e) {
    			// unknown 에러
    			connect = false;
    			System.out.println("Unknown Error");
    			e.printStackTrace(); //에러 출력해주는 메서드
    		}
    		if(connect) {%>
    			<h2>DB연동 성공</h2>
    		<% }else { %>
    			<h2>DB연동 실패</h2>
    		<% }%>
    	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>