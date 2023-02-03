<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Notice</title>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous">	</script>
	
<script type="text/javascript">
	function linkPage(pageNo){
		location.href = "/web/notice?pageNo="+pageNo;
	}	
	
	function n_write() {
		location.href="./n_write";
	}
</script>

</head>
<body>
	<jsp:include page="menu.jsp" />
	<h1>공지사항</h1>

	<div class="container text-center">
		<div class="row align-items-start">
			<div class="col">글번호</div>
			<div class="col-5">글제목</div>
			<div class="col">관리자</div>
			<div class="col">날짜</div>
			<div class="col">조회수</div>
		</div>
	</div>
	<c:forEach items="${n_val }" var="ntc">
		<div class="container text-center">
			<div class="row align-items-start">
				<div class="col">${ntc.n_no}</div>
				<div class="col-5"><a href="./n_detail?no=${ntc.n_no}">${ntc.n_title}</a><c:if test="${ntc.n_file != null}"><small><i class="xi-image"></i></small></c:if></div>
				<div class="col">${ntc.admin_name}</div>
				<div class="col">${ntc.n_date}</div>
				<div class="col">${ntc.n_read}</div>
			</div>
		</div>
	</c:forEach>
	<c:if test="${sessionScope.id ne null}"><button type="button" class="btn btn-primary" onclick="n_write()">글쓰기</button></c:if>	
	
	<div style="width : 100%; height : 30px; text-align:center;">
	<ui:pagination paginationInfo = "${paginationInfo}"
			type="text"
			jsFunction="linkPage"/>
	</div>
</body>
</html>