<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>상품 페이지</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="/css/styles.css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>


<!-- 헤더-->
<c:import url="../header.jsp" />
<!-- 메인화면-->
<section class="py-5">
    <div class="container px-4 px-lg-5 my-5">
        <form action="/addToCart" method="post">
        <div class="row gx-4 gx-lg-5 align-items-center">
            <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0"
                                       src="${item.imagePath}" alt="${item.image}"
                                       style="width:350px; height: 350px; object-fit: cover;" />
            </div>
            <div class="col-md-6">
                <h1 class="display-5 fw-bolder">${item.name} </h1>
                <div class="fs-5 mb-5">

                    <span class="priceText" >${item.price} 원</span>
                </div>
                    <span>${item.description}</span>

                <hr class="my-4">


                <div class="input-group fs-5 mb-5">
                    <div class="input-group-prepend">
                        <span class="input-group-text">주문 수량</span>
                    </div>
                    <input class="form-control text-center me-3" id="count" name="count" type="number" value="1"
                           style=" max-width: 5rem" />
                </div>


                <div class="container bg-light">
                    <h6>총 상품 금액</h6>
                    <h4 name="totalPrice" id="totalPrice" class="font-weight-bold"></h4>
                </div>
                <br>
                <input type="hidden" id="userId" value="${userId}">
                <input type="hidden" name="itemId" value="${item.itemId}">
                <div class="d-flex">
                    <form th:action="@{/logout}" class="d-flex" method="post">
                        <button class="btn btn-outline-dark" type="submit">
                            바로 구매하기
                        </button>
                    </form>
                    &nbsp
                    <button class="btn btn-outline-dark flex-shrink-0" type="submit" id="addToCartBtn">
                        <i class="bi-cart-fill me-1"></i>
                        장바구니 담기
                    </button>
                </div>
            </div>
        </div>
        </form>

    </div>
</section>

<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Roominis</p>
    </div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<script>
    window.onload = function() {
        // 상품 가격과 수량 입력 필드를 가져옵니다.
        var priceText = document.querySelector('.priceText').innerText;
        var price = parseFloat(priceText.replace(' 원', ''));
        var countInput = document.getElementById('count');


        // 총 상품 금액을 계산하고 출력하는 함수입니다.
        var calculateAndDisplayTotalPrice = function() {
            var count = parseInt(countInput.value);
            var totalPrice = price * count;
            document.getElementById('totalPrice').innerText = totalPrice + ' 원';
        };
        // 페이지 로드 시 총 상품 금액을 계산하고 출력합니다.
        calculateAndDisplayTotalPrice();
        // 수량 입력 필드의 값이 변경될 때마다 총 상품 금액을 계산하고 출력합니다.
        countInput.addEventListener('change', calculateAndDisplayTotalPrice);
    };
</script>
<script>
    $(document).ready(function() {
        $('#addToCartBtn').click(function(e) {
            e.preventDefault();

            var itemId = $('input[name="itemId"]').val();
            var count = $('#count').val();
            var userId = $('#userId').val();

            $.ajax({
                url: '/addToCart',
                type: 'POST',
                data: {
                    itemId: itemId,
                    count: count,
                    userId: userId
                },
                success: function(response) {
                    if (response === "Success") {
                        var confirmResult = confirm("상품이 장바구니에 담겼습니다. 지금 확인하시겠습니까?");
                        if (confirmResult) {
                            window.location.href = "/user/" + userId + "/cart";
                        }
                    } else {
                        alert('장바구니에 상품을 추가하는 데 실패했습니다.');
                    }
                },
                error: function(error) {
                    alert('장바구니에 상품을 추가하는 데 실패했습니다.');
                }
            });
        });
    });

</script>
</body>

</html>

