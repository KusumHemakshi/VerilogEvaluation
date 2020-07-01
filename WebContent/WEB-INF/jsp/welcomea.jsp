<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>    
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Admin</title>
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
		<h1>Welcome Admin !</h1><br><br>
		<h2><u>Login Details</u></h2><br>
		<table class="table">
    		<thead class="thead-light">
      			<tr>
        			<th>Username</th>
        			<th>IP Address</th>
        			<th>Login Date</th>
        			<th>Login Time</th>
     	 		</tr>
    		</thead>
    		<tbody>
    			<c:forEach var="list" items="${list}">
    				<tr>
    					<td>
    						${list.username}
    					</td>
    					<td>
    						${list.ip}
    					</td>
    					<td>
    						${list.date}
    					</td>
    					<td>
    						${list.time}
    					</td>
    				</tr>
    			</c:forEach>
    		</tbody>
    	</table>	
	</div>
	<script>
	$(document).ready(function() {
	    $('#example').DataTable( {
	        dom: 'Bfrtip',
	        lengthMenu: [
	            [ 10, 25, 50, -1 ],
	            [ '10 rows', '25 rows', '50 rows', 'Show all' ]
	        ],
	        buttons: [
	            'pageLength'
	        ]
	    } );
	} );
	</script>
</body>
</html>