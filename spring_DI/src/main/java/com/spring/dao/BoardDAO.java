package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.command.SearchCriteria;
import com.spring.dto.BoardVO;

public interface BoardDAO {
	
	// 목록 조회
	List<BoardVO> selectSearchBoardList(SearchCriteria cri) throws SQLException;
	
	// 목록 개수
	int selectSearchBoardListCount(SearchCriteria cri) throws SQLException;
	
	// 게시글 조회
	BoardVO selectBoardByBno(int bno) throws SQLException;
	
	// 시퀀스 가져오기
	int selectBoardSequenceNextValue() throws SQLException;

	// 조회수 증가
	void increaseViewCount(int bno) throws SQLException;
	
	// 작성
	public void insertBoard(BoardVO board) throws SQLException;
	
	// 수정
	public void updateBoard(BoardVO board) throws SQLException;
	
	// 삭제
	public void deleteBoard(int bno) throws SQLException;
	
}
