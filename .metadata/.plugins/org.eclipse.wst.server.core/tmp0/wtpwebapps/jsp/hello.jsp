<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="hello.jsp">
<input type="text" name="username" placeholder="username">

<input type="button" value="submit" >

</form>
<% 
//out.println("today is  "+ java.util.Calendar.getInstance().getTime());
 //response.sendRedirect("http://www.google.com");
 
 String s=request.getParameter("username");
 out.println("welcome to "+s);
%>
</body>
</html>