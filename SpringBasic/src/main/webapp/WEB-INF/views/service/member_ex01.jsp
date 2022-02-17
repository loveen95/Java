<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberServiceController</title>
</head>
<body>
	<h2>회원 정보 처리</h2>
	<h3>request로 값을 받아 처리(전통적)</h3>
	<form action="/service/memlogin" method="post">
		ID : <input type="text" name="memid"><br><br>
		PW : <input type="password" name="mempw"><br><br>
		<input type="submit" value="로그인">
	</form>
	<hr>
	<h3>RequestParam 어노테이션을 이용한 HTTP전송 정보 얻기</h3>
	<form action="/service/memlogin2" method="post">
		ID : <input type="text" name="memid"><br><br>
		PW : <input type="password" name="mempw"><br><br>
		<input type="submit" value="로그인">
	</form>
	<hr>
	<h3>커맨드 객체를 통한 처리</h3>
	<form action="/service/memlogin3" method="post">
		ID : <input type="text" name="id"><br><br>
		PW : <input type="password" name="pw"><br><br>
		Name : <input type="text" name="name"><br><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>