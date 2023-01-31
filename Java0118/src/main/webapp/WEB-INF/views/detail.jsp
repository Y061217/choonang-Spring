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

$(function(){
	$(".del").click(function(){
		if(confirm("삭제하시겠습니까?")){
			var choose = $(this).siblings(".c_no").text();
			//제이쿼리와 에이잭스로 해당 댓글을 지우고, 서버에 삭제 명령 전송, 화면 전환 없이 부드럽게 작동
			//DB에서 지우기 ajax() , post() , get()
			$.post({
				url : "./commentDel" ,
				data : {"c_no" : choose}	
			}).done(function(data){
				alert("서버 응답 :" + data);
				commentbox.hide();
			}); 
			
			
		}
	})
})

$(function(){
	var choose = 0;
	$(".upd").click(function(){
		if(confirm("수정하시겠습니까?")){
			choose = $(this).siblings(".c_no").text();
			var context = $(this).siblings(".cm_text");
			$(".upd").css("display","none");
 			$(".del").css("visibility","hidden");
			context.append("<br><textarea class='upcmt'></textarea><br><button id='send'>수정하기</button>");
		}
	});
	
	$(".c_comment").on('click','#send',function(){
		alert("로딩중");
		$.post({
			url : "./upcmt" ,
			data : {"c_no" : choose  , "upcmt" : $('textarea').val()}
		
		}).done(function(data){
		$.ajax({
				type : "get",
				url : "./detail",
				data : {"d_no"  : "18"}
			})
			//갱신해오기
			
			alert("!");
			

			$(".tobody").empty();
			let temp_html = `
				<c:forEach items="${C_comment }" var="c">
				<tr class="comment">
					<td>${c.member_name }님</td>
					<td class="c_comment">
						<div class="c_no" style="visibility: hidden;">${c.c_no }</div> <label
						class="cm_text">${c.c_comment }</label> &nbsp <c:if
							test="${c.member_id eq sessionScope.id}">
							<button class="del">삭제</button>
							<button class="upd">수정</button>
						</c:if>
					</td>
					<td>${c.c_date }</td>
				</tr>
			</c:forEach>
			`
			$(".tobody").append(temp_html);
		})
	})
})
	
</script>

<style>
.commentform {
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

.commentform textarea {
	width: calc(100% - 110px);
}

.commentform button {
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
		${detail.b_date }<br> ${detail.b_like }<br> 댓글 수 :
		${detail.comment}<br>

		<table style="background-color: #afe1ff; text-align: center;">
			<thead>
				<tr>
					<th scope="col">글쓴이 번호</th>
					<th scope="col">댓글 내용</th>
					<th scope="col">댓글 시간</th>
				</tr>
			</thead>
			<tbody class="tobody">
				<c:forEach items="${C_comment }" var="c">
					<tr class="comment">
						<td>${c.member_name }님</td>
						<td class="c_comment">
							<div class="c_no" style="visibility: hidden;">${c.c_no }</div> <label
							class="cm_text">${c.c_comment }</label> &nbsp <c:if
								test="${c.member_id eq sessionScope.id}">
								<button class="del">삭제</button>
								<button class="upd">수정</button>
							</c:if>
						</td>
						<td>${c.c_date }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<button type="button" class="btn btn-primary" onclick="board()">게시판으로</button>
	<c:if test="${detail.member_id eq sessionScope.id}">
		<button type="button" class="btn btn-primary"
			onclick="del(${detail.b_no})">삭제</button>
		<button type="button" class="btn btn-primary" id="update">수정</button>
	</c:if>

	<c:if test="${sessionScope.id ne null }">
		<div class="commntform">
			<form action="./comment" method="post">
				<textarea name=comment></textarea>
				<input type="hidden" name="b_no" value="${detail.b_no }">
				<button type="submit">댓글 남기기</button>
			</form>
		</div>
	</c:if>



</body>

</html>