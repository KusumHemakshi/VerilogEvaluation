<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Student</title>
	</head>
	<body onload="load();">
		
			<jsp:include page="welcomes.jsp" />
			<br><br>
			<script type="text/javascript">
				load = function()
				{
					alert("You have already submitted your test");
				}

			</script>
	</body>
</html>