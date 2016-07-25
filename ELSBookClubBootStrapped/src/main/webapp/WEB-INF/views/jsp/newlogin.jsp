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
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>


<body>     

	   <div class="container">
       <div class="col-xs-12">
       
	<form name="loginForm" action="//POST_TO_DB" method="post">
	
            <div class="row">
                <div class="col-xs-8 col-xs-offset-2">
                    <div class="page-header">
                        <h1 align="center">Sign in to your account.</h1>
                    </div>
                </div>
            </div>
   		
        		<div class="row">
                    <div class="col-xs-6 col-xs-offset-3">
                        <div class="form-group">
                            <label class="control-label">Email:</label>
                            <div id="message"></div>
                            <input type="text" class="form-control input-lg" name="email" id="email" placeholder="name@domain.com"/>
                        </div>                   
                     </div>
                </div>
        		
                <div class="row">
                    <div class="col-xs-6 col-xs-offset-3">
                        <div class="form-group">
                            <label class="control-label">Password:</label>
                            <input type="text" class="form-control input-lg" name="password" id="password" placeholder="password"/>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-xs-6 col-xs-offset-3">
                        <button type="button" class="btn btn-success">Sign In</button>
                    </div>
                </div>
                
                <div class="row">
                	<div class="col-xs-6 col-xs-offset-3">
                		<br>
                    	<a href="src/main/webapp/WEB-INF/views/jsp/hello.jsp">New user? Register Here.</a>
                    	<!-- ^^^*******Fix Above Link When Registration Complete -->
                	</div>
            	</div>
            	
	 </form> 
    	</div>
    	</div> 

</body>
</html>