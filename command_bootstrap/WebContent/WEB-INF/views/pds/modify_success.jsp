<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<script>
	alert("게시글 삭제가 성공했습니다.");
	location.href="detail.do?pno=${pds.pno}&from=modify";
</script>