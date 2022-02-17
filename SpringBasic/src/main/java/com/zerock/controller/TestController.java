package com.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/*")
public class TestController {
/*
	@RequestMapping(value="/req_ex01")
	public void req_ex01() {
		// @RequestMapping으로 지정된 /test/req_ex01로 전달 (view로 전달)
		// 반환값이 없기 때문에 메서드가 실행되면 바로 경로(컨트롤러 매핑값 포함)로 이동함 - sendRedirect와 비슷한 기능
		System.out.println("void 메서드의 페이지 이동");
	}
	}
*/	
	
  // return값에 경로 정보를 넣어야 함 ( prefix에 /가 붙어있기 때문에 앞의 /는 생략! )
	@RequestMapping(value="/req_ex01")
	public String req_ex01() {		
		return "test/req_ex01";
	}
	
	@RequestMapping(value="/test")	// http://localhost:8080/test/test로 접속 시 /test/req_ex01로 전환
	public String req_ex00() {		
		System.out.println("redirect 처리");
		return "redirect:req_ex01"; 
	}
	
}
