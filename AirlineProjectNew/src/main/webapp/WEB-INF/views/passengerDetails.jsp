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
		<h4 style="text-align: center">Enter Passenger Details</h4>
		
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<form:form modelAttribute="passengerDetails" action="${contextPath}/addPassenger" enctype="multipart/form-data">
	<center>		
			<label> Enter Name:</label><form:input type="text" id="name" path="name" placeholder="Full Name" required="required" /></br>
			<label> Enter Email:</label><form:input type="email" id="email" path="email" pattern="[^(_|\\W)][a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}" placeholder="format abcd@gmail.com" required="required" /></br>
			<label> Recent Id proof in pdf format</label><form:input type="file" id="idProof" path="idProof" required="required" /></br>
			
			<input type="hidden" value="${requestScope.flightId}" name="flightId"/> 
			<input type="submit" name="save" value="Save My Information" />
			
	</center>
			</form:form>
					
</body>
</html>