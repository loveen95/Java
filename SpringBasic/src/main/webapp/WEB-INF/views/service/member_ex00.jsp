<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 회원 가입 (화면 URL요청 : con_path/service/member_tx01) </h2>
	
	<!-- 1. join 의 맵핑을 처리할수 있는 메소드를 생성하세요. (controller)
		 2. command 패키지의 parameter값을 처리할수 있는 JoinVO를 생성해서 값을 받아 처리한다.  	
				(Member (id,pw,name 최소로...) )
	     3. 서비스 패키지는 JoinService 인터페이스와 , JoinServiceImpl 클래스 생성
	     4. JoinServiceImpl 를 어노테이션을 이용하여자동 객체 생성 시키세요. @Service(이름)
	     5. 컨트롤러의 멤버 변수로 해당 객체를 자동 의존 주입 시키세요. @Autowired
	     
	     
	-->

	<form action="join" method="post">
		ID : <input type="text" name="id"><br><br>
		PW : <input type="password" name="pw"><br><br>
		Name : <input type="text" name="name"><br><br>
		Address : <input type="text" name="addr"><br><br>
		Phone : <input type="text" name="phone"><br><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>