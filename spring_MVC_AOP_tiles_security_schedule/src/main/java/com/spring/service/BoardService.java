package com.spring.service;

import java.sql.SQLException;
import java.util.Map;

import com.spring.command.SearchCriteria;
import com.spring.dto.BoardVO;

public interface BoardService {

	// 목록 조회
	Map<String, Object> getBoardList(SearchCriteria cri) throws SQLException;
	
	// 게시글 조회
	BoardVO getBoard(int bno) throws SQLException;
	
	// 수정화면 상세
	BoardVO getBoardForModify(int bno) throws SQLException;
	
	// 등록
	void regist(BoardVO board) throws SQLException;
	
	// 수정
	void modify(BoardVO board) throws SQLException;
	
	// 삭제
	void remove(int bno) throws SQLException;
	
	
	BoardVO findFileInContent(String fileName) throws SQLException;
	
}
