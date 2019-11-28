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
<title>Purchase Order Edit</title>
</head>
<body>
	<%@include file="Menu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-heading bg-primary text-white">
				<h1>Welcome to Purchase Order Edit Page!!</h1>
			</div>
			<!-- CARD HEADING END -->
			<div class="card-body">
				<div class="container">
					<form:form action="update" method="POST" modelAttribute="po">

						<div class="form-group">
							<form:label path="orderId"
								cssClass="control-label col-sm-offset-4 font-weight-bold">Order Id</form:label>
							<form:input path="orderId" cssClass="form-control col-sm-4"
								readonly="true" />
						</div>

						<div class="form-group">
							<form:label path="orderCode"
								cssClass="control-label col-sm-offset-4 font-weight-bold">Order Code</form:label>
							<form:input path="orderCode" cssClass="form-control col-sm-4" />
							<form:errors path="orderCode" cssClass="text-danger"/>
						</div>

						<div class="form-group">
							<form:label path="shipmentMode"
								cssClass="control-label col-sm-offset-4 font-weight-bold">Mode</form:label>
							<form:select path="shipmentMode" cssClass="form-control col-sm-4">
								<form:option value="">--SELECT--</form:option>
								<form:options items="${shipmentTypes}" itemLabel="shipmentCode"
									itemValue="shipmentTypeId" />
							</form:select>
							<form:errors path="shipmentMode" cssClass="text-danger"/>
						</div>

						<div class="form-group">
							<form:label path="vendor"
								cssClass="control-label col-sm-offset-4 font-weight-bold">Vendors</form:label>
							<form:select path="vendor" cssClass="form-control col-sm-4">
								<form:option value="">--SELECT--</form:option>
								<form:options items="${vendorsList}" itemLabel="userCode"
									itemValue="whUserTypeId" />
							</form:select>
							<form:errors path="vendor" cssClass="text-danger"/>
						</div>

						<div class="form-group">
							<form:label path="refernceNumber"
								cssClass="control-label col-sm-offset-4 font-weight-bold">Reference Num</form:label>
							<form:input path="refernceNumber"
								cssClass="form-control col-sm-4" />
								<form:errors path="refernceNumber" cssClass="text-danger"/>
						</div>

						<div class="form-group">
							<form:label path="qualityCheck"
								cssClass="control-label col-sm-offset-4 font-weight-bold">Quality Check</form:label>
							<form:radiobuttons path="qualityCheck" items="${qualityChecks}"
								cssStyle="margin:10px;" />
							<form:errors path="qualityCheck" cssClass="text-danger"/>
						</div>

						<div class="form-group">
							<form:label path="status"
								cssClass="control-label col-sm-offset-4 font-weight-bold">Status</form:label>
							<form:input path="status" cssClass="form-control col-sm-4"
								readonly="true" value="OPEN" />
						</div>

						<div class="form-group">
							<form:label path="description"
								cssClass="control-label col-sm-offset-4 font-weight-bold">Description</form:label>
							<form:textarea path="description"
								cssClass="form-control col-sm-4" />
							<form:errors path="description" cssClass="text-danger"/>
						</div>

						<div class="form-group">
							<label for="createdOn" class="control-label col-sm-2">Created
								On</label>
							<form:input path="createdOn" cssClass="form-control col-sm-4"
								readonly="true" />
						</div>

						<div class="form-group">
							<label for="modifiedOn" class="control-label col-sm-2">Modified
								On</label>
							<form:input path="modifiedOn" cssClass="form-control col-sm-4"
								readonly="true" />
						</div>

						<div class="form-group">
							<input type="submit" value="Update Order"
								class="btn btn-outline-success">
						</div>
					</form:form>
				</div>
			</div>
			
			<c:if test="${!empty po}">
				<div class="card-footer bg-success text-white">
					<h3>${po}</h3>
				</div>
				<!--CARD FOOTER END -->
			</c:if>
		</div>
	</div>
</body>
</html>