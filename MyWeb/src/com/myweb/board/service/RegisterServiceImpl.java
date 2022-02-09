package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;

public class RegisterServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//폼에서 전달된 값을 처리할수 있다.
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		//dao객체 생성
		//resist 메서드 호출
		BoardDAO dao = BoardDAO.getInstance();
		
		int result = dao.regist(writer, title, content);
		
		if(result == 1) {
			System.out.println("게시글이 등록되었습니다.");
			
		}else {
			System.out.println("게시글 등록에 실패했습니다.");
			
		
		}
	}

}
