<%@page import="bean.khachhangbean"%>
<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>
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
	long tongtien = 0;
	
	if(gh.ds.size() != 0){
		tongtien = gh.tongtien();
		}
	%>
	
	<center>
		<div style="width: 400px; height: 340px; border: 1px solid; margin-top: 150px;">
			<h3 style="margin: 20px 0 0 0">Tổng Tiền Thanh Toán là: <%= tongtien %></h3>
			<form action="" ">
				<div style="padding-bottom: 20px">
				Họ Tên: <input type="text" style="margin: 20px 0" value="<%=(session.getAttribute("dn") != null) ? kh.getHoten() : ""%>"><br> 
				Địa Chỉ: <input type="text" style="margin-bottom: 20px" value="<%=(session.getAttribute("dn") != null) ? kh.getDiachi() : ""%>"><br>
				Số ĐT: <input type="text" style="margin-bottom: 20px" value="<%=(session.getAttribute("dn") != null) ? kh.getSdt() : ""%>"><br>
				Email: <input type="text" style="margin-bottom: 20px" value="<%=(session.getAttribute("dn") != null) ? kh.getEmail() : ""%>"><br>
				Tên DN: <input type="text" style="margin-bottom: 20px" value="<%=(session.getAttribute("dn") != null) ? kh.getTendn() : ""%>"><br>
				<h4 style="display: inline-block; margin: 0">Bạn có chăc muốn thanh toán:</h4>
				<%if(session.getAttribute("dn") != null){ %>
	     		 <a href="hoadon?tt=yes">Yes</a>
		  		or  
				<a href="hoadon?tt=no">No</a>
	      		<%}else {  
	    		%>
	    		<button>Yes</button>
	    		<button>No</button>
	    		<%} %>

				<!-- <a href="hoadon?tt=yes">Yes</a>
		  		or  
				<a href="hoadon?tt=no">No</a> -->
			</div>
			</form>
			
		</div>
	</center>
	
	
</body>
</html>