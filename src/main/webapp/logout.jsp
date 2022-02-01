<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
     //로그아웃 처리는 세션정보를 삭제하는것
     //session.invalidate();
     //response.sendRedirect("login.jsp");
     
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


   <script>alert ("로그아웃 되었습니다.")
           location.href="login.jsp"; </script>   
</body>
</html>