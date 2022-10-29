<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import = "java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>

</head>

<body>
	<%
		String un = request.getParameter("txtun");
		String pass = request.getParameter("txtpass");
		/* if(un.equals("abc") && pass.equals("132")){
			//
			response.sendRedirect("htsach.jsp");
		}else {
			response.sendRedirect("baitap12_09.jsp?kt=1");
		}
 */	
 		if(session.getAttribute("dn") == null)
 			session.setAttribute("dn", "");
 		session.setAttribute("dn", un);
 		response.sendRedirect("htsach.jsp");
 	%>

</body>
</html>