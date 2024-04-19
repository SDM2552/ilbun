<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="en" data-bs-theme="light">


    <script src="../assets/js/color-modes.js"></script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.122.0">
    <title>Headers · Bootstrap v5.3</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/headers/">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/headers.css" rel="stylesheet">




<main>
    <nav class="py-2 bg-body-tertiary border-bottom">
        <div class="container d-flex flex-wrap">
            <ul class="nav me-auto">
                <li class="nav-item"><a href="/" class="nav-link link-body-emphasis px-2 active" aria-current="page">처음으로</a>
                </li>
                <c:choose>
                    <c:when test="${not empty SPRING_SECURITY_CONTEXT}">
                        <li class="nav-item">
                            <a href="/cart" class="nav-link link-body-emphasis px-2">장바구니</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <a href="/user/login" class="nav-link link-body-emphasis px-2">장바구니</a>
                    </c:otherwise>
                </c:choose>


                <li class="nav-item"><a href="/user/orderList" class="nav-link link-body-emphasis px-2">마이페이지</a></li>
                <li class="nav-item"><a href="#" class="nav-link link-body-emphasis px-2">고객센터</a></li>
            </ul>
            <ul class="nav">
                <c:choose>
                    <c:when test="${not empty SPRING_SECURITY_CONTEXT}">
                    <li class="nav-item"><a href="#" class="nav-link link-body-emphasis px-2"><sec:authentication property="principal.name"/> 님 환영합니다.</a></li>
                        <li class="nav-item"><a href="/logout" class="nav-link link-body-emphasis px-2">로그아웃</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item"><a href="/user/login" class="nav-link link-body-emphasis px-2">로그인</a></li>
                        <li class="nav-item"><a href="/join" class="nav-link link-body-emphasis px-2">회원 가입</a></li>
                    </c:otherwise>
                </c:choose>


            </ul>
        </div>
    </nav>
    <header class="py-3 mb-4 border-bottom">
        <div class="container d-flex flex-wrap justify-content-center">
            <a href="/" class="d-flex align-items-center mb-3 mb-lg-0 me-lg-auto link-body-emphasis text-decoration-none">
                <svg class="bi me-2" width="40" height="32">
                    <use xlink:href="#bootstrap" />
                </svg>
                <span class="fs-4">1인분 마트</span>
            </a>
            <form class="col-12 col-lg-auto mb-3 mb-lg-0" role="search">
                <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
            </form>
        </div>
    </header>
    <script>
        window.addEventListener("DOMContentLoaded", (event) => {
            const logoutButton = document.getElementById('logout');
            if (logoutButton) {
                logoutButton.addEventListener('click', function(event) {
                    var confirmed = confirm('로그아웃 하시겠습니까?');
                    if (confirmed) {
                        // AJAX 요청으로 로그아웃 처리
                        fetch('/logout', { method: 'POST' })
                            .then(function(response) {
                                if (response.ok) {
                                    alert('로그아웃 되었습니다');
                                    window.location.href = '/';
                                } else {
                                    alert('로그아웃에 실패하였습니다');
                                }
                            });
                    }
                });
            }
        });
    </script>
</main>


