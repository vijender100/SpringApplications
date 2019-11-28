<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="../bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<script type="text/javascript"
	src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../bootstrap/js/jquery-3.2.1.slim.min.js"></script>
<script type="text/javascript" src="../bootstrap/popper.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ShipmentTypeDataEdit</title>
</head>
<body>
<%@include file="Menu.jsp" %>
<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>WELCOME TO ShipmentType EDIT PAGE</h2>
			</div>
			<!-- CARD HEAD END -->
			<div class="card-body">
				<form:form action="update" method="post" modelAttribute="shipmentType">
				
				<div class="form-group">
						<label for="shipmentTypeId" class="control-label  col-sm-4">Shipment Type Id</label>
						<form:input path="shipmentTypeId" readonly="true" cssClass="form-control col-sm-4" />
					</div>
					
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
				
				<div class="form-group">
						<label for="createdOn" class="control-label col-sm-4">Created Date</label>
						<form:input path="createdOn" cssClass="form-control col-sm-4" readonly="true"/>
						
				</div>
					
				<div class="form-group">
						<label for="modifiedOn" class="control-label col-sm-4">Modified Date</label>
						<form:input path="modifiedOn" cssClass="form-control col-sm-4" readonly="true"/>
						
				</div>
					
							<input type="submit" value="Update Shipment" class="btn btn-success"/>
 			</form:form>
				 
			</div>
			<!-- CARD BODY END -->
		</div>
		<!--CARD END -->
	</div>
	<!-- CONTAINER END -->
</body>
</html>