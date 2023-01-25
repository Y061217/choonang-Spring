<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<style>
body {
	margin: 0;
	padding: 0;
}

.menu {
	width: 100%;
	height: 30px;
	background-color: #afe1ff;
	margin: 0;
	padding: 0;
}

.menu ul li {
	list-style: none;
	display: inline-block;
	width: 75px;
	line-height: 30px;
	box-sizing: border-box;
}

.menu ul li:hover {
	color: yellow;
}
</style>
<div class="menu">
	<ul>
		<li onclick="location.href = './index'">index</li>
		<li onclick="location.href = './member'">멤버 목록</li>
		<li onclick="location.href = './board'">게시판</li>
		<li onclick="location.href = './draw'">뽑기</li>
		
		<c:choose>
		
		<c:when test = "${sessionScope.id eq null }">
		<li onclick="location.href = './login'">로그인</li>
		</c:when>
<%-- 		<c:when test2 = "조건식">참일경우출력</c:when> --%>
<%-- 		<c:when test3 = "조건식">참일경우출력</c:when> --%>
		<c:otherwise>
		<li onclick="location.href = './myinfo'">${sessionScope.name }님</li>
		<li onclick="location.href = './logout'">로그아웃</li>
		</c:otherwise>
		
		</c:choose>
	</ul>
</div>