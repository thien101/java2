<%@page import="bean.dangnhapbean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import = "java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
	  	<div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand " href="<%=(session.getAttribute("admin") == null ? "ktdn_admin":"htloaiController")%>">Loai</a>
	    </div>  
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="<%=(session.getAttribute("admin") == null ? "ktdn_admin":"upsach")%>">Sach</a></li>
	      <li><a href="<%=(session.getAttribute("admin") == null ? "ktdn_admin":"xacnhanHD")%>">Xac nhan hoa don</a></li>

	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href=""><span class="glyphicon glyphicon-log-in"></span> Sign Up</a></li>
	      <%if(session.getAttribute("admin") == null){ %>
	       <li><a href="ktdn"><span class="glyphicon glyphicon-user"></span> Login</a></li>
	      <%}else {
	    	  dangnhapbean k = (dangnhapbean)session.getAttribute("admin");
	    	%>
	    	<li><a href="#"><span class="glyphicon glyphicon-user"></span> Xin Chao <%=k.getTendn() %></a></li>
	    	<%} %>
	    </ul>
	  	</div>
</nav>
</body>
</html>