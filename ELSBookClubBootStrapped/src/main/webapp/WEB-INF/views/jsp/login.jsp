<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Login Form</title>

 
<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />

</head>
<body>
	<form:form name="submitForm" method="POST">

		<div align="center">
			<table>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="userName" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><button type="submit" class="btn btn-primary">Submit</button></td>
				</tr>
			</table>
			<div style="color: red">${error}</div>

		</div>
	</form:form>
	<h1>hello test</h1>
	<button type="button" class="btn btn-default">Default</button>
	<button type="button" class="btn btn-primary">Primary</button>
	<script src="<c:url value="/resources/js/jquery.1.9.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap-min.js" />"></script>
</body>
</html>