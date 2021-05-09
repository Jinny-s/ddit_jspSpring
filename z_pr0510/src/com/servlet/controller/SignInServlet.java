package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dto.MemberVO;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;
import com.servlet.service.IMemberService;
import com.servlet.service.MemberServiceImpl;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/signin.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");

		MemberVO mv = new MemberVO();
		mv.setMemId(memId);
		mv.setMemPw(memPw);
		IMemberService service = MemberServiceImpl.getInstance();
				
		String msg = "";
		try {
			service.login(memId, memPw);
			request.setAttribute("msg", "로그인이 성공했습니다.");
			request.setAttribute("url", request.getContextPath() + "/main");
		} catch (NotFoundIDException | InvalidPasswordException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("url", request.getContextPath() + "/signin");
		} catch (SQLException e) {
			request.setAttribute("msg", "서버 장애로 인해 불가합니다.");
			request.setAttribute("url", request.getContextPath() + "/main");
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/save.jsp");
		rd.forward(request, response);
	}

}
