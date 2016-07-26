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
		<ul class="nav navbar-nav">
			<li><a href="/ELSBookBootStrapped/adduser">Add User</a></li>
		</ul>
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
		<form:form name="bookForm" method="POST">
        <div class="row">
            <div class="col-xs-8 col-xs-offset-2">
                <div class="page-header">
                    <h2>Add a book</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-8 col-xs-offset-2">
                <div class="form-group">
                    <label for="title">Book Title</label>
                    <input type="text" id="title" name="title" class="form-control">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-5 col-xs-offset-2">
                <div class="form-group">
                    <label for="author">Author</label>
                    <input type="text" id="author" name="author" class="form-control">
                </div>
            </div>
            <div class="col-xs-3">
                <div class="form-group">
                    <label for="genre">Genre</label><br>
                    <input type="text" id="genre" name="genre" class="form-control">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-6 col-xs-offset-2">
                <div class="form-group">
                    <label for="ISBN">ISBN</label><br>
                    <input type="text" id="ISBN" name="ISBN" class="form-control">
                </div>
            </div>
            <div class="col-xs-2">
                <div class="form-group">
                    <label for="price">Price</label><br>
                    <input type="text" id="price" name="price" class="form-control">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-8 col-xs-offset-2">
                <div class="form-group">
                    <label for="details">Details</label><br>
                    <textarea id="details" name='details' class="form-control"></textarea>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-8 col-xs-offset-2">
                <div class="form-group">
                    <input type="submit" class="form-control">
                </div>
            </div>
        </div>
        </form:form>
   </div>

</body>
</html>