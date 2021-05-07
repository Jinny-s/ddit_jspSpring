package com.servlet.member.service;

import java.util.List;

import com.servlet.member.vo.MemberVO;

public interface IMemberService {
	
	public int insertMember(MemberVO mv);
	
	public int updateMember(MemberVO mv);
	
	public int deleteMember(String memId);
	
	public int checkMemId(String memId);
	
	public MemberVO checkMemPw(MemberVO mv);
	
	public MemberVO getMem(String memId);
	
	public List<MemberVO> getMemList();
	
}
