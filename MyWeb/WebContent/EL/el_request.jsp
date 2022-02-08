<%@page import="com.myweb.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	UserVO vo = new UserVO();
    	vo.setId("dbsqls95");
    	vo.setName("이윤빈");
    	vo.setAddress("서울 은평구 갈현동");
    	
    	request.setAttribute("vo",vo); //리퀘스트에 저장
    	
    	RequestDispatcher dp =request.getRequestDispatcher("el_request_ok.jsp");
        dp.forward(request, response);
 
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>