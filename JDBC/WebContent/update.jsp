<%@page import="com.ok.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%

         String id = (String)session.getAttribute("id"); //아이디만 세션에 저장했기 때문에 

    	//VO를 이용한 값 바꾸기
    	MemberVO vo = (MemberVO)request.getAttribute("vo");
    	System.out.println(vo.getId());
    	System.out.println(vo.getPw());
    	System.out.println(vo.getName());
    	System.out.println(vo.getPhone1());
    	System.out.println(vo.getPhone2());
    	System.out.println(vo.getEmail());
    	System.out.println(vo.getGender());
    	
      
        String pw = vo.getPw();
        String name = vo.getName();
        String phone1 = vo.getPhone1();
        String phone2 = vo.getPhone2();
        String email = vo.getEmail();
        String gender = vo.getGender();
  
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정 </title>
</head>
<body>

<!-- 
                                      "readonly"
select 태그의 옵션 중 미리 선택(default)값은 "selected" 
radio 버튼이나, checkbox 미리 선택하는 기능은 "checked"
radio 버튼이나, checkbox  선택할수 없게 하는 기능은 "disabled"

-->
<h2>회원정보 수정 페이지</h2>

<form action="update_ok" method="post"> 
ID : <input type="text" name="id" size="20"  value="<%=id%>" readonly><br>
PW : <input type="password" name="pw" size="20"  value="<%=pw%>" readonly><br>
이름 : <input type="text" name="name" size="20"  value="<%=name%>"><br>
전화번호 : 
<select name ="phone1">
<option <%=phone1.equals("010")?"selected" :""  %>>010</option>
<option <%=phone1.equals("011")?"selected" :""  %>>011</option>
<option <%=phone1.equals("018")?"selected" :""  %>>018</option>
</select> <input type="text" name="phone2" size="20" value="<%=phone2%>" ><br>

이메일 : <input type="email" name="email" size="30" value="<%=email%>"><br>
성별 : 
<%
if (gender == null || gender.equals("m")) {%>
<input type="radio" name="gender" value="m" checked>남자
<input type="radio" name="gender" value="f">여자 <br>
<%}else {%>
<input type="radio" name="gender" value="m" >남자
<input type="radio" name="gender" value="f" checked>여자 <br>
<%} %>
<input type="submit" value="수정">

</form>

</body>
</html>