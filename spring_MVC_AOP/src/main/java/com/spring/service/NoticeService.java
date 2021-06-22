package com.spring.service;

import java.sql.SQLException;
import java.util.Map;

import com.spring.command.SearchCriteria;
import com.spring.dto.NoticeVO;

public interface NoticeService {

	// 게시글 리스트 조회
	Map<String, Object> getNoticeList(SearchCriteria cri) throws SQLException;
	
	// 게시글 조회
	NoticeVO getNotice(int nno) throws SQLException;
	
	// 수정화면 상세
	NoticeVO getNoticeForModify(int nno) throws SQLException;
	
	// 공지등록
	void regist(NoticeVO notice) throws SQLException;
	
	// 공지수정
	void modify(NoticeVO notice) throws SQLException;
	
	// 공지삭제
	void remove(int nno) throws SQLException;
	
}
