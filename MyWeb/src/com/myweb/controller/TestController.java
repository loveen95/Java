package com.myweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//컨트롤러를 생성할때는 매핑 형식을 확장자 패턴형식으로 변경..... ~~~.xxx 형식

//@WebServlet("/TestController")
@WebServlet("*.test")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public TestController() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response); //어떤 메소드로 전달되든 doAction 으로 전달하게 설정
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri = request.getRequestURI(); 
		
		String path = request.getContextPath(); //ContextPath == MyWeb 경로
		
		String command = uri.substring(path.length());
		
		System.out.println("uri 정보 : " +uri);
		System.out.println("Contextpath 정보 : " +path);
		
		System.out.println(command);
		
		if(command.equals("/controller/join.test")) {
			
			//...회원가입관련 동작....
			System.out.println("조인동작 확인" );
		}else if (command.equals("/controller/login.test")) {
			System.out.println("로그인동작 확인" );
		}else if (command.equals("/controller/update.test")) {
			System.out.println("수정 요청 동작 확인" );
		}else if (command.equals("/controller/delete.test")) {
			System.out.println("삭제 요청 동작 확인");
		}
		
	}
}
