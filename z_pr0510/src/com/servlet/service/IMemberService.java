package com.servlet.service;

import java.sql.SQLException;
import java.util.List;

import com.servlet.dto.MemberVO;
import com.servlet.exception.ExistIdException;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;


public interface IMemberService {
	
	public MemberVO checkMember(String memId) throws ExistIdException, SQLException;
	
	public int insertMember(MemberVO mv);
	
	public int updateMember(MemberVO mv);
	
	public int deleteMember(String memId);
	
	public MemberVO login(String memId, String memPw) throws NotFoundIDException, InvalidPasswordException, SQLException;
	
	public MemberVO selectMemberByID(String memId);
	
	public List<MemberVO> selectMemberList();
	
}
