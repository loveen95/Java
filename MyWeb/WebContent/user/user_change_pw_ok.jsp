<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
    <%
    
    	request.setCharacterEncoding("utf-8");
    	if(session.getAttribute("user_id")==null){
    		response.sendRedirect("user_login.jsp");
    	}
    	
    	String id = (String)session.getAttribute("user_id");
    	String old_pw = request.getParameter("old_pw");
    	String new_pw = request.getParameter("new_pw");
	
    	UserDAO dao = UserDAO.getInstance();

        int result = dao.login(id, old_pw); 
    	if(result ==1){
    		int result2 = dao.changePassword(id,new_pw);
    		
    		if(result2 == 1){ //비밀번호 변경 성공
    	%>
    		 alert ("비밀번호 변경 처리 되었습니다.");
    		 location.href="user_mypage.jsp";
  	
    	 <% }else { %>
    		alert ("비밀번호가 틀립니다.");
		    history.go(-1);
    	<% }
    	
    	} else {%>
    	alert ("비밀번호 변경에 실패했습니다.");
	    location.href="user_mypage.jsp";
    	    
    	<%}%>
  
    	
    /*  1. 폼 값을 처리
       2. 로그인 (id, 예전비밀번호) 아이디로 비밀번호가 맞는지 확인
      	  기존 비밀번호가 틀리면 뒤로가기 	 
       3. 일치하면 changepassword(??) 메소드를 실행
       4. 성공하면 "비밀번호 변경 처리 되었습니다." ==> mypage로 이동
      	  실패하면 "비밀번호 변경에 실패 했습니다.를 출력하고 mypage로 이동
      	 
    
    */
    
    
   
      </script>
