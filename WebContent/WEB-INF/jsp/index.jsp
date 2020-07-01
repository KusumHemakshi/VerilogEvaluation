<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>    
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Welcome</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css">
    <script src="main.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script src="https://www.google.com/recaptcha/api.js"
        async defer>
    </script>
	<style>
		.carousel-inner img{
							padding:0px;
							width:1000px; height:380px;
							border-radius: 10px 10px;
							}	
		.nav navbar hover{background-color:#1669ad;}
		.carousel-inner{border-radius:20px 10px;}
		.dropdown-menu{font-size:13px;}

	</style>
</head>
<body >
    <nav class="navbar navbar-light bg-info">
        <h5>
			<div style="float:left;">
				<img src="<c:url value="/images/img1.png"/>" style='padding-right:20px; height:60px; width:80px'/>
			</div>
			<div style="float:right; color:white; padding-top:5px">
				<p>
					<br>National Institute of Technology, Calicut
				</p>
			</div>
			<div style="clear: left;">
			</div>
		</h5>
    </nav>
    <nav class="navbar navbar-expand-sm navbar-light bg-light">
    </nav>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-sm-8">
				<div id="demo" class="carousel slide" data-ride="carousel">
	
					<!-- Indicators -->
  
					<ul class="carousel-indicators">
						<li data-target="#demo" data-slide-to="0" class="active"></li>
						<li data-target="#demo" data-slide-to="1"></li>
						<li data-target="#demo" data-slide-to="2"></li>
					</ul>
  
					<!-- The slideshow -->
	
					<div class="carousel-inner" id="leftdiv">
						<div class="carousel-item active">
							<img src="<c:url value="/images/123.jpg"/>"  width="1100" height="500">
						</div>
						<div class="carousel-item">
							<img src="<c:url value="/images/456.jpg"/>" width="1100" height="500">
						</div>
						<div class="carousel-item">
							<img src="<c:url value="/images/789.jpg"/>" width="1100" height="500">
						</div>
					</div>
  
					<!-- Left and right controls -->
					<a class="carousel-control-prev" href="#demo" data-slide="prev">
						<span class="carousel-control-prev-icon"></span>
					</a>
					<a class="carousel-control-next" href="#demo" data-slide="next">
						<span class="carousel-control-next-icon"></span>
					</a>
				</div>
			</div>	
			<!-- <div class="col" align="center">
    			<h1>Login</h1>
    			<hr> -->
    			<form id="myForm" action="welcome" method="POST">
    			<div class="col" align="center">
    			<h1>Login</h1>
    			<hr>
    				<table class="table table-borderless" align="center">
    					<tr>
    						<td><label><b>Name             :</b></label></td>
    						<td><input type="text" placeholder="Username" name="username" required><br></td>
    					</tr>
    					<tr>
							<td><label><b>Password         :</b></label></td>
    						<td><input type="password" placeholder="Password" name="pwd" required><br><br></td>
    					</tr>
    				</table>
    				<div class="g-recaptcha" data-sitekey="6LfaZKYUAAAAAPcvs65KVyzcFr5QSLX7-8Ws_m-W"></div><br>
    				<button type="submit" class="btn btn-info btn-lg">Login</button>
    				</div>
    			</form>
			<!-- </div> -->
		</div>
	</div>
	
	<nav class="navbar fixed-bottom navbar-light bg-light mx-auto">
		<span class="navbar-text">
    		Hemakshi Tank<br>
    		M160059CA<br>
    	</span>
	</nav>
</body>
</html>