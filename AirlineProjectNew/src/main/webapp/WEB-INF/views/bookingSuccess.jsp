<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

form
{
	align-self:right;
}
</style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<h1 style="text-align: center;">Booking Done Successfully!!</h1></br>
	
	<h4 style="text-align: center;">An email has been sent to <c:out value="${requestScope.passengerDetails.getEmail()}"/></h4>
	
	<form action="${contextPath}/logout">
            <input type="submit" value="Logout"/>
        </form>
</body>
</html>