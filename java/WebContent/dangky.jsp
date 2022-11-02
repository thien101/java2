<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import = "java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <link rel="stylesheet" type="text/css" href="./CSS/jsp.css">
</head>
<body>
	<div class="container">
		<div class="card bg-light">
	        <article class="card-body mx-auto" style="max-width: 400px;">
		        <form action="dangky" method="post">
		            <h4 class="card-title mt-3 text-center">Create Account</h4>
		            <p class="text-center">Get started with your free account</p>
		            <p>
		                <a href="" class="btn btn-block btn-facebook"> <i class="fab fa-facebook-f"></i>   Login via facebook</a>
		            </p>
		           
		            <div class="form-group input-group">
		                <div class="input-group-prepend">
		                    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		                 </div>
		                <input name="tendn" class="form-control" placeholder="Tên Đăng Nhập" type="text">
		            </div>
		
		            <div class="form-group input-group">
		                <div class="input-group-prepend">
		                    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		                 </div>
		                <input name="hoten" class="form-control" placeholder="Họ Tên" type="text">
		            </div> <!-- form-group// --> 
		
		            <div class="form-group input-group">
		                <div class="input-group-prepend">
		                    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		                 </div>
		                <input name="email" class="form-control" placeholder="Email" type="email">
		            </div> <!-- form-group// -->
		            <div class="form-group input-group">
		                <div class="input-group-prepend">
		   					<span class="input-group-text"> <i class="fa fa-building"></i> </span>
						</div>
		                <input name="diachi" class="form-control" placeholder="Dia chi" type="text">
		            </div> <!-- form-group// -->
		            <div class="form-group input-group">
		                <div class="input-group-prepend">
		                    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
		                </div>
		                
		                <input name="sodt" class="form-control" placeholder="Số Điện Thoại" type="text">
		            </div> 
		            
		            <div class="form-group input-group">
		                <div class="input-group-prepend">
		                    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		                </div>
		                <input name="pass" class="form-control" placeholder="Nhập Pass" type="password">
		            </div> <!-- form-group// -->
		            <div class="form-group input-group">
		                <div class="input-group-prepend">
		                    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		                </div>
		                <input name="checkpass" class="form-control" placeholder="Nhập Lại Pass" type="password">
		            </div> <!-- form-group// -->                                      
		            <div class="form-group">
		                <button type="submit" class="btn btn-primary btn-block"> Đăng ký  </button>
		            </div> <!-- form-group// -->      
		            <p class="text-center">Have an account? <a href="ktdn">Log In</a> </p>                                                                 
		        </form>
	        </article>
		</div>       
	</div> 
</body>
</html>