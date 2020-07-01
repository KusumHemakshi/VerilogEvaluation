<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>    
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Add Student</title>
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
				<a class="nav-link text-info" href="welcomef">Home</a>
            </li>
            <li class="nav-item  dropdown">
				<a class="nav-link  text-info dropdown-toggle" data-toggle="dropdown" href="#">Add User
				</a>
				<div class="dropdown-menu">
        			<a class="dropdown-item text-info" href="fas">Student</a>
				 </div>
            </li>
			<li class="nav-item  dropdown">
				<a class="nav-link text-info dropdown-toggle" data-toggle="dropdown" href="#">Edit User
				</a>
				<div class="dropdown-menu">
        			<a class="dropdown-item text-info" href="frs">Student</a>
				</div>
            </li>
			<li class="nav-item  dropdown">
				<a class="nav-link text-info dropdown-toggle" data-toggle="dropdown" href="#">Change Password
				</a>
				<div class="dropdown-menu">
        			<a class="dropdown-item text-info" href="ffp">Faculty</a>
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
    	<h1>Add Student</h1>
    	<hr>
    		<form method="POST" action="ffas2" enctype="multipart/form-data">
    			<table class="table table-borderless">
    				<tbody>
    					<tr>
    						<td>
    							Upload CSV file
    						</td>
    						<td>
    							<input type="file" name="fileStudent" accept=".csv" />
    						</td>
    					</tr>
    					<tr>
    						<td colspan="2">
    							 <p class="font-weight-bolder">CSV Input Format: (Username,Name,Email,Course,Semester)</p>
    							  <p class="font-weight-bolder">NOTE:<p class="font-weight-normal">Don't use any space</p></p>
    						</td>
    					</tr>
    				</tbody>
    			</table>
    			<br>
    			<button type="submit" class="btn btn-info btn-lg">Upload</button>
    		</form>
    		<hr>
    		<h3>OR</h3>
    		<hr>
    		<form method="POST" action="ffas">
    			<table class="table table-borderless">
    				<tbody>
    					<tr>
    						<td>User Name             :</td>
    						<td><input type="text" maxlength="20" placeholder="User Name" name="s_username" onkeypress="return alpha(event)" required><br></td>
    					</tr>
    					<tr>
    						<td>Name             :</td>
    						<td><input type="text" placeholder="Student Name" name="s_name" onkeypress="return alpha(event)" required></td>
    					</tr>
    					<tr>
	    					<td>Password             :</td>
    						<td><input type="text" placeholder="Password" name="s_pwd" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required></td>
    					</tr>
    					<tr>
    						<td>Email             :</td>
    						<td><input type="email" placeholder="Faculty Email" name="s_email"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Please enter Valid password"  required></td>
    					</tr>
    					<tr>
    						<td>Course:</td>
    						<td>
    							<select name="test_course" onchange="SemOptions(this.value)" style="width: 150px;" id="test_course"  required>
 			 						<option value="B.Tech." selected>B.Tech.</option>
  			 						<option value="M.Tech.">M.Tech.</option>
  			 						<option value="MCA">MCA</option>
			 					</select>
    						</td>
    					</tr>
    					<tr>
    						<td>Semester:</td>
    						<td>
    							<select name="test_sem" id="test_sem" style="width: 150px;">
    								<option value="I">I</option>
    								<option value="II">II</option>
    								<option value="III">III</option>
    								<option value="IV">IV</option>
    								<option value="V">V</option>
    								<option value="VI">VI</option>
    								<option value="VII">VII</option>
    								<option value="VIII">VIII</option>
			 					</select>
			 				</td>
    					</tr>
    					<tr>
    						<td>Registered By             :</td>
							<td>
								<c:forEach items="${f_username}" var="f_username">
                    				<option value="${f_username}">${f_username}</option>
                    			</c:forEach>
                    			<input type="hidden" name="f_username" value="${f_username}">
        					</td>
        				</tr>
        			</tbody>
        		</table>
    			<button type="submit" class="btn btn-info btn-lg">Register</button>
    		</form> 
	</div>
	<script>
	function SemOptions(x) 
	{
		  if(x=="B.Tech.")
			  {
			  		var ts = document.getElementById("test_sem");
			  	    for(i = ts.options.length - 1 ; i >= 0 ; i--)
			  	    {
			  	        ts.remove(i);
			  	    }
			  	    var option = document.createElement("option");
			    	option.text = "I";
			  		ts.add(option,0);
			  		for(i=2;i<=8;i++)
			  			{
			  				var option = document.createElement("option");
			  		    	option.text = convert(i);
			  		    	var sel = i;  
			  		    	ts.add(option, sel-1);
			  			}
			  }
		  else if(x=="M.Tech.")
		  {
		  		var ts = document.getElementById("test_sem");
		  	    for(i = ts.options.length - 1 ; i >= 0 ; i--)
		  	    {
		  	        ts.remove(i);
		  	    }
		  	    var option = document.createElement("option");
		    	option.text = "I";
		  		ts.add(option,0);
		  		for(i=2;i<=4;i++)
		  			{
	  					var option = document.createElement("option");
	  		    		option.text = convert(i);
	  		    		var sel = i;  
	  		    		ts.add(option, sel-1);
		  			}
		  }
		else if(x=="MCA")
		  {
	  		var ts = document.getElementById("test_sem");
	  	    for(i = ts.options.length - 1 ; i >= 0 ; i--)
	  	    {
	  	        ts.remove(i);
	  	    }
	  	    var option = document.createElement("option");
	    	option.text = "I";
	  		ts.add(option,0);
	  		for(i=2;i<=6;i++)
	  			{
					var option = document.createElement("option");
		    		option.text = convert(i);
		    		var sel = i;  
		    		ts.add(option, sel-1);
	  			}
	  	}
	}
	function convert(num) 
	{ 
		  if(num < 1){ return "";}
		  if(num >= 40){ return "XL" + convert(num - 40);}
		  if(num >= 10){ return "X" + convert(num - 10);}
		  if(num >= 9){ return "IX" + convert(num - 9);}
		  if(num >= 5){ return "V" + convert(num - 5);}
		  if(num >= 4){ return "IV" + convert(num - 4);}
		  if(num >= 1){ return "I" + convert(num - 1);}  
	}
		function alpha(e) 
		{
	    	var k;
	    	document.all ? k = e.keyCode : k = e.which;
	    	return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k == 32 || (k > 47 && k < 58));
		}
	</script>
</body>
</html>