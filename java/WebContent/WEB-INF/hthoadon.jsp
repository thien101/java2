<%@page import="bean.khachhangbean"%>
<%@page import="bo.giohangbo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
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
	      <a class="navbar-brand" href="htsach">Trang Chu</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="htgio.jsp">Gio Hang(<%= sl %>)</a></li>
	      <li><a href="hoadon">Thanh Toan</a></li>
	      <li><a href="#">Lich Su Mua Hang</a></li>
	      <%//<li><a href="#"><%=session.getAttribute("s") %></a></li> %>
	      
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="action_gh?xoaAll=true"><span class="glyphicon glyphicon-log-in"></span> Sign Up</a></li>
	      <%if(session.getAttribute("dn") == null){ %>
	      <li><a href="ktdn"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	      <%}else {
	    	  khachhangbean k = (khachhangbean)session.getAttribute("dn");
	    	%>
	    	<li><a href="baitap12_09.jsp"><span class="glyphicon glyphicon-user"></span> Xin Chao <%=k.getHoten() %></a></li>
	    	<%} %>
	    </ul>
	  	</div>
	</nav>
</body>
</html>