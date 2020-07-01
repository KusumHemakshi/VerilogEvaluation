<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Test</title>
	</head>
	<body onload="load();">
		
			<jsp:include page="welcomef.jsp" />
			<br><br>
			<script type="text/javascript">
				load = function()
				{
					alert("Added New Test Successfully");
				}

			</script>
	</body>
</html>