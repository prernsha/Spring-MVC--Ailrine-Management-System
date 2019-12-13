<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Welcome to Airline Management System 
</h1>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	

	<b><a href="${contextPath}/login">Login Page</a></b>
           
</body>
</html>
