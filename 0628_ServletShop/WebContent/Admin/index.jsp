<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SimpleMarket</title>
</head>
<body>

	<h1>${sessionScope.adminId}</h1>
	
	
	<c:if test="${sessionScope.adminId==null}">
	<a href="/Shop/AdminAction?action=goLogin">로그인하기</a>
	</c:if>
	
	<c:if test="${sessionScope.adminId!=null}">
	
	<a href="/Shop/AdminAction?action=goProduct">상품관리</a>
	<a href="/Shop/AdminAction?action=goSoldProduct">판매내역관리</a>
	<a href="/Shop/AdminAction?action=logout">로그아웃</a>
	</c:if>
	
</body>
</html>








