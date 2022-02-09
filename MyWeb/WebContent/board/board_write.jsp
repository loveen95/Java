<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<div class="brand">My Web</div>        
    <div class="address-bar">Welcome to MyWorld</div>
    <%@ include file = "../include/_header.jsp" %>
<body>
	<section >
	<div align="center">
	
		<form action="register.board" method="post" name="regform">
		
		<h2>게시판 글작성 페이지</h2>
		<hr>
		<table board="1" width="500">
		 <tr>
		 	<td>작성자</td>
		 	<td><input type="text" name="writer" size="10"></td>
		 </tr>
		 <tr>
		 	<td>글제목</td>
		 	<td><input type="text" name="title"></td>
		 </tr>
		 <tr>
		 	<td>글내용</td>
		 	<td><textarea rows="10" style="width:100%;" name="content"></textarea></td>
		 </tr>
		 <tr>
		 <!-- 글 등록 메뉴-->
		 	<td colspan="2" align="center">
		 	<input type="button" value="등록" onclick="registCheck()">
		 	<input type="button" value="목록" onclick="location='list.board'">
		 	</td>	
		 </tr>
		
		</table>
	
	
		</form>
	</div>
	</section>
	<%@ include file = "../include/_footer.jsp" %>
	<!-- 
		registCheck() 구현
		작성자, 글 제목에 공백을 확인하고 , 공백이 아니라면 submit()처리
	 -->
	<script type="text/javascript">
 	function registCheck(){
 		if(document.regform.writer.value == ""){
 			alert("작성자는 필수 입니다.");
 			return;
 		}else if(document.regform.title.value == ""){
 			alert("글 제목은 필수 입니다.");
 			return;
 		}else if(confirm("게시글을 등록하시겠습니까?")) {
 			document.regform.submit();
 		} 
 			
 		}
 		

 </script>
</body>
</html>
