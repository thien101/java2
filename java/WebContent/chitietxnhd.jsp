<%@page import="bean.dangnhapbean"%>
<%@page import="bean.danhsachxnbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.giohangbean"%>
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
	   			<table width="900" align="center" style=" border: 1px solid;">
		   			<tr height="30" style="text-align: center;">

		   					<td width="" style="border-right: 1px solid; border-bottom: 1px solid; padding-left: 10px">Tên Sách</td>
		   					<td width="" style="border-right: 1px solid; border-bottom: 1px solid; padding-left: 10px">Số Lượng</td>
		   					<td width="" style="border-right: 1px solid; border-bottom: 1px solid; padding-left: 10px">Giá</td>
		   					<td width="" style="border-right: 1px solid; border-bottom: 1px solid; padding-left: 10px">Thành Tiền</td>
		   					<td width="" style="border-bottom: 1px solid; padding-left: 10px">Trạng thái</td>
	
		   			</tr>
		   			<%
		   			
		   			ArrayList<danhsachxnbean> dssxn = (ArrayList<danhsachxnbean>)session.getAttribute("sachmua");
		   			for(danhsachxnbean sp : dssxn){%>
		   				<tr height="30" style="border: 1px solid; text-align: center;">
		   					<td width="" style="border-right: 1px solid; padding-left: 10px"><%=sp.getTensach() %></td>
		   					<td width="" style="border-right: 1px solid; padding-left: 10px"><%=sp.getSlm() %></td>
		   					<td width="" style="border-right: 1px solid; padding-left: 10px"><%=sp.getGia() %></td>
		   					<td width="" style="border-right: 1px solid; padding-left: 10px"><%=sp.getThanhtien() %></td>
		   					<td width="" style=" padding-left: 10px"><%=(sp.isDamua() == false)?"Chua thanh toan":"" %></td>
		   				</tr>
		   			<%}
		   			%>
					<tr><td></td></tr>
	   			</table>
	   		</td></tr></table>
	   		<center style="margin-top: 50px">
				<form action="xacnhanHD?mahdxn=<%=dssxn.get(0).getMahd()%>" method="post"><input type="submit" value="XacNhan"></form>
			</center>
	   		
</body>
</html>