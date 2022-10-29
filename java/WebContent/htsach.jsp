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
	<title>Gio Hang</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	/* if(session.getAttribute("htsach") == null){
		session.setAttribute("htsach", 1);
		response.sendRedirect("htsach");
	} */
	int sl=0;
	if(session.getAttribute("slhang") != null){
		sl = (int)session.getAttribute("slhang");
	}
	%>
	<nav class="navbar navbar-inverse">
	  	<div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="htsach">Trang Chu</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="htgio">Gio Hang(<%=sl %>)</a></li>
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
		   				//loaibo loai = new loaibo();
		   				ArrayList<loaibean> loai = (ArrayList<loaibean>)request.getAttribute("dsloai");
		   				for(loaibean l: loai/*loai.getloai()*/){%>
		   					<tr>
		   						<td width="200">
		   							<a href="sach?ml=<%=l.getMaloai()%>">
		   							<%=l.getTenloai()%> </a>
		   						</td>
		   					</tr>
		   			<%} %>
		   			<tr><td><a href="sach?ml=<%="" %>">Hiển thị tất cả</a></td></tr>
		   		  </table>
	
	   		</td><br>
	   		<td valign="top" width="50%" > <center><h2>Danh sách các sách</h3></center>
	   			<table width="100%">
		   			<%
		   			/* String mls = request.getParameter("ml");
		   			String tk = request.getParameter("timkiem"); */
		   			//out.print("aaaaa---1" + mls + "---2" + tk);
		   			//sachdao sdao= new sachdao();
		   			/* sachbo sbo = new sachbo();
		   		    ArrayList<sachbean> dssach = sbo.getsach();
		   		    /* if(mls != null) {
		   		    	dssach = sbo.timkiem(dssach, mls);
		   		    }else if(tk != null){
		   		    	dssach = sbo.timkiem(dssach, tk);
		   		    } */
		   		 	ArrayList<sachbean> dssach = (ArrayList<sachbean>)request.getAttribute("dssach");
		   		    int n=dssach.size();
			   		    for(int i=0;i<n;i++){
			   		    	sachbean s=dssach.get(i);
			   		    %>
			   		    <tr>
			   		    	<td style="border-bottom: 1px solid;  border-right: 1px solid; padding-top: 10px">
					   		    <center>
					   		    	<div style = "border: 1px solid; width: 252px; border-radius: 8px; margin-bottom: 10px">
					   		    		<img style="border-radius: 8px; width: 250px; height: 250px" src="<%=s.getAnh() %>">
					   		    	</div>
					   		    </center>
						   		     <div style="width: 252px; margin: 0px auto">
						   		     	<div style="height: 38px"><%=s.getTensach() %></div>
						   		     	<div style="height: 22px"><%=s.getMaloai() %></div>
						   		     	<div style="height: 22px"><%=s.getTacgia() %></div>
						   		     	<div style="height: 22px"><%=s.getGia() %></div>
						   		     	<a href="giohang?ms=<%=s.getMasach()%>&ts=<%=s.getTensach()%>&gia=<%=s.getGia()%>&anh=<%=s.getAnh()%>&sl=<%=s.getSoluong()%>">Dat Mua</a>
						   		     </div>
				   			</td>
				   		   
				   		   <% 
				   		   	i++; 
				   		   	if(i<n){
				   		   		s=dssach.get(i);%>
				   		   	<td style="border-bottom: 1px solid;  border-left: 1px solid; padding-top: 10px">
					   		    <center>
					   		    	<div style = "border: 1px solid; width: 252px; border-radius: 8px; margin-bottom: 10px">
					   		    		<img style="border-radius: 8px; width: 250px; height: 250px" src="<%=s.getAnh() %>">
					   		    	</div>
					   		    </center>
						   		     <div style="width: 252px; margin: 0px auto">
						   		     	<div style="height: 38px"><%=s.getTensach() %></div>
						   		     	<div style="height: 22px"><%=s.getMaloai() %></div>
						   		     	<div style="height: 22px"><%=s.getTacgia() %></div>
						   		     	<div style="height: 22px"><%=s.getGia() %></div>
						   		     	<a href="giohang?ms=<%=s.getMasach()%>&ts=<%=s.getTensach()%>&gia=<%=s.getGia()%>&anh=<%=s.getAnh()%>&sl=<%=s.getSoluong()%>">Dat Mua</a>
						   		     </div>
				   			</td>
				   		     	<%} %>
				   		 </tr>
				   		 <%} %>
	   		 	</table>
		   		
	   		</td><br>
	   		<td valign="top" width="20%" >
	   			<form action="htsach">
	   				<input style="margin-left: 20px" type="text" name="timkiem">
					<input style="margin-left: 20px; margin-top: 5px" type="submit" value="tìm kiếm">
	   			</form>
			</td><br>
	   	</table>
	   	
</body>
</html>