<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    	<div class="brand">My Web</div>        
    <div class="address-bar">Welcome to MyWorld</div>
   <%@ include file = "../include/_header.jsp" %>
  
  <section>
  	<div align="center">
  		<form action = "user_delete_check_ok.jsp" method="post">
  			<h3> 현재 비밀번호를 입력하세요.</h3>
  			<hr>
  			비밀번호 : <input type="password" name="pw">
  			<input type="submit" value="확인">  			
  		</form>
  	</div>
  </section>

<%@ include file = "../include/_footer.jsp" %>