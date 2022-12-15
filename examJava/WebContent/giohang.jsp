<%@page import="bean.sanphambean"%>
<%@page import="bean.hangbean"%>
<%@page import="bo.giohangbo"%>
<%@page import="bean.giohangbean"%>
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
	
	giohangbo ghb = (session.getAttribute("gh") != null)?(giohangbo)session.getAttribute("gh"): new giohangbo();
	khachhangbean kh = (session.getAttribute("khachhang") != null)?(khachhangbean)session.getAttribute("khachhang"):new khachhangbean();
	long sl = (session.getAttribute("slhang") != null)?Long.parseLong(session.getAttribute("slhang").toString()) : 0;
	//if(sl == 0)response.sendRedirect("trangchuController");
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	%>
	<nav class="navbar navbar-inverse bar">
		<div class="container-fluid">
			<div class="navbar-header">
			<a class="navbar-brand" href="trangchuController">Shop LapTop</a>
			</div>
			<ul class="nav navbar-nav">
				<li class=""><a href="giohangController">Giỏ Hàng(<%=sl%>)</a></li>
				<li><a href="thanhtoan.jsp">Thanh Toán</a></li>
				<li><a href="hoadonMuahang.jsp">Lịch Sử Mua Hàng</a></li>
				<li class="dropdown dropbar">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"><%=(session.getAttribute("khachhang") == null)?"Tài Khoản" : kh.getTenkh()%>
					<ul class="dropdown-menu ">
						<%if(session.getAttribute("khachhang") == null){ %><li><a href="khachhangController?dn=true">Đăng Nhập</a></li>
						<li><a href="khachhangController?dk=true">Đăng Ký</a></li><%}else{ %>
						<li><a href="thongtinKH.jsp">Thông Tin</a></li>
						<li><a href="#">Đăng Xuất</a></li><%} %>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	
	<div style="width: 1200px; margin: 0px auto">	
			<table style="width: 1200px;text-align: center;">
				<tr>
					<td></td>
					<td style="border: 1px solid; width: 250px">Mã Sản Phẩm</td>
					<td style="border: 1px solid; width: 550px">Tên Sản Phẩm</td>
					<td style="border: 1px solid; width: 200px">Số lượng mua</td>
					<td style="border: 1px solid; width: 200px">Thành Tiền</td>
				</tr>
				<%if(session.getAttribute("gh") != null){for(giohangbean gh : ghb.dssp){ %>
				<tr>
					<td width="50px">
						<form style="display: inline-block;">
	   							<input type="checkbox" value="<%=gh.getMasp()%>" name="xoacheck" form = "checkxoa">
	   					</form>
					</td>
					<td style="border: 1px solid; width: 200px"><%=gh.getMasp() %></td>
					<td style="border: 1px solid; width: 510px"><%=gh.getTensp() %></td>
					<td style="border: 1px solid; width: 300px"><form action="action_gh" method="post">
		   				<input type="text" value="<%=gh.getSlmua()%>" name="soluong"  min="1" style="text-align: right; display: inline-block; width: 180px; margin-right: 3px;">
		   				<input type="text" value="<%=gh.getMasp()%>" name="masp" style="display: none;">
		   				<input type="submit" value="Sua" name="sua" style="margin: 6px; display: inline-block; width: 60px; padding: 2px 12px;">
	   				</form></td>
					<td style="border: 1px solid; width: 100px"><%=gh.getThanhtien() %></td>
					<td style="width: 40px; text-decoration: none">
						<a href="action_gh?xoa=true&masp=<%=gh.getMasp()%>"><h4>X</h4></a>
					</td>
				</tr>
				<%}} %>
			</table>
	</div>
	<center>
	   				<form id="checkxoa" action="action_gh" method="post" style="display: inline-block;">
	   					<button style="margin-top: 20px">Xoá đã chọn</button>
	   					<input type="text" value="true" name="xoaNsach" style="display: none;"></form>
	   				<form action="action_gh?xoaAll=true" method="post" style="display: inline-block;">
	   					<button style="margin: 20px 30px 0;">Trả lại toàn bộ</button></form>
	   				<form action="trangchuController" method="post" style="display: inline-block;">
	   					<button style="margin: 20px 30px 0;">Tiếp tục mua hàng</button></form>
	   				<form action="hoadon" method="post" style="display: inline-block;">
	   					<button style="margin-top: 20px">Thanh Toán</button></form>
	   			</center>
	
</body>
</html>