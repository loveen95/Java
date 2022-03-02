package com.zerock.member.service;

import javax.servlet.http.HttpSession;

import com.zerock.member.command.MemberVO;

public interface MemberService {
	
	public int join(MemberVO vo); //회원가입
	public int login(MemberVO vo); //회원 로그온 처리
	public void logout(HttpSession session); 
    
}
