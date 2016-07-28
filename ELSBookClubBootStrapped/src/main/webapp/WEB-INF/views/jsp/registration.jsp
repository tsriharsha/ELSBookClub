<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
<title>Registration</title>
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
				<li><a href="/ELSBookBootStrapped/newlogin"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
	</div>
</nav>

<body>
	<div class="container">
		<div class="col-xs-12">
			<div class="row">
				<div class="col-xs-12 col-md-8 col-md-offset-2">
					<div class="page-header">
						<h1>Registration</h1>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-md-8 col-md-offset-2">
					<a href="login">Login</a>
				</div>
			</div>
			<form:form name="submitForm" method="POST">
				<div align="center">
					<table>
						<tr>
							<td>First Name</td>
							<td><input type="text" class="form-control" name="firstName" /></td>
						</tr>

						<tr>
							<td>Last Name</td>
							<td><input type="text" class="form-control" name="lastName" /></td>
						</tr>


						<tr>
							<td>Email</td>
							<td><input type="email" class="form-control" name="email" /></td>
						</tr>

						<tr>
							<td>Password</td>
							<td><input class="form-control" type="password"
								name="password" /></td>
						</tr>
						<tr>
							<td></td>
							<td><button type="submit"
									class="btn btn-primary form-control">Submit</button></td>
						</tr>
					</table>

				</div>
			</form:form>
			<!-- <form:form name="submitForm" method="POST">
                
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <div class="form-group">
                            <label class="control-label">Email:</label>
                            <div id="message"></div>
                            <input type="text" class="form-control input-lg" name="email" id="email" />
                        </div>                   
                     </div>
                </div>

                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <div class="form-group">
                            <label class="control-label">First Name:</label>
                            <input type="text" class="form-control input-lg" name="firstName" />
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <div class="form-group">
                            <label class="control-label">Last Name:</label>
                            <input type="text" class="form-control input-lg" name="lastName" />
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <div class="form-group">
                            <label class="control-label">Password:</label>
                            <input type="text" class="form-control input-lg" name="password" />
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="submit" class="btn btn-default">Register />
                    </div>
                </div>
                
            </form:form>-->
		</div>
	</div>
</body>
</html>