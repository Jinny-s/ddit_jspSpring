package com.servlet.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.SqlMapClientUtil;
import com.servlet.dao.IMemberDao;
import com.servlet.dao.MemberDaoImpl;
import com.servlet.dto.MemberVO;
import com.servlet.exception.ExistIdException;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;

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
	public MemberVO checkMember(String memId) throws ExistIdException, SQLException{
		MemberVO member = null;
		try {
			member = memDao.selectMemberByID(smc, memId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		if(member != null) {
			throw new ExistIdException();
		} else {
			return member;
		}
	}
	
	@Override
	public int insertMember(MemberVO mv){
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
	public MemberVO login(String memId, String memPw) throws NotFoundIDException, InvalidPasswordException, SQLException {
		MemberVO member = null;
		try {
			member= memDao.selectMemberByID(smc, memId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		if(member != null) {
			if(memPw.equals(member.getMemPw())) {
				return member;
			} else {
				throw new InvalidPasswordException();
			}
		} else {
			throw new NotFoundIDException();
		}
	}
	
	@Override
	public MemberVO selectMemberByID(String memId) {
		MemberVO memVO = null;
		try {
			memVO = memDao.selectMemberByID(smc, memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memVO;
	}

	@Override
	public List<MemberVO> selectMemberList() {
		List<MemberVO> list = new ArrayList<>();
		try {
			list = memDao.selectMemberList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
