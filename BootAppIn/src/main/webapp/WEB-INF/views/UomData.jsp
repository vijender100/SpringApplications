<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
<script type="text/javascript" src="../bootstrap/js/popper.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/SearchPageParam.js"></script>
<title>UomData Page</title>
</head>
<body>
<%@include file="Menu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info text-white">
				<h1>Welcome To UomData</h1>
			</div>
			<!-- CARD HEAD END -->
			<div class="card-body">
			<form:form cssClass="form-inline" action="all" method="get" modelAttribute="uom">
			
			   <div class="form-group">
			      <label for="uomType" class="control-label">Select UOM Type</label>
			      
			      <form:select path="uomType" cssClass="form-control">
			         <form:option value="">--Select--</form:option>
			         <form:options items="${uomTypes}"/>
			      </form:select><br>
			     </div>
			     
			     <div class="form-group">
			      <label class="control-label">Enter UOM Model</label>
			      <form:input path="uomModel" cssClass="form-control"/><br>
			      </div>
			      
			     <div class="form-group"> 
			      <label for="description" class="control-label col-sm-4">Description</label>
			      <form:textarea path="description" cssClass="form-control"/><br>
			     </div>
			        
			      <input type="submit" value="Search UOM's" class="btn btn-success">
			    
			</form:form>
			<hr/><br>
			
			
				<table class="table table-hover">
					<tr class="thead-light">
						<th>ID</th>
						<th>Type</th>
						<th>MODEL</th>
						<th>DESC</th>
						<th>CREATED</th>
						<th>MODIFIED</th>
						<th colspan="2">OPERATIONS</th>
					</tr>
					<c:forEach items="${page.getContent()}" var="uom">
						<tr>
							<td><c:out value="${uom.uomId}" /></td>
							<td><c:out value="${uom.uomType}" /></td>
							<td><c:out value="${uom.uomModel}" /></td>
							<td><c:out value="${uom.description}" /></td>
							<td><c:out value="${uom.createdOn}" /></td>
							<td><c:out value="${uom.modifiedOn}" /></td>
							<td><a href="delete?uomId=${uom.uomId}" class="btn btn-danger">DELETE</a></td>
							<td><a href="edit?uomId=${uom.uomId}" class="btn btn-info">EDIT</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<!-- CARD BODY END -->
			<div class="card-footer text-white">
				<ul class="pagination">
					<c:if test="${!page.isFirst()}">
						<li class="page-item"><a class="page-link" href="#" onclick="setParam('page',0)">First</a></li>
					</c:if>
					<!-- End of  First link -->

					<c:if test="${page.hasPrevious()}">
						<li class="page-item"><a class="page-link"
							href="#" onclick="setParam('page',${page.getNumber()-1})">Previous</a></li>
					</c:if> 
					<!-- End of Previous link -->

					<c:if test="${!empty page.getContent()}">
					<c:forEach begin="0" end="${page.getTotalPages()-1}" var="i">
						<c:choose>
							<c:when test="${page.getNumber() eq i}">
								<li class="page-item active"><a class="page-link" href="#">${i+1}</a></li>
							</c:when> 
						<c:otherwise>
							<li class="page-item"><a class="page-link" href="#" onclick="setParam('page',${i})">${i+1}</a></li>
						</c:otherwise>
					   </c:choose>
					</c:forEach>
					</c:if>
					<!-- End of Pagination Order -->


					<c:if test="${page.hasNext()}">
						<li class="page-item"><a class="page-link"
							href="#" onclick="setParam('page',${page.getNumber()+1})">Next</a></li>
					</c:if>
					<!-- End of Next link -->

					<c:if test="${!page.isLast()}">
						<li class="page-item"><a class="page-link"
							href="#" onclick="setParam('page',${page.getTotalPages()-1})">Last</a></li>
					</c:if>
					
				</ul>
			</div>
			<!-- CARD FOOTER END -->
		</div>
		<!-- CARD END -->
	</div>
	<!-- CONTAINER END -->
</body>
</html>