<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add A Book</title>

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
				<li><a href="/ELSBookBootStrapped/">Home</a>
				<li><a href="/ELSBookBootStrapped/search?search=">Browse</a>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="shoppingcart"><span
						class="glyphicon glyphicon-shopping-cart">
							(${shoppingcart.getIsbnList().size()})</span></a></li>
				<c:choose>
					<c:when test="${loggedin == null}">
						<li><a href="registration"><span
								class="glyphicon glyphicon-user"></span> Sign Up</a></li>
						<li><a href="login"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</c:when>
					<c:when test="${loggedin != null && loggedin.getUsergroup() == 1  }">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Welcome,
								${loggedin.getFirstname()}<span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="orders">My Order History</a></li>
								<li><a href="logout"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>
							</ul>
					</li>
						
					</c:when>
					<c:when test="${loggedin != null && loggedin.getUsergroup() == 2 }">
					`<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Welcome,
								${loggedin.getFirstname()}<span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="orders">My Order History</a></li>
								<li><a href="addbook">Add Books</a></li>
								<li><a href="viewbooks">View Books</a></li>
								<li><a href="adduser">Add User</a></li>
								<li><a href="viewusers">View Users</a></li>
								<li><a href="logout"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>
							</ul>
					</li>
					</c:when>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>

<body>

	<div class="container">
		<form:form name="bookForm" method="POST">
        <div class="row">
            <div class="col-xs-12 col-md-8 col-md-offset-2">
                <div class="page-header">
                    <h2>Add a book</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-md-8 col-md-offset-2">
                <div class="form-group">
                    <label for="title">Book Title</label>
                    <input type="text" id="title" name="title" class="form-control" required>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-md-8 col-md-offset-2">
                <div class="form-group">
                    <label for="author">Author</label>
                    <input type="text" id="author" name="author" class="form-control" required>
                </div>
            </div>
            <div class="col-xs-12 col-md-8 col-md-offset-2">
                <div class="form-group">
                    <label for="genre">Genre</label><br>
                    <input type="text" id="genre" name="genre" class="form-control" required>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-md-6 col-md-offset-2">
                <div class="form-group">
                    <label for="ISBN">ISBN</label><br>
                    <input type="number" id="ISBN" name="ISBN" class="form-control" required>
                </div>
            </div>
            <div class="col-xs-12 col-md-2">
                <div class="form-group">
                    <label for="price">Price</label><br>
                    <input type="number" step="0.01" min = 0 id="price" name="price" class="form-control" required>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-md-8 col-md-offset-2">
                <div class="form-group">
                    <label for="details">Details</label><br>
                    <textarea id="details" name='details' class="form-control" required></textarea>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-md-8 col-md-offset-2">
                <div class="form-group">
                	<button style="width: 100%;" type="submit" class="btn btn-lg btn-primary">Add Book</button>
                </div>
            </div>
        </div>
        <div class="row">
        	<div class="col-xs-12 col-md-8 col-md-offset-2">
        		<div style="color: red; text-align:center">${error}</div>
        	</div>
        </div>
        </form:form>
   </div>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>