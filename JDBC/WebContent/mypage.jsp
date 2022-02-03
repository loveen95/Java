<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
  
     request.setCharacterEncoding("utf-8");
     String id = (String)session.getAttribute("id");
     if(id ==null){
     	response.sendRedirect("login.jsp");//session을 사용하여 비 정상적인 접근을 막기위해 사전에 차단한다.
     }
     String pw = (String)session.getAttribute("pw");
     
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 페이지 정보</title>
</head>
<body>
<h2><%=id %>님 환영합니다.</h2>
<a href="logout.jsp">로그아웃</a>
<a href="modify_ok">회원정보 수정</a>
<a href="delete_ok">회원탈퇴</a>

</body>
</html>