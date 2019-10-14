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
		<input type="hidden" value="insertProduct" name="action">
		상품명 : <input type="text" name="name" value="${product.name}"><br>
		수량 : <input type="number" name="quantity" value="${product.quantity}"><br>
		가격 : <input type="number" name="price" value="${product.price}"><br>
		상품설명 : <br><textarea rows="10" cols="30" name="comments">${product.comments}</textarea>
		
		<br><input type="submit" value="상품등록">
	</form>
	

<h2><a href="/Shop/Admin/index.jsp">홈으로</a></h2>
</body>
</html>