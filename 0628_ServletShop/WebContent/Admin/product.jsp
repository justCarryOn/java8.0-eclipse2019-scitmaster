<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품목록</title>
</head>
<body>

	<form action="/Shop/AdminAction" method="get">
		<input type="hidden" value="goInsertProduct" name="action">
		<button>상품등록</button>
	</form>

	
	<table>
	<c:forEach items="${pList}" var="product">
	<tr>
	<td>${product.productSeq}</td>
	<td><a href="/Shop/AdminAction?action=update&productSeq=${product.productSeq}" >${product.name}</a></td>
	<td>${product.indate}</td>
	<td>${product.name}</td>
	</tr>
	</c:forEach>
	</table>


<h2><a href="Admin/index.jsp">홈으로</a></h2>

</body>
</html>