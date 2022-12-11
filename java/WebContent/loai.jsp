<%@page import="bean.loaibean"%>
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
<link rel="stylesheet" type="text/css" 	href="./CSS/dungchung.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	  	<div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand " href="">Loai</a>
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
	<div style="padding: 0px 180px; display: inline-block;">
		<h4 style="text-align: center;">Danh Sách Loại</h3>
		<ul style="list-style: none; display: inline-block;">
		  <%
		  ArrayList<loaibean>dsloai = (ArrayList<loaibean>)session.getAttribute("dsloai");
		  for(loaibean l :dsloai){%>
			  <li class="loai" style="border: 1px solid;
			   text-align: center; display: inline-block; background-color: #ccc; padding: 5px 0px; margin: 4px">
			  	<a class="loai_content" style="cursor: pointer; padding: 7px 5px; color: #000;" href="htloaiController?html=<%=l.getMaloai()%>"><%=l.getTenloai() %></a>
			  	</li>
		  <%}
		  %>
		</ul>
	</div>

	<center style="margin-top: 100px">
		<form action="htloaiController">
		Tên Loai: <input style="margin-left: 10px;margin-right: 60px; padding: 2px" type="text" name="txttenloai" value="<%=(request.getParameter("tl") == null)?"":request.getParameter("tl")%>">
		Ma Loai: <input style="margin-left: 10px; padding: 2px" type="text" name="txtmaloai" value="<%=(request.getParameter("ml") == null)?"":request.getParameter("ml")%>"><br>
		<input type="submit" style="margin-top: 20px; padding: 6px 20px; display: inline-block;" value="Them" name="them">
		<input type="submit" style="margin-top: 20px; padding: 6px 20px; display: inline-block;" value="Xoa" name="xoa">
		<input type="submit" style="margin-top: 20px; padding: 6px 20px; display: inline-block;" value="Sua" name="sua">
		</form>
	</center>
</body>
</html>