<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
  	<div class="brand">My Web</div>        
    <div class="address-bar">Welcome to MyWorld</div>
    <%@ include file = "../include/_header.jsp" %>
<body>
<h2 align="center">로그인 </h2>
<hr>
<!-- 1. Myweb 사이트와 연동 되어야 한다.
	 2. 로그인시 필요한 아이디와 비밀번호를 입력 받게 설정
	 3. 로그인 버튼과 , 회원가입 버튼을 생성
	     =submit        =redirect
 -->
 <section> 
 
  	<div align="center">
	<form action="user_login_ok.jsp" method="post">
		아이디 <input type="text" name="id" placeholder="아이디"><br>
		비밀번호 <input type="password" name="pw"  placeholder="비밀번호"><br>
		<input type="submit" value="로그인" class="btn btn-default"> 
		
		<input type="button" value="회원가입" class="btn btn-primary" onclick="location.href='join.jsp'">
			    														<!--   -->

	</form>	
	
	</div>
</section>
	 <%@ include file = "../include/_footer.jsp" %>
</body>
	
		



</html>