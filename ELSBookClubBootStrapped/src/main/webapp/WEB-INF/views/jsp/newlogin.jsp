<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Login</title>

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
				<li><a href="/ELSBookBootStrapped/adduser"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			</ul>
		</div>
	</div>
</nav>
<body>
	<div class="container">
		<div class="col-xs-12">
			<form:form name="loginForm" method="post">
				<div class="row">
					<div class="col-xs-12 col-md-8 col-md-offset-2">
						<div class="page-header">
							<h1 align="center">Sign in to your account.</h1>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-md-6 col-md-offset-3">
						<div class="form-group">
							<label class="control-label">Email:</label>
							<div id="message"></div>
							<input type="text" class="form-control input-lg" name="userName"
								id="email" placeholder="name@domain.com" value="${userN}"
								required />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-md-6 col-md-offset-3">
						<div class="form-group">
							<label class="control-label">Password:</label> <input
								type="password" class="form-control input-lg" name="password"
								id="password" placeholder="password" value="${pass}" required />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-md-6 col-md-offset-3">
						<button type="submit" class="btn btn-success">Sign In</button>
					</div>
					<div style="color: red">${error}</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-md-6 col-md-offset-3">
						<br> <a href="registration">New user? Register Here.</a>
						<!-- ^^^*******Fix Above Link When Registration Complete -->
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>