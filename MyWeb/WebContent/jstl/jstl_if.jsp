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
	<c:if test="true" >
		무조건 실행되는 문장
	</c:if>
<hr>
	<c:if test="${param.name eq '이윤빈' }">이윤빈 입니다. </c:if> 
	<c:if test="${param.name == '전정국' }">전정국 입니다.</c:if>
	<br>
	<%--age값이 20이상 이면 성인입니다. 20미만이면 미성년입니다.를 출력하는 코드 작성 --%>
	<c:if test="${param.age >= 20 }">성인입니다.</c:if>
	<c:if test="${param.age < 20 }">미성년입니다.</c:if>
	
</body>
</html>