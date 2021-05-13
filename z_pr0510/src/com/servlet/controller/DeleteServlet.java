package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.service.IMemberService;
import com.servlet.service.MemberServiceImpl;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/view/save.jsp";
		
		IMemberService service = MemberServiceImpl.getInstance();
		int cnt;
		try {
			cnt = service.deleteMember(request.getParameter("memId"));
			if(cnt > 0) {
				request.setAttribute("msg", "회원 삭제가 완료되었습니다.");
			}
		} catch (SQLException e) {
			request.setAttribute("msg", "회원 삭제가 실패하였습니다.");
		}
		
		request.setAttribute("url", request.getContextPath() + "/list");
		request.getRequestDispatcher(view).forward(request, response);
	}
}