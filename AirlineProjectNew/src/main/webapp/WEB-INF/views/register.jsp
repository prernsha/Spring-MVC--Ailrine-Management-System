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

<h3 style="text-align: center">Registration Form</h3>
	<form:form action="${contextPath}/registerUser" modelAttribute="user">
	
         <table align="center" style="text-align: center">       
                    <tr><td><label> Username :  </label><form:input placeholder="max 6 characters"  pattern="^[A-Za-z\\s]{1,6}$" path="username" required="required"/></td></tr>
                    <tr><td><label> Password :  </label><form:input placeholder="Enter the password" path="password" type="password" required="required"/></td></tr>
                   
                    <tr><td><form:radiobutton path="type" value="admin" label="Admin" required="required"/>
                            <form:radiobutton path="type"  value="customer" label="Customer"/></td></tr></br></br>
                        
                   <tr><td> <input type="submit"  value="Register"/></td></tr>
               </table>
              
        </form:form>
		
	
	
</body>
</html>