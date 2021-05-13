<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form action="${url }" method="get" name="fm">
</form>

<script type="text/javascript">
	<c:if test="${not empty msg }">
		alert('${msg}')
	</c:if>
	document.fm.submit();
</script>
</body>
</html>