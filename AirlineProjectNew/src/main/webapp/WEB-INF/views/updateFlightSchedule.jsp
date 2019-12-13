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

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<h3 style="text-align: center">List of Flight and their Schedules</h3>
	<table border="1" align="center" style="text-align: center" >
	
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
        <c:forEach var="flightList" items="${flightScheduleList}">
            <tr>
                <td><c:out value="${flightList.getFlightId()}"/></a></td>
                <td><c:out value="${flightList.getSourceAirport()}"/></a></td>
                <td><c:out value="${flightList.getDepartureDate()}"/></a></td>
                <td><c:out value="${flightList.getDepartureTime()}"/></a></td>
                <td><c:out value="${flightList.getDestinationAirport()}"/></a></td>
                <td><c:out value="${flightList.getArrivalDate()}"/></a></td>
                <td><c:out value="${flightList.getArrivalTime()}"/></a></td>
                <td><c:out value="${flightList.getFare()}"/></a></td>
                <td><a href="${contextPath}/getScheduleForFlight?flightId=${flightList.getFlightId()}">Update</a></td>

                </tr>
        </c:forEach>
       </tbody>
        	
	</table>
	<table align="center">
	
       <tr><td><form action="${contextPath}/logout">
            
            <input type="submit" value="Logout"/>
        </form>
        <form action="${contextPath}/admin">
            
            <input type="submit" value="Back"/>
        </form></td></tr>
        
     </table>


</body>
</html>