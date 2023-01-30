<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>톺아보기</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<link href="./css/detail.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script>
function board() {
	location.href="./board";
}

function del(no){
	if(confirm("삭제하시겠습니까?")){
		location.href="./delete?no="+no;
	}
}

$(function(){
	$("#update").click(function(){
		if(confirm("수정하시겠습니까?")){
			location.href="./update?no=${detail.b_no}";
		}
	})
	
})
</script>
<style type="text/css">
.commentform{
   width: 100%;
   height: 100px;
   background-color: gray;
   padding: 5px;
}
.commentform textarea, button {
   margin: 0;
   padding: 0;
   height: 90px;
}
.commentform textarea{
   width: calc(100% - 110px); 
}
.commentform button{
   width: 100px;
   vertical-align: top;
}
</style>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h1>detail</h1>


	<div>
		${detail.b_no }<br> ${detail.b_title }<br>
		${detail.b_content }<br>${detail.b_write }<br>
		${detail.b_date }<br> ${detail.b_like }<br>
	</div>
	<button type="button" class="btn btn-primary" onclick="board()">게시판으로</button>
	<c:if test="${detail.member_id eq sessionScope.id}">
		<button type="button" class="btn btn-primary"
			onclick="del(${detail.b_no})">삭제</button>
		<button type="button" class="btn btn-primary" id="update">수정</button>
	</c:if>
	
	<c:if test="${sessionScope.id ne null }">
		<div class="commntform">
			<form action=" " method="post">
				<textarea></textarea>
				<input type="hidden" value="${detail.b_no }">
				<button type="submit">댓글 남기기</button>
			</form>
		</div>
	</c:if>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous">
	
</script>
</html>