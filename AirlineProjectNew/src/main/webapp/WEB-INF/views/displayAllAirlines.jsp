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
	
	<h3 style="text-align: center"> All airlines Below</h3>
	<table border="2" style="text-align: center" align="center">
        <c:if test="${not empty airlineList}">
            <thead>
	            
	             <th>Airline Id</th>
	            <th>Airline Name</th>
           
        	</thead>
        
      </c:if>
      <tbody>
           
            <c:forEach var="list" items="${airlineList}"> 
                <tr>
                <td><c:out value="${list.getAirlineId()}"/></td>
                <td><c:out value="${list.getAirlineName()}"/></td>
                </tr>
                 
            </c:forEach>

        </tbody>
        
       </table> </br></br>
       
       <form action="${contextPath}/logout">
            
            <input type="submit" value="Logout"/>
        </form>
        
       
</body>
</html>