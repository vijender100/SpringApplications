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

<style type="text/css">
  .col-custom-1 {
    -webkit-box-flex: 0;
    -ms-flex: 0 0 8.333333%;
    flex: 0 0 8.333333%;
    max-width: 8.333333%;
  }
    .col-custom-2 {
    -webkit-box-flex: 0;
    -ms-flex: 0 0 16.666667%;
    flex: 0 0 16.666667%;
    max-width: 8.666667%;
  }
  </style>


<title>ItemData Edit Page</title>
</head>
<body>
<%@include file="Menu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>WELCOME TO ITEM DATA EDIT PAGE</h2>
			</div>
			<!-- CARD HEAD END -->
			<div class="card-body">
				<form:form action="update" method="post" modelAttribute="item">
				
					<div class="form-group">
						<label for="itemId" class="control-label col-sm-2">ID</label>
						 <form:input path="itemId" cssClass="form-control col-sm-4" readonly="true" />
					</div>
					
					
					<div class="form-group">
  					 <label for="itemCode" class="control-label col-sm-2"><b>Item Code</b></label>
   					 <form:input path="itemCode" cssClass="form-control col-sm-4"/>
   					 <form:errors path="itemCode" cssClass="text-danger"/>
				   	</div>
				
					<div class="form-group">
  					 <label class="control-label col-sm-2"><b>Item Dimensions</b></label><br>
  					
  					 <label for="itemWdth" class="control-label col-sm-4">Width</label>
   					 <form:input path="itemWdth" cssClass="form-control col-custom-1"/> 
   					 <form:errors path="itemWdth" cssClass="text-danger"/><br> 
 
  					 <label for="" class="control-label col-sm-4">Length</label>
   					 <form:input path="itemLnth" cssClass="form-control col-custom-1"/> 
   					 <form:errors path="itemLnth" cssClass="text-danger"/><br> 
 
  					 <label for="" class="control-label col-sm-4">Height</label>
   					 <form:input path="itemHgth" cssClass="form-control col-custom-1"/>
   					 <form:errors path="itemHgth" cssClass="text-danger"/>
	  				</div>	
	  				
	  				<div class="form-group">
  					 <label for="baseCost" class="control-label col-sm-4"><b>Base Cost</b></label>
   					 <form:input path="baseCost" cssClass="form-control col-sm-4"/>
				   	 <form:errors path="baseCost" cssClass="text-danger"/>
				   </div>
				   
				   <div class="form-group">	
			       <label for="baseCurrency" class="control-label col-sm-4"><b>Base Currency</b></label>	
             		<form:select path="baseCurrency" cssClass="form-control col-sm-4">
         					<form:option value="">--Select--</form:option>
         				 	<form:options items="${itemBseCurncies}"/>
         		   		</form:select>
         		   		<form:errors path="baseCurrency" cssClass="text-danger"/>
         		   </div>
         		   
         		   <div class="form-group">	
			       <label for=uom class="control-label col-sm-4"><b>Item UOM</b></label>	
             		<form:select path="uom" cssClass="form-control col-sm-4">
         					<form:option value="">--Select--</form:option>
         				 	<form:options items="${uoms}" itemLabel="uomModel" itemValue="uomId"/>
         		   	</form:select>
         		   	<form:errors path="uom" cssClass="text-danger"/> 		 
         		   </div>
					
					<div class="form-group">	
			       <label for=omSale class="control-label col-sm-4"><b>Order Method Sale</b></label>	
             		<form:select path="omSale" cssClass="form-control col-sm-4">
         					<form:option value="">--Select--</form:option>
         				 	<form:options items="${omSales}" itemLabel="orderCode" itemValue="orderMethdId"/>
         		   		</form:select>
         		   		<form:errors path="omSale" cssClass="text-danger"/> 
         		   </div>
         		   
         		   <div class="form-group">	
			       <label for=omPurchase class="control-label col-sm-4"><b>Order Method Purchase</b></label>	
             		<form:select path="omPurchase" cssClass="form-control col-sm-4">
         					<form:option value="">--Select--</form:option>
         				 	<form:options items="${omPurchases}" itemLabel="orderCode" itemValue="orderMethdId"/>
         		   		</form:select>
         		   		<form:errors path="omPurchase" cssClass="text-danger"/>
         		   </div>
				   
				   <div class="form-group">	
			       <label for=whVendors class="control-label col-sm-4"><b>Item Vendors</b></label>	
             		<form:select path="whVendors" cssClass="form-control col-sm-4" multiple="true">
         				 	<form:options items="${whVendors}" itemLabel="userCode" itemValue="whUserTypeId"/>
         		   		</form:select>
         		   		<form:errors path="whVendors" cssClass="text-danger"/>
         		   </div>
         		   
         		   <div class="form-group">	
			       <label for=whCustomers class="control-label col-sm-4"><b>Item Customers</b></label>	
             		<form:select path="whCustomers" cssClass="form-control col-sm-4" multiple="true">
         				 	<form:options items="${whCustomers}" itemLabel="userCode" itemValue="whUserTypeId"/>
         		   		</form:select>
         		   		<form:errors path="whCustomers" cssClass="text-danger"/>
         		   </div>
         		   
         		   <div class="form-group">
  					 <label for="description" class="control-label col-sm-4"><b>Description</b></label>
   					 <form:textarea path="description" cssClass="form-control col-sm-4"/>
   					 <form:errors path="description" cssClass="text-danger"/>
				   </div>
				
 					<div class="form-group">
						<label for="createdOn" class="control-label col-sm-2">Created On</label>
						 <form:input path="createdOn" cssClass="form-control col-sm-4" readonly="true" />
					</div>
					
					<div class="form-group">
						<label for="modifiedOn" class="control-label col-sm-2">Modified On</label>
						 <form:input path="modifiedOn" cssClass="form-control col-sm-4" readonly="true" />
					</div>

					<input type="submit" value="Update Item" class="btn btn-success" />
					
				</form:form>
			</div>
			
		</div>
		<!-- Card End -->
	</div>
	<!--Container End-->
</body>
</html>