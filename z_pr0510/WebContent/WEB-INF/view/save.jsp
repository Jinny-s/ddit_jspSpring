<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String msg = (String) request.getAttribute("msg");
	String url = (String) request.getAttribute("url");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form action="<%=url%>" method="get" name="fm">

</form>
<script type="text/javascript">

<%
	if(msg != null) {
%>
	alert("<%=msg %>");
<%
	}
%>

document.fm.submit();

</script>
</body>
</html>