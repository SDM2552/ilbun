<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="light">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
	<meta name="generator" content="Hugo 0.122.0">
	<script src="../assets/js/color-modes.js"></script>
	<link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
	<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link href="../css/login.css" rel="stylesheet" />
	<title>로그인</title>
</head>
<body>
<c:import url="../header.jsp" />

<body class="d-flex align-items-center py-4 bg-body-tertiary">


<main class="form-signin w-100 m-auto">
	<form action="/user/loginProc" method="post">

		<h1 class="h3 mb-3 fw-normal">로그인</h1>

		<div class="form-floating">
			<input type="text" class="form-control" name="userId" id="floatingInput" placeholder="name@example.com">
			<label for="floatingInput">아이디 입력</label>
		</div>
		<div class="form-floating">
			<input type="password" class="form-control" name="password" id="floatingPassword" placeholder="Password">
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
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>