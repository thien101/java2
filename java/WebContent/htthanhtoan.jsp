<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
	<%
	giohangbo gh = (giohangbo)session.getAttribute("gh");
	long tongtien = 0;
	if(gh.ds.size() != 0){
		tongtien = gh.tongtien();
	}
	 for(giohangbean g : gh.ds){
   		tongtien += g.getThanhtien();
   	} 
	%>
	
	<center>
		<div style="width: 400px; height: 320px; border: 1px solid; margin-top: 200px;">
			<h3 style="margin: 20px 0 0 0">Tổng Tiền Thanh Toán là: <%= tongtien %></h3>
			<form action="">
				<div>
				Họ Tên: <input type="text" style="margin: 20px 0"><br> 
				Địa Chỉ: <input type="text" style="margin-bottom: 20px"><br>
				Số ĐT: <input type="text" style="margin-bottom: 20px"><br>
				Email: <input type="text" style="margin-bottom: 20px"><br>
				Địa Chỉ: <input type="text" style="margin-bottom: 20px"><br>
				<h4 style="display: inline-block; margin: 0">Bạn có chăc muốn thanh toán:</h4>
				<a href="">Yes</a>
		  		or  
				<a href="htgio">No</a>
			</div>
			</form>
			
		</div>
	</center>
	
	
</body>
</html>