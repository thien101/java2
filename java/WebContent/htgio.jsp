<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>
<%@page import="bo.loaibo"%>
<%@page import="bo.sachbo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.sachdao"%>
<%@page import="bean.sachbean"%>
<%@page import="bean.loaibean"%>
<%@page import="dao.loaidao"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import = "java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>Trung Quá Kém Cỏi</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
	      <li><a href="action_gh?xoaAll=true"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	      <%if(session.getAttribute("dn") == null){ %>
	      <li><a href="ktdn"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	      <%}else {
	    	%>
	    	<li><a href="baitap12_09.jsp"><span class="glyphicon glyphicon-log-in"></span> Xin Chao <%=session.getAttribute("dn") %></a></li>
	    	<%} %>
	    </ul>
	  	</div>
	</nav>
	<table width="90%" align="center">
   		<tr><td colspan="3"> <H1>SÁCH ONLINE </H1> </td></tr>
	    <tr>
	   		<td valign="top" width="20%" > Danh sách các loại
	   			<table  style="width: 200px">
	   				<%	
	   					request.setCharacterEncoding("utf-8");
	   					response.setCharacterEncoding("utf-8");
		   				loaibo loai = new loaibo();
		   				for(loaibean l: loai.getloai()){%>
		   					<tr>
		   						<td width="200">
		   							<a href="htsach.jsp?ml=<%=l.getMaloai()%>">
		   							<%=l.getTenloai()%> </a>
		   						</td>
		   					</tr>
		   			<%} %>
		   			<tr><td><a href="htsach.jsp?ml=<%="" %>">Hiển thị tất cả</a></td></tr>
		   		  </table>
	
	   		</td><br>
	   		<td valign="top" width="60%" > Danh Sách Sản Phẩm
	   			<table>
	   			<tr height="30" style="border-bottom: 1px solid;">
	   					<td width="5%">
	   					</td>
	   					<td width="10%" style="border-right: 1px solid; padding-left: 10px">Mã Sách</td>
	   					<td width="20%" style="border-right: 1px solid; padding-left: 10px">Tên Sách</td>
	   					<td width="10%" style="border-right: 1px solid; padding-left: 10px">Giá Sách</td>
	   					<td width="14%" style="border-right: 1px solid; padding-left: 10px">Số Lượng</td>
	   					<td width="10%" style="padding-left: 10px">Thành Tiền</td>
	   			</tr>
	   			<%
	   			if(session.getAttribute("gh") != null){
	   			for(giohangbean g: gh.ds){%>
	   				<tr height="30">
	   					<td width="5%">
	   						<a style="display: inline-block;" href="action_gh?msx=<%=g.getMasach()%>&xoa=true">Xoá</a>
	   						<form style="display: inline-block;">
	   							<input type="checkbox" value="<%=g.getMasach()%>" name="xoacheck" form = "checkxoa">
	   						</form>
	   					</td>
	   					<td width="10%" style="border-right: 1px solid; padding-left: 10px"><%=g.getMasach() %></td>
	   					<td width="20%" style="border-right: 1px solid; padding-left: 10px"><%=g.getTensach() %></td>
	   					<td width="10%" style="border-right: 1px solid; padding-left: 10px"><%=g.getGiasach() %></td>
	   					<td width="14%" style="border-right: 1px solid; padding-left: 10px">
	   						<form action="action_gh?sua=true" method="post">
	   							<input type="text" value="<%=g.getSoluong()%>" name="soluong"  min="1" style="text-align: right; width: 65%">
	   							<input type="text" value="<%=g.getMasach()%>" name="masach" style="display: none;">
	   							<input type="submit" value="Sua" style="text-align: right; width: 30%">
	   						</form>
	   					</td>
	   					<td width="5%" style="padding-left: 10px"><%=g.getThanhtien() %></td>
	   					
	   				</tr>
	   			<%}}
	   			%>
				
	   			</table>
	   			<center>
	   				<form id="checkxoa" action="action_gh" method="post" style="display: inline-block;">
	   					<button style="margin-top: 20px">Xoá đã chọn</button>
	   					<input type="text" value="true" name="xoaNsach" style="display: none;"></form>
	   				<form action="action_gh?xoaAll=true" method="post" style="display: inline-block;">
	   					<button style="margin: 20px 30px 0;">Trả lại toàn bộ</button></form>
	   				<form action="htsach" style="display: inline-block;">
	   					<button style="margin: 20px 30px 0;">Tiếp tục mua hàng</button></form>
	   				<form action="hoadon" method="post" style="display: inline-block;">
	   					<button style="margin-top: 20px">Thanh Toán</button></form>
	   			</center>
	   		</td><br>
	   		<td valign="top" width="20%" >
	   			<form action="htsach.jsp">
	   				<input style="margin-left: 50px" type="text" name="timkiem">
					<input style="margin-left: 50px; margin-top: 5px" type="submit" value="tìm kiếm">
	   			</form>
			</td><br>
	   	</table>
	   	
	   	
</body>
</html>