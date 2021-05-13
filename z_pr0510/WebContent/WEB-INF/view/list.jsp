<%@page import="com.servlet.dto.MemberVO"%>
<%@page import="java.util.List"%>
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
	<script src="<c:url value='/' />js/jquery-3.6.0.js"></script>
	<title>JINNY</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary d-flex justify-content-between">
	<a class="navbar-brand" href="<c:url value='/' />list"><i class="fas fa-users mr-2"></i>JINNY's MEMBER CRUD</a>
</nav>

<div class="container">

	<div class="col-md-12">
		<h1 class="m-5"><i class="fas fa-user mr-3"></i>MEMBER LIST</h1>
		<table class="table table-hover text-center">
			<thead>
				<tr class="table-info">
					<th scope="col">아이디</th>
					<th scope="col">비밀번호</th>
					<th scope="col">이메일</th>
					<th scope="col">전화번호</th>
					<th scope="col">관리</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${empty list }">
				<tr>
					<td colspan="6">등록된 회원이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${list }" var="list">
				<tr>
					<td>${list.memId }</td>
					<td>${list.memPw }</td>
					<td>${list.memEmail }</td>
					<td>${list.memHp }</td>
					<td>
						<a class="btn btn-outline-info btn-sm" onclick="fn_detail('${list.memId }');">조회</a>
						<a class="btn btn-outline-info btn-sm" onclick="fn_update('${list.memId }');">수정</a>
						<a class="btn btn-outline-danger btn-sm" onclick="fn_delete('${list.memId }');">삭제</a>
					</td>
				</tr>
			</c:forEach>
				<tr>
					<td colspan="6">
						<a class="btn btn-outline-info btn-sm" href="<c:url value='/' />signup">등록</a>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script type="text/javascript">
	function fn_detail(memId) {
		$('#memId').attr('value', memId);
		$('#fm').attr('method', 'get');
		$('#fm').attr('action', '<c:url value='/' />detail');
		$('#fm').submit();
	}	
	
	function fn_update(memId) {
		$('#memId').attr('value', memId);
		$('#fm').attr('method', 'get');
		$('#fm').attr('action', '<c:url value='/' />update');
		$('#fm').submit();
	}

	function fn_delete(memId) {
		if(confirm('회원정보를 삭제하시겠습니까?')) {
			$('#memId').attr('value', memId);
			$('#fm').attr('action', '<c:url value='/' />delete');
			$('#fm').submit();
		}
	}
</script>
</body>
</html>