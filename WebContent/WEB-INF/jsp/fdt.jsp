<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>    
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Submissions</title>
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
    	<h1>Submissions: Transcript Files</h1>
    	<hr>
    	<p class="font-weight-bolder" align="left">Test ID:  ${test_id}</p>
    	<p class="font-weight-bolder"align="left">Roll No.  ${user}</p>
    	<table class="table">
    		<thead class="thead-light">
      			<tr>
        			<th>Question</th>
        			<th>IP Address</th>
        			<th>Date</th>
        			<th>Time</th>
        			<th>File</th>
     	 		</tr>
    		</thead>
    		<tbody>
    		<c:forEach var="transList" items="${transList}">
    			<tr>
    				<td>
    					${transList.que_no}
    				</td>
    				<td>
    					${transList.ip}
    				</td>
    				<td>
    					${transList.date}
    				</td>
    				<td>
    					${transList.time}
    				</td>
    				<td>
    					<a href="downloadTranscript?test_id=${test_id}&que=${transList.que_no}&user=${transList.s_username}"><button class="btn btn-info">Download</button>
    				</td>
    			</tr>
    		</c:forEach>
    		</tbody>
    	</table>
	</div>
</body>
</html>