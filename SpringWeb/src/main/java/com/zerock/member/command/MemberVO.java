package com.zerock.member.command;

import java.sql.Timestamp;

public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private Timestamp regdate;
	public MemberVO(String id, String pw, String name, Timestamp regdate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.regdate = regdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	

}