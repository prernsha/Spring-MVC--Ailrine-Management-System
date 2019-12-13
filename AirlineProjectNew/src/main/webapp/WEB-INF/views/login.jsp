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

<h3 style="text-align: center" >Airline Management/Booking System</h3>
<form:form action="${contextPath}/check" modelAttribute="user">
         <table align="center" style="text-align: center">       
                    <tr><td><label> Username :  </label><form:input  pattern="^[A-Za-z\\s]{1,6}$" placeholder="Enter your username" path="username" required="required"/></td></tr>
                    <tr><td><label> Password :  </label><form:input placeholder="Enter your password" path="password" type="password" required="required"/></td></tr>
                   
                    <tr><td><form:radiobutton path="type" value="admin" label="Admin" required="required"/>
                            <form:radiobutton path="type" value="customer" label="Customer"/></td></tr></br></br>
                        
                   <tr><td> <input type="submit"  value="Login" id="login" name="checkButton"/></td></tr>
                   
               </table>
               
        </form:form></br>
        <table align="center"> 
         <tr>
	         <td><form action="${contextPath}/check" >
	         <input type="submit"  value="Register" name="checkButton"/>
         
         </form></td>
         </tr>
         </table> 
     
     
</body>
</html>