<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Add User</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>
<nav id="theNavbar" class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a id="theNavbarBrand" class="navbar-brand" href="elsevier.com"
				target="_blank">ELSEVIER</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="signup.jsp"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="newlogin.jsp"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
	</div>
</nav>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-8 col-xs-offset-2">
				<div class="page-header">
					<h1>Add New User</h1>
					<div class="clearfix"></div>
				</div>
				<!--First & Last Name-->
				<div class="form-group">
					<div class="row">
						<div class="col-xs-6">
							<label id="lblFirstName" class="control-label">First Name</label>
							<input id="txtFirstName" class="form-control input-lg"
								placeholder="First Name" autofocus required>
						</div>
						<div class="col-xs-6">
							<label id="lblLastName" class="control-label">Last Name</label> <input
								id="txtLastName" class="form-control input-lg"
								placeholder="Last Name" required>
						</div>
					</div>
				</div>
				<!--Email Address-->
				<div class="form-group">
					<div class="row">
						<div class="col-xs-12">
							<label id="lblEmailAddress" class="control-label">Email
								Address</label> <input id="txtEmailAddress"
								class="form-control input-lg" placeholder="Email Address"
								required>
						</div>
					</div>
				</div>
				<!--Password-->
				<div class="form-group">
					<div class="row">
						<div class="col-xs-12">
							<label id="lblPassword" class="control-label">Password</label> <input
								id="txtPassword" class="form-control input-lg" type="password"
								placeholder="Password" required>
						</div>
					</div>
				</div>
				<button type="button" class="btn btn-primary btn-lg">Add
					User</button>
			</div>
		</div>
	</div>
	<spring:url value="/resources/core/css/hello.js" var="coreJs" />
	<spring:url value="/resources/core/css/bootstrap.min.js"
		var="bootstrapJs" />

	<script src="${coreJs}"></script>
	<script src="${bootstrapJs}"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>