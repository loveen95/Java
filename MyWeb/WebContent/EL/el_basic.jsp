<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>표현식</h3>
	<%= 1 + 2 %> <br>  <!-- 스크립트를 이용한 표현식 -->
	<%= "안녕" %> <br>
	<%= 1 > 2 || 1 == 2 %> <br> 
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ<br>
	<!-- 산술 연산 및 출력 -->
	<h3>EL</h3>
	${1+2}<br>
	${'안녕'} <br>
	
	<!-- 비교 / 논리 연산자 -->
	${ 1 < 2 && 1 != 2 } <br>
	${ 1 > 2 || 1 > 2} <br>   
	${ 1 < 2 and 1 > 2} <br>   
	${ 1 > 2 or 1 > 2} <br>
	   
	${ '홍길동' == '홍길동'} <br>
	${ '홍길동' eq '홍길동'} <br>
	${ '홍길동' != '홍길동'} <br>
	<!-- 
	${ '홍길동' ne '홍길동'} <br> -->

	<!--삼항 연산  -->
	${ 1 == 2 ? "같음(참)" : "다름(거짓)"} <br>
	${ 1 != 2 ? "같음(참)" : "다름(거짓)"} <br>
	

</body>
</html>