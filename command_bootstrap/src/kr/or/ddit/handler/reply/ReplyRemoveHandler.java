package kr.or.ddit.handler.reply;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.ReplyModifyCommand;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.ReplyVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ReplyService;

public class ReplyRemoveHandler implements Handler {
	
	private ReplyService replyService;
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		
		int rno = Integer.parseInt((String)request.getParameter("rno"));
		int bno = Integer.parseInt((String)request.getParameter("bno"));
		int page = Integer.parseInt((String)request.getParameter("page"));
		
		try {
			replyService.removeReply(rno);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(new SearchCriteria());
			pageMaker.setTotalCount(replyService.getReplyListCount(bno));
			
			int realEndPage = pageMaker.getRealEndPage();
			
			if(page>realEndPage) {page=realEndPage;}
			
			PrintWriter out = response.getWriter();
			out.print(page);
			out.close();

		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		} 
		
		return url;
	}

}
