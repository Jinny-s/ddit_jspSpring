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
	<script src="<c:url value='/' />js/jquery-3.6.0.js"></script>
	<title>JINNY</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary d-flex justify-content-between">
	<a class="navbar-brand" href="<c:url value='/' />list"><i class="fas fa-users mr-2"></i>JINNY's MEMBER CRUD</a>
</nav>

<div class="container">

	<div class="col-md-12">
		<h1 class="m-5"><i class="fas fa-user mr-3"></i>UPDATE FORM</h1>
		<form action="update" method="post">
			<table class="table">
				<tbody>
					<tr>
						<th width="20%" class="align-middle">아이디</th>
						<td>
							<input type="text" class="form-control align-middle" name="memId" value="${mv.memId }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<th class="align-middle">비밀번호</th>
						<td>
							<input type="password" class="form-control align-middle" name="memPw" value="${mv.memPw }" required="required">
						</td>
					</tr>
					<tr>
						<th class="align-middle">이메일</th>
						<td>
							<input type="email" class="form-control align-middle" name="memEmail" value="${mv.memEmail }" required="required">
						</td>
					</tr>
					<tr>
						<th class="align-middle">전화번호</th>
						<td>
							<input type="text" class="form-control align-middle" name="memHp" value="${mv.memHp }" required="required">
						</td>
					</tr>
				</tbody>
			</table>
			<hr>
			<a class="btn btn-outline-secondary mt-4 ml-4 float-right" href="<c:url value='/' />list">목록으로</a> 
			<button class="btn btn-outline-primary mt-4 float-right" type="submit">수정</button>
		</form>
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>