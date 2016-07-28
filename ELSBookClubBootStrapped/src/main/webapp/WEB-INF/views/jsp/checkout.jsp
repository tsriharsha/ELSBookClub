<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Out</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
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
    	<form:form name="checkForm" method="POST">
        <div class="row">
            <div class="col-xs-12 col-md-8 col-md-offset-2">
                <div class="page-header">
                    <h2>Check Out</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-md-8 col-md-offset-2">
                <div class="form-group">
                    <label for="name">Name On Card</label><br>
                    <input type="text" id="name" name="name" class="form-control" required>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-md-6 col-md-offset-2">
                <div class="form-group">
                    <label for="CCN">Credit Card Number</label><br>
                    <input type="text" id="CCN" name="CCN" class="form-control" required placeholder="####-####-####-####">
                </div>
            </div>
            <div class="col-xs-12 col-md-2">
                <div class="form-group">
                    <label for="expires">Expiration Date</label><br>
                    <input type="text" id="expires" name="expires" class="form-control" required placeholder="MM/YY">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-md-4 col-md-offset-2">
                <div class="form-group">
                    <label for="country">Country</label><br>
                    <input type="text" id="country" name="country" class="form-control" required>
                </div>
            </div>
            <div class="col-xs-12 col-md-4">
                <div class="form-group">
                    <label for="state">State</label><br>
                    <input type="text" id="state" name="state" class="form-control" required>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-md-6 col-md-offset-2">
                <div class="form-group">
                    <label for="address">Address</label><br>
                    <input type="text" id="address" name="address" class="form-control" required>
                </div>
            </div>
             <div class="col-xs-12 col-md-2">
                <div class="form-group">
                    <label for="zip">Zip Code</label><br>
                    <input type="text" id="zip" name="zip" class="form-control" required>
                </div>
            </div>
        </div>
        <br><br>
        <div class="row">
            <div class="col-xs-12 col-md-8 col-md-offset-2">
                <div class="form-group">
                    <input type="submit" class="btn btn-primary btn-lg" style="width: 100%">
                </div>
            </div>
        </div>
        </form:form>
    </div>
    

</body>
</html>
