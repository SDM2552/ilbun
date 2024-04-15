<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>첫 페이지</title>
</head>
<body>
<c:import url="header.jsp" />
<h1>메인 페이지</h1>
<hr>
<a href="item/list">상품 목록</a><br>
<a href="item/addItems">상품 등록</a><br>
<a href="cart">장바구니</a><br>
<a href="buyPage">구매하기</a><br>
<a href="user/login">로그인</a><br>
<a href="MyPage/orderList">주문 확인</a><br>
<a href="join">회원가입</a><br>
<a href="admin">관리자 페이지</a><br>


</body>
</html>