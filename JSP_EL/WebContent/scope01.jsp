<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	pageContext.setAttribute("msg", "페이지컨텍스틐!!");
	request.setAttribute("msg", "리퀘스틐!!");
	session.setAttribute("msg", "세션!!");
	application.setAttribute("msg", "어플리케이션!!");
%>

<h1>${param.msg }</h1>
￦${requestScope.msg}