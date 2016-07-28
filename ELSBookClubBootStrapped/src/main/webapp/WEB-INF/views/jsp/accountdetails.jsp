<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Details</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>
<!-- Navigation Menu -->
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
			<ul class="nav navbar-nav">
				<li><a href="/ELSBookBootStrapped/">Home</a></li>
				<li><a href="/ELSBookBootStrapped/search">Browse</a></li>
				<li><input id="mySearchBar" type="text" class="form-control" placeholder="Search..." name="q"></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="viewmycart"><span
						class="glyphicon glyphicon-shopping-cart">
							(${shoppingcart.getIsbnList().size()})</span></a></li>
				<c:choose>
					<c:when test="${loggedin == null}">
						<li><a href="registration"><span
								class="glyphicon glyphicon-user"></span> Sign Up</a></li>
						<li><a href="login"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</c:when>
					<c:when test="${loggedin.getUsergroup() == 2}">
					
					`<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Welcome,
								${loggedin.getFirstname()}<span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="orders">My Order History</a></li>
								<li><a href="logout">Logout</a></li>
							</ul></li>
					</c:when>

				</c:choose>
			</ul>
		</div>
	</div>
	</nav>
<body>
	<div class="container">
		<div class="col-xs-12">
			<form:form name="editAccountDetails" method="post">
				<div class="row">
					<div class="col-xs-12 col-md-8 col-md-offset-2">
						<div class="page-header">
							<h1 align="center">Edit Account Details</h1>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-md-8 col-md-offset-2">
						<div class="form-group">
							<label class="control-label">Name:</label> <input type="text"
								class="form-control input-lg" name="firstName" id=firstName
								" placeholder="John" /> <input type="text"
								class="form-control input-lg" name="lastName" id=lastName
								" placeholder="Doe" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-md-8 col-md-offset-2">
						<div class="form-group">
							<label class="control-label">Email:</label> <input type="text"
								class="form-control input-lg" name="email" id="email"
								placeholder="johndoe@yahoo.com" />
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-xs-12 col-md-8 col-md-offset-2">
						<div class="form-group">
							<label class="control-label">Password:</label> <input
								type="password" class="form-control input-lg" name="password"
								id="password" placeholder="password" />
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-xs-12 col-md-8 col-md-offset-2">
						<!--  <button type="button" class="btn btn-success">Save Changes</button> -->
						<input type="submit" class="btn btn-success" value="Save Changes">
						<button type="button" class="btn btn-warning" value="back"
							onClick=history.go(-1);returnvalue; >Cancel</button>
					</div>
				</div>

			</form:form>
		</div>
	</div>


</body>
</html>