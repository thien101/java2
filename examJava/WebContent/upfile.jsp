<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import = "java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <form method="post" action="sachAdminCotroller" enctype= "multipart/form-data">
		  Ho Ten: <input type="text" name="txthoten" value=""> <br>
		  Đia chi: <input type="text" name="txtdiachi" value=""> <br>
		  file: <input type="file" name="txtfile"><br>
		  <input type="submit"> 
  	</form> --> 
  	
  	<form action="themsanpham" enctype= "multipart/form-data" method="post">
						<%-- Mã Sản Phẩm: <input style="margin-bottom: 20px; margin-left: 14px; width: 370px; text-align: right;"
						 type="text" name="txtmsp" value="<%=(session.getAttribute("sanpham")!=null)?sanpham.getMasp():""%>"> <br> --%>
						 
						Tên Sản Phẩm: <input style="margin-bottom: 20px; margin-left: 10px; width: 370px; text-align: right;"
						 type="text" name="txttensp" value=""> <br>
						 
						Mã Hãng: <input style="margin-bottom: 20px; margin-left: 46px; width: 370px; text-align: right;"
						 type="text" name="txtmh" value=""> <br>
						 
						Tồn Kho: <input style="margin-bottom: 20px; margin-left: 50px; width: 370px; text-align: right;"
						 type="text" name="txtsl" value=""> <br>
						 
						Giá: <input style="margin-bottom: 20px; margin-left: 80px; width: 370px; text-align: right;"
						 type="text" name="txtgia" value=""> <br>
						 
						file: <input type="file" name="txtfile"><br>
					<input type="submit" name="them" value="Them" style="margin-top: 10px; margin-right: 32px; margin-left: 116px; padding: 4px 16px;"> 
					<input type="submit" name="xoa" value="Xoa" style="margin-top: 10px; margin-right: 32px; padding: 4px 21px;"> 
					<input type="submit" name="sua" value="Sua" style="padding: 4px 21px;"> 
				</form> 
  	
	<img alt="" src="./images/a3.jpg">
</body>
</html>