<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Faculty</title>
	</head>
	<body onload="load();">
		
			<jsp:include page="aaf.jsp" />
			<br><br>
			<script type="text/javascript">
				load = function()
				{
					alert("Added Faculty Successfully. Verification mail has been sent to user");
				}

			</script>
	</body>
</html>