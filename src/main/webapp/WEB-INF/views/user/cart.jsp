<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="light">
<head>
    <meta charset="UTF-8">
    <script src="../assets/js/color-modes.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>장바구니</title>
</head>
<body>
<c:import url="../header.jsp"/>
<div class="container-md">
<h1>장바구니</h1>
<table class="table table-hover">
    <thead>
    <tr>
        <th>상품명</th>
        <th>상품 이미지</th>
        <th>가격</th>
        <th>수량</th>
        <th>선택</th>
    </tr>
    </thead>
    <tbody id="cartItems">
    <c:forEach var="item" items="${itemsInCart}">
        <tr>
            <td>${item.name}</td>
            <td><img src="${item.imagePath}" alt="${item.image}" width="100" height="100"></td>
            <td>${item.price}</td>
            <td>${item.cartItemQuantity}</td>
            <td><input type="checkbox" class="itemCheckbox" data-price="${item.price}"
                       data-quantity="${item.cartItemQuantity}" checked></td>
            <td>
                <button class="removeItemBtn" data-itemId="${item.itemId}" data-id="${id}">제거</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div id="summary">
    총 수량: <span id="totalQuantity">0</span><br>
    총 금액: <span id="totalPrice">0</span>
</div>
<button id="purchaseBtn" onclick="purchaseItems()">선택한 상품 구매하기</button>
</div>

<script>
    // 각 아이템의 수량과 가격을 가져와서 총 수량과 총 금액을 계산하는 함수
    function calculateTotal() {
        let totalQuantity = 0;
        let totalPrice = 0;
        const items = document.querySelectorAll("#cartItems tr");
        items.forEach(function (itemRow) {
            const isChecked = itemRow.querySelector(".itemCheckbox").checked;
            if (isChecked) {
                const quantity = parseInt(itemRow.querySelector("td:nth-child(4)").textContent);
                const price = parseFloat(itemRow.querySelector("td:nth-child(3)").textContent);
                totalQuantity += quantity;
                totalPrice += quantity * price;
            }
        });
        // 계산된 총 수량과 총 금액을 HTML 요소에 반영
        document.getElementById("totalQuantity").textContent = totalQuantity;
        document.getElementById("totalPrice").textContent = totalPrice.toFixed(2); // 소수점 2자리까지 표시
    }

    // 페이지 로드 시 총 수량과 총 금액 계산
    window.onload = calculateTotal;

    // 체크박스 상태 변경 시 총 수량과 총 금액 재계산
    const checkboxes = document.querySelectorAll(".itemCheckbox");
    checkboxes.forEach(function (checkbox) {
        checkbox.addEventListener("change", function () {
            calculateTotal();
        });
    });
    // 페이지 로드 시 실행
    window.onload = function () {
        // 제거 버튼 클릭 이벤트 처리
        const removeButtons = document.querySelectorAll('.removeItemBtn');
        removeButtons.forEach(button => {
            button.addEventListener('click', function () {
                const itemId = button.getAttribute('data-itemId');
                const id = button.getAttribute('data-id');
                deleteCartItem(id, itemId);
            });
        });

        // 총 수량과 총 금액 계산
        calculateTotal();
    };

    // 상품 제거 함수
    function deleteCartItem(id, itemId) {
        // Ajax 요청
        const xhr = new XMLHttpRequest();
        xhr.open('POST', '/deleteCartItem');
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.onload = function () {
            if (xhr.status === 200) {
                // 제거 성공 시 페이지 새로고침
                window.location.reload();
                // 총 수량과 총 금액 재계산
                calculateTotal();
            } else {
                // 오류 처리
                console.error('상품 제거 실패');
            }
        };
        xhr.send(JSON.stringify({id: id, itemId: itemId}));
    }

    // 현재 페이지의 URL에서 userId를 가져오기
    // const id = window.location.pathname.split('/')[2];
    const id = ${id}

    // 선택한 상품 구매 함수
    function purchaseItems() {
        const selectedItems = [];
        const items = document.querySelectorAll("#cartItems tr");
        items.forEach(function (itemRow) {
            const isChecked = itemRow.querySelector(".itemCheckbox").checked;
            if (isChecked) {
                const itemId = itemRow.querySelector(".removeItemBtn").getAttribute('data-itemId');
                const itemName = itemRow.querySelector("td:nth-child(1)").textContent;
                const itemImage = itemRow.querySelector("td:nth-child(2) img").getAttribute('alt');
                const itemImagePath = itemRow.querySelector("td:nth-child(2) img").src;
                const itemPrice = parseFloat(itemRow.querySelector("td:nth-child(3)").textContent);
                const itemCount = parseInt(itemRow.querySelector("td:nth-child(4)").textContent);
                selectedItems.push({
                    id: id,
                    itemId: itemId,
                    itemName: itemName,
                    image: itemImage,
                    imagePath: itemImagePath,
                    itemPrice: itemPrice,
                    itemCount: itemCount
                });
            }
        });


        // Ajax 요청으로 선택한 상품 정보를 서버로 전송
        const xhr = new XMLHttpRequest();
        xhr.open('POST', '/user/' + id + '/order');
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.onload = function () {
            if (xhr.status === 200) {
                // 성공 시 처리
                console.log('구매 성공');
                window.location.href = '/order';

            } else {
                // 오류 처리
                console.error('구매 실패');
            }
        };
        xhr.send(JSON.stringify(selectedItems));
    }
</script>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>