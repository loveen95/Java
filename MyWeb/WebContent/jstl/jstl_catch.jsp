<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	자바의 예외처리 구분과 같이 동작
	try{
		검증할 내용이 있는 영역
	}catch (Exception e){
		검증된 내용이 처리하다가 에러 발생시에 내용이 처리될 영역
	}

 --%>
 	<!-- JSTL을 사용하는 경우  -->
 	<c:catch var="abc"> <!--abc 는 Exception e 와 같다. -->
 		<!-- 검증할 내용이 있는 영역 -->
 		<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>
 		
 	</c:catch>
 		<!--에러내용은 ${abc}로 확인한다.  -->
 		 ${abc} <br>
 	

</body>
</html>