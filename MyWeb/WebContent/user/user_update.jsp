<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	/*이 페이지에 들어올때 , getUserInfo () 메서드를 재활용 해서 정보를 불러온 후에 input 태그에 값이 보여지도록 
	   	처리, id 태그는 변경 불가 
	   
	   
	   */
	   if(session.getAttribute("user_id")==null){
		   response.sendRedirect("user_mypage.jsp");
		   
	   }
		String id = (String)session.getAttribute("user_id");
		
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.getUserInfo(id);
	

%>
<div class="brand">My Web</div>        
    <div class="address-bar">Welcome to MyWorld</div>
<%@ include file="../include/_header.jsp" %>
<section>
    	<div align="center">
    		
    	    <form name="regform" action="user_update_ok.jsp" method="post">
			<h2>회원정보  수정</h2>
				<table>
				<tr>
					<td>아이디</td> 
					<td><input type="text" name="id" value="<%=vo.getId() %>" ></td>			
				</tr> 
				
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="<%=vo.getName() %>"></td>			
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" value="<%=vo.getEmail() %>"></td>			
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value="<%=vo.getAddress() %>"></td>			
				</tr>
				</table>
				<input type="button" value="정보수정" class="btn btn-primary" onclick="check()">
				<input type="button" value="마이페이지" class="btn btn-info" onclick="location.href='user_mypage.jsp'">
				
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
			
			}else if(confirm("회원정보 변경 하시겠습니까?")){
				//confirm()은 확인창에"예"를 클릭하면 true 반환, "아니오"는 false를 반환
				document.regform.submit(); //자바 스크립트를 이용한 submit() 기능
			} 
		
		}
	</script>
