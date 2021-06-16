package kr.or.ddit.handler.pds;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.AttachVO;
import kr.or.ddit.dto.PdsVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.PdsService;
import kr.or.ddit.utils.MakeFileName;

public class ModifyFormHandler implements Handler {

	private PdsService PdsService;
	public final void setPdsService(PdsService pdsService) {
		PdsService = pdsService;
	}


	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "pds/modify";
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		PdsVO pds = PdsService.getPds(pno);
		List<AttachVO> renamedAttachList = MakeFileName.parseFileNameFromAttaches(pds.getAttachList(), "\\$\\$");
		
		pds.setAttachList(renamedAttachList);
		
		request.setAttribute("pds", pds);
		
		return url;
	}

}
