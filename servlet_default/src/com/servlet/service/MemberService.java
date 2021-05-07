package com.servlet.service;

import java.sql.SQLException;

import com.servlet.dto.MemberVO;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;

public interface MemberService {

	MemberVO login(String memId, String memPw) throws NotFoundIDException, InvalidPasswordException, SQLException;
	
}
