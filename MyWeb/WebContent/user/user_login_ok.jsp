<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <script type="text/javascript">
<%


	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	/*
	1. login(id,pw) 메서드를 생성
	 	executeQuery()메서드를 사용하고 그 결과 값이 존재하는지 확인
	2. 결과 값이 존재하면 성공의 의미로 1반환
              없다면 0반환
    3. 실패인 경우 경고 창 출력후 뒤로 가기
             성공인 경우에는 user_mypage.jsp로 이동
    4. 성공시 user_mypage.jsp 로 이동하기전에 user_mypage.jsp 에 전달함
       정보를 세션에 저장하여 전달(UserVO객체에 정보를 저장)
	
	
	*/
	//DAO 객체 생성
	UserDAO dao = UserDAO.getInstance();
	
   
 
    int result = dao.login(id, pw);
  
    
    if(result == 1){ //로그인 성공시 회원정보를 얻어오는 작업
    	%> 
    	<%
            UserVO vo = dao.getUserInfo(id);
    	
    		String name = vo.getName();
    		//아이디와 이름을 세션에 저장
    		
            session.setAttribute("user_id", id);
            session.setAttribute("user_name", name);
            response.sendRedirect("user_mypage.jsp");        
    	%>
    		// location.href = "user_mypage.jsp" 
    	
   	<% }else {
	   %> alert("아이디또는 비밀번호가 잘못되었습니다.");
	   	  history.go(-1);
	   
   <%}%>

   
%>
  </script>