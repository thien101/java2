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
/* 		    margin-top: 36px; */
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
 	ArrayList<hangbean> hang = (ArrayList<hangbean>)session.getAttribute("dshang");
	ArrayList<sanphambean> dssp = (ArrayList<sanphambean>)session.getAttribute("dssanpham"); 
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8"); 
	%>
	<nav class="navbar navbar-inverse bar">
		<div class="container-fluid">
			<div class="navbar-header">
			<a class="navbar-brand" href="adminController">Shop LapTop</a>
			</div>
			<ul class="nav navbar-nav">
				<li class=""><a href="<%=(session.getAttribute("admin") != null)?"nhaccController":"adminController?dn=true"%>">Nhà Cung Cấp</a></li>
				<li><a href="<%=(session.getAttribute("admin") != null)?"sanphamController":"adminController?dn=true"%>">Sản Phẩm</a></li>
				<li><a href="<%=(session.getAttribute("admin") != null)?"xacnhanhdControler":"adminController?dn=true"%>">Xác Nhận Đơn Hàng</a></li>
				<li class="dropdown dropbar">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"><%=(session.getAttribute("admin") == null)?"Tài Khoản" : ad.getTendn()%>
					<ul class="dropdown-menu ">
						<%if(session.getAttribute("admin") == null){ %><li><a href="adminController?dn=true">Đăng Nhập</a></li>
						<%}else{ %>
						<li><a href="adminController?dx=true">Đăng Xuất</a></li><%} %>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	
		<%sanphambean sanpham = (session.getAttribute("sanpham")!=null)?(sanphambean)session.getAttribute("sanpham"): new sanphambean(); %>
		<div style="width: 1349px;min-height: 525px;
		 display: flex; justify-content: center; margin-top: 20px; align-items: center;">
			<div style="width: 600px; min-height: 400px;">
				<div style="width: 600px; min-height: 400px;">
				<form action="sanphamController" method="get">
						<%-- Mã Sản Phẩm: <input style="margin-bottom: 20px; margin-left: 14px; width: 370px; text-align: right;"
						 type="text" name="txtmsp" value="<%=(session.getAttribute("sanpham")!=null)?sanpham.getMasp():""%>"> <br> --%>
						 
						Tên Sản Phẩm: <input style="margin-bottom: 20px; margin-left: 10px; width: 450px; text-align: right;"
						 type="text" name="txttensp" value="<%=(session.getAttribute("sanpham")!=null)?sanpham.getTensp():""%>"> <br>
						 
						Mã Hãng: <input style="margin-bottom: 20px; margin-left: 46px; width: 450px; text-align: right;"
						 type="text" name="txtmh" value="<%=(session.getAttribute("sanpham")!=null)?sanpham.getMahang():""%>"> <br>
						 
						Tồn Kho: <input style="margin-bottom: 20px; margin-left: 50px; width: 450px; text-align: right;"
						 type="text" name="txtsl" value="<%=(session.getAttribute("sanpham")!=null)?sanpham.getTonkho():""%>"> <br>
						 
						Giá: <input style="margin-bottom: 20px; margin-left: 80px; width: 450px; text-align: right;"
						 type="text" name="txtgia" value="<%=(session.getAttribute("sanpham")!=null)?sanpham.getGia():""%>"> <br>
						 
					<input type="submit" name="xoa" value="Xoa" style="margin-top: 10px; margin-right: 32px; margin-left: 138px; padding: 4px 28px;">
					<input type="submit" name="sua" value="Sua" style="margin-left: 116px; padding: 4px 28px;"> 
				</form> 
			</div>
			</div>
		</div>
	</div>
	
	<div class="footer" style="height: 60px; width: 1349px; background-color: #000"></div>
</body>
</html>