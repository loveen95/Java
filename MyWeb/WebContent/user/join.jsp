<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <div class="brand">My Web</div>        
    <div class="address-bar">Welcome to MyWorld</div>
    <%@ include file = "../include/_header.jsp" %>
    
    <section>
    	<div align="center">
    		
    	    <form name="regform" action="user_join_ok.jsp" method="post">
			<h2>회원가입</h2>
				<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" placeholder="4글자 이상 8글자 이하"></td>			
				</tr> 
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw"></td>			
				</tr>	
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" name="pw_check"></td>			
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"></td>			
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email"></td>			
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address"></td>			
				</tr>
				</table>
				<input type="button" value="회원가입" class="btn btn-primary" onclick="check()">
				<input type="button" value="로그인" class="btn btn-info" onclick="location.href='user_login.jsp'">
				
			</form>
  
    	</div>
    
    </section>

	<%@ include file = "../include/_footer.jsp" %>
	<script type="text/javascript">
		function check() {
			//form 은  document.태그이름.태그이름으로 하위 태그에 접근이 가능하다. 페이지에서 f12 단축키
			//console.log(document.regform.id.value);
			if(document.regform.id.value == ''){
				alert("아이디는 필수 사항입니다.");
				return; 
			}else if(document.regform.id.value.length < 4 || document.regform.id.value.length > 8){
				alert("아이디는 4글자 이상 8글자 이하로 입력하세요.");
				return;
			}else if(document.regform.pw.value == ''){
				alert("비밀번호는 필수 사항입니다.");
				return;
			}else if(document.regform.pw.value != document.regform.pw_check.value){
				alert("비밀번호를 다시 확인하세요.");
				return;
			}else if(document.regform.name.value == ''){
				alert("이름은 필수 사항입니다.");
				return;
			}else if(confirm("회원가입을 하시겠습니까?")){
				//confirm()은 확인창에"예"를 클릭하면 true 반환, "아니오"는 false를 반환
				document.regform.submit(); //자바 스크립트를 이용한 submit() 기능
			} 
		
		}
	</script>




