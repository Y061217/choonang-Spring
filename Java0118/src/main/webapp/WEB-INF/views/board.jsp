<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Board</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<style>
table {
	margin: 0;
	width: 900px;
	text-align: center;
}

.title {
	text-align: center;
}
</style>
<script>
function write1() {
	location.href="./write";
}
</script>
</head>

<body>
	<jsp:include page="menu.jsp" />
	<h1>Board</h1>
	<!-- jstl을 사용하기 위해서는 최상단에 선언문을 넣어줘야 합니다. -->
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<td class="col-1">번호</td>
				<td class="col-6">제목</td>
				<td class="col-2">글쓴이</td>
				<td class="col-2">날짜</td>
				<td class="col-1">조회수</td>
			</tr>
		<thead>
		<tbody>
			<c:forEach items="${board }" var="row">
				<tr>
					<td>${row.b_no }</td>
					<td class="title"><a href="./detail?b_no=${row.b_no }">${row.b_title }</td>
					<td>${row.b_write }</td>
					<td>${row.b_date }</td>
					<td>${row.b_like }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:if test="${sessionScope.id ne null}"><button type="button" class="btn btn-primary" onclick="write1()">글쓰기</button></c:if>	
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>

</html>