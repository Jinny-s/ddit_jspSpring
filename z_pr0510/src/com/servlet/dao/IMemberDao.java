package com.servlet.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.dto.MemberVO;

public interface IMemberDao {
	
	public int insertMember(SqlMapClient smc, MemberVO mv) throws SQLException;
	
	public int updateMember(SqlMapClient smc, MemberVO mv) throws SQLException;
	
	public int deleteMember(SqlMapClient smc, String memId) throws SQLException;
	
	public MemberVO selectMemberByID(SqlMapClient smc, String memId) throws SQLException;
	
	public List<MemberVO> selectMemberList(SqlMapClient smc) throws SQLException;
}
