<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>    
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Student</title>
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
				<a class="nav-link text-info" href="welcomes">Home</a>
            </li>
			<li class="nav-item  dropdown">
				<a class="nav-link text-info" href="ssp">Change Password</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
			<li class="nav-item">
				<a class="nav-link" href="logout">Logout</a>
            </li>
        </ul>  
    </nav>
	<br>
	<div class="container" align="left">
		<form method="POST" action="ssnt" name="questionForm"  enctype="multipart/form-data">
			<input type="hidden" value="${hr}" id="hr" />
			<input type="hidden" value="${min}" id="min"/>
			<c:forEach var="t_list" items="${t_list}">
				<input type="hidden" name="test_id" value="${t_list.test_id}">
				<input type="hidden" name="ques" value="${t_list.no_que}">
				<table class="table table-borderless">
						<h3></h3>
						<h1><p class="text-info" align="center">Test:${t_list.test_id}&emsp;&emsp;${t_list.test_name}</p><div id="timer" align="right"/></h1>
						
						<tr>
							<p class="font-weight-bold">Student ID:&emsp;&emsp;${usr}</p><br>
						</tr>
						<c:forEach var="q_list" items="${q_list}">
							<tr>
								<td>
									<p class="font-italic font-weight-normal">${q_list.que_no}.&emsp;&emsp;${q_list.que}</p>
									<input type="hidden" id="nt_'+${q_list.que_no}+'" name="nt_'+${q_list.que_no}+'" value="${q_list.no_files}">
									<table class="table table-borderless">
									<tbody>
									<script>
										var val=document.getElementById("nt_'+${q_list.que_no}+'").value;
										var s1='<tr><td>Transcript file:</td><td><input type="file" name="trans"/></td></tr>';
										for(var i = 1; i <= val ; i++)
										{
    										s1+= '<tr><td>File '+i+'</td><td><input type="file" name="fileUpload" accept=".v" /></td></tr>'; //accept=".v"
										}
										document.write("<br>");
										document.write(s1);
									</script>
									</tbody>
									</table>
								</td>
							</tr>
						</c:forEach>
				</table>
			</c:forEach>
			<button type="submit" value="Submit" class="btn btn-info btn-lg">Submit</button>
		</form>
		<script type="text/javascript">

			var hr = document.getElementById("hr").value;
			var min = document.getElementById("min").value;
			var sec =0;
			var total=(hr*60*60)+(min*60);
			
			hr = parseInt(total/3600);
			min=parseInt(total/60);
			sec = parseInt(total%60);
			function init()
			{
				if(total>0)
				{
					document.getElementById("timer").innerHTML='Time Left: ' + hr + ' : ' + min+ ' : ' + sec ;
					setTimeout("CheckTime()",999);
				}
			}
			function CheckTime()
			{
				document.getElementById("timer").innerHTML='Time Left: ' + hr + ' : ' + min+ ' : ' + sec  ;
				if(total <=0)
				{
					setTimeout('document.questionForm.submit()',1);
    
				} 
				else if(total==59)
				{
					alert("Last "+sec+" secs for submission");
					total = total -1;
					hr = parseInt(total/3600);
					min=parseInt(total/60)
					sec = parseInt(total%60);
					setTimeout("CheckTime()",999);
    
				} 
				else
				{
					total = total -1;
					hr = parseInt(total/3600);
					min=parseInt(total/60)
					sec = parseInt(total%60);
					setTimeout("CheckTime()",999);
				}
			}
			init();
		</script>
	</div>	
</body>
</html>