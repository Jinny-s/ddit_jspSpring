package com.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.membership.MemberImpl;

import com.servlet.dto.MemberVO;
import com.servlet.service.IMemberService;
import com.servlet.service.MemberServiceImpl;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/signup.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO mv = new MemberVO();
		IMemberService service = MemberServiceImpl.getInstance();
		mv.setMemId(request.getParameter("memId"));
		mv.setMemPw(request.getParameter("memPw"));
		mv.setMemEmail(request.getParameter("memEmail"));
		mv.setMemHp(request.getParameter("memHp"));
		
		int cnt = service.insertMember(mv);

		if(cnt > 0) {
			request.setAttribute("msg", "회원가입이 완료되었습니다.");
		} else {
			request.setAttribute("msg", "회원가입이 실패하였습니다.");
		}
		
		request.setAttribute("url", request.getContextPath() + "/signin");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/save.jsp");
		rd.forward(request, response);
	}

}
