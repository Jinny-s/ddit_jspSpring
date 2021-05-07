package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class HTMLView {
	
	public static void html(HttpServletResponse response, String title, String body) throws IOException, ServletException {
		html(response, title, null, null, body);
	}
	
	public static void html(HttpServletResponse response, String body) throws IOException, ServletException {
		html(response, null, null, null, body);
	}
	
	public static void html(HttpServletResponse response, String title, String css, String script, String body) throws IOException, ServletException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + title + "</title>");
		out.println("<style>" + css + "</style>");
		out.println("<script>" + script + "</script>");
		out.println("</head>");
		out.println("<body>" + body + "</body>");
		out.println("</html>");
		
	}
	
	public static void loginView(HttpServletResponse response) throws IOException, ServletException {
		
		String body = null;
		
		response.setContentType("text/html;charset=utf-8");
		
		body = "<form action='login' method='post'>"
				+ "아이디 : <input type='text' name='memId' /><br/>"
				+ "비밀번호 : <input type='password' name='memPw' /><br/>"
				+ "<input type='submit' value='로그인' />"
				+ "</form>";
		
		html(response, "로그인", null, null, body);
		
	}
	
}
