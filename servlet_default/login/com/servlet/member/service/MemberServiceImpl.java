package com.servlet.member.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.member.SqlMapClientUtil;
import com.servlet.member.dao.IMemberDao;
import com.servlet.member.dao.MemberDaoImpl;
import com.servlet.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {

	private IMemberDao memDao;
	private SqlMapClient smc;
	
	private static IMemberService memService;
	
	private MemberServiceImpl() {
		memDao = MemberDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(memService == null) {
			memService = new MemberServiceImpl();
		}
		return memService;
	}
	
	@Override
	public int insertMember(MemberVO mv) {
		int cnt = 0;
		try {
			cnt = memDao.insertMember(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) {
		int cnt = 0;
		try {
			cnt = memDao.updateMember(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			cnt = memDao.deleteMember(smc, memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int checkMemId(String memId) {
		int cnt = 0;
		try {
			cnt = memDao.checkMemId(smc, memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public MemberVO checkMemPw(MemberVO mv) {
		MemberVO memVO = null;
		try {
			memVO = memDao.checkMemPw(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memVO;
	}

	@Override
	public MemberVO getMem(String memId) {
		MemberVO memVO = null;
		try {
			memVO = memDao.getMem(smc, memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memVO;
	}

	@Override
	public List<MemberVO> getMemList() {
		List<MemberVO> list = new ArrayList<>();
		try {
			list = memDao.getMemList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
