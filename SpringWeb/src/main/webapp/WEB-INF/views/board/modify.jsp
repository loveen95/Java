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
<%@ include file="../include/header.jsp" %>

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Modify Page</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-header bg-primary text-white">수정 페이지</div>
      <div class="card-body">



        <form role="form" name="regform" action="update" method="post" id="regform" >
          
          <div class="form-group">
            <label>번호</label>
            <input class="form-control" name="num" value="${board_modify.num}" readonly>
          </div>
          
          <div class="form-group">
            <label>제목</label>
            <input class="form-control" name="title"  value="${board_modify.title}">
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name="content">${board_modify.content}</textarea>
          </div>

          <div class="form-group">
            <label>작성자</label>
            <input class="form-control" name="writer" value="${board_modify.writer}" readonly>
          </div>
          
          
   <!--       
          <button type="submit" class="btn btn-primary" onclick="modifyCheck('modify')">변경</button>
         
          <button type="button" class="btn btn-secondary" onclick="location.href='boardDelete?num=${board_modify.num}'">삭제</button>
         
          <button type="button" class="btn btn-dark" onclick="location.href='list?&pageNum=${cri.pageNum }&count=${cri.count}'">목록</button>
     -->    
   


 		<button type="button" class="btn btn-primary" onclick="modifyCheck('modify')">변경</button>
         
        <button type="button" class="btn btn-secondary" onclick="modifyCheck('delete')">삭제</button>
         
        
        <button type="button" class="btn btn-dark" onclick="modifyCheck('list')">목록</button>
 

</form>

      </div>
      <!--  end card-body -->
    </div>
    <!--  end card-body -->
  </div>
  <!-- end card -->
</div>
<!-- /.row -->

<%@ include file="../include/footer.jsp" %>




<script type="text/javascript">
   function modifyCheck(e){
	   //$(#"id")는 html의 아이디 속성에 한번에 접근할 수 있음.
	   //attr (속성, 변경할 값) 함수는 태그 내부 속성을 변경하는 경우
	   if(e =='modify'){
		   <%System.out.println("함수 실행 중 ");%> 
	     if(document.regform.title.value==""){
	    	 alert("제목을 입력해주세요.");
		   return;
	   }else if (document.regform.content.value==""){
		   alert("내용을 입력해주세요.");
		   return;
	   }else if(confirm("수정하시겠습니까?")){
		   document.regform.submit();
	   
	   }

   }else if(e=='delete'){
	   if(confirm("삭제 하겠습니까?")){
		   $("#regform").attr("action","boardDelete");
		 	$("#regform").submit();
		 	
		 	
	   }else{
			   return;
	   }  
   } else{
	   $("#regform").attr("action","list");
	   $("#regform").submit();
   }
 }
   

</script>

</body>
</html>