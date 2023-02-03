<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<!-- include libraries(jQuery, bootstrap) -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<title>글쓰기</title>
<style>
body {
	margin: 0 auto;
	padding: 0;
}

article {
	width: 60vw;
	height: 60vh;
	margin: 0 auto;
	padding: 0;
}

input {
	width: 60vw;
	padding: 5px;
}

textarea {
	width: 60vw;
	height: 60vh;
	padding: 5px;
	margin: 5px;
}
</style>
</head>
<body>

	<div>
		<header>
			<jsp:include page="menu.jsp" />
		</header>
		<section>
			<article>
				<h1>이곳에서 글을 작성하고 저장할 수 있습니다.</h1>
				<form action="./n_write" method="post" enctype="multipart/form-data">
					<input type="text" name="title" placeholder="이곳에 제목을 입력"> <br>
					<textarea id="summernote" name="content" placeholder="이곳에 내용을 입력"></textarea>
					<br>
					<input type="file" name="file" accept="image/*">
					<button type="submit" class="btn btn-primary">저장하기</button>
					
				</form>
			</article>
		</section>
	</div>
<script>
$(document).ready(function() {
	  $('#summernote').summernote({
		  height : 300
	  });
	});
</script>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
</html>