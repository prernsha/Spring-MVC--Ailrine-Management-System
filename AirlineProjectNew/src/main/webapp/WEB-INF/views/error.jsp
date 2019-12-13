<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section>
		<h3 style="color: red">Error!!! ${eMsg}</h3>
	</section>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<a href="${contextPath}/login">Try Again!!!Back To Login</a>
</body>
</html>