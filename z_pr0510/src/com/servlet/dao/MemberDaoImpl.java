package com.servlet.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.dto.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	
	private static IMemberDao memDao;
	
	private MemberDaoImpl() {
	}
	
	public static IMemberDao getInstance() {
		if(memDao == null) {
			memDao = new MemberDaoImpl();
		}
		return memDao;
	}

	@Override
	public int insertMember(SqlMapClient smc, MemberVO mv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("member.insertMember", mv);
		
		if(obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int updateMember(SqlMapClient smc, MemberVO mv) throws SQLException {
		return (int) smc.update("member.updateMember", mv);
	}

	@Override
	public int deleteMember(SqlMapClient smc, String memId) throws SQLException {
		return (int) smc.delete("member.deleteMember", memId);
	}

	@Override
	public MemberVO selectMemberByID(SqlMapClient smc, String memId) throws SQLException {
		return (MemberVO) smc.queryForObject("member.selectMemberByID", memId);
	}

	@Override
	public List<MemberVO> selectMemberList(SqlMapClient smc) throws SQLException {
		List<MemberVO> list = smc.queryForList("member.selectMemberList");
		return list;
	}
	
}
