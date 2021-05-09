<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<a class="navbar-brand" href="<%=request.getContextPath()%>/main"><i class="fas fa-users mr-2"></i>JINNY's MEMBER CRUD</a>
</nav>

<div class="container">

	<div class="col-md-12">
		<h1 class="m-5"><i class="fas fa-user mr-3"></i>SIGN IN</h1>
		<form action="signin" method="post">
			<table class="table">
				<tbody>
					<tr>
						<th width="20%" class="align-middle">아이디</th>
						<td>
							<input type="text" class="form-control align-middle" name="memId" placeholder="아이디를 입력하세요" required="required">
						</td>
					</tr>
					<tr>
						<th class="align-middle">비밀번호</th>
						<td>
							<input type="password" class="form-control align-middle" name="memPw" placeholder="비밀번호를 입력하세요" required="required">
						</td>
					</tr>
				</tbody>
			</table>
			<hr>
			<a class="btn btn-outline-secondary mt-4 ml-4 float-right" href="<%=request.getContextPath()%>/main">메인으로</a> 
			<button class="btn btn-outline-primary mt-4 float-right" type="submit">로그인</button>
		</form>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>