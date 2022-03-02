package com.zerock.controller;

import java.lang.reflect.Member;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zerock.board.command.BoardVO;
import com.zerock.board.command.Criteria;
import com.zerock.board.command.PageVO;
import com.zerock.board.service.BoardService;

@Controller
@RequestMapping("/board/*")  //보드로 들어오는 모든 url은 보드컨트롤러를 거친다.
public class BoardController {

	@Autowired
	private BoardService service;
	
	
	//1. Controller 구현  view
	//2. 테이블 생성(더미 데이터 작업) 
	//3. DB관련 설정테스트 (root-context.xml 작업후 테스트)
	//4. BoardVO 생성(DB의 컬럼명으로 동일하게 생성)
	//5. Service 구현 
	//6. DAO를 구현 (hikari 사용)
	//7. JDBCTemplate 구현

	
	//get방식
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model,Criteria cri) {  //페이징 작업...... 
		
		model.addAttribute("cri", cri);	
		
		System.out.println("등록 화면처리");
		
         
		System.out.println("페이지 번호" + cri.getPageNum()+"카운트 값:" +cri.getCount());
		System.out.println("pageNum" + model);
		
		
		return "board/register";
	}
	
	//post 방식으로 등록 처리
	@RequestMapping(value="/boardForm",method=RequestMethod.POST)
	public String register(BoardVO vo) {
		System.out.println("등록처리");
		
		//서비스 처리
		service.register(vo);
		
		return "redirect:/board/list";
	}
//	@RequestMapping(value="/list")
//	public String list(Model model){
//		//1.list 에 요청이 들어오면 DB에서 모든 값을 가지고 화면으로 이동해야한다.
//		ArrayList<BoardVO> list = service.getList();
//	
//		model.addAttribute("board_list", list);
//		//컨트롤러에 메서드의 리턴값을 추가하고 싶다면, 
//		//1.model 객체를 추가
//		//2. return 유형을 ModelAndView객체를 추가한다.
//		
//		return "board/list";		
//	}
	
	
	//페이징 화면 처리
	
	@RequestMapping("/list")
	public String list(Model model, Criteria cri) {
		//게시글 정보 가져 오기(Criteria를 기준 설정)
		ArrayList<BoardVO> list =service.getList(cri);
		
		model.addAttribute("board_list", list );
		
		//게시글 전체 데이터를 가져오기
		int total = service.getTotal();
		//pageVO(페이징 기준, 전체 게시글 갯수) 전달하면 , pageVO에서는 페이징에 따른 계산을 모두 끝냄 
		model.addAttribute("pageMarker", new PageVO(total, cri));
		
		
		System.out.println(total);
		return "board/list";
		
	}

	
	//상세보기 처리
	@RequestMapping("/viewContent")
	public String content(@RequestParam("num")int num, Model model,
			@ModelAttribute("cri") Criteria cri) { //8. paging에서 추가함.(이후content.jsp변경)
		
//		System.out.println("============controller계층=========");
//		System.out.println(num);
		
		
		BoardVO vo = service.getContent(num);
		model.addAttribute("board",vo);
		return "board/content";
		
	}
	//수정 페이지 처리
	@RequestMapping("/viewModify")
	public String modify(@RequestParam("num")int num, Model model,
			@ModelAttribute("cri") Criteria cri) {
		
		BoardVO vo = service.getContent(num);
		model.addAttribute("board_modify",vo);
	    
		return "board/modify";
	}
	

	//게시판 수정 완료 버튼

	@RequestMapping("/update")
	public String update(BoardVO vo,Model model) {
		System.out.println(vo.getNum());
		System.out.println(vo.getNum());
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		service.update(vo);
		model.addAttribute("board", vo);
		
		//서비스 계층에 전달받은 폼값을 전달하는 updateVO 를 생성하세요.
		// update ()메서드 안에서 mybatis 로 연결하는 BoardUpdate(VO)메서드를 생성하세요.
		//동작하여 업데이트 진행하세요.
		return "board/content";
		
		
	}
	//게시판 삭제 완료 처리
	@RequestMapping("/boardDelete")
	public String delete(@RequestParam("num") String num) {
		 System.out.println(num);
		 service.delete(Integer.parseInt(num));
		
		 return "redirect:/board/list";
		
	}
	

}
