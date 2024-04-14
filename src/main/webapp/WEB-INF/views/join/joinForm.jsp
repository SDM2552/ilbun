<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 가입</title>
</head>
<body>
<c:import url="../header.jsp" />
<h1>회원 가입</h1>
<hr>
<form action="join" method="post">
    아이디: <input type="text" name="userId" placeholder="ID 입력"><br>
    비밀번호: <input type="password" name="password" placeholder="비밀번호 입력"><br>
    이름: <input type="text" name="name" placeholder="이름 입력"><br>
    이메일: <input type="text" name="email" placeholder="이메일 입력"><br>
    주소: <input type="text" name="address" placeholder="주소 입력(선택사항)"><br>
    <button type="submit">가입</button>
</form>
</body>
</html>