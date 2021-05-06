package com.servlet.member.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.member.service.IMemberService;
import com.servlet.member.service.MemberServiceImpl;
import com.servlet.member.vo.MemberVO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>LOG IN</title>");
		out.println("</head>");
		out.println("<body text-align='center'>");
		out.println("<h1>LOG IN</h1>");
		out.println("<form method='post'>");
		out.println("아이디 : <input type='text' name='memId'><br>");
		out.println("비밀번호 : <input type='password' name='memPw'><br><br>");
		out.println("<button type='submit'>로그인</button>");
		out.println("<button type='reset'>초기화</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>LOG IN</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>메인입니당</h1>");
		out.println("</form>");
		out.println("</body>");
		
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		System.out.println(memId + " / " + memPw);
		
		MemberVO mv = new MemberVO();
		
		mv.setMemId(memId);
		IMemberService service = MemberServiceImpl.getInstance();
		int checkMemId = service.checkMemId(memId);

		if(checkMemId == 0) {
			out.println("<script>alert('존재하지 않는 아이디입니다.');location.href='login'</script>");
			out.flush();
		} else {
			mv.setMemPw(memPw);
			mv = service.checkMemPw(mv);
			if(mv != null) {
				String mem = mv.getMemId();
				out.println("<script>alert('" + mem + "님 환영합니다.');</script>");
				out.flush();
			} else {
				out.println("<script>alert('잘못된 비밀번호입니다.');location.href='login'</script>");
				out.flush();
			}
		}
		out.println("</html>");
	}

}
