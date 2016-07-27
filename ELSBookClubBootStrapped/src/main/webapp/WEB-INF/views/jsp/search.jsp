<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 
<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
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
                  <h5>${bean.getIsbn() }</h5>
                  <h3 style="color:blue">${bean.getName() }</h3>
                  <h4 style="color:red">Price: $${bean.getPrice() }</h4>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                  <p>
                      <a href="addtocart/${bean.getIsbn()}+${bean.getPrice()}" class="btn btn-primary" >Add to cart!</a>
                  </p>
              </div>
          </div>
      </div>
        </c:forEach>
  </div>

</div>
</div>
 <script src="<c:url value="/resources/js/jquery.1.9.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap-min.js" />"></script>
</body>
</html>