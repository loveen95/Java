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
    <h2>점수 등록 결과</h2>
    <!-- service에서 점수 저장 결과 메서드 만든 후 사용 -->
    
    <!-- 현재 for문에 index 를 알수 있는 상태 변수 num을 사용 -->
    <c:forEach var="good" items="${scoreList }" varStatus="num">
        
        번호 : ${num.index +1} 
        이름 : ${good.name}
        국어 : ${good.kor}
        영어 : ${good.eng}
        수학 : ${good.math}
     <input type="button" value="삭제" onclick="location.href='scoreDelete?num=${num.index}'"> 
     <br>
    </c:forEach>
    <a href = "1scoreRegister">점수 등록하러 가기</a>


</body>
</html>