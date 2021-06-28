package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.LoginUserLogVO;

public interface LoginUserLogService {
	
	public void write(List<LoginUserLogVO> logList) throws Exception;
	
}
