<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
input {
	margin : 0 auto;
	width : 90vw;
	height: 30px;
	font-size: large;
	padding : 5px;
	
	
}
</style>
</head>
<body>

<jsp:include page="menu.jsp"/>
<h1>Draw Who & What</h1>
<form action="./draw" method="post"><input type="text" name="names"><button type = "submit">DRAW!!</button></form>
<h2>The winner is...</h2>
<h3>발표자 : ${speaker }</h3>
<h3>코드 : ${code }</h3>

</body>
</html>