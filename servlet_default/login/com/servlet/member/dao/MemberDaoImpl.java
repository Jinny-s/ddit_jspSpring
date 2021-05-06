package com.servlet.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.member.vo.MemberVO;

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
	public int checkMemId(SqlMapClient smc, String memId) throws SQLException {
		return (int) smc.queryForObject("member.checkMemId", memId);
	}

	@Override
	public MemberVO checkMemPw(SqlMapClient smc, MemberVO mv) throws SQLException {
		return (MemberVO) smc.queryForObject("member.checkMemPw", mv);
	}

	@Override
	public MemberVO getMem(SqlMapClient smc, String memId) throws SQLException {
		return (MemberVO) smc.queryForObject("member.getMem", memId);
	}

	@Override
	public List<MemberVO> getMemList(SqlMapClient smc) throws SQLException {
		List<MemberVO> list = smc.queryForList("member.getMemList");
		return list;
	}
	
}
