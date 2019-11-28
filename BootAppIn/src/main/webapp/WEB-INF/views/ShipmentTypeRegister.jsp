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
<script type="text/javascript" src="../bootstrap/popper.min.js"></script>
<title>ShipmentType Register Page</title>
</head>
<body>
<%@include file="Menu.jsp" %>
 <div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>Welcome To ShipmentType Register Page</h2>
			</div>
			
			<div class="card-body">
 			<form:form action="register" method="post" modelAttribute="shipmentType"> 
		    
		    <div class="form-group">
				<label for="shipmentMode" class="control-label col-sm-4">Shipment Mode</label>	
				<form:select path="shipmentMode" cssClass="form-control col-sm-4">
					   		<form:option value="">--SELECT--</form:option>
 							<form:options items="${shipmentMode}"/>
					   		</form:select> 
					   		<form:errors path="shipmentMode" cssClass="text-danger"/>
			</div>
			
			<div class="form-group">
				<label for="shipmentCode" class="control-label col-sm-4">Shipment Code</label>
							<form:input path="shipmentCode" cssClass="form-control col-sm-4"/>
							<form:errors path="shipmentCode" cssClass="text-danger"/>
			</div>	
			
			<div class="form-group">			
       			<label for="enableShipment" class="control-label col-sm-2">Enable Shipment</label>
       			<form:checkbox path="enableShipment" value = "YES" cssClass="checkbox offset-sm-1"/>YES 
        	</div>	
        	
        	<div class="form-group">
				<label for=shipmentGrade class="control-label col-sm-4">Shipment Grade</label><br>
				<form:radiobuttons path="shipmentGrade" items="${shipmentGrade}" cssClass="radio offset-sm-1"/><br>
							<form:errors path="shipmentGrade" cssClass="text-danger"/>
			</div>
			<div class="form-group">
				<label for=description class="control-label col-sm-4">Description</label>
							<form:textarea path="description" cssClass="form-control col-sm-4"/>
							<form:errors path="description" cssClass="text-danger"/>
			</div>	
					
							<input type="submit" value="create Shipment" class="btn btn-success"/>
							&nbsp;&nbsp;&nbsp;<input type="reset" value="Clear" class="btn btn-danger" />
 			</form:form>
 			</div>
			<!-- CARD BODY END -->
			<c:if test="${null!=message}">
				<div class="card-footer bg-success text-white">
					<b>${message}</b>
				</div>
				<!--CARD FOOTER END -->
			</c:if>
 		</div>
		<!--CARD END -->
 	</div>
	<!-- CONTAINER END -->
</body>
</html>