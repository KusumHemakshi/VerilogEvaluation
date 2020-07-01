<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>    
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Add Faculty</title>
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
    	<h1>Add Faculty</h1>
    	<hr>
    		<form method="POST" action="aaaf">
    			<table class="table table-borderless" align="center">
    				<tr>
    					<td>
    						<label><b>User Name             :</b></label>
    					</td>
    					<td>
			    			<input type="text" maxlength="20" placeholder="User Name" name="f_username" onkeypress="return alpha(event)" required><br><br>
			    		</td>
			    	</tr>
    				<tr>
    					<td>
	    					<label><b>Name             :</b></label>
	    				</td>
	    				<td>	
    						<input type="text" placeholder="Faculty Name" name="f_name" onkeypress="return alpha(event)" required><br><br>
    					</td>
    				</tr>
    				<tr>
    					<td>
			    			<label><b>Password             :</b></label>   
			    		</td>
			    		<td>
			    			<input id="f_pwd" type="text" placeholder="Password" name="f_pwd"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"  required><br><br>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td>
			    			<label><b>Email             :</b></label>
			    		</td>
			    		<td>
			    			<input type="email" placeholder="Faculty Email" name="f_email" title="Please enter Valid email" required>    
			    			<br><br>
			    		</td>
			    	
			    	</tr>
			    	</table>
    			<button type="submit" class="btn btn-info btn-lg">Register</button>
    		</form> 
	</div>
	<script>
		function alpha(e) 
		{
	    	var k;
	    	document.all ? k = e.keyCode : k = e.which;
	    	return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k == 32 || (k > 47 && k < 58));
		}
	</script>
</body>
</html>