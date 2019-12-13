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

	<h3 style="text-align: center"> Add Airline Details </h3>
	
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<form:form action="${contextPath}/add" modelAttribute="airline">
	
         <table align="center">       
                    <tr><td><label> Airline Name :  </label><form:input placeholder="airline name" path="airlineName" required="required"/></td></tr>
                         
                   <tr><td style="text-align: left"> <input type="submit"  value="Add Airline" name="operation"/></td></tr>
               </table>
            
        </form:form></br></br>
        
        <h5 style="text-align: center">Please select the airline Name to add its schedule</h5>
        <table border="2" align="center">
        	
        <c:if test="${not empty airlineList}">
            <thead>
	            
	            <th>Airline Id</th>
	            <th>Airline Name</th>
            
        	</thead>
        
      </c:if>
      <tbody>
           
            <c:forEach var="list" items="${airlineList}"> 
                <tr>
	                <td><c:out value="${list.getAirlineId()}"/>
	                <td><a href="${contextPath}/AddFlightSchedule.htm?airlineID=${list.getAirlineId()}"><c:out value="${list.getAirlineName()}"/></a></td>
	                <td><a href="${contextPath}/DeleteAirline.htm?airlineID=${list.getAirlineId()}">Delete</a></td>
	                   
                </tr>
             </c:forEach>

        </tbody>
        
       </table></br></br>
       
       <table align="center">
       	<tr><td><form action="${contextPath}/logout">
            
            <input type="submit" value="Logout"/></form>
            </td></tr>
        
     	</table>
    
</body>
</html>