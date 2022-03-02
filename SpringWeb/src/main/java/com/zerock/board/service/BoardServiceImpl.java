package com.zerock.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerock.board.command.BoardVO;
import com.zerock.board.command.Criteria;
import com.zerock.board.mapper.BoardMapper;


//service 
//스프링에서는 DiapatcherServlet 이 동작하고, 핸들러 어댑터가 가동되면, 해당 어노테이션을 확인
//빈으로 등록 생성. 
//수동으로 빈 등록을 하지 않았으면, 어노테이션을 사용했다면 servlet-context.xml에다가 컴포넌트 스캔을 처리한다.

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper mapper;
	
	boolean bool;
   //게시글 리스
//	@Override
//	public ArrayList<BoardVO> getList() {
//		
//		ArrayList<BoardVO> list = mapper.getList();
//	
//		return list;
//	}

	//페이징 게시글 리스트 
	@Override
	public ArrayList<BoardVO> getList(Criteria cri ){
		//cri 값을 전달하여 받아 처리하는 DAO를 통해서 구현
		ArrayList<BoardVO> list = mapper.pagingList(cri);
		
		return list; 
	}
	//전체 게시물 수
	@Override
	public int getTotal() {
		int total = mapper.getTotal();
		return total;
	}
	
	@Override
	public void register(BoardVO vo) {
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		System.out.println(vo.getWriter());
		mapper.insertBoard(vo);
		
	}

	@Override
	public BoardVO getContent(int num) {
		//mybatis 의 맵퍼를 확인
		BoardVO vo = mapper.getContent(num);
		System.out.println("============service 계층================");
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		System.out.println(vo.getWriter());
		return vo;
	}

	@Override
	public void update(BoardVO vo) {
	
		bool = mapper.updateBoard(vo);
		System.out.println("성공 실패? : " + bool);
		
	}

	@Override
	public void delete(int num) {
		
		mapper.delete(num);
		
	}

}
