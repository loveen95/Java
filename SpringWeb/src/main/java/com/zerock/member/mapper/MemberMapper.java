package com.zerock.member.mapper;

import javax.servlet.http.HttpSession;

import com.zerock.member.command.MemberVO;

public interface MemberMapper {
	
	public int join(MemberVO vo); //회원가입
	public int login(MemberVO vo); //로그인 처리
	public void logout(HttpSession session);
}
