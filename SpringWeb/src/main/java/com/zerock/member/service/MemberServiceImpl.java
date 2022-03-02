package com.zerock.member.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerock.member.command.MemberVO;
import com.zerock.member.mapper.MemberMapper;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired      //mybatis 매퍼를 추가
	private MemberMapper mapper;
	
	@Override
	public int join(MemberVO vo) {
		
		int result = mapper.join(vo);
		 System.out.println("성공실패?" +result);
		return result;
		
	}
	@Override
	public int login(MemberVO vo) {
		int result = mapper.login(vo);
		return result;
	}
	@Override
	public void logout(HttpSession session) {
		mapper.logout(session);
		
	}
	
}
