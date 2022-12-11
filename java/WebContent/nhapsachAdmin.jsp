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
	      <a class="navbar-brand " href="htloaiController">Loai</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="upsach">Sach</a></li>
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
	<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	%>
	<center style="margin-top: 60px">
		<form method="post" action="upsach" enctype= "multipart/form-data">
<!-- 		Tên Sách: <input type="text" name="txthoten" value=""> <br>
			Số Lượng: <input type="text" name="txtdiachi" value=""> <br> -->
			Mã Sách: <input style="margin-left: 20px; margin-bottom: 10px" type="text" name="txtms" value=""> <br>
			Tên Sách: <input style="margin-left: 16px; margin-bottom: 10px" type="text" name="txttensach" value=""> <br>
			Số Lượng: <input style="margin-left: 13px; margin-bottom: 10px" type="text" name="txtsl" value=""> <br>
			Giá: <input style="margin-left: 54px; margin-bottom: 10px" type="text" name="txtgia" value=""> <br>
			Loai: <input style="margin-left: 48px; margin-bottom: 10px" type="text" name="txtloai" value=""> <br>
			So Tap: <input style="margin-left: 31px; margin-bottom: 10px" type="text" name="txtsotap" value=""> <br>
			Tác giả: <input style="margin-left: 29px; margin-bottom: 20px" type="text" name="txttacgia" value=""> <br>
			file: <input type="file" name="txtfile" style="display: inline-block;"><br>
		<input type="submit"> 
	</form> 
	</center>
	
<!-- 	<div style="width: 100px; height: 100px; border: 1px solid">
	<img alt="" src=".\image_sach\hanhtrinh.jfif">
	</div> -->
</body>
</html>