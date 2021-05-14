<%@page import="com.servlet.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" crossorigin="anonymous">
	<script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.js"></script>
	<title>JINNY</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary d-flex justify-content-between">
	<a class="navbar-brand" href="<%=request.getContextPath()%>/list"><i class="fas fa-users mr-2"></i>JINNY's MEMBER CRUD</a>
</nav>

<div class="container">

	<div class="col-md-12">
		<h1 class="m-5"><i class="fas fa-user mr-3"></i>MEMBER PROFILE</h1>
		<table class="table">
			<tbody>
				<tr>
					<th width="20%" class="align-middle">아이디</th>
					<td>${member.memId }</td>
				</tr>
				<tr>
					<th class="align-middle">비밀번호</th>
					<td>${member.memPw }</td>
				</tr>
				<tr>
					<th class="align-middle">이메일</th>
					<td>${member.memEmail }</td>
				</tr>
				<tr>
					<th class="align-middle">전화번호</th>
					<td>${member.memHp }</td>
				</tr>
				<tr>
					<td colspan="2" class="text-center">
						<a class="btn btn-outline-info btn-sm" onclick="fn_update('${member.memId }');">수정</a>
						<a class="btn btn-outline-danger btn-sm" onclick="fn_delete('${member.memId }');">삭제</a>
						<a class="btn btn-outline-secondary btn-sm" href="<%=request.getContextPath()%>/list">목록으로</a> 
					</td>
				</tr>
			</tbody>
		</table>
		<hr>
	</div>
<form id="fm" method="post">
	<input type="hidden" id="memId" name="memId" />
</form>
</div>
<script type="text/javascript">
	function fn_update(memId) {
		$('#memId').attr('value', memId);
		$('#fm').attr('method', 'get');
		$('#fm').attr('action', '<%=request.getContextPath()%>/update');
		$('#fm').submit();
	}

	function fn_delete(memId) {
		if(confirm('회원정보를 삭제하시겠습니까?')) {
			$('#memId').attr('value', memId);
			$('#fm').attr('action', '<%=request.getContextPath()%>/delete');
			$('#fm').submit();
		}
	}
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>