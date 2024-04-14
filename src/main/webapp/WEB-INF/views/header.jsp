<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<a href="/">메인으로</a>
<c:choose>
    <c:when test="${not empty SPRING_SECURITY_CONTEXT}">
        <span><sec:authentication property="principal.username"/> 님 환영합니다. <button id="logout">로그아웃</button></span>
    </c:when>
    <c:otherwise>
        <button onclick="location.href='/user/login'">로그인</button>
    </c:otherwise>
</c:choose>

<hr>

<script>
    document.getElementById('logout').addEventListener('click', ()=> {window.location.href = '/logout';});
</script>
