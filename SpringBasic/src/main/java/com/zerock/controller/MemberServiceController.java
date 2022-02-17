package com.zerock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.command.MemberVO;
import com.zerock.service.MemberService;

@Controller
@RequestMapping("/service/*")
public class MemberServiceController {
	
	@Autowired		// 인터페이스로 지정
	MemberService memberService;
	
	
	//화면처리(회원가입)
	@RequestMapping("/member_ex00")
	public String member_ex00() {
		return "service/member_ex00";
	}
	
	//회원가입 처리 메서드
	@RequestMapping("/join")
	public String join(MemberVO vo) {
		memberService.insertMember(vo);
		return "service/member_ex02";
	}
	
	//화면처리(로그인)
	@RequestMapping("/member_ex03")
	public String member_ex03() {
		return "service/member_ex03";
	}
		
	//로그인 처리 메서드
	@RequestMapping("/login")
	public ModelAndView login(MemberVO vo, Model model, RedirectAttributes RA) {
		
		//로그인 유효성 검사 - 서비스로 아이디를 전달
		int result = memberService.memberCheck(vo);
		ModelAndView mav = new ModelAndView();
		
		if (result == 1) {
			//model.addAttribute("memberInfo", vo);
			mav.setViewName("service/member_mypage");
			
			mav.addObject("memberInfo",vo);
			return mav;
		} else {
			mav.setViewName("redirect:/service/member_ex03");
			
			//모델앤뷰 리다이렉트시에 모델앤뷰는 값을 addObject한경우에는 오류가 발생한다.
			RA.addFlashAttribute("msg", "아이디 또는 비밀번호 확인해주세요!!");
			return mav;
		
	    }
	}
	
	
	

	//화면처리(로그인-전달값확인)
	@RequestMapping("/member_ex01")
	public String member_ex01() {
		return "service/member_ex01";
	}
	
	//전통적 방식
	@RequestMapping(value="/memlogin", method = RequestMethod.POST)
	public String memlogin(Model model, HttpServletRequest request) {
		
		String memId = request.getParameter("memid");
		String memPw = request.getParameter("mempw");
		
		model.addAttribute("memId", memId);
		model.addAttribute("memPw", memPw);
		
		return "service/result";
	}

	// RequestParam 어노테이션을 이용한 HTTP전송 정보 얻기
	@RequestMapping(value="/memlogin2", method = RequestMethod.POST)
	public String memlogin2(Model model, @RequestParam("memid") String memId, @RequestParam("mempw") String memPw) {	
		
		model.addAttribute("memId", memId);
		model.addAttribute("memPw", memPw);
		
		return "service/result";
	}
	
	// 커맨드를 이용한 HTTP 전송 정보 처리
	@RequestMapping(value="/memlogin3", method = RequestMethod.POST)
	public String memlogin3(Model model, MemberVO vo) {
		
		model.addAttribute("memId", vo.getId());
		model.addAttribute("memPw", vo.getPw());
		System.out.println("id : " + vo.getId() + " pw : " + vo.getPw());
		
		return "service/result";
	}
	
	
	
	
	
	
}
