<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table
	{
		border-collapse: collapse;
	}
</style>
</head>
<body>

  <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <h2 style="text-align: center">Here are your search Results!!</h2></br>
    
        <h2 style="text-align: center">Please select the row for booking the flight!!</h2></br>
    
     <table border="1" align="center" style="text-align: center" >
       
       <c:if test="${not empty flightsList}">
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
        
      </c:if>
      <c:if test="${empty flightsList}">
            <h3>No matching flight schedule found. Please try again !!</h3>
	  </c:if>
      
      <tbody>
        <c:forEach var="searchList" items="${flightsList}">
            <tr>
                <td><a href= "${contextPath}/continue?flightId=${searchList.getFlightId()}"><c:out value="${searchList.getFlightId()}"/></a></td>
                <td><a href= "${contextPath}/continue?flightId=${searchList.getFlightId()}"><c:out value="${searchList.getSourceAirport()}"/></a></td>
                <td><a href= "${contextPath}/continue?flightId=${searchList.getFlightId()}"><c:out value="${searchList.getDepartureDate()}"/></a></td>
                <td><a href= "${contextPath}/continue?flightId=${searchList.getFlightId()}"><c:out value="${searchList.getDepartureTime()}"/></a></td>
                <td><a href= "${contextPath}/continue?flightId=${searchList.getFlightId()}"><c:out value="${searchList.getDestinationAirport()}"/></a></td>
                <td><a href= "${contextPath}/continue?flightId=${searchList.getFlightId()}"><c:out value="${searchList.getArrivalDate()}"/></a></td>
                <td><a href= "${contextPath}/continue?flightId=${searchList.getFlightId()}"><c:out value="${searchList.getArrivalTime()}"/></a></td>
                <td><a href= "${contextPath}/continue?flightId=${searchList.getFlightId()}"><c:out value="${searchList.getFare()}"/></a></td>

                </tr>
        </c:forEach>
       </tbody>
       
     </table></br></br>   
    	<table align="left">
           <tr><td><form action="${contextPath}/logout">
            <input type="submit" value="Logout"/>
        </form></td></tr>
        </table>
        
</body>
</html>






