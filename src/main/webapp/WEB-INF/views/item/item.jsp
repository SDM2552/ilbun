<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../header.jsp" />
	<h1>상품 정보</h1>
	<hr>
	<form action="/addToCart" method="post">
	<table>
    <tr>
        <th class="category">카테고리</th>
        <th class="name">상품명</th>
        <th class="image" >상품 이미지 </th>
        <th class="price" >가격 </th>
    </tr>
    <tr>
        <td>${item.category}</td>
        <td>${item.name} </td>
        <td><img src="${item.imagePath}" alt="${item.image}" width="200" height="200"></td>
        <td>${item.price}</td>
    </tr>
	</table>
	수량: <input type="number" name="count" id="countInput" value="1" min="1"><br>
	<input type="hidden" name="itemId" value="${item.itemId}">
	<button type="submit" id="addToCartBtn">장바구니에 추가</button>
	<button onclick="location.href='#'">구매하기</button><br>
	</form>

	
	
</body>
</html>