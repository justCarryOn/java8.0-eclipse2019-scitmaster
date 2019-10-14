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

	<h1>${sessionScope.loginId}</h1>
	
	
	<c:if test="${sessionScope.loginId==null}">
	<a href="CustomerAction?action=goSignup">회원가입하기</a>
	<a href="CustomerAction?action=goLogin">로그인하기</a>
	</c:if>
	
	<c:if test="${sessionScope.loginId!=null}">
	
	<a href="CustomerAction?action=goProduct">상품보기이동</a>
	<a href="CustomerAction?action=goMyPage">내구매내역</a>
	<a href="CustomerAction?action=goDelete">탈퇴하기</a>
	<a href="CustomerAction?action=logout">로그아웃</a>
	</c:if>
	
</body>
</html>








