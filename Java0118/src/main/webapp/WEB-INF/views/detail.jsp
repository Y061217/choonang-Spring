<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>톺아보기</title>
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

function update(){
	
}
</script>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h1>detail</h1>


	<div>
		${detail.b_no }<br> ${detail.b_title }<br>
		${detail.b_content }<br> ${detail.b_write }<br>
		${detail.b_date }<br> ${detail.b_like }<br>
	</div>
	<button type="button" class="btn btn-primary" onclick="board()">게시판으로</button>
	<button type="button" class="btn btn-primary" onclick="del(${detail.b_no})">삭제</button>
	<button type="button" class="btn btn-primary" onclick="update()">수정</button>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous">
	
</script>
</html>