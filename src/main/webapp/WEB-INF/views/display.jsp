<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<h1>User Found</h1>
	<h2>User ID: ${user.getId()}</h2>
	<h2>User Name: ${user.getName() }</h2>
	<h2>Phone: ${user.getPhone() }</h2>
	<h2>Email ID: ${user.getEmail() }</h2>
</body>
</html>