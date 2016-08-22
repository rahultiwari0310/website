<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="14.jpg">

<a href='index.html'><h3>Login Page</h3></a>
		<% String username=(String)session.getAttribute("username");%>
 <center><h1>Hello    ....<%=" "+username%></h1></center>
<%session.invalidate();%>
</body>
</html>