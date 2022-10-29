<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import = "java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>

</head>

<body>
	<form action="ktdn" method="post">
       un= <input name="txtun" type="text" value="" placeholder = "Nhap un"> <br>
       pass= <input name="txtpass" type="password" value="" > <br>
       <input name="butdn" type="submit" value="login">
       <%if (request.getParameter("kt")!= null){
    	   out.print("Dang nhap sai");
       } %>
    </form>

</body>
</html>