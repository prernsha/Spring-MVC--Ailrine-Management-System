<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<h3>Username "<b>${requestScope.user.username}</b>" successfully registered</h3><br><br>
	
	
	<b><a href="${contextPath}/login">Back to Login</a></b>
	
</body>
</html>