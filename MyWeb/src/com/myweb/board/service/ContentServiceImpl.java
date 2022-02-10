package com.myweb.board.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class ContentServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	/*1. getContent(num)메서드 생성하고 호출
	 *2. getContent() 메서드에서는 num을 가지고, 게시글에 대한 정보를 vo객체에 담는 코드를 작성합니다.
	 *3. 메서드 리턴 타입은 BoardVO
	 *4. 화면 전송을 위한 리턴값은 vo라는 이름으로 강제 저장처리 합니다.
	 * 
	 * */
		String num = request.getParameter("num");
		
		
		BoardDAO dao = BoardDAO.getInstance();
		
		//쿠키 생성 : 서버에 요청시 자동으로 request에 담겨서 전달됨.
		Cookie[] arr = request.getCookies(); //생성된 쿠키 값을 얻기
		
		//쿠키 검사(판별) 
		boolean bool = true; // 쿠키 값이 없는 경우 
		
		for(Cookie c:arr) {
			if(c.getName().equals("hitNum"+num)) { //쿠키 이름 게시글 번호의 쿠키인지 확인
				bool = false;
				break;
			}
		}
		//조회수 업데이트
		if(bool) { //bool이 true면 클릭한 적이 없다. (쿠키값이없다.)
			dao.upHit(num); //hit 값을 +1 해서 업데이트 하는 메서드
			
		}
	
		BoardVO vo = new BoardVO(); 
		vo = dao.getContent(num);
		
		request.setAttribute("vo", vo);  //request에 강제 저장
		
		//중복 증가를 방지하기 위한 쿠키 생성()  
		
		Cookie hitcoo = new Cookie("hitNum" +num, num); //num게시글 번호
		hitcoo.setMaxAge(60);
	    response.addCookie(hitcoo);

	}

}
