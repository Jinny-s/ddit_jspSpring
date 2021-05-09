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
		<h1 class="m-5"><i class="fas fa-user mr-3"></i>MAIN PAGE</h1>
		<div class="card-columns text-center">
			<div class="card border-primary mb-3" style="max-width: 18rem;">
				<div class="card-header">SIGN IN</div>
				<div class="card-body">
					<h5 class="card-title"><a href="<%=request.getContextPath()%>/signin">로그인</a></h5>
				</div>
			</div>
			<div class="card border-primary mb-3" style="max-width: 18rem;">
				<div class="card-header">SIGN UP</div>
				<div class="card-body">
					<h5 class="card-title"><a href="<%=request.getContextPath()%>/signup">회원가입</a></h5>
				</div>
			</div>
			<div class="card border-primary mb-3" style="max-width: 18rem;">
				<div class="card-header">MEMBER CRUD</div>
				<div class="card-body">
					<h5 class="card-title"><a href="<%=request.getContextPath()%>/list">회원 관리</a></h5>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>