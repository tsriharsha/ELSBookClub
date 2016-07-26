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
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<body>

	   <div class="container">
       <div class="col-xs-12">
       
	<form:form name="editAccountDetails" method="post">
	
            <div class="row">
                <div class="col-xs-8 col-xs-offset-2">
                    <div class="page-header">
                        <h1 align="center">Edit Account Details</h1>
                    </div>
                </div>
            </div>
   		
        		<div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <div class="form-group">
                            <label class="control-label">Name:</label>
                            <input type="text" class="form-control input-lg" name="firstName" id=firstName" placeholder="John"/>
                            <input type="text" class="form-control input-lg" name="lastName" id=lastName" placeholder="Doe"/>
                        </div>                   
                     </div>
                </div>

        		<div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <div class="form-group">
                            <label class="control-label">Email:</label>
                            <input type="text" class="form-control input-lg" name="email" id="email" placeholder="johndoe@yahoo.com"/>
                        </div>                   
                     </div>
                </div>
        		
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <div class="form-group">
                            <label class="control-label">Password:</label>
                            <input type="password" class="form-control input-lg" name="password" id="password" placeholder="password"/>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                    	<!--  <button type="button" class="btn btn-success">Save Changes</button> -->
                    	<input type="submit" class="btn btn-success" value="Save Changes">
                        <button type="button" class="btn btn-warning" value="back" onClick=history.go(-1);return value; >Cancel</button>
                    </div>
                </div>                
 	
	 </form:form> 
    	</div>
    	</div> 


</body>
</html>