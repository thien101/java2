<%@page import="bean.xacnhanhdbean"%>
<%@page import="bean.adminbean"%>
<%@page import="bean.sanphambean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.hangbean"%>
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
	
		* {
		    margin: 0;
		    padding: 0;
		    box-sizing: border-box;
		}
		
		li.dropdown.dropbar {
		    width: 100px;
		    text-align: center;
		}
		
		.container {
		    padding: 8px;
		}
		
		.wrap-layout {
		    background-color: #e0e0e0;
		    margin-top: 36px;
		    padding: 12px 0 32px 0;
		    display: flex;
		    justify-content: space-around;
		    flex-wrap: wrap;
		    max-height: 150px;
		}
		
		.wrap-layout__item {
		    display: flex;
		    justify-content: center;
		    width: 100px;
		    height: 40px;
		    text-align: center;
		    line-height: 40px;
		    font-size: 18px;
		    font-weight: 700;
		    margin-top: 20px;
		    background-color: #fff;
		    border-radius: 40px;
		    text-decoration: none;
		}
		
		.wrap-layout__item  a{
		    text-decoration: none;
		}
		
		.wrap-layout__item:hover {
		    border: 2px solid #000;
		}
	
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
	adminbean ad = (adminbean)session.getAttribute("admin");
	ArrayList<xacnhanhdbean> xnbean = (ArrayList<xacnhanhdbean>)request.getAttribute("dsxnhd");
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	%>
	<nav class="navbar navbar-inverse bar">
		<div class="container-fluid">
			<div class="navbar-header">
			<a class="navbar-brand" href="adminController">Shop LapTop</a>
			</div>
			<ul class="nav navbar-nav">
				<li class=""><a href="<%=(session.getAttribute("admin") != null)?"nhaccController":"adminController?dn=true"%>">Nh?? Cung C???p</a></li>
				<li><a href="<%=(session.getAttribute("admin") != null)?"sanphamController":"adminController?dn=true"%>">S???n Ph???m</a></li>
				<li><a href="<%=(session.getAttribute("admin") != null)?"xacnhanhdControler":"adminController?dn=true"%>">X??c Nh???n ????n H??ng</a></li>
				<li class="dropdown dropbar">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"><%=(session.getAttribute("admin") == null)?"T??i Kho???n" : ad.getTendn()%>
					<ul class="dropdown-menu ">
						<%if(session.getAttribute("admin") == null){ %><li><a href="adminController?dn=true">????ng Nh???p</a></li>
						<%}else{ %>
						<li><a href="adminController?dx=true">????ng Xu???t</a></li><%} %>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	
	<div>
		<center>
			<h4>
				Danh S??ch H??a ????n
			</h4>
		</center>
	</div>
	
	<div style="width: 1300px; margin: 0px 25px; padding: 20px 0px; min-height: 525px;">
		<table style="width: 1300px;text-align: center;">
				<tr>
					<td></td>
					<td style="border: 1px solid; width: 150px">M?? H??a ????n</td>
					<td style="border: 1px solid; width: 250px">T??n Kh??ch H??ng</td>
					<td style="border: 1px solid; width: 250px">Th??nh Ti???n</td>
					<td style="border: 1px solid; width: 225px">Ng??y ?????t</td>
					<td style="border: 1px solid; width: 200px">???? Duy???t</td>
					<td style="border: 1px solid; width: 225px">Ng??y Duy???t</td>
				</tr>
				<%
				for(xacnhanhdbean hd : xnbean){
				%>
				<tr>
					<td></td>
					<td style="border: 1px solid; width: 150px"><a href="xacnhanhdControler?chitiet=true&mahd=<%=hd.getMahd() %>" style="font-size: 16px; cursor: pointer;"><%=hd.getMahd() %></a></td>
					<td style="border: 1px solid; width: 250px"><%=hd.getTenkh() %></td>
					<td style="border: 1px solid; width: 250px"><%=hd.getThanhtien() %></td>
					<td style="border: 1px solid; width: 200px"><%=hd.getNgaydat() %></td>
					<td style="border: 1px solid; width: 250px"><%=(hd.isDuyet() == true)?"???? ???????c duy???t" : "Ch??a ???????c duy???t" %></td>
					<td style="border: 1px solid; width: 200px"><%=(hd.getNgayduyet() == null)?"??ang ch???":hd.getNgayduyet() %></td>
				</tr>
				<%} %>
			</table>
	</div>

	<div class="footer" style="height: 60px; width: 1366px; background-color: #000"></div>
</body>
</html>