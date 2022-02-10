<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<div class="brand">My Web</div>        
    <div class="address-bar">Welcome to MyWorld</div>
    <%@ include file = "../include/_header.jsp" %>
<body>
<section>
		<div align="center">
			<form name="regform" action="update.board" method="post" >
			  <table border="1" width="500">
			  	<tr>
					<td width="10%" >글번호</td>
					<td width="30%"><input type="text" name="num" value="${vo.num }" readonly></td> <!-- DB로부터 전달 받은 부분 -->
			  	</tr>
			  	<tr>
			  		<td>작성자</td>
			  		<td><input type="text" name="num" value="${vo.writer }" readonly></td> <!-- DB로부터 전달 받은 부분 -->
			  	</tr>
			  	<tr>
			  		<td>제목</td>
			  		<td><input type="text" name="title" value="${vo.title }" ></td> <!-- DB로부터 전달 받은 부분 -->
			  	</tr>
			  	<tr>
			  		<td>내용</td>
			  		<td colspan="3" height="120"><textarea rows="10" style="width:100%;" name="content">${vo.content}
			  			</textarea>
			  			</td> <!-- DB로부터 전달 받은 부분 -->
			  	</tr>
			  	<tr>
			  		<td colspan="2" align="center">
			  		<input type="button" value="목록" onclick="location.href='list.board'">
			  		<input type="button" value="수정" onclick="modifyCheck()">
			  		<input type="button" value="삭제" onclick="deleteCheck()">
			  	</tr>			  	
			  </table>
			</form>
		</div>
	</section>




<%@ include file = "../include/_footer.jsp" %>
</body>

<script type="text/javascript">
	function modifyCheck(){
		if(document.regform.title.value == ""){
			alert("제목을 입력해주세요.");
		}else if(confirm("수정하시겠습니까?")){
			document.regform.submit();
		}
			
	}
	function deleteCheck(){
		if(confirm("삭제하시겠습니까?")){
			location.href="delete.board?num="+ ${vo.num};
		}
			
	}


</script>
</html>