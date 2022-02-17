<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그인 페이지(화면 URL 요청 : 컨패스/service/member_ex03)</h3>
	<form action="login" method="post">
		ID : <input type="text" name="id"><br><br>
		PW : <input type="password" name="pw"><br><br>
		<input type="submit" value="로그인">
		<input type="button" value="회원가입" onclick="location.href='member_ex00'">
	</form>
	결과 : ${msg }
</body>
</html>