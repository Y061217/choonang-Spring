<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>

<script>
	// 정석
$(document).ready(function() {
	//alert("test");
});

	// 준 실무
$().ready(function() {
	//alert("test2");
});

	//실무 최대 축약형

$(function() {
	$(".check").click(function() {

		var id = $("#id").val();			
		var pw = $("#pw").val();
		
			
		if(id=="" || id.length < 4){
			alert("아이디는 4글자 이상으로 입력해주세요.");
			$("#id").focus();
			//아이디 입력창으로 커서를 이동합니다.
			return false;
			}
		
		if(pw=="" || pw.length < 4){
			alert("비밀번호는 4글자 이상으로 입력해주세요.");
			$("#pw").focus();
			//비밀번호 입력창으로 커서를 이동합니다.
			return false;
			}
		
		alert(id+"|"+pw);
		});
	});
</script>
<body>
	<jsp:include page="menu.jsp" />
	<h1>login</h1>
	
	<!-- 
	ne = not equal? !=
	eq = equal? ==
	lt <
	gt >
	le >=
	ge <=	
	 -->
	
	<c:if test = " ${param.error ne null} "/>
		<h2>올바른 아이디와 비밀번호를 입력하세요</h2>
	<form method="post" action="./login" name="loginForm">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr height="60">
				<td colspan="3" align="center">MEMBER LOGIN</td>
			</tr>

			<tr height="35">
				<td width="100" bgcolor="#ccc">아이디</td>
				<td width="300" align="center"><input name="id" id="id"
					type="text" style="width: 280px; height: 32px;"></td>
				<td width="100" rowspan="2" align="center"><input type="submit"
					class="check" value="로그인"
					style="background-color: black; width: 95px; height: 65px; color: white;">
				</td>
			</tr>

			<tr height="35">
				<td bgcolor="#ccc">패드워드</td>
				<td align="center"><input name="pw" type="password" id="pw"
					style="width: 280px; height: 32px;"></td>
			</tr>

			<tr height="40">
				<td colspan="2" align="center">회원가입</td>
				<td colspan="1" align="center">아이디/패스워드 찾기</td>
			</tr>

		</table>
	</form>
</body>
</html>