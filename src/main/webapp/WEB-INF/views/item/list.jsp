<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상품 목록</title>
</head>
<body>
<c:import url="../headerA.jsp" />
	<h1>상품 목록</h1>
	<hr>
<table>
	<tr>
		<th class="category">카테고리</th>
		<th class="name">상품명</th>
		<th class="image" >상품 이미지 </th>
		<th class="price" >가격 </th>

	</tr>
	<c:forEach var="item" items="${list}">
		<tr>
			<td>${item.category}</td>
			<td><a href="item?itemId=${item.itemId}">${item.name}</a>
			</td>
			<td><img src="${item.imagePath}" alt="${item.image}" width="100" height="100"></td>
			<td>${item.price}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>