<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Welcome</title>
	</head>
	<body onload="load();">
		
			<jsp:include page="index.jsp" />
			<br><br>
			<script type="text/javascript">
				load = function()
				{
					alert("Invalid token");
				}

			</script>
	</body>
</html>