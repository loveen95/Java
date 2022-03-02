package com.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/session/*")
public class SessionController {
	//세션 연습
	//1. main 화면 처리(mainPage)
	@RequestMapping("/mainPage")
	public String mainPage() {
		return "session/mainPage";
	}
	
	//2.로그인 -> loginPage
	@RequestMapping("loginPage")
	public String loginPage() {
		return "session/loginPage";
	}
	
    //3.마이페이지 처리 ->myPage
	@RequestMapping(value="/myPage", method=RequestMethod.GET)
	public String myPage(HttpSession session) {
		//8.마이페이지 접근 막기
//	  if(session.getAttribute("user_id")==null) {
//		  return "redirect:/session/loginPage";
//	  } ==>인터셉터 설정시 주석으로 처리
		return "session/myPage";
	}
	
	//4. 정보 수정 페이지
	@RequestMapping(value="/updatePage", method=RequestMethod.GET)
	public String updatePage() {	
		//9. 세션 아이디 없을 경우 접근 차단 ...와 같이 모든 페이지에 이렇게 하면 불편함이 생길수 있다. 
		//쉽게 하기 위해서 인터셉터를 사용...
		//인터셉터의 용도 및 예시
		// - 세부적인 보안 및 인증/인가 공통작업
		// - API 호출에 대한 로깅 또는 검사
		// - Controller로 넘겨주는 정보(데이터)의 가공 
		return "session/updatePage";
	}
	//5. 로그인 폼 처리(login 정보 처리)
	@RequestMapping("/sessionLogin")
	public String sessionLogin(@RequestParam("id")String id,
			@RequestParam("pw")String pw, 
		HttpSession session,
		RedirectAttributes RA) {
			//아이디가abc,비밀번호가 1234라면 로그인 성공이라 가정
		if(id.equals("abc") && pw.equals("1234")) {
			//로그인 성공 
			session.setAttribute("user_id", id);//세션에 아이디 저장
			session.setAttribute("user_name", "홍길동");
			return "redirect:/session/myPage";
		}else {
			//6.아이디와 비밀번호가 틀렸을 경우 다시 로그인으로 보내기
			
			//9. 리다렉트를 보내면서 1회성 데이터로 파라미터 값을 전달하고자 할 때 사용
			RA.addFlashAttribute("msg", "아디와 비밀번호를 확인하실래요?");
			return "redirect:/session/loginPage";
			
			
		}
	}
	//7.로그아웃 처리
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_id");//특정 세션 제거
		session.invalidate();//세션 전체 삭제
		return "redirect:/session/mainPage";
	}
		
}
	

