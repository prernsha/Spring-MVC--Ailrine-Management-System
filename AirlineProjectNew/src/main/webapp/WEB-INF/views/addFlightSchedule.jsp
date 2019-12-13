<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

.container {
  
  align-content: center
 
}



</style>

</head>
<body>
	
	<h1 style="text-align: center"> Add Airline Details </h1>
	
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div class="container">
	<form:form action="${contextPath}/addSchedule" modelAttribute="fs">
	
         <table align="center">  
                    <tr><td><label> Departure Date:  </label><form:input pattern="([2][0](1[9]|2[01])-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))" placeholder="YYYY-MM-DD" path="departureDate" required="required"/></td></tr>
                    <tr><td><label> Arrival Date:  </label><form:input pattern="([2][0](1[9]|2[01])-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))" placeholder="YYYY-MM-DD" path="arrivalDate" required="required"/></td></tr>
                    <tr><td><label> Departure Time:  </label><form:input pattern="([0-1]{1}[0-9]{1}|20|21|22|23):[0-5]{1}[0-9]{1}" placeholder="HH:MM " path="departureTime" required="required"/></td></tr>
                    <tr><td><label> Arrival Time:  </label><form:input pattern="([0-1]{1}[0-9]{1}|20|21|22|23):[0-5]{1}[0-9]{1}" placeholder=" HH:MM " path="arrivalTime" required="required"/></td></tr>
                    <tr><td><label> Source Airport:  </label><form:input placeholder="from" path="sourceAirport" required="required"/></td></tr>
                    <tr><td><label> Destination Airport:  </label><form:input placeholder="to" path="destinationAirport" required="required"/></td></tr>
                    <tr><td><label> Fare:  </label><form:input placeholder=" value <= 1000" path="fare" pattern="[1-9][0-9]{3,}" required="required"/></td></tr>
                    <tr><td><label> Total Number of Seats:  </label><form:input placeholder="Value in range 20-40" path="noOfSeats" pattern="[2-3][0-9]{1}|40" required="required"/></td></tr>
                    <tr><td><label> Available Number of Seats:  </label><form:input placeholder="Value in range 1-40" path="availSeats" pattern="^[1-9]$|^[1-2]\d$|^3[0-9]|40$" required="required"/></td></tr>
                    
                    <input type="hidden" value="${requestScope.airlineId}" name="airlineId"/>     
                   <tr><td> <input type="submit"  value="Add Airline Schedule"/></td></tr>
               </table>
            
        </form:form>
        </div>
</body>
</html>