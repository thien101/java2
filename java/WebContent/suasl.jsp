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
	// sua so luong gio
	giohangbo gh = (giohangbo)session.getAttribute("gio");
/* 	out.print(request.getParameter("soluong"));;
	out.print("---");
	out.print(request.getParameter("masach")); */
	
	if(request.getParameter("masach") != null && request.getParameter("soluong") != null){
		String ms = request.getParameter("masach");
   		long sl=0;
   		if(Integer.parseInt(request.getParameter("soluong")) > 0){
   			sl =  Integer.parseInt(request.getParameter("soluong"));
   		}	
   	for(giohangbean g : gh.ds){
   		if(g.getMasach().equals(ms)){
   			g.setSoluong(sl);
   		}
   	}
   	session.setAttribute("gio", gh);
   	response.sendRedirect("htgio.jsp");
	}
	%>
</body>
</html>