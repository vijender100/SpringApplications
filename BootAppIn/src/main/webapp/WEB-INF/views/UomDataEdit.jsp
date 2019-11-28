<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="../bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<script type="text/javascript"
	src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../bootstrap/js/jquery-3.2.1.slim.min.js"></script>
<script type="text/javascript" src="../bootstrap/popper.min.js"></script>
<title>Uom Data Edit</title>
</head>
<body>
<%@include file="Menu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>WELCOME TO UOM EDIT PAGE</h2>
			</div>
			<!-- CARD HEAD END -->
			<div class="card-body">
				<form:form action="update" method="post" modelAttribute="uom">

					<div class="form-group">
						<label for="uomId" class="control-label  col-sm-4">UOM Id</label>
						<form:input path="uomId" readonly="true" cssClass="form-control col-sm-4" />
						<form:errors path="uomId" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="uomType" class="control-label  col-sm-4">UOM Type</label>
						<form:select path="uomType" cssClass="form-control  col-sm-4">
							<form:option value="">--Select--</form:option>
							<form:options items="${uomTypes}"/>
						</form:select>
						<form:errors path="uomType" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="uomModel" class="control-label col-sm-4">UOM Model</label>
						<form:input path="uomModel" cssClass="form-control col-sm-4" />
						<form:errors path="uomModel" cssClass="text-danger" />
					</div>
					
					<div class="form-group">
						<label for="createdOn" class="control-label col-sm-4">Created On</label>
						<form:input path="createdOn" readonly="true"  cssClass="form-control col-sm-4" />
					</div>
					
					<div class="form-group">
						<label for="modifiedOn" class="control-label col-sm-4">Modified On</label>
						<form:input path="modifiedOn" readonly="true" cssClass="form-control col-sm-4" />
					</div>

					<div class="form-group">
						<label for="description" class="control-label col-sm-4">Description</label>
						<form:textarea path="description" cssClass="form-control col-sm-4" />
						<form:errors path="description" cssClass="text-danger" />
					</div>

					<input type="submit" value="Update UOM" class="btn btn-success" />

				</form:form>
			</div>
			<!-- CARD BODY END -->
		</div>
		<!--CARD END -->
	</div>
	<!-- CONTAINER END -->
</body>
</html>