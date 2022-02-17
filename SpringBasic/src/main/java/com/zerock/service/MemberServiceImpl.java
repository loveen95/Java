package com.zerock.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zerock.command.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	ArrayList<MemberVO> memberList = new ArrayList<>(); // 회원 정보 저장소 생성
	
	// 회원 가입 처리
	@Override
	public void insertMember(MemberVO vo) {
		memberList.add(vo);
	}
	
	// 로그인 유효성 검사 (회원 확인)
	@Override
	public int memberCheck(MemberVO vo) {
		int result = 0;
		
		for (MemberVO dbvo : memberList) {
			System.out.println(vo.getId());
			if(dbvo.getId().equals(vo.getId())) {
				String dbpw = dbvo.getPw();
				String pw = vo.getPw();
				
				if (dbpw.equals(pw)) {
					result = 1;
				}
			}
		}
		return result;
	}

}
