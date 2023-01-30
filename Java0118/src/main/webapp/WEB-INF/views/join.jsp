<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<meta charset="UTF-8">
<title>회원가입</title>
<script>

	$(function() {
		//alert("!");
		$("#joinBtn").click(function() {
			//alert("가입하기를 눌렀습니다.");
			var name = $("#name").val();
			if (name == "" || name.length < 2) {
				alert("이름을 입력하세요.\n이름은 2글자 이상으로 입력해주세요");
				$("#name").focus();
				return false;//멈춤.
			}

			var id = $("#id").val();
			if (id == "" || id.length < 3) {
				alert("아이디를 입력하세요.\n아이디는 3글자 이상으로 입력해주세요");
				$("#checkResult").css("color", "red");
				$("#checkResult").text("아이디는 3글자 이상으로 입력해주세요");
				$("#id").focus();
				return false;//멈춤.
			}

			var pw1 = $("#pw1").val();
			if (pw1 == "" || pw1.length < 4) {
				alert("비밀번호를 입력하세요.\n비밀번호는 4글자 이상으로 입력해주세요");
				$("#pw1").focus();
				return false;//멈춤.
			}
			var pw2 = $("#pw2").val();
			if (pw1 != pw2) {
				alert("비밀번호가 일치하지 않습니다.\n 다시 입력해주세요");
				$("#pw2").val("");
				$("#pw2").focus();
				return false;//멈춤.
			}

			var email = $("#email").val();
			if (email == "" || email.length < 4) {
				alert("이메일을 입력하세요.");
				$("#email").focus();
				return false;//멈춤.
			}
		});

	});

	function check() {
		var id = $("#id").val();
		if (id == "" || id.length < 3) {
			$("#checkResult").text("3글자 이상 입력하세요");
			$("#checkResult").css("color", "red");
			$("#id").focus();
			return false;
		} else {
			$.ajax({
				url : "./checkID",
				type : "post",
				cache : false,
				dataType : "html", //수신할 데이터 타입
				data : {
					"id" : $("#id").val()
				}, //객체네?
				success : function(data) {
					if (data == "1") {
						$("#checkResult").text("사용 중인 아이디 입니다.");
						$("#checkResult").css("color", "red");
						$("#joinBtn").attr("disabled" , true);
					} else {
						$("#checkResult").text("사용가능한 아이디 입니다.");
						$("#checkResult").css("color", "green");
						$("#joinBtn").attr("disabled" , false);
					}
				},
				error : function(request, status, error) {
					alret("문제 발생" + error);
				}
			});
		}
	}
</script>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="container">
		<div class="join">
			<form action="./join" method="post">
				<table class="table">
					<tr>
						<th>이름</th>
						<td><input type="text" name="name" id="name"
							placeholder="이름을 입력하세요"></td>

					</tr>

					<tr>
						<th>아이디</th>
						<td><input type="text" name="id" id="id"
							placeholder="아이디를 입력하세요" onchange="return check()">
							<p id="checkResult">아이디를 입력하세요</p></td>
					</tr>

					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="pw1" id="pw1"
							placeholder="비밀번호를 입력하세요"> <input type="password"
							name="pw2" id="pw2" placeholder="비밀번호 재입력"></td>
					</tr>

					<tr>
						<th>이메일</th>
						<td><input type="email" name="email" id="email"
							placeholder="이메일을 입력하세요"></td>
					</tr>

				</table>
				<button type="reset" class="btn btn-danger">초기화</button>
				<button type="submit" disabled="disabled" class="btn btn-success" id="joinBtn">가입하기</button>
			</form>

		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>

</body>
</html>