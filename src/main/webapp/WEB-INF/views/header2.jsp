<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="navbar-header">
    <c:choose>
        <c:when test="${not empty SPRING_SECURITY_CONTEXT}">
            <span><sec:authentication property="principal.username"/> 님 환영합니다. <a class="navbar-brand" href="logout">로그아웃</a>
        </c:when>
        <c:otherwise>
            <a class="navbar-brand" href="#">회원가입</a>
            <a class="navbar-brand" href="/user/login">로그인</a>
        </c:otherwise>
    </c:choose>

    <a class="navbar-brand" href="#">고객센터</a>
</div>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="#!">마트</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">상품 목록</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">전체보기</a></li>
                        <li>
                            <hr class="dropdown-divider" />
                        </li>
                        <li><a class="dropdown-item" href="#!">야채</a></li>
                        <li><a class="dropdown-item" href="#!">과일</a></li>
                        <li><a class="dropdown-item" href="#!">육류</a></li>
                        <li><a class="dropdown-item" href="#!">냉동·건조식품</a></li>
                        <li><a class="dropdown-item" href="#!">과일2</a></li>
                        <li><a class="dropdown-item" href="#!">과일3</a></li>
                        <li><a class="dropdown-item" href="#!">과일4</a></li>
                        <li><a class="dropdown-item" href="#!">디저트</a></li>

                    </ul>
                </li>
            </ul>
            <form class="d-flex">
                <button class="btn btn-outline-dark" type="submit">
                    <i class="bi-cart-fill me-1"></i>
                    Cart
                    <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                </button>
            </form>


            <hr>

            <script>
                window.onload = function() {
                    var logoutButton = document.getElementById('logout');
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
                };
            </script>

        </div>
    </div>
</nav>