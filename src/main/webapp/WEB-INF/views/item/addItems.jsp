<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 등록</title>
</head>
<body>
<c:import url="../headerA.jsp"/>
<h1>상품 등록</h1>
<hr>
<form action="add" method="post" enctype="multipart/form-data">
    <label for="category">카테고리:</label>
    <select name="category" id="category">
        <option value="야채">야채</option>
        <option value="과일">과일</option>
        <option value="육류">육류</option>
        <option value="해산물">해산물</option>
        <option value="건조식품">건조식품</option>
        <option value="음료">음료</option>
        <option value="기타">기타</option>
    </select><br>
    상품명: <input type="text" name="name" placeholder="상품명 입력"><br>
    가격: <input type="text" name="price" placeholder="가격 입력"><br>
    수량: <input type="text" name="quantity" placeholder="수량 입력"><br>
    설명: <input type="text" name="description" placeholder="상품 설명(선택사항)"><br>
    이미지: <input type="file" id="imgFile" name="imgFile"><br>
    <button type="submit">등록</button>
</form>
</body>
</html>