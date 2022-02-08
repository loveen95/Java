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
	<!-- choose 의 자식으로 c:when, c:otherwise를 가진다. -->
	<c:choose>
		<c:when test="${param.name eq '이윤빈' }">이윤빈입니다.</c:when> 
		<c:when test="${param.age >= 20 }">성인입니다.</c:when>
		<c:otherwise>이윤빈도 아니고, 성인도 아닙니다.</c:otherwise>	
	</c:choose>

</body>
</html>