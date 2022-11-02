<%@page import="bean.khachhangbean"%>
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
	<title>Gio Hang</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<style type="text/css">
		.active {
			background-color: orange;
		}
	</style>
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
	ArrayList<loaibean> loai = (ArrayList<loaibean>)request.getAttribute("dsloai");
	ArrayList<sachbean> dssach = (ArrayList<sachbean>)session.getAttribute("dssach");
	int sls = 12;
	int st = (dssach.size()/sls == 0) ? 1 : dssach.size()/sls;
	int n=dssach.size();
	if(dssach.size()/sls != 0)st++;
	//khachhangbean k;
	//if(session.getAttribute("dn") != null){
	//	k = (khachhangbean)session.getAttribute("dn");
	//}
	%>
	<nav class="navbar navbar-inverse">
	  	<div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="htsach?all=true">Trang Chu</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="htgio">Gio Hang(<%=sl %>)</a></li>
	      <li><a href="hoadon">Thanh Toan</a></li>
	      <li><a href="#">Lich Su Mua Hang</a></li>
	      <%//<li><a href="#"><%=session.getAttribute("s") %></a></li> %>
	      
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	    <%if(session.getAttribute("dn") == null){ %>
	       <li><a href="dangky"><span class="glyphicon glyphicon-user"></span> Register</a></li>
	      <%}%>
	      <li><a href="action_gh?xoaAll=true"><span class="glyphicon glyphicon-log-in"></span> Sign Up</a></li>
	      <%-- <li><a href="<%= (session.getAttribute("dn") == null) ? "ktdn" : "#"%>"><span class="glyphicon glyphicon-user"></span><%=(session.getAttribute("dn") == null) ? "Login" : "Xin chao " + k.getHoten() %></a></li> --%>
	      <%if(session.getAttribute("dn") == null){ %>
	       <li><a href="ktdn"><span class="glyphicon glyphicon-user"></span> Login</a></li>
	      <%}else {
	    	  khachhangbean k = (khachhangbean)session.getAttribute("dn");
	    	%>
	    	<li><a href="#"><span class="glyphicon glyphicon-user"></span> Xin Chao <%=k.getTendn() %></a></li>
	    	<%} %>
	    </ul>
	  	</div>
	</nav>
	<table width="90%" align="center">
   		<tr><td colspan="3"> <H1>SÁCH ONLINE </H1> </td></tr>
	    <tr style="margin-left: 30px">
	   		<td valign="top" width="20%" > Danh sách các loại
	   			<table  style="width: 200px">
	   				<%	
	   					request.setCharacterEncoding("utf-8");
	   					response.setCharacterEncoding("utf-8");
		   				//loaibo loai = new loaibo();
		   				
		   				for(loaibean l: loai/*loai.getloai()*/){%>
		   					<tr>
		   						<td width="200">
		   							<a href="htsach?ml=<%=l.getMaloai()%>">
		   							<%=l.getTenloai()%> </a>
		   						</td>
		   					</tr>
		   			<%} %>
		   			<tr><td><a href="htsach?all=true">Hiển thị tất cả</a></td></tr>
		   		  </table>
	
	   		</td><br>
	   		<td valign="top" width="50%" > <center><h2>Danh sách các sách</h3></center>
	   			<table width="100%">
		   			<%
		   				int trang = (int)request.getAttribute("trang");
		   				int start = (trang -1)*sls;
		   				int end = trang *sls;
		   				 if(trang  == n/sls +1){
		   					if(n%sls != 0)end = (trang -1)*sls + n%sls;
		   				} 
			   		    for(int i=start; i<end ;i++){
			   		    	sachbean s=dssach.get(i);
			   		    %>
			   		    <tr>
			   		    	<td style="padding-top: 10px">
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
				   		   	if(i < end){
				   		   		s=dssach.get(i);%>
				   		   	<td style="padding-top: 10px">
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
		   		<center>
		   			<div class="listpage" style="margin: 30px 0px 60px 0px; display: block; cursor: pointer;">
		   				<ul style="padding: 0px">
		   					<li class="giam" style="display: inline-block; cursor: pointer; padding: 0 10px">
   								<a href="htsach?trang=<%=(trang-1)==0?trang:trang-1 %>" style="font-size: 16px"><%="<" %></a>
   							</li>
		   					<%for(int index = 1; index<=st; index++){%>
		   						<li class = "<%=(index == trang)?"active":"" %>" style="display: inline-block; cursor: pointer; padding: 4px 10px">
		   							<a  href="htsach?trang=<%=index %>" style="font-size: 16px"><%=index %></a>
		   						</li>
		   					<%}%>
		   					<li class="tang" style="display: inline-block; cursor: pointer; padding: 0 10px">
   								<a href="htsach?trang=<%=(trang+1) > st?trang:trang+1 %>" style="font-size: 16px"><%=">" %></a>
   							</li>
		   				</ul>
		   			</div>
		   		</center>
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
