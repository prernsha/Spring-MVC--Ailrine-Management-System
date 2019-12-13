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
		<h3 style="text-align: center;">Updated Successfully!! Please Find the updated details below</h3>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<table border="1" style="text-align: center;">
			<thead>
	            
		         <th>Flight ID </th>
		         <th>Source Airport </th>
	            <th>Departure Date</th>
	            <th>Departure Time</th>
	            <th>Destination Airport</th>
	            <th>Arrival Date</th>
	            <th>Arrival Time </th>
	            <th>Fare</th>
	            
        	</thead>
        	
        	<tbody>
        
            <tr>
                <td>${updatedSchedule.getFlightId()}</td>
                <td>${updatedSchedule.getSourceAirport()}</td>
                <td>${updatedSchedule.getDepartureDate()}</td>
                <td>${updatedSchedule.getDepartureTime()}</td>
                <td>${updatedSchedule.getDestinationAirport()}</td>
                <td>${updatedSchedule.getArrivalDate()}</td>
                <td><${updatedSchedule.getArrivalTime()}</td>
                <td>${updatedSchedule.getFare()}</td>

                </tr>
        
       </tbody>
		</table></br></br>
		
		<table align="center">
           <tr><td><form action="${contextPath}/logout">
            <input type="submit" value="Logout"/>
        </form></td></tr>
        </table>
		
</body>
</html>