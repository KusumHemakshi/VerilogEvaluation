<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>    
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Change Password</title>
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
</head>
<body>
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
        <ul class="navbar-nav">
            <li class="nav-item">
				<a class="nav-link text-info" href="welcomea">Home</a>
            </li>
            <li class="nav-item  dropdown">
				<a class="nav-link  text-info dropdown-toggle" data-toggle="dropdown" href="#">Add User
				</a>
				<div class="dropdown-menu">
					<a class="dropdown-item text-info" href="aaf">Faculty</a>
				 </div>
            </li>
			<li class="nav-item  dropdown">
				<a class="nav-link text-info dropdown-toggle" data-toggle="dropdown" href="#">Edit User
				</a>
				<div class="dropdown-menu">
					<a class="dropdown-item text-info" href="arf">Faculty</a>
        			<a class="dropdown-item text-info" href="ars">Student</a>
				</div>
            </li>
			<li class="nav-item  dropdown">
				<a class="nav-link text-info dropdown-toggle" data-toggle="dropdown" href="#">Change Password
				</a>
				<div class="dropdown-menu">
					<a class="dropdown-item text-info" href="aap">Admin</a>
				</div>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
			<li class="nav-item">
				<a class="nav-link" href="logout">Logout</a>
            </li>
        </ul>  
    </nav>
	<br>
	<div class="container" align="center">	
    	<h1>Change Password</h1>
    	<hr>
    		<form id="myForm" method="POST" action="aaap">
    			<table class="table table-borderless" align="center">
    				<tr>
		    			<td><label><b>User Name             :</b></label></td>
    					<td><input type="text" placeholder="User Name" name="a_username" required></td>
    				</tr>
    				<tr>
    					<td><label><b>New Password             :</b></label></td>
    					<td><input type="password" placeholder="Password" name="a_pwd" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required></td>
					</tr>
					<tr>
    					<td><label><b>Confirm Password             :</b></label></td>
    					<td><input type="password" placeholder="Password" name="a2_pwd" onmouseleave="check();" required></td>
    				</tr>
    			</table>	
    			<button type="submit" class="btn btn-info btn-lg">Change</button>
    		</form> 
    		<script language="javascript" type="text/javascript">
    		$('#myForm').submit(function() 
    				{
		  			  	var n = $('input[name=a_pwd').val();
		  		    	var m = $('input[name=a2_pwd').val();

		  		    	if(n!=m ) 
		  		    	{
		  		    		alert("Passwords not matching");
		  		      		return false;
		  		    	}
		  		    	else
		  		    	{
		  		      		return true;
		  		    	}
					}
    		);
    		</script>
	</div>
</body>
</html>