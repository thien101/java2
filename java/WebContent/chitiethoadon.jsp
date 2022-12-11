<%@page import="bean.giohangbean"%>
<%@page import="bean.hoadonbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.giohangbo"%>
<%@page import="bean.khachhangbean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	</head>
<body>
	<%
	khachhangbean kh = new khachhangbean();
	if(session.getAttribute("dn") != null){
		 kh= (khachhangbean)session.getAttribute("dn");
	 }
	int sl=0;
	giohangbo gh =  new giohangbo();
	if(session.getAttribute("gh") != null){
		gh= (giohangbo)session.getAttribute("gh");
		if(gh.ds.size() == 0)response.sendRedirect("htsach");
		if(session.getAttribute("slhang") != null){
			sl = (int)session.getAttribute("slhang");
		}
	}
	//if(gh.ds.size() == 0)response.sendRedirect("htsach.jsp");
	
	%>
	<nav class="navbar navbar-inverse">
	  	<div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand " href="htsach?all=true">Trang Chu</a>
	    </div>
	    <ul class="nav navbar-nav">
	       <li class="active"><a href="htgio">Gio Hang(<%=sl %>)</a></li>
	      <li><a href="hoadon">Thanh Toan</a></li>
	      <li><a href="lichsugiaodich">Lich Su Mua Hang</a></li>
	      <%//<li><a href="#"><%=session.getAttribute("s") %></a></li> %>
	      
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="action_gh?xoaAll=true"><span class="glyphicon glyphicon-log-in"></span> Sign Up</a></li>
	      <%if(session.getAttribute("dn") == null){ %>
	      <li><a href="ktdn"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	      <%}else {  
	    	%>
	    	<li><a href="baitap12_09.jsp"><span class="glyphicon glyphicon-user"></span> Xin Chao <%=kh.getHoten() %></a></li>
	    	<%} %>
	    </ul>
	  	</div>
	</nav>
	
	<%
	
	%>
	<center>
		<h3 style="margin-top: 20px">Danh Sach Hóa Đơn</h3>
	</center>
	<table width="900" align="center" style="margin-top: 50px">
	    <tr>
	   		<td>
	   			<table width="900" align="center">
		   			<tr height="30" style="border: 1px solid; text-align: center;">

		   					<td width="" style="border-right: 1px solid; padding-left: 10px">Mã Sách</td>
		   					<td width="" style="border-right: 1px solid; padding-left: 10px">Tên Sách</td>
		   					<td width="" style="border-right: 1px solid; padding-left: 10px">Số Lượng</td>
		   					<td width="" style="border-right: 1px solid; padding-left: 10px">Giá</td>
		   					<td width="" style="border-right: 1px solid; padding-left: 10px">Thành Tiền</td>
		   					<td width="" style="border-right: 1px solid; padding-left: 10px">Trạng thái</td>
	
		   			</tr>
		   			<%
		   			ArrayList<giohangbean> dssp = (ArrayList<giohangbean>)session.getAttribute("cthd");
		   			for(giohangbean sp : dssp){%>
		   				<tr height="30" style="border: 1px solid; text-align: center;">
		   					<td width="" style="border-right: 1px solid; padding-left: 10px"><%=sp.getMasach() %></td>
		   					<td width="" style="border-right: 1px solid; padding-left: 10px"><%=sp.getTensach() %></td>
		   					<td width="" style="border-right: 1px solid; padding-left: 10px"><%=sp.getSoluong() %></td>
		   					<td width="" style="border-right: 1px solid; padding-left: 10px"><%=sp.getGiasach() %></td>
		   					<td width="" style="border-right: 1px solid; padding-left: 10px"><%=sp.getThanhtien() %></td>
		   					<td width="" style="border: 1px solid; padding-left: 10px"><%=(sp.isDamua() == true) ? "Đã Thanh Toán" : "Chưa Thanh Toán" %></td>
		   				</tr>
		   			<%}
		   			%>
	   			</table>
	   		</td></tr></table>
	   		
	   		
	
</body>
</html>