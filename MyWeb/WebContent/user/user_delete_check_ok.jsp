<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <script>
    <%
    		/*
    		1. user_delete_check.jsp로 받은 폼 데이터 값을 처리
    		2. login(id,pw)메서드를 재사용하여 , 비밀번호를 확인
    		3. login 메서드가 0을 반환하면 "비밀번호를 확인하세요."
    		4. login 메서드가 1을 반환하면 delete() 를 실행
    		4. 삭제 성공시 "회원 탈퇴처리가 되었습니다." 출력후에 세션을 전부 삭제후 / MyWeb으로 이동
    			삭제 실패시 "회원탈퇴에 실패했습니다." 출력. 마이페이지로 이동
    			sql = "delete from users where id = ?"
    		*/
    		 request.setCharacterEncoding("utf-8");
    
    		if(session.getAttribute("user_id")== null){
    			response.sendRedirect("user_login.jsp");	  //로그인 정보없이 url접근을 막기 위함
    		}
    		
    		String id = (String)session.getAttribute("user_id");
    		String pw = request.getParameter("pw");
    
    		UserDAO dao = UserDAO.getInstance();
    		
    		int result = dao.login(id, pw);
    		
    		if(result == 0){ %> 
    			alert("비밀번호를 확인하세요");
    			histori.go(-1);
    		
    		<%}else{	//성공한 경우
    			int result2 = dao.delete(id);
    				if(result2 == 1){%>
    				   alert("회원탈퇴가 처리 되었습니다.");
    				<% session.invalidate(); %>
    					location.href="/MyWeb/index.jsp";
 		
    				<%}else {%>
    				 	alert("회원탈퇴에 실패했습니다.");
    					location.href="user_mypage.jsp";
    				<%}

    		} %>
    		
    		   
    
    </script>