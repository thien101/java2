<%@page import="bean.chitietsanpham"%>
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
	ArrayList<chitietsanpham> dssp = (ArrayList<chitietsanpham>)session.getAttribute("chitietsp");
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
	
	<div style="width: 1200px; margin: 0px auto">	
			<table style="width: 1200px;text-align: center;">
				<tr>
					<td></td>
					<td style="border: 1px solid; width: 150px">Mã Hóa Đơn</td>
					<td style="border: 1px solid; width: 400px">Tên Sản Phẩm</td>
					<td style="border: 1px solid; width: 300px">Số Lượng Mua</td>
					<td style="border: 1px solid; width: 200px">Thành Tiền</td>
					<td style="border: 1px solid; width: 150px">Đã Mua</td>
					
				</tr>
				<%
				for(chitietsanpham sp : dssp){
				%>
				<tr>
					<td></td>
					<td style="border: 1px solid; width: 150px"><%=sp.getMahd() %></a></td>
					<td style="border: 1px solid; width: 250px"><%=sp.getTensp() %></td>
					<td style="border: 1px solid; width: 250"><%=sp.getSoluong() %></td>
					<td style="border: 1px solid; width: 400px"><%=sp.getGia() %></td>
					<td style="border: 1px solid; width: 250px"><%=(sp.isDamua() == false)?"Chưa Thanh Toán":"Đã Thanh Toán" %></td>
				</tr>
				<%} %>
			</table>
	</div>
</body>
</html>