<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form
	{
		align-content: center;
	}
</style>
</head>
<body>

	<h1 style="text-align: center;"> Search Flights</h1>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	
		<form action="${contextPath}/searchFlights">
			<table align="center" style="text-align: center">
			<tr>
			<td><label> Source Airport: </label><input type="text" name="source" placeholder="Enter the source airport" required="required"/></td></tr>
			<tr><td><label> Destination Airport: </label><input type="text" name="destination"  placeholder="Enter the destination airport" required="required"/></td></tr>
			<tr><td>Departure Date: </label><input type="text" pattern="([2][0](1[9]|2[01])-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))" placeholder="YYYY-MM-DD" name="departureDate" required="required"/></td></tr>
			<tr><td>Arrival Date: </label><input type="text" pattern="([2][0](1[9]|2[01])-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))" placeholder="YYYY-MM-DD" name="arrivalDate" /></td></tr>
			<tr><td><input type="submit" value="Search"/> </td></tr>
			</table>
	</form>
		
</body>
</html>