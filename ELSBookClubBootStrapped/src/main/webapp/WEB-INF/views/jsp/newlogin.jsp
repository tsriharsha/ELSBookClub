<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="#" method="get">
        <div class="col-xs-6 col-xs-offset-3">

                <legend>Account Login</legend>
                        <label class="control-label" for="UserName">Username</label>
                        <input type="email" id="Username" class="form-control" name="username" placeholder="name@domain.com" autofocus>

                        <label class="control-label" for="password">Password</label>
                        <input type="text" id="password" class="form-control" name="password" placeholder="password"> <br />

                        <button class="btn btn-success" type="submit">Log In</button> <br /> <br />

                        <a href="SignUp.html">New user? Register Here.</a>

        </div>

    </form>
</body>
</html>