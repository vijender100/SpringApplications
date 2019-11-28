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
<script type="text/javascript">
$(document).ready(function() {
	
    $('input[type=radio][name=userType]').change(function() {
        if (this.value == 'Vendor') {
           $("#userFor").val("Purchase Type");
        }
        else if (this.value == 'Customer') {
        	$("#userFor").val("Sale Type");
        }
    });
    
    $(function() {
        $("#userIdType").change(function() {
        	if (this.value == 'OTHERS') {
                $("#ifOther").prop("readonly",false);
             }
             else  {
             	$("#ifOther").val("").prop("readonly",true);
             }
        });
    });
});
</script>
<title>WhUserTypeDataEdit</title>
</head>
<body>
<%@include file="Menu.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>Welcome To WhUserType Edit Page</h2>
			</div>

			<div class="card-body">
					<form:form action="update" method="post" modelAttribute="whUserType">

					<div class="form-group">
						<label for="whUserTypeId" class="control-label  col-sm-4">WhUserType Id</label>
						<form:input path="whUserTypeId" readonly="true" cssClass="form-control col-sm-4" />
						<form:errors path="whUserTypeId" cssClass="text-danger" />
					</div>
					
					<div class="form-group">
						<label for=userType class="control-label col-sm-4">User Type</label><br>
						<form:radiobuttons path="userType" items="${userType}" cssClass="radio offset-sm-1" />
						<br>
						<form:errors path="userType" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="userCode" class="control-label col-sm-4">User Code</label>
						<form:input path="userCode" cssClass="form-control col-sm-4" />
					</div>

					<div class="form-group">
						<label for="userFor" class="control-label col-sm-4">User For</label>
						<form:input path="userFor" cssClass="form-control col-sm-4" readonly="true"/>
					</div>

					<div class="form-group">
						<label for="userEmail" class="control-label col-sm-4">User Email</label>
						<form:input path="userEmail" cssClass="form-control col-sm-4" />
						<form:errors path="userEmail" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="userContact" class="control-label col-sm-4">User Contact</label>
						<form:input path="userContact" cssClass="form-control col-sm-4" />
						<form:errors path="userContact" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="userIdType" class="control-label col-sm-4">User ID Type</label>
						<form:select path="userIdType" cssClass="form-control col-sm-4">
							<form:option value="">--SELECT--</form:option>
							<form:options items="${userIdType}" />
						</form:select>
						<form:errors path="userIdType" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="ifOther" class="control-label col-sm-4">If Other</label>
						<form:input path="ifOther" cssClass="form-control col-sm-4" readonly="true" />
					</div>

					<div class="form-group">
						<label for="idNumber" class="control-label col-sm-4">ID Number</label>
						<form:input path="idNumber" cssClass="form-control col-sm-4" />
					</div>
					
					<div class="form-group">
						<label for="createdOn" class="control-label col-sm-4">Created On</label>
						<form:input path="createdOn" readonly="true"  cssClass="form-control col-sm-4" />
					</div>
					
					<div class="form-group">
						<label for="modifiedOn" class="control-label col-sm-4">Modified On</label>
						<form:input path="modifiedOn" readonly="true" cssClass="form-control col-sm-4" />
					</div>
					
					<input type="submit" value="Update WhUserType" class="btn btn-success" />
				</form:form>
			</div>
			<!-- CARD BODY END -->
		</div>
		<!--CARD END -->
	</div>
	<!-- CONTAINER END -->
</body>
</html>