package com.zerock.service;

import com.zerock.command.MemberVO;

public interface MemberService {
	
	public void insertMember(MemberVO vo);
	public int memberCheck(MemberVO vo);
}
