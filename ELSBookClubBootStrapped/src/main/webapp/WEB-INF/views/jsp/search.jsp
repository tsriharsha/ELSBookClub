<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
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
	<spring:url value="/resources/core/css/hello.css" var="coreCss" />
	<spring:url value="/resources/core/css/bootstrap.min.css"
		var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${coreCss}" rel="stylesheet" />

	<div class="container">
		<div class="col-xs-12">
			<div class="row text-center">
				<c:forEach var="bean" items="${searchlist}">
					<div class="col-md-3 col-sm-6">
						<div class="thumbnail">
							<img src="http://placehold.it/500x300" alt="">
							<div class="caption">
								<h5>ISBN: ${bean.getIsbn() }</h5>
								<h3 style="color: #FF8200">${bean.getName() }</h3>
								<h4 style="color: #007398">Price: $${bean.getPrice() }</h4>
								<p style="color: #A7A8AA">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
								<div class="col-xs-12" style="text-align: center;">
									<a href="addtocart/${bean.getIsbn()}+${bean.getPrice()}"
										class="btn btn-primary" style="width: 100%;">Add to Cart</a>
									<hr id="addToCartHR" />
								</div>

								<div class="btn-group btn-group-justified">
									<button type="button" class="btn btn-warning"
										data-toggle="modal" data-target="#printModal"
										style="width: 43%;">Print</button>

									<button type="button" class="btn btn-success"
										data-toggle="modal" data-target="#downloadModal"
										style="width: 44%;">Download</button>
								</div>

								<!--Print Modal -->
								<div id="printModal" class="modal fade" role="dialog">
									<div class="modal-dialog">

										<!-- Modal Content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 style="text-align: left;" class="modal-title">Print
													${bean.getName() }</h4>
											</div>
											<div class="modal-body">
												<p>You must proceed to checkout in order to print this
													content. Please click 'Add to Cart' below!</p>
											</div>
											<div class="modal-footer">
												<a href="addtocart/${bean.getIsbn()}+${bean.getPrice()}"
													class="btn btn-primary" style="width: 100%;">Add to
													Cart</a>
											</div>
										</div>

									</div>
								</div>

								<!--Download Modal -->
								<div id="downloadModal" class="modal fade" role="dialog">
									<div class="modal-dialog">

										<!--Modal Content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 style="text-align: left;" class="modal-title">Download ${bean.getName() }</h4>
											</div>
											<div class="modal-body">
												<p>You must proceed to checkout in order to download this
													content to your device. Please click 'Add to Cart' below!</p>
											</div>
											<div class="modal-footer">
												<a href="addtocart/${bean.getIsbn()}+${bean.getPrice()}"
													class="btn btn-primary" style="width: 100%;">Add to
													Cart</a>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>

	<script src="${coreJs}"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<script src="<c:url value="/resources/js/jquery.1.9.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>