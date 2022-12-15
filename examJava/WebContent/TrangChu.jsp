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
	khachhangbean kh = (khachhangbean)session.getAttribute("khachhang");
	ArrayList<hangbean> hang = (ArrayList<hangbean>)request.getAttribute("dshang");
	ArrayList<sanphambean> dssp = (ArrayList<sanphambean>)request.getAttribute("dssanpham");
	long sl = (session.getAttribute("slhang") != null)?Long.parseLong(session.getAttribute("slhang").toString()) : 0;
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	%>
	<nav class="navbar navbar-inverse bar">
		<div class="container-fluid">
			<div class="navbar-header">
			<a class="navbar-brand" href="trangchuController">Shop LapTop</a>
			</div>
			<ul class="nav navbar-nav">
				<li class=""><a href="htgio">Giỏ Hàng(<%=sl%>)</a></li>
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
	
	<div style="width: 1326px; margin: 0px 20px">
		<center>
			<form action="trangchuController?tk=true" method="post">
				<input type="text" style="width: 600px" name="key">
				<input type="submit" value="Tìm Kiếm"; style="padding: 0px 5px">
			</form>
		</center>
	</div>
	
	<div class="wrap-layout" style="margin-bottom: 20px">
		<%for(hangbean h : hang){ %>
        <div class="wrap-layout__item"><a href="trangchuController?tk=true&mahang=<%=h.getMahang()%>"><%=h.getTenhang() %></a></div> <%} %>
    </div> 
	
	<div style="width: 1326px; margin: 0px 20px; padding: 20px 0px; min-height: 600px">
		<table style="width: 1326px">
			<%
			int n = dssp.size();
			for(int i=0; i<n; i++){
				sanphambean sp = dssp.get(i);
			%>
			<tr style="width: 1326px;">
				<td style="padding-top: 10px; border: 1px solid;">
					<center>
					   	<div style = "margin-bottom: 10px">
					   		<img style="border-radius: 8px; width: 250px; height: 180px" src="<%=sp.getAnh() %>">
					   	</div>
					</center>
					<div style="width: 285px; margin: 0px auto">
						<div style="height: 38px"><%=sp.getTensp()%></div>
						<div style="height: 22px"><%=sp.getMahang() %></div>
						<div style="height: 22px"><%=sp.getTonkho() %></div>
						<div style="height: 22px"><%=sp.getGia() %></div>
						<a href="giohangController?masp=<%=sp.getMasp()%>&tensp=<%=sp.getTensp()%>&gia=<%=sp.getGia()%>">Dat Mua</a>
					</div>
				 </td>
				 <% 
				 i++;
				 if(i < n){
				 	sp=dssp.get(i);%>
					 <td style="padding-top: 10px; border: 1px solid;">
					 <center>
						<div style = "margin-bottom: 10px">
							<img style="border-radius: 8px; width: 250px; height: 180px" src="<%=sp.getAnh() %>">
						</div>
					 </center>
					 <div style="width: 285px; margin: 0px auto; padding-bottom: 10px">
						<div style="height: 38px"><%=sp.getTensp()%></div>
						<div style="height: 22px"><%=sp.getMahang() %></div>
						<div style="height: 22px"><%=sp.getTonkho() %></div>
						<div style="height: 22px"><%=sp.getGia() %></div>
						<a href="giohangController?masp=<%=sp.getMasp()%>&tensp=<%=sp.getTensp()%>&gia=<%=sp.getGia()%>">Dat Mua</a>
					 </div>
				 </td>
				 <%}
				 i++;
				 if(i < n){
				 	sp=dssp.get(i);%>
					 <td style="padding-top: 10px;  border: 1px solid;">
					 <center>
						<div style = "margin-bottom: 10px">
							<img style="border-radius: 8px; width: 250px; height: 180px" src="<%=sp.getAnh() %>">
						</div>
					 </center>
					 <div style="width: 285px; margin: 0px auto">
						<div style="height: 38px"><%=sp.getTensp()%></div>
						<div style="height: 22px"><%=sp.getMahang() %></div>
						<div style="height: 22px"><%=sp.getTonkho() %></div>
						<div style="height: 22px"><%=sp.getGia() %></div>
						<a href="giohangController?masp=<%=sp.getMasp()%>&tensp=<%=sp.getTensp()%>&gia=<%=sp.getGia()%>">Dat Mua</a>
					 </div>
				 </td>
				 <%} %>
			</tr>
			<%} %>
		</table>
	</div>
	
	<div class="footer" style="height: 100px; width: 1366px; background-color: #000"></div>
</body>
</html>