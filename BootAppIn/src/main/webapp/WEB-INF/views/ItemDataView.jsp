<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>ItemDataView</title>
</head>
<body>
<%@include file="Menu.jsp"%>
<div class="container">

		<div class="card">

			<div class="card-header bg-primary text-white">
				<h2>Item Data View Page</h2>
			</div>
				<div class="card-body">
					<table class="table table-hover">
						<tr class="thead-dark">
							<td>ID</td>
							<td><c:out value="${item.itemId}" /></td>
						</tr>
			
						<tr class="thead-dark">
							<td>CODE</td>
							<td><c:out value="${item.itemCode}" /></td>
						</tr>							
						
						<tr class="thead-dark">
							<td>WIDTH</td>
							<td><c:out value="${item.itemWdth}" /></td>
						</tr>
			
						<tr class="thead-dark">
							<td>LENGTH</td>
							<td><c:out value="${item.itemLnth}" /></td>
						</tr>
			
						<tr class="thead-dark">
							<td>HEIGHT</td>
							<td><c:out value="${item.itemHgth}" /></td>
						</tr>
			
						<tr class="thead-dark">
							<td>BASE COST</td>
							<td><c:out value="${item.baseCost}" /></td>
						</tr>
			
						<tr class="thead-dark">
							<td>BASE CURRENCY</td>
							<td><c:out value="${item.baseCurrency}" /></td>
						</tr>
			
						<tr class="thead-dark">
							<td>ITEM UOM</td>
							<td><c:out value="${item.uom.uomModel}" /></td>
						</tr>
			
						<tr class="thead-dark">
							<td>ORDER SALE MODE</td>
							<td><c:out value="${item.omSale.orderCode}" /></td>
						</tr>
			
			
						<tr class="thead-dark">
							<td>ORDER PURCHSE MODE</td>
							<td><c:out value="${item.omPurchase.orderCode}" /></td>
						</tr>
			
			
						<tr class="thead-dark">
							<td>ITEM VENDORS</td>
							<td><c:forEach items="${item.whVendors}" var="i">
									<c:out value="${i.userCode}" /> 
								</c:forEach>
							</td>
							<%-- <td><c:out value="${item.vendors}" /></td> --%>
						</tr>
			
						<tr class="thead-dark">
							<td>ITEM CUSTOMERS</td>
							<td>
								<c:forEach items="${item.whCustomers}" var="i">
								<c:out value="${i.userCode}" /> 
								</c:forEach>
							</td>
							<%-- <td><c:out value="${item.customers}" /></td> --%>
						</tr>
			
						<tr class="thead-dark">
							<td>DESCRIPTION</td>
							<td><c:out value="${item.description}" /></td>
						</tr>
			
						<tr class="thead-dark">
							<td>CREATED</td>
							<td><c:out value="${item.createdOn}" /></td>
						</tr>
			
						<tr class="thead-dark">
							<td>MODIFIED</td>
							<td><c:out value="${item.modifiedOn}" /></td>
						</tr>
			
				</table>
						<a href="http://localhost:2018/item/all"><input type="button" value="Back" class="btn btn-success"/></a>
				</div>
			</div>
		</div>

</body>
</html>