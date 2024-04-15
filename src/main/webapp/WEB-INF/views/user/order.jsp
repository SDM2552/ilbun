<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 페이지</title>
</head>
<body>
	<c:import url="../header.jsp" />
	<h1>결제하기</h1>
	<hr>
	<table>
		<thead>
			<tr>
				<th>상품명</th>
				<th>상품 이미지</th>
				<th>가격</th>
				<th>수량</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${selectedItems}">
				<tr>
					<td>${item.itemName}</td>
					<td><img src="${item.image}" width="100" height="100"
						alt="상품 이미지"></td>
					<td>${item.itemPrice}</td>
					<td>${item.itemCount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr>
	배송지 입력:
	<input type="text" name="adress" placeholder="배송받을 주소를 적어주세요">
	<br> 결제 방식:
	<button>무통장입금</button>
	<button>신용카드</button>
	<hr>
	
	<button id="orderButton">결제하기</button>

	<script>
		document.getElementById("orderButton").addEventListener(
				"click",
				function() {
					var xhr = new XMLHttpRequest();
					xhr.open("POST", "/orderComplete");
					xhr.setRequestHeader("Content-Type",
							"application/json;charset=UTF-8");

					xhr.onload = function() {
						if (xhr.status === 200) {
							console.log("주문이 완료되었습니다.");
							window.location.href = "/orderComplete"; // 페이지 리다이렉트
						} else {
							console.error("주문 요청이 실패했습니다.");
						}
					};

					xhr.onerror = function() {
						console.error("주문 요청이 실패했습니다.");
					};

					xhr.send(); // POST 요청 보내기
				});

	</script>


</body>
</html>