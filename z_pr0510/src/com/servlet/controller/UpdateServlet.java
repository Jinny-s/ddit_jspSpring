package com.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dto.MemberVO;
import com.servlet.service.IMemberService;
import com.servlet.service.MemberServiceImpl;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/update.jsp");
		
		IMemberService service = MemberServiceImpl.getInstance();
		String memId = (String) request.getParameter("memId");
		MemberVO mv = service.selectMemberByID(memId);
		request.setAttribute("mv", mv);
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO mv = new MemberVO();
		IMemberService service = MemberServiceImpl.getInstance();
		mv.setMemId(request.getParameter("memId"));
		mv.setMemPw(request.getParameter("memPw"));
		mv.setMemEmail(request.getParameter("memEmail"));
		mv.setMemHp(request.getParameter("memHp"));
		
		int cnt = service.updateMember(mv);

		if(cnt > 0) {
			request.setAttribute("msg", "수정이 완료되었습니다.");
		} else {
			request.setAttribute("msg", "수정이 실패하였습니다.");
		}
		
		request.setAttribute("url", request.getContextPath() + "/list");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/save.jsp");
		rd.forward(request, response);
	}

}
