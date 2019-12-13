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
	<h1 style="text-align: center;">Update Flight Schedule</h1>
	
	
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	
	<div class="container">
	<form action="${contextPath}/updateSchedule" >
	
         <table align="center" style="text-align:center;">  
                    <tr><td><label> Departure Date:  </label><input type="text" value="${flightSchedule.getDepartureDate()}" readonly/></td></tr>
                    <tr><td><label> Arrival Date:  </label><input type="text" value="${flightSchedule.getArrivalDate()}" readonly /></td></tr>
                    <tr><td><label> Departure Time:  </label><input type="text" value="${flightSchedule.getDepartureTime()}" readonly/></td></tr>
                    <tr><td><label> Arrival Time:  </label><input type="text" value="${flightSchedule.getArrivalTime()}" readonly/></td></tr>
                    <tr><td><label> Source Airport:  </label><input type="text" value="${flightSchedule.getSourceAirport()}" readonly/></td></tr>
                    <tr><td><label> Destination Airport:  </label><input type="text" placeholder="to" name="destinationAirport" required="required"/></td></tr>
                    <tr><td><label> Fare:  </label><input type="text" placeholder="value >= 1000" pattern="[1-9][0-9]{3,}" name="fare" required="required"/></td></tr>
                    <tr><td><label> Total Number of Seats:  </label><input type="text" value="${flightSchedule.getNoOfSeats()}" readonly/></td></tr>
                    <tr><td><label> Available Number of Seats:  </label><input type="text" value="${flightSchedule.getAvailSeats()}" readonly/></td></tr>
                    
                    <input type="hidden" value="${requestScope.flightId}" name="flightId"/>     
                   <tr><td> <input type="submit"  value="Update Flight Schedule"/></td></tr>
               </table>
            
        </form>
        </div>
	
</body>
</html>