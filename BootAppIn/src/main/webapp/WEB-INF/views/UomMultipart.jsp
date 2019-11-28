<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<script type="text/javascript"
	src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../bootstrap/js/jquery-3.2.1.slim.min.js"></script>
<script type="text/javascript" src="../bootstrap/popper.min.js"></script>

<title>UomMultipart Page</title>
</head>
<body>
<%@include file="Menu.jsp" %>
	<div class="container">
		<div class="card">
			 <div class="card-header bg-primary text-white">
				<h1>Uom Bulk Upload/Download Screen</h1>
			</div>
			<div class="card-body">
			<form action="uomimport" method="post" enctype="multipart/form-data">
			
				<div class="form-group">
				<label for="uomFile" class="control-label col-sm-2">Select File</label> 
				<input type="file" name="uomFile" class="custom-file-control col-sm-3"/> 
				</div>
				
				<input type="submit" value="Import UOM's" class="btn btn-success">
				<a href="exportUoms" class="btn btn-info">Export Data</a>
			</form>
		</div>
		<!-- CARD BODY END -->
		<c:if test="${!empty message}">
			<div class="card-footer bg-success text-white">
				<c:out value="${message}"></c:out>
			</div>
			<!--CARD FOOTER END -->
		</c:if>

		<c:if test="${!empty errorsMap}">
			<table class="table table-hover">
			   <tr class="thead-light">
			      <th>#</th>
			      <th>Errors</th>
			   </tr>
			   <c:forEach items="${errorsMap}" var="e">
			       <tr>
			          <td><c:out value="${e.key}"></c:out></td>
			          <td><c:out value="${e.value}"></c:out></td>
			       </tr>
			   </c:forEach>
			</table>
		</c:if>
		
	</div>
	<!--CARD END -->
	</div>
	<!-- CONTAINER END -->
</body>
</html>