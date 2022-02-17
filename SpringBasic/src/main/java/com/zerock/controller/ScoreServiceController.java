package com.zerock.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.command.ScoreVO;
import com.zerock.service.ScoreService;
import com.zerock.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service/*")
public class ScoreServiceController {
	//1. 객체 생성
	//ScoreService scoreService = new ScoreServiceImpl();
	
	//2. 설정에 bean 등록후에 scoreService scoreService 주입 설정
	
	  //@Resource(name="scoreService")
	  //ScoreService scoreService; 
	
	//3. 어노테이션 을 이용한 빈 생성 및 자동 주입 설정 (@/Service로 주입)
	  @Autowired
	  ScoreService scoreService; //service패키지에 컴포넌트 스캔 걸어야함.
	
	
	//화면처리 - 점수 등록 화면으로
	@RequestMapping("/1scoreRegister")
	public String score() {
		return "service/1scoreRegister";
		
		
	}
	//점수 등록 메서드
	@RequestMapping("scoreForm")
	public String scoreForm(ScoreVO vo) {
		scoreService.ScoreSRegister(vo);
		return "service/2scoreResult";// 뷰 리졸버를 통해서 강제 이동 ...
	}
	//점수 리스트
		@RequestMapping("/3scoreList")
		public String scoreList(Model model) {
			
			//결과 반환 메서드
			//메서드의 파라미터에 Model을 추가하여 , model에 리스트를 실어줌(화면에서 사용 가능하게)
			ArrayList<ScoreVO> scoreList = scoreService.scoreResult();
			model.addAttribute("scoreList" ,scoreList);
			
			return "service/3scoreList";
		}
		//점수 삭제....
		@RequestMapping("/scoreDelete")
		public String scoreDelete(@RequestParam("num")String num) {
			
			//점수 삭제 
		    scoreService.scoreDelete(num);
		    //return "service/3scoreList";를 사용하게 되면 list값을 가져 갈수 없다. ->뷰로 간다.
		    //redirect를 통해서 다시 처리 해준다. -->다시 컨트롤러로 가서 탈수 있게 강제 이동하라!!!!
		    
			return "redirect:/service/3scoreList";
		}
		
			
	
	
}
