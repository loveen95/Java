package com.zerock.controller;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.board.command.BoardVO;
import com.zerock.board.command.Criteria;
import com.zerock.board.mapper.BoardMapper;

//1) JUnit 4.7 -> 4.12 ,  2) spring-test 설치 : 메이븐을 통해서 설치  

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class PagingTest {
     
	@Autowired
	BoardMapper mapper;  //main/com.zerock.board.mapper

	@Test				//테스트 코드 
	public void pagingTest() {
		
		System.out.println("----pagingTest----");
		
		Criteria cri = new Criteria();
		
		cri.setPageNum(2); // 2번페이지 클릭
		cri.setCount(10); // 10개씩 보기
		
		ArrayList<BoardVO> list = mapper.pagingList(cri);
		
		for(BoardVO vo : list) {
			System.out.println("게시물번호:" + vo.getNum());
		}
		
	}
	
	@Test
	public void ceilTest() {
		
		System.out.println("----ceilTest----");
		
		//올림 함수 Math.ceil(실수)
		System.out.println("ceil확인:" + Math.ceil(2.1));
		
		//5페이지를 보고 있다면 화면에 보여질 패이지 1~10
		//11페이지를 보고 있다면 화면에 보여질 페이지 11~20
		
		//끝 페이지 번호
		//공식 : (int)Math.ceil( 페이지번호 / 10.0) * 10;
		int end = (int)Math.ceil( 5 / 10.0) * 10; 
		System.out.println("5페이지 일때 보여지는 끝번호: " + end);
		
		//시작 페이지 번호
		//공식 : (끝 페이지 - 9);
		int start = end - 9;
		System.out.println("5페이지 일때 보여지는 시작번호:" + start);
		
		//끝 페이지 번호
		int end1 = (int)Math.ceil(12 / 10.0) * 10;
		System.out.println("12페이지 일때 보여지는 끝번호: " + end1);
		//시작 페이지 번호
		int start1 = end1 - 9;
		System.out.println("12페이지 일때 보여지는 시작번호:" + start1);
		
		
		//만약 데이터가 총 게시글 수가 100개 이하라면?
		//총 게시글수 : 81개
		//보여져야 할 페이지 수 = 9 
		//공식 : Math.ceil( 전체 게시글 수 * 1.0 / 보여질 페이지 수)
		int realEnd = (int)Math.ceil( 81 * 1.0 / 10); 
		System.out.println("전체 데이터가 100개 이하일때:" + realEnd);
		
	}

}
