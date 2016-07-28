<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>

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
		<ul class="nav navbar-nav">
			<li><a href="/ELSBookBootStrapped/adduser">Add User</a></li>
			<li><a href="/ELSBookBootStrapped/viewbooks">View Books</a></li>
		</ul>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="registration"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
						
			</ul>
		</div>
	</div>
</nav>
<br />
<br />
<br />
<br />
<div class="container">
	<div class="col-xs-8 col-xs-offset-2">
		<h1 align="center">
			Elsevier Book Club <span class="label label-default"></span>
		</h1>
		<div class="form-group">
			<input id="mySearchBar" class="form-control input-lg" name="search"
				id="inputlg" type="text" placeholder="Search..">
		</div>
	</div>
</div>
<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js"
	var="bootstrapJs" />
	
<script src="${coreJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>

jQuery.ajax({
            url: "rest/list/items",
            type: "GET",

            contentType: 'application/json; charset=utf-8',
            success: function(resultData) {
                //here is your json.
                  // process it
                  console.log(resultData);

            },
            error : function(jqXHR, textStatus, errorThrown) {
            },

            timeout: 120000,
        });
</script>
</body>
</html>