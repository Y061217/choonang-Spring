<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<li>게시판 2</li>
		<li>게시판 3</li>
		<li>게시판 4</li>
		<li>로그인</li>
	</ul>
</div>