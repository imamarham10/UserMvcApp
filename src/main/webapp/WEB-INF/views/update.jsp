<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="user" action="update" method="put">
		<form:label path="id">Id</form:label>
		<form:input path="id"/>
		<form:label path="name">Name</form:label>
		<form:input path="name"/>
		<form:label path="phone">Phone Number</form:label>
		<form:input path="phone"/>
		<form:label path="email">Email Id</form:label>
		<form:input path="email"/>
		<form:label path="password">Password</form:label>
		<form:input path="password"/>
		
		<form:button>Register</form:button>
	</form:form>
</body>
</html>