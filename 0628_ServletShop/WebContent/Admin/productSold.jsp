<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내구매내역</title>
</head>
<body>
	<h1>내구매내역</h1>
	<table>
	<tr>
	<td>상품명</td>
	<td>구매자</td>
	<td>구매일자</td>
	<td>상품단가</td>
	<td>상품수량</td>
	<td>구매액</td>
	</tr>
	<c:forEach items="${pList}" var="product">
	<tr>
	<td>${product.name}</td>
	<td>${product.customerId}</td>
	<td>${product.indate}</td>
	<td>${product.price}</td>
	<td>${product.quantity}</td>
	<td>${product.quantity*product.price}</td>
	</tr>
	</c:forEach>
	</table>


<h2><a href="Admin/index.jsp">홈으로</a></h2>

</body>
</html>