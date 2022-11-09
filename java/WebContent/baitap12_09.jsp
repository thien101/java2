<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import = "java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./CSS/login.css">
</head>

<body>
	<%
	String error = (request.getAttribute("Loi") != null ? (String)request.getAttribute("Loi"): "");
	%>
	<div class="container">
	<div class="screen">
		<div class="screen__content">
			<form action="ktdn" class="login" method="post">
				<div class="login__field">
					<i class="login__icon fas fa-user"></i>
					<input name="tendn" type="text" class="login__input" placeholder="User name / Email">
				</div>
				<div class="login__field">
					<i class="login__icon fas fa-lock"></i>
					<input name="pass" type="password" class="login__input" placeholder="Password">
				</div>
				<button class="button login__submit">
					<span class="button__text">Log In Now</span>
					<i class="button__icon fas fa-chevron-right"></i>
				</button>			
			</form>
			<form action="dangky" class="login" method="" style="padding-top: 0px">
				<button class="button login__submit" style="margin-top: 0px">
					<span class="button__text">Register</span>
					<i class="button__icon fas fa-chevron-right"></i>
				</button>			
			</form>
		</div>
		<div class="screen__background">
			<span class="screen__background__shape screen__background__shape4"></span>
			<span class="screen__background__shape screen__background__shape3"></span>		
			<span class="screen__background__shape screen__background__shape2"></span>
			<span class="screen__background__shape screen__background__shape1"></span>
		</div>		
	</div>
</div>
    <h5><%=(error != "") ? error : ""%></h3>
    
    
<%if (request.getParameter("kt")!= null){
    	   out.print("Dang nhap sai");
       } %>
</body>
</html>