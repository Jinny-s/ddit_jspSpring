package com.servlet.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.member.vo.MemberVO;

public interface IMemberDao {
	
	public int insertMember(SqlMapClient smc, MemberVO mv) throws SQLException;
	
	public int updateMember(SqlMapClient smc, MemberVO mv) throws SQLException;
	
	public int deleteMember(SqlMapClient smc, String memId) throws SQLException;
	
	public int checkMemId(SqlMapClient smc, String memId) throws SQLException;
	
	public MemberVO checkMemPw(SqlMapClient smc, MemberVO mv) throws SQLException;
	
	public MemberVO getMem(SqlMapClient smc, String memId) throws SQLException;
	
	public List<MemberVO> getMemList(SqlMapClient smc) throws SQLException;
}
