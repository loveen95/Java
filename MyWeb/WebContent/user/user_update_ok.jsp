<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script type="text/javascript">

 
<%
/*

1. 폼 값을 받기
2. DAO 연동을 통해서 update() 메서드를 호출해서 회원정보를 수정
3. 매개 값을 VO전달 
4. 수정 성공시 "회원정보가 수정 되었습니다. " 출력후 마이페이지로 이동
      수정 실패시 "회원정보 수정에 실패했습니다." 출력후 마이페이지로 이동

*/
    if (session.getAttribute("user_id")==null){
    	response.sendRedirect("user_login.jsp");
    }
	request.setCharacterEncoding("utf-8");
	String id = (String)session.getAttribute("user_id");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	
	UserDAO dao = UserDAO.getInstance();
	UserVO vo = dao.getUserInfo(id);
	
	vo.setName(name);
	vo.setEmail(email);
	vo.setAddress(address);
	
	int result = dao.update(vo);
	
	if(result == 1){ //성공시
		//이름을 변경한 경우 세션에 저장한 이름을 변경.
		session.setAttribute("user_name", name);
	    		
	%>	alert("회원정보가 수정되었습니다.");
	    location.href("user_mypage.jsp");
		
	<%}else {%>
		alert("회원정보가 수정에 실패 했습니다.");
    	location.href("user_mypage.jsp");
		
	<%}%>
	
	

</script>  