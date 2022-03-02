package com.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.member.command.MemberVO;
import com.zerock.member.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	//테이블 생성(Id, pw , name, 날짜)
	/*create table member (
	id varchar(30) primary key,
	pw varchar(30) not null, 
	name varchar(30) not null,
	regdate timestamp default now();

);
*/
	@Autowired
	private MemberService member;
	
	//로그인 화면 처리
	@RequestMapping("/login")
	public String login() {
		return "member/login";	
	}
	//회원가입 화면 처리
	@RequestMapping("/join")
	public String join() {
		return "member/join";
		
  }
	//회원가입 처리
	@RequestMapping("/joinForm")      
	public String joinForm(MemberVO vo, RedirectAttributes RA) {
		
		//service로 join작업을 처리해야함.
		int result = member.join(vo);
		if(result==1) { //1반환받았다는것은 insert성공
			RA.addFlashAttribute("msg","회원가입에 성공했습니다.");
			
		}else {
			RA.addFlashAttribute("msg","회원가입에 실패했씁니다.");
		}
		return "redirect:/member/join_result"; 
	}
	//가입완료 처리 화면
	@RequestMapping("/join_result")       
	public String join_result() {
		return "member/login"; 
	}
	//로그인 폼 처리 - 인증 처리, 세션 처리, 성공?"/" 실패?"login"
	@RequestMapping("/loginForm")
	public String loginForm(MemberVO vo, HttpSession session,RedirectAttributes RA) {
		int result = member.login(vo);
		
		if(result==1) { //1개의 카운트나왔다는 것으로 로그인 성공
			session.setAttribute("user_id", vo.getId()); //세션에 아이디를 저장	
			return "redirect:/" ; //홈 컨트롤러의 매핑으로 이동
		}else {
			RA.addFlashAttribute("msg","아이디, 비밀번호를 확인하세요!");
			return "redirect:/member/login";
		}

	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
		
	}
	       
	
}