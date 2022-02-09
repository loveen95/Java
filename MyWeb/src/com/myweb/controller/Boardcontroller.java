package com.myweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.service.GetListServiceImpl;
import com.myweb.board.service.IBoardService;
import com.myweb.board.service.RegisterServiceImpl;


@WebServlet("*.board")
public class Boardcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Boardcontroller() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doAction(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doAction(request, response);
	
	}
	// .board 로 끝나는 요청은 이 컨트롤러로 들어오도록 처리
	//1. get, post 요청을 하나의 메서드에 연결 - > doAction ()으로
	//2. 컨텍스트 path 를 제거 /board/list.board 요청으로 들어오면 board_list화면(view)로 이동
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//컨트롤러로 들어온 명령을 구분해서 처리하는 구간
		//2. 컨텍스트 path를 제거
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI(); //요청 주소(http[S]:// 를 뺀주소)
		String path = request.getContextPath(); //Context 주소를 얻어옴
		String command = uri.substring(path.length()); // /board/list.board 로 만드는 과정
		System.out.println(command);
		
		IBoardService service = null;
		
		//command에 따른 동작 구현.......
		if(command.equals("/board/list.board")) {
			//게시글 목록을 가지고 화면으로 이동
			//response.sendRedirect("/MyWeb/board/board_list.jsp");
			service = new GetListServiceImpl();
			service.execute(request, response);
			RequestDispatcher dp = request.getRequestDispatcher("board_list.jsp"); 
			dp.forward(request, response);
		}else if(command.equals("/board/write.board")) {
			//글 작성 페이지(view)로 이동
			response.sendRedirect("/MyWeb/board/board_write.jsp");
		}else if(command.equals("/board/register.board")) {
			//글 등록 페이지(view)로 이동
			service = new RegisterServiceImpl();
			service.execute(request, response);
			response.sendRedirect("/MyWeb/board/board_list.jsp");
			
		}
		
		}

}
