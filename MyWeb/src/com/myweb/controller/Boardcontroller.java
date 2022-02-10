package com.myweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.service.ContentServiceImpl;
import com.myweb.board.service.DeleteServiceImpl;
import com.myweb.board.service.GetListServiceImpl;
import com.myweb.board.service.IBoardService;
import com.myweb.board.service.RegisterServiceImpl;
//컨트롤러는 모델이나 view에대해서 알고 있어야 한다.
import com.myweb.board.service.UpdateServiceImpl;


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
			
		}else if(command.equals("/board/content.board")) {
			//글 보기(상세보기)
			service = new ContentServiceImpl();
			service.execute(request, response);
			RequestDispatcher dp = request.getRequestDispatcher("board_content.jsp"); 
			dp.forward(request, response);
			
		}else if(command.equals("/board/modify.board")) {
			//글 수정 뷰를 제공합니다. (수정화면 요청)
			service = new ContentServiceImpl();
			service.execute(request, response);
			RequestDispatcher dp = request.getRequestDispatcher("board_modify.jsp"); 
			dp.forward(request, response);
		
		}else if(command.equals("/board/update.board")) {
			/*1. UpdateServiceImpl 을 생성
			 *2. 서비스 영역에서 num, title, content 를 받아서, Update()메서드를 실행 
			 *3. DAO의 업데이트 메소드에서 update구문으로 데이터를 수정해준다.
			 *4. 페이지이동을 상세보기 화면으로 연결(이때 필요한 값을 전달해야한다.)
			 *   
			 * */
			service = new UpdateServiceImpl();
			service.execute(request, response);
			String num = request.getParameter("num");
			response.sendRedirect("content.board?num=" + num); //다시 컨트롤러로 보내준다.
			
		}else if(command.equals("/board/delete.board")) {
			/*1. deleteServiceImpl을 생성
			 *2. 서비스 영역에는 num을 받아서 delete()메서드를 실행
			  3. DAO의 delete () 에서는 delete구문으로 삭제
			  
			 *4. 페이지 이동은 목록으로 처리  
			 *	 추가) board_modify.jsp에서 사제를 자바스크립트를 이용하여
			 *	확인하는 펑션 이용
			 *	
			 *  sql = "delete from board where num=?";
			 *5. 
			 */
				service = new DeleteServiceImpl();
				service.execute(request, response);
				
				response.sendRedirect("list.board");
			
		}
	
		}

}
