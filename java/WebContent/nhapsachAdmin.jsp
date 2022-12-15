<%@page import="bean.sachbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.loaibean"%>
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
	<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	ArrayList<sachbean> sach = (ArrayList<sachbean>)session.getAttribute("dssach");
	%>
	
	<table style="margin-top: 30px; width: 1349px">
		<tr>
			<td style="width: 10%; border-right: 1px solid;">
				<center style="position: fixed; top: 80px; left: 10px; z-index: 1000;">
					<table  style="">
	   				<%	
	   					request.setCharacterEncoding("utf-8");
	   					response.setCharacterEncoding("utf-8");
	   					ArrayList<loaibean> loai = (ArrayList<loaibean>)session.getAttribute("dsloai");
		   				//loaibo loai = new loaibo();
		   				
		   				for(loaibean l: loai/*loai.getloai()*/){%>
		   					<tr>
		   						<td>
		   							<a href="action_sach?ml=<%=l.getMaloai()%>">
		   							<%=l.getTenloai()%> </a>
		   						</td>
		   					</tr>
		   			<%} %>

		   		  	</table>
				</center>
			</td>
			<td style="width: 55% ; padding: 10px;">
				<table style="width: 100%;">
					<tr style="text-align: center; border-bottom: 1px solid; border-top: 1px solid;">
						<td style="width: 10%; border-right: 1px solid;">Mã Sách</td>
						<td style="width: 25%; border-right: 1px solid;">Tên Sách</td>
						<td style="width: 8%; border-right: 1px solid;">Số Lượng</td>
						<td style="width: 10%; border-right: 1px solid;">Giá</td>
						<td style="width: 20%; border-right: 1px solid;">Loại</td>
						<td style="width: 8%; border-right: 1px solid;">Số Tập</td>
						<td style="width: 19%">Tác Giả</td>
					</tr>
					<%
					for(sachbean s : sach){%>
					<tr style="text-align: center; border-bottom: 1px solid; border-top: 1px solid;">
						<td style="width: 10%; border-right: 1px solid;"><a href="action_sach?opt=true&ms=<%=s.getMasach()%>"><%=s.getMasach() %></a></td>
						<td style="width: 25%; border-right: 1px solid;"><%=s.getTensach() %></td>
						<td style="width: 8%; border-right: 1px solid;"><%=s.getSoluong() %></td>
						<td style="width: 10%; border-right: 1px solid;"><%=s.getGia() %></td>
						<td style="width: 20%; border-right: 1px solid;"><%=s.getMaloai() %></td>
						<td style="width: 8%; border-right: 1px solid;"><%=1 %></td>
						<td style="width: 19%;"><%=s.getTacgia() %></td>
					</tr>
					<%}
					%>
				</table>
			</td>
			<td style="width: 20%; border-left: 1px solid;">
			<%sachbean s = new sachbean();
			if(request.getAttribute("addsach") != null){
				s = (sachbean)request.getAttribute("addsach");
			} %>
				<center style="padding-left: 20px; position: fixed; top: 80px; right: 10px; z-index: 1000;">
					<form method="post" action="upsach" enctype= "multipart/form-data">
			<!-- 		Tên Sách: <input type="text" name="txthoten" value=""> <br>
						Số Lượng: <input type="text" name="txtdiachi" value=""> <br> -->
						Mã Sách: <input style="margin-left: 20px; margin-bottom: 10px" type="text" name="txtms" value="<%=(request.getAttribute("addsach") == null)?"":s.getMasach()%>"> <br>
						Tên Sách: <input style="margin-left: 16px; margin-bottom: 10px" type="text" name="txttensach" value="<%=(request.getAttribute("addsach") == null)?"":s.getTensach()%>"> <br>
						Số Lượng: <input style="margin-left: 13px; margin-bottom: 10px" type="text" name="txtsl" value="<%=(request.getAttribute("addsach") == null)?"":s.getSoluong()%>"> <br>
						Giá: <input style="margin-left: 54px; margin-bottom: 10px" type="text" name="txtgia" value="<%=(request.getAttribute("addsach") == null)?"":s.getGia()%>"> <br>
						Loai: <input style="margin-left: 48px; margin-bottom: 10px" type="text" name="txtloai" value="<%=(request.getAttribute("addsach") == null)?"":s.getMaloai()%>"> <br>
						So Tap: <input style="margin-left: 31px; margin-bottom: 10px" type="text" name="txtsotap" value="<%=(request.getAttribute("addsach") == null)?"":1%>"> <br>
						Tác giả: <input style="margin-left: 29px; margin-bottom: 20px" type="text" name="txttacgia" value="<%=(request.getAttribute("addsach") == null)?"":s.getTacgia()%>"> <br>
						file: <input type="file" name="txtfile" style="display: inline-block;"><br>
					<input type="submit" name="them" value="Them" style="margin-top: 10px; margin-right: 10px"> 
					<input type="submit" name="xoa" value="Xoa" style="margin-top: 10px; margin-right: 10px"> 
					<input type="submit" name="sua" value="Sua"> 
					</form> 
				</center>
			</td>
		</tr>
	</table>
</body>
</html>