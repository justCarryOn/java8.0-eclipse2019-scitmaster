<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>~~상수의 자바나라~~</title>
</head>
<body>

	<h1>${sessionScope.loginId}</h1>
	
	
	<c:if test="${sessionScope.loginId==null}">
	<a href="signup.jsp">회원가입하기</a>
	<a href="login.jsp">로그인하기</a>
	</c:if>
	
	<c:if test="${sessionScope.loginId!=null}">
	
	<a href="boardAction?action=board">게시판 이동</a>
	<a href="deletemember.jsp">탈퇴하기</a>
	<a href="frontAction?action=logout">로그아웃</a>
	</c:if>
	
</body>
</html>








