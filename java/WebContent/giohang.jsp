<%@page import="bo.giohangbo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	session.getAttribute("slhang");// tao ss sl sach trong gio
	//Náº¿u mua láº§n Äáº§u
	giohangbo gh;
	if(session.getAttribute("gh")==null){
		gh=new giohangbo();
		session.setAttribute("gh", gh);
		};
	//b1 gÃ¡n ss voÃ  1 biÃªn
	gh=(giohangbo) session.getAttribute("gh");
	
	//b2 thao tac tren bien gh	
	//b3 lÆ°u ds vÃ o ss
	
	 if(request.getParameter("xoaNsach") != null){// xoa n sach da chon
		String[] arr = request.getParameterValues("xoa");
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<gh.ds.size(); j++){
				if(arr[i].equals(gh.ds.get(j).getMasach())){
					gh.ds.remove(j);
					break;
				}
			}
		}
	}
	else if(request.getParameter("xoa") != null){// xoa sach
		gh.Xoa(request.getParameter("msx"));
	}
	else { // them sach vao gio
		String masach=request.getParameter("ms");
		String tensach=request.getParameter("ts"); 
		long giasach=Long.parseLong(request.getParameter("gia"));
		long soluong=Long.parseLong(request.getParameter("sl")); 
		String anh=request.getParameter("anh");
		gh.Them(masach, tensach, giasach, soluong, anh);
	}
	
	session.setAttribute("gh",gh);
	
	//hienthi gio
	session.setAttribute("slhang", gh.ds.size());
	response.sendRedirect("htgio.jsp");
	
%>
</body>
</html>