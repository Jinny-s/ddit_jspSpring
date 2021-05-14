<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>



<%
	String result = "";
	for(int i = 2; i < 10; i++) {
%>
	<h3>[ <%=i%> 단 ]</h3>
<%
		for(int j = 1; j < 10; j++) {
%>
	<p><%=i%> * <%=j%> = <%=i * j%></p>
<%
		}
%>
	<br/>
<%
	}
%>