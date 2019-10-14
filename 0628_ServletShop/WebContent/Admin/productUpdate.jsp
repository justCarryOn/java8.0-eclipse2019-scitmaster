<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품등록</title>
</head>
<body>


	<form action="/Shop/AdminAction" method="post">
	<input type="hidden" name="productSeq" value="${product.productSeq}">
		<input type="hidden" value="updateProduct" name="action">
		상품명 : ${product.name}<br>
		수량 : <input type="number" name="quantity" value="${product.quantity}"><br>
		가격 : ${product.price}<br>
		상품설명 : ${product.comments}<br>
		
		<br><input type="submit" value="수량수정">
	</form>
	

</body>
</html>