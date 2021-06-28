package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.command.SearchCriteria;
import com.spring.dto.NoticeVO;

public interface NoticeDAO {
	
	// 게시글리스트 조회
	List<NoticeVO> selectSearchNoticeList(SearchCriteria cri) throws SQLException;
	
	// 검색 결과의 전체 리스트 개수
	int selectSearchNoticeListCount(SearchCriteria cri) throws SQLException;
	
	// 게시글 조회
	NoticeVO selectNoticeByNno(int nno) throws SQLException;
	
	// viewcnt 증가
	void increaseViewCount(int nno) throws SQLException;
	
	// Notice_seq.nextVal 가져오기
	int selectNoticeSequenceNextValue() throws SQLException;
	
	// 공지 작성
	public void insertNotice(NoticeVO notice) throws SQLException;
	
	// 공지 수정
	public void updateNotice(NoticeVO notice) throws SQLException;
	
	// 공지 삭제
	public void deleteNotice(int nno) throws SQLException;
	
	
	
	NoticeVO selectNoticeByFileName(String fileName) throws SQLException;
}