<%@page import="bean.xacnhanhdbean"%>
<%@page import="java.util.ArrayList"%>
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
	<center>
		<h3 style="margin-top: 20px">Danh Sach Hóa Đơn</h3>
	</center>
	<table width="900" align="center" style="margin-top: 50px">
	    <tr>
	   		<td>
	   			<table width="900" align="center">
		   			<tr height="30" style="border: 1px solid; text-align: center;">
							<td width="" style="border-right: 1px solid; padding-left: 10px">Tên Khách Hàng</td>
		   					<td width="" style="border-right: 1px solid; padding-left: 10px">Mã Hóa Đơn</td>
		   					<td width="" style="border-right: 1px solid; padding-left: 10px">Ngày Mua</td>
		   					<td width="" style="border-right: 1px solid; padding-left: 10px">Trạng thái</td>
	
		   			</tr>
		   			<%
		   			ArrayList<xacnhanhdbean> dsxnhd = (ArrayList<xacnhanhdbean>)session.getAttribute("xndshd");
		   			for(xacnhanhdbean hd : dsxnhd){%>
	   				<tr height="30" style="border: 1px solid; text-align: center;">
							<td width="" style="border-right: 1px solid; padding-left: 10px">
							<a href="xacnhanHD?mahd=<%=hd.getMahd()%>"><%=hd.getTenkh() %></a>
							</td>
		   					<td width="" style="border-right: 1px solid; padding-left: 10px"><%=hd.getMahd() %></td>
		   					<td width="" style="border-right: 1px solid; padding-left: 10px"><%=hd.getNgaymua() %></td>
		   					<td width="" style="border-right: 1px solid; padding-left: 10px"><%=(hd.isDamua() == false)?"Chua Thanh Toan":"" %></td>
	
		   			</tr>
		   			<% }%>
		   			<%-- <%
		   			ArrayList<hoadonbean> dshd = (ArrayList<hoadonbean>)session.getAttribute("dshd");
		   			for(hoadonbean hd : dshd){%>
		   				<tr height="30" style="border: 1px solid; text-align: center;">
		   					<td width="">
		   						<a style="display: inline-block;" href="chitiethoadon?mahd=<%=hd.getMahd()%>"><%=hd.getMahd() %></a>
		   					</td>
		   					<td width="" style="border: 1px solid; padding-left: 10px"><%=hd.getNgaymua() %></td>
		   					<td width="" style="border: 1px solid; padding-left: 10px"><%=(hd.isDamua() == true) ? "Đã Thanh Toán" : "Chưa Thanh Toán" %></td>
		   				</tr>
		   			<%}
		   			%> --%>
				
	   			</table>
	   		</td></tr></table>
</body>
</html>