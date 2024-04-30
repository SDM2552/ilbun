<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" data-bs-theme="light">
<head>
	<meta charset="UTF-8">
	<script src="../assets/js/color-modes.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

	<title>주문 완료</title>
</head>
<body>
	<c:import url="../header.jsp" />
	<div class="container">
	<h1>주문 완료</h1>
	<hr>
	<table class="table table-hover">
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
	<h2>주문이 완료되었습니다!</h2>
	<hr>
		<button onclick="window.location.href='/user/orderList'">주문 정보 확인</button>
		<button onclick="window.location.href='/'">메인으로</button>
	</div>


<script>
    // 세션에서 selectedItems 속성을 제거하는 함수
    function removeSelectedItemsFromSession() {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "/removeSelectedItemsFromSession");
        xhr.onload = function() {
            if (xhr.status === 200) {
                console.log("selectedItems 세션 속성이 제거되었습니다.");
            } else {
                console.error("selectedItems 세션 속성 제거 요청이 실패했습니다.");
            }
        };
        xhr.onerror = function() {
            console.error("selectedItems 세션 속성 제거 요청이 실패했습니다.");
        };
        xhr.send();
    }
    // 페이지가 로드될 때 호출되는 함수
    window.onload = function() {
        removeSelectedItemsFromSession();
    }
</script>

</body>
</html>