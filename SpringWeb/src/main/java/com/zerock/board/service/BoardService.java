package com.zerock.board.service;

import java.util.ArrayList;

import com.zerock.board.command.BoardVO;
import com.zerock.board.command.Criteria;

public interface BoardService {
	
//	public ArrayList<BoardVO> getList(); //게시판 리스트 가져오는 메서드
	public ArrayList<BoardVO> getList(Criteria cri); //페이징 처리 리스트 가져오기 
	//리스트를 가지고 올때 끊어서 가져와야 하기 때문에 creiteria 를 불러온다.
	public int getTotal();//전체 게시물 수  
	
	public void register (BoardVO vo); //게시물 등록 메서드
	public BoardVO getContent(int num); //게시물 상세보기 \메서드 (반환유형 생각)
	public void update(BoardVO vo); //게시물 수정 완료 버튼
	public void delete(int num); //게시물 삭제

	
	
	

}
