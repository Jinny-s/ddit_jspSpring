<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="pageMaker" value="${dataMap.pageMaker}" />
<c:set var="cri" value="${dataMap.cri}" />
<c:set var="noticeList" value="${dataMap.noticeList}" />

<head></head>

<title>공지사항</title>

<body>
	<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>공지사항</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="list.do">
				        	<i class="fa fa-dashboard"></i>공지사항
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	목록
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
	</section>
	
	<section class="content">
		<div class="card">
			<div class="card-header with-border">
				<button type="button" class="btn btn-primary" onclick="OpenWindow('registForm.do','공지등록',800,700);">공지작성</button>
				<div id="keyword" class="card-tools" style="width:550px;">
					<div class="input-group row">
						<select class="form-control col-md-3 mr-3" name="perPageNum" id="perPageNum" onchange="list_go();">
							<option value="10">정렬개수</option>						
							<option value="20" ${cri.perPageNum == 20 ? 'selected':''}>20개씩</option>						
							<option value="50" ${cri.perPageNum == 50 ? 'selected':''}>50개씩</option>						
							<option value="100" ${cri.perPageNum == 100 ? 'selected':''}>100개씩</option>						
						</select>
						
						<select class="form-control col-md-3" name="searchType" id="searchType">
							<option value="" ${cri.searchType eq '' ? 'selected':''}>검색구분</option>						
							<option value="t" ${cri.searchType eq 't' ? 'selected':''}>제목</option>						
							<option value="w" ${cri.searchType eq 'w' ? 'selected':''}>작성자</option>						
							<option value="c" ${cri.searchType eq 'c' ? 'selected':''}>내용</option>						
							<option value="tc" ${cri.searchType eq 'tc' ? 'selected':''}>제목+내용</option>						
							<option value="cw" ${cri.searchType eq 'cw' ? 'selected':''}>내용+작성자</option>						
							<option value="tcw" ${cri.searchType eq 'tcw' ? 'selected':''}>제목+내용+작성자</option>						
						</select>
						
						<input class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." value="${cri.keyword }" />
						<span class="input-group-append">
							<button class="btn btn-primary" type="button" id="searchBtn" data-card-widget="search" onclick="list_go(1);">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
					</div>
				</div>
			</div>
			<div class="card-body" style="text-align:center">
				<div class="row">
					<div class="col-sm-12">
						<table class="table table-bordered">
							<tr>
								<th style="width:10%">번호</th>
								<th style="width:60%">제목</th>
								<th style="width:10%">작성자</th>
								<th style="width:10%">작성일</th>
								<th style="width:10%">조회수</th>
							</tr>
							<c:forEach items="${noticeList}" var="notice">
							<tr>
								<td>${notice.nno}</td>
								<td>
									<a href="javascript:OpenWindow('detail.do?id=${notice.nno}',상세보기,800,700);">${notice.title}</a>
								</td>
								<td>${notice.writer}</td>
								<td><fmt:formatDate value="${notice.regdate }" pattern="yyyy-MM-dd"/></td>
								<td>${notice.viewcnt}</td>
							</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<div class="card-footer">
				<%@ include file="/WEB-INF/views/common/pagination.jsp" %>
			</div>		
		</div>	
	</section>
<script src="/resources/js/common.js"></script>

</body>