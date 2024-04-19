<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<script src="/assets/js/color-modes.js"></script>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
	<meta name="generator" content="Hugo 0.122.0">
	<title>로그인</title>

	<link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
	<link href="/assets/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="/css/styles.css" rel="stylesheet" />
	<link href="/css/login.css" rel="stylesheet" />
<title>로그인</title>
</head>

<body class="">
<c:import url="../header.jsp" />
<main class="form-signin w-100 m-auto">
	<form action="/user/loginProc" method="post">
		<h1 class="h3 mb-3 fw-normal">로그인</h1>

		<div class="form-floating">
			<input type="text" name="userId" class="form-control" id="floatingInput" placeholder="name@example.com">
			<label for="floatingInput">아이디 입력</label>
		</div>
		<div class="form-floating">
			<input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
			<label for="floatingPassword">비밀번호 입력</label>
		</div>

		<div class="form-check text-start my-3">
			<input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
			<label class="form-check-label" for="flexCheckDefault">
				아이디 기억하기
			</label>
		</div>
		<button class="btn btn-primary w-100 py-2" type="submit">로그인</button>
		<p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2024</p>
	</form>
</main>
<script src="/assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>