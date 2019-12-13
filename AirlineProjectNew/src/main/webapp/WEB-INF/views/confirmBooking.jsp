<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4 style="text-align: center">Please confirm the flight schedule below</h4>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form action="${contextPath}/bookingConfirm" method="GET">
	<table border="1" style="text-align: center" align="center">
       
       <c:if test="${not empty schedule}">
            <thead>
	            
	            <th>Airline Name</th>
		         <th>Flight ID </th>
		         <th>Source Airport </th>
	            <th>Departure Date</th>
	            <th>Departure Time</th>
	            <th>Destination Airport</th>
	            <th>Arrival Date</th>
	            <th>Arrival Time </th>
	            <th>Fare</th>
	            
        	</thead>
        
      </c:if>
      
      <tbody>
       
            <tr>
            	<td><c:out value="${requestScope.airlineName}"/></td>
                <td><c:out value="${schedule.getFlightId()}"/></td>
                <td><c:out value="${schedule.getSourceAirport()}"/></td>
                <td><c:out value="${schedule.getDepartureDate()}"/></td>
                <td><c:out value="${schedule.getDepartureTime()}"/></td>
                <td><c:out value="${schedule.getDestinationAirport()}"/></td>
                <td><c:out value="${schedule.getArrivalDate()}"/></td>
                <td><c:out value="${schedule.getArrivalTime()}"/></td>
                <td><c:out value="${schedule.getFare()}"/></td>

                </tr>
        
       </tbody>
       
     </table></br></br>
     
     <input type="hidden" value="${requestScope.passengerId}" name="passengerId"/>
     <input type="hidden" value="${requestScope.flightId}" name="flightId"/>
     <input type="hidden" value="${requestScope.airlineName}" name="airlineName"/>
     <input type="submit" value="Confirm Booking"/>
	</form></br></br>
	
	
</body>
</html>





