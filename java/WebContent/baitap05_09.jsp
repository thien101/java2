<%@page import="java.util.ArrayList"%>
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
<%-- <form action="baitap06_08.jsp" method="POST">
     	First Name: <input type="text" name="first_name"> <br />
     	Last Name: <input type="text" name="last_name" />
    	<input type="submit" value="Submit" /> 
	</form>
	 First Name: <%= request.getParameter("first_name")%> 
	 Last Name: <%= request.getParameter("last_name")%>  --%>
	
<%-- 	Tính Toán:
	<% 	int a=0, b=0;
		String tinh = request.getParameter("tinh");
		String number1 = request.getParameter("number_1");
		String number2 = request.getParameter("number_2");
		if(number1 != null && number2 != null)
			a= Integer.parseInt(number1);
			b= Integer.parseInt(number2);
		    if(tinh != null){
		    	if(tinh.equals("+")){
			    	out.print(a+b);
			    }
			    else if(tinh.equals("-")){
			    	out.print(a-b);
			    }
			    else if(tinh.equals("*")){
			    	out.print(a*b);
			    }
			    else {
			   		out.print(a/b);
			    }
		    }
		
	%>
	
	<form action="baitap05_09.jsp" method="post">
		<input type="number" name = "number_1" value="<%= a%>"><br>
		<input type="number" name = "number_2" value="<%= b%>"><br>
	 	<input type='submit' name='tinh' value='+'>
	 	<input type='submit' name='tinh' value='-'>
	 	<input type='submit' name='tinh' value='*'>
	 	<input type='submit' name='tinh' value='/'>
	</form> --%>
	
	<%-- <%    // thay sua code
	int a=0,b=0,kq=0;
	//Lay ve a,b tu client gui len
		String tama=request.getParameter("txta");
		String tamb=request.getParameter("txtb");
		if(tama!=null && tamb!=null){
			//Doi tama, tamb ra so
			 a=Integer.parseInt(tama);
			 b=Integer.parseInt(tamb);
			 kq=0;
			 
			 
			if(request.getParameter("butc")!=null)//Nguoi dung chon nut +
			  kq=a+b;
			else
				if(request.getParameter("butt")!=null)//Nguoi dung chon nut -
	 			  kq=a-b;
	 			else
	 				if(request.getParameter("butn")!=null)//Nguoi dung chon nut +
	  			  		kq=a*b;
	  				else
	  					if(b==0)
	  	 				 out.print("<script>alert('Bo tay');</script>");
	  	 			     else
	  					   kq=a/b;
			//out.print("Ket qua="+  kq);
		}
  %>--%>
  	<%	
  	ArrayList<Double> resutl = new ArrayList<>();
  		//String a = "";
  		//String b = "";
  	double a = 0;
  	double b = 0;
  	double t = 0;
  	if(request.getAttribute("kq") != null /*&& request.getParameter("a")!=null && request.getParameter("b")!=null*/){
  		resutl = (ArrayList<Double>)request.getAttribute("kq");
  		//a = request.getParameter("a");
  		//b = request.getParameter("b");
  		a = resutl.get(0);
  		b = resutl.get(1);
  		t = resutl.get(2);
  	} 
  	%>
    <form action="removegh?ma=0" method="post">
       a= <input name="txta" type="number" value="<%=a %>"> <br>
       b= <input name="txtb" type="number" value="<%=b %>"> <br>
       kq= <input name="txtkq" type="number" value="<%=t %>"><br>
       <input name="butc" type="submit" value="+"> 
       <input name="butt" type="submit" value="-">
       <input name="butn" type="submit" value="*">
       <input name="butchia" type="submit" value="/">
    </form> 

	
</body>
</html>