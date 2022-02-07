<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script>  
    <%
    /*진행 흐름 
    	1. 전달 받은 값을 처리
    	2. 회원가입 여부를 확인
    	3. 가입된 경우 실패(뒤로가기) , 가입이 안된경우 -> 가입 진행(join메서드 사용)
    	4. 회원가입 축하 및 로그인 페이지로 이동 , 실패시에는 재가입 페이지로 이동 	
    	*/
    	
    	request.setCharacterEncoding("utf-8");
  
    	String id=request.getParameter("id");
    	String pw = request.getParameter("pw");
    	String name = request.getParameter("name");
    	String address = request.getParameter("address");
    	String email = request.getParameter("email");  	
    
    	
	  	UserDAO dao = UserDAO.getInstance();
	  	
	  	UserVO vo = new UserVO(id, pw, name, email, address, null);
	  	
	  	//회원 가입 전에 이미 존재하는 아이디 인지 검증(중복 검사);
    	int result = dao.idConfirm(id);
    	
    	int result2;
    
    	if(result == 1) { %>
    	  alert("이미 존재하는 아이디 입니다.");
	 		history.go(-1);	 //뒤로 가기	
    	<%
    		}else {  // 중복이 없는 경우 (회원가입 - join())
    		result2 = dao.join(vo);%>
    		<% 
    		if(result2 == 1){ %>
       	 	alert("회원가입을 축하합니다.");
       		location.href = "user_login.jsp";
       		<%}else{ %>
       		alert("회원가입에 실패했습니다.");
       		history.go(-1);
			
       	<% 
       		}
       	   	}
       	%>
    		

    </script> 
    

    
     

