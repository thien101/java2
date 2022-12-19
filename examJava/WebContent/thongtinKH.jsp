<%@page import="bean.sanphambean"%>
<%@page import="bean.hangbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.khachhangbean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import = "java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Shop LapTop</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./CSS/style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<style type="text/css">
		.active {
			background-color: orange;
		}
		li.dropdown.dropbar {
		    position: absolute;
		    top: 0;
		    right: 20px;
		    
		}
		

		
		.dropdown-menu {
			min-width: 0px;
		}
		
		.navbar-nav>li>.dropdown-menu {
		    background-color: #ccc;
		}
	</style>
</head>
<body>
	<%
	khachhangbean kh = (khachhangbean)session.getAttribute("khachhang");
	long sl = (session.getAttribute("slhang") != null)?Long.parseLong(session.getAttribute("slhang").toString()) : 0;
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	%>
	<nav class="navbar navbar-inverse bar">
		<div class="container-fluid">
			<div class="navbar-header">
			<a class="navbar-brand" href="trangchuController">Shop LapTop</a>
			</div>
			<ul class="nav navbar-nav">
				<li class=""><a href="<%=((session.getAttribute("khachhang") == null)?"khachhangController?dn=true":"htgio")%>">Giỏ Hàng(<%=sl%>)</a></li>
				<li><a href="<%=((session.getAttribute("khachhang") == null)?"khachhangController?dn=true":"thanhtoanController")%>">Thanh Toán</a></li>
				<li><a href="<%=((session.getAttribute("khachhang") == null)?"khachhangController?dn=true":"lichsuController")%>">Lịch Sử Mua Hàng</a></li>
				<li class="dropdown dropbar">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"><%=(session.getAttribute("khachhang") == null)?"Tài Khoản" : kh.getTenkh()%>
					<ul class="dropdown-menu ">
						<%if(session.getAttribute("khachhang") == null){ %><li><a href="khachhangController?dn=true">Đăng Nhập</a></li>
						<li><a href="khachhangController?dk=true">Đăng Ký</a></li><%}else{ %>
						<li><a href="thongtinKH.jsp">Thông Tin</a></li>
						<li><a href="khachhangController?dx=true">Đăng Xuất</a></li><%} %>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<center>
		<div style="width: 400px; height: 340px; border: 1px solid; margin-top: 150px;">
			<h3>Thông tin của bạn</h3>
			<form action="khachhangController?capnhapkh=true" method="post">
				Họ Tên: <input type="text" name="hoten" style="margin: 8px 0px 20px 5px;" value="<%=kh.getTenkh()%>"><br> 
				Địa Chỉ: <input type="text" name="diachi" style="margin-bottom: 20px; margin-left: 5px;" value="<%=kh.getDiachi()%>"><br>
				Số ĐT: <input type="text" name="sodt" style="margin-bottom: 20px; margin-left: 15px;" value="<%=kh.getSdt()%>"><br>
				Email: <input type="text" name="email" style="margin-bottom: 20px;  margin-left: 18px;" value="<%=kh.getEmail()%>"><br>
				<input type="submit" value="Cập Nhập">
			</form>
			
		</div>
	</center>
	
</body>
</html>