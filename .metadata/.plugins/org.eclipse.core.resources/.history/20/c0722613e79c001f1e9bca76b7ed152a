<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>


</style>
<body>
<%
final String valid_username="vijay";
final String valid_password="12345";
String s1=request.getParameter("username");
String s2=request.getParameter("password");

if(valid_username.equals(s1)&& valid_password.equals(s2)){
	out.println("welcome to "+s1);
}else{
	out.println("Login failed");
	out.println("invalid username or password");
}

%>
</body>
</html>