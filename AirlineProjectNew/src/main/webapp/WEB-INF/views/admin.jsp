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

	<h1 style="text-align: center"> Manage Airlines/Schedules </h1>
	<table border=1 align="center">
	<tr>
	<td> Click Here to <a href="${contextPath}/AddAirline.htm">Add/Delete Airline</a> </td>
	</tr>
	<tr>
	<td> Click Here to <a href="${contextPath}/retrieveAllAirlines">Retrieve All Airlines</a> </td>
	</tr>
	<tr>
	<td> Click Here to <a href="${contextPath}/update">Update Schedule</a> </td>
	</tr>
	</table>
	
</body>
</html>