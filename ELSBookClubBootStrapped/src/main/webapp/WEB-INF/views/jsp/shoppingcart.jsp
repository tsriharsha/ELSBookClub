<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Orders</title>

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
          <div class="row">
            <div class="col-xs-12 col-md-8 col-md-offset-2">
                <div class="page-header">
                    <h2>Shopping Cart</h2>
                </div>
            </div>
        </div>
   <c:choose>
		<c:when test="${shoppingcart.getIsbnList().size() > 0}">     
		<div class="row">
					
			<div class="table-container">
				<table class="table table-filter">
					<tbody>
						<tr>
							<th style="text-align: center">Title</th>
							<th style="text-align: center">Author</th>
							<th style="text-align: center">ISBN</th>
							<th style="text-align: center">Price</th>
							<th style="text-align: center">Amount</th>
							<th style="text-align: center">Delete</th>
						</tr>
					
       					<c:forEach var="cart" items="${shoppingcartlist}" varStatus="loop">
       						<form:form>
							<tr>
								<td style="text-align: center">${cart.getName()}</td>
								<td style="text-align: center">${cart.getAuthor()}</td>
								<td style="text-align: center">${cart.getIsbn()}</td>
								<td style="text-align: center">${cart.getPrice()}</td>
								<td style="text-align: center">${shoppingcart.getAmount(loop.index)}</td>
								<td style="text-align: center"><input type="submit" formmethod="post" formaction="removefromcart/${cart.getIsbn()}+${cart.getPrice()}" value="Delete"></td>
							</tr>
							</form:form>
						</c:forEach>
					</tbody>				
				</table>
			
			</div>
		</div>
		
        <div class="buttonRight">
        	<a href="/ELSBookBootStrapped/checkout" class="btn btn-primary">Proceed to Checkout</a>
        </div>
        </c:when>
        </c:choose>
   </div>
		<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>