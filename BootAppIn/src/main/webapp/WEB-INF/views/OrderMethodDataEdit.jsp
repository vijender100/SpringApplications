<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<script type="text/javascript" src="../bootstrap/js/popper.min.js"></script>
<title>OrderMethodDataEdit</title>
</head>
<body>
<%@include file="Menu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>WELCOME TO ORDER METHOD REGISTER PAGE</h2>
			</div>
			<!-- CARD HEAD END -->
			<div class="card-body">
				
				<form:form action="update" method="post" modelAttribute="orderMethod">

					<div class="form-group">
						<label for="orderMethdId" class="control-label  col-sm-4">Order Method Id</label>
						<form:input path="orderMethdId" readonly="true" cssClass="form-control col-sm-4" />
						<form:errors path="orderMethdId" cssClass="text-danger" />
					</div>
					
					<div class="form-group">
						<label for="orderMode" class="control-label col-sm-2">Order Mode</label><br>
						<form:radiobuttons path="orderMode" items="${orderMode}" cssClass="radio offset-sm-1" />
						<form:errors path="orderMode" items="${orderMode}" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="orderCode" class="control-label col-sm-4">Order Code</label>
						<form:input path="orderCode" cssClass="form-control col-sm-4" />
						<form:errors path="orderCode" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="orderMethd" class="control-label col-sm-4">Order Method</label>
						<form:select path="orderMethd" cssClass="form-control col-sm-4">
							<form:option value="">--Select--</form:option>
							<form:options items="${orderMethd}" />
						</form:select>
						<form:errors path="orderMethd" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="orderAccept" class="control-label col-sm-2">Order Accept</label><br>
						<form:checkboxes path="orderAccept" items="${orderAccept}" cssClass="checkbox offset-sm-1" />
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

					<input type="submit" value="Update Order Method" class="btn btn-success" />
				</form:form>
			</div>
			<!-- CARD BODY END -->
			</div>
		<!--CARD END -->
	</div>
	<!-- CONTAINER END -->
</body>
</html>