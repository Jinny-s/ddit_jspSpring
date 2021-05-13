package com.servlet.service;

import java.sql.SQLException;
import java.util.List;

import com.servlet.dto.MemberVO;
import com.servlet.exception.ExistIdException;


public interface IMemberService {
	
	public MemberVO checkMember(String memId) throws ExistIdException, SQLException;
	
	public int insertMember(MemberVO mv);
	
	public int updateMember(MemberVO mv) throws SQLException;
	
	public int deleteMember(String memId) throws SQLException;
	
	public MemberVO selectMemberByID(String memId);
	
	public List<MemberVO> selectMemberList();
	
}
