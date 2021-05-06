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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>REGISTER</title>");
		out.println("</head>");
		out.println("<body text-align='center'>");
		out.println("<h1>회원가입</h1>");
		out.println("<form method='post'>");
		out.println("아이디 : <input type='text' name='memId' required><br>");
		out.println("비밀번호 : <input type='password' name='memPw' required><br>");
		out.println("이메일 : <input type='email' name='memEmail' required><br>");
		out.println("전화번호 : <input type='text' name='memHp' required><br><br>");
		out.println("<button type='submit'>회원가입</button>");
		out.println("<button type='reset'>초기화</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		MemberVO mv = new MemberVO();
		IMemberService service = MemberServiceImpl.getInstance();
		
		mv.setMemId(request.getParameter("memId"));
		mv.setMemPw(request.getParameter("memPw"));
		mv.setMemEmail(request.getParameter("memEmail"));
		mv.setMemHp(request.getParameter("memHp"));
		service.insertMember(mv);
		
		out.println("<script>alert('회원가입이 완료되었습니다.');location.href='login'</script>");
		out.flush();
	}

}
