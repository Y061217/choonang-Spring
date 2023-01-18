<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>
	<jsp:include page="menu.jsp"/>
	<c:import url="menu.jsp"/> <!-- JSTL 문법이기 때문에 JSTL이 선언 선행 필요함 -->
<%-- 	<%@ include file="./menu.jsp" %> --%>
	<h1>데이터베이스에서 불러옴</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>전화번호</th>
			<th>이메일</th>
		</tr>
		<c:forEach items="${list }" var="i">
			<tr>
				<td>${i.member_no }</td>
				<td>${i.member_name }</td>
				<td>${i.member_age }</td>
				<td>${i.member_tel }</td>
				<td>${i.member_email }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<c:forEach begin="1" end="10" step="2" var="i">${i }<br>
	</c:forEach>
	<c:if test="true">참</c:if>
	<br>
	<c:if test="${1 == 1}">참</c:if>
	<br>
	<c:if test="false">안나옴</c:if>
	<c:out value="out으로 만듦"></c:out>
</body>
</html>