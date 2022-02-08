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
<!-- 
	choose절을 이용하여 90이상은 A, 80이상은 B, 70 이상은c , 나머지는 f로 출력

	 -->
	<c:choose> 
		
		<c:when test="${param.point >= 90} ">A입니다.</c:when>
		<c:when test="${param.point >= 80} ">B입니다.</c:when>
		<c:when test="${param.point >= 70} ">C입니다.</c:when>
		<c:otherwise >F입니다.</c:otherwise>

	</c:choose>


</body>
</html>