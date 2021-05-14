<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%!
	public int total(int kor, int eng, int math, int sci) {
		return kor + eng + math + sci;
	}
%>

<%
	String korParam = request.getParameter("kor");
	String engParam = request.getParameter("eng");
	String mathParam = request.getParameter("math");
	String sciParam = request.getParameter("sci");
	
	float avg = 0.0f;
	try {
		int kor = Integer.parseInt(korParam);
		int eng = Integer.parseInt(engParam);
		int math = Integer.parseInt(mathParam);
		int sci = Integer.parseInt(sciParam);
		
		int total = total(kor, eng, math, sci);
		
		avg = total/4.0f;
		
	} catch(Exception e) {
		out.println("입력값이 올바르지 않습니다.");
		return;
	}
	
	pageContext.setAttribute("avg", avg);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<p>국어 : ${param.kor }점</p>
<p>영어 : ${param.eng }점</p>
<p>수학 : ${param.math }점</p>
<p>과학 : ${param.sci }점</p>
<p>총점 : ${param.kor+param.eng+param.math+param.sci }점</p>
<p>평균 : ${avg }점<p> 

<script type="text/javascript">
alert('총점 : ${param.kor+param.eng+param.math+param.sci }점 / 평균 : ${avg}점');
</script>
</body>
</html>