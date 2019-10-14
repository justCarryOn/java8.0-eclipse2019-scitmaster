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


	
		상품명 : ${product.name}<br>
		수량 : ${product.quantity}<br>
		가격 : ${product.price}<br>
		상품설명 : <br>${product.comments}
		<br>
	<b style="color:red;">${message}</b>
	<form action="/Shop/CustomerAction" method="post">
		<input type="hidden" value="buyProduct" name="action">
		<input type="hidden" value="${product.productSeq}" name="productSeq">
		수량: <input type="number" name="quantity">
		<br><input type="submit" value="구매">
	</form>
	

<h2><a href="index.jsp">홈으로</a></h2>
</body>
</html>