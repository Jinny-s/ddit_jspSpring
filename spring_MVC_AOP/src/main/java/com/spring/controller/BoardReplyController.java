package com.spring.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.command.PageMaker;
import com.spring.command.ReplyModifyCommand;
import com.spring.command.ReplyRegistCommand;
import com.spring.command.SearchCriteria;
import com.spring.dto.ReplyVO;
import com.spring.service.ReplyService;

/**
 *  url : /replies
 *  
 *  bno번 게시글의 페이징 처리된 댓글 목록
 *  /replies/{bno}/{page}			page list : GET방식
 *  
 *  /replies/{rno}					modify : PUT, PATCH방식, rno 댓글의 수정
 *  /replies/{bno}/{rno}/{page}		remove : DELETE 방식, rno 댓글의 삭제
 *  /replies						regist : POST 방식, 댓글 입력
 */

@RestController
@RequestMapping("/replies")
public class BoardReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value="/{bno}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> replyList(@PathVariable("bno") int bno, @PathVariable("page")int page) throws Exception {
		ResponseEntity<Map<String, Object>> entity = null;
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(page);
		
		try {
			Map<String, Object> dataMap = replyService.getReplyList(bno, cri);
			entity = new ResponseEntity<Map<String,Object>>(dataMap,HttpStatus.OK);
		} catch (SQLException e) {
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyRegistCommand registReq) throws Exception {
		ResponseEntity<String> entity = null;
		
		ReplyVO reply = registReq.toReplyVO();
		try {
			replyService.registReply(reply);
			
			SearchCriteria cri = new SearchCriteria();
			
			Map<String, Object> dataMap = replyService.getReplyList(reply.getBno(), cri);
			PageMaker pageMaker = (PageMaker) dataMap.get("pageMaker");
			int realEndPage = pageMaker.getRealEndPage();
			
			entity = new ResponseEntity<String>(realEndPage+"",HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
	
	@RequestMapping(value="/{rno}", method= {RequestMethod.PUT,RequestMethod.PATCH})
	public ResponseEntity<String> modify(@PathVariable("rno") int rno,@RequestBody ReplyModifyCommand modifyReq) throws Exception {
		ResponseEntity<String> entity = null;

		ReplyVO reply = modifyReq.toReplyVO();
		reply.setRno(rno);
		
		try {
			replyService.modifyReply(reply);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
	
	@RequestMapping(value="/{bno}/{rno}/{page}", method=RequestMethod.DELETE) 
	public ResponseEntity<String> remove(@PathVariable("rno")int rno, @PathVariable("bno")int bno, @PathVariable("page")int page) throws Exception {
		ResponseEntity<String> entity = null;
		
		try {
			replyService.removeReply(rno);
			
			SearchCriteria cri = new SearchCriteria();
			
			Map<String, Object> dataMap = replyService.getReplyList(bno, cri);
			PageMaker pageMaker = (PageMaker) dataMap.get("pageMaker");
			
			int realEndPage = pageMaker.getRealEndPage();
			if(page>realEndPage) {page=realEndPage;}
			
			entity = new ResponseEntity<String>(""+page,HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
}
