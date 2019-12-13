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

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<form:form action="${contextPath}/check" modelAttribute="user">
	<h4 style="text-align: center"> Schedule for <b>"${airlineName}"</b> added successfully !!</h4>
	</form:form>
	<table>
	<tr>
		<td><form action="${contextPath}/logout">
            <input type="submit" value="Logout"/>
        </form></td></tr>
        <tr><td><form action="${contextPath}/AddAirline.htm">
            <input type="submit" value="Add another schedule"/>
    	</form></td></tr>
    <tr>	
    </table>
</body>
</html>