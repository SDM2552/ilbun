<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en" data-bs-theme="light">

<head>
    <script src="/assets/js/color-modes.js"></script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.122.0">
    <title>회원 가입</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/checkout/">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">

    <link href="/assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/join.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="checkout.css" rel="stylesheet">
</head>

<body class="bg-body-tertiary">
<c:import url="../header.jsp" />
<div class="container">
    <main>
        <div class="py-5 text-center">
            <img class="d-block mx-auto mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
            <h2>회원 가입</h2>
            <p class="lead">Below is an example form built entirely with Bootstrap’s form controls. Each required form
                group
                has a validation state that can be triggered by attempting to submit the form without completing it.</p>
        </div>


        <div class="col-md-7 col-lg-8">
            <h4 class="mb-3">회원 가입</h4>
            <form action="join" method="post" class="needs-validation" novalidate>
                <div class="row g-3">

                    <div class="col-12">
                        <label for="address" class="form-label">아이디</label>
                        <input type="text" name="userId" class="form-control" id="address" placeholder="아이디 입력"
                               required>
                        <div class="invalid-feedback">
                            이 칸은 반드시 채워야 합니다.
                        </div>
                    </div>

                    <div class="col-12">
                        <label for="address" class="form-label">비밀번호</label>
                        <input type="password" name="password" class="form-control" id="address2" placeholder="비밀번호 입력"
                               required>
                        <div class="invalid-feedback">
                            이 칸은 반드시 채워야 합니다.
                        </div>
                    </div>

                    <div class="col-12">
                        <label for="address" class="form-label">이름</label>
                        <input type="text" name="name" class="form-control" id="address3" placeholder="이름 입력" required>
                        <div class="invalid-feedback">
                            이 칸은 반드시 채워야 합니다.
                        </div>
                    </div>

                    <div class="col-12">
                        <label for="address" class="form-label">이메일</label>
                        <input type="email" name="email" class="form-control" id="address4" placeholder="이메일 입력"
                               required>
                        <div class="invalid-feedback">
                            이 칸은 반드시 채워야 합니다.
                        </div>
                    </div>

                    <div class="col-12">
                        <label for="address" class="form-label">주소</label>
                        <input type="email" name="email" class="form-control" id="address5" placeholder="주소 입력(선택사항)">

                    </div>
                </div>

                <hr class="my-4">

                <button class="w-100 btn btn-primary btn-lg" type="submit">가입하기</button>
                <button class="btn btn-primary w-100 py-2 lastbtn" type="button"
                        onclick="window.location.href='/';">돌아가기
                </button>
            </form>
        </div>

</main>

<footer class="my-5 pt-5 text-body-secondary text-center text-small">
    <p class="mb-1">&copy; 2017–2024 Company Name</p>
    <ul class="list-inline">
        <li class="list-inline-item"><a href="#">Privacy</a></li>
        <li class="list-inline-item"><a href="#">Terms</a></li>
        <li class="list-inline-item"><a href="#">Support</a></li>
    </ul>
</footer>
</div>
<script src="/assets/dist/js/bootstrap.bundle.min.js"></script>

<script src="/js/signUp.js"></script>
</body>

</html>