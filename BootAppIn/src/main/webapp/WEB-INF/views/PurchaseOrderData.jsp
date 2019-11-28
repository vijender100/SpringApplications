<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<script type="text/javascript" src="../bootstrap/js/SearchPageParam.js"></script>
<title>Purchase Order Data</title>
</head>
<body>
	<%@include file="Menu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-heading bg-primary text-white">
				<h1>Welcome to Purchase Order Data Page!!</h1>
			</div>
			<div class="card-body">
			
			<form:form action="all" method="get" modelAttribute="po">

						<div class="form-group">
							<form:label path="orderCode"
								cssClass="control-label col-sm-offset-4 font-weight-bold">Order Code</form:label>
							<form:input path="orderCode" cssClass="form-control col-sm-4" />
						</div>
						
						<div class="form-group">
							<form:label path="shipmentMode"
								cssClass="control-label col-sm-offset-4 font-weight-bold">Mode</form:label>
							<form:select path="shipmentMode" cssClass="form-control col-sm-4">
								<form:option value="">--SELECT--</form:option>
								<form:options items="${shipmentTypes}" itemLabel="shipmentCode"
									itemValue="shipmentTypeId" />
							</form:select>
						</div>
					<div class="form-group">
						<input type="submit" value="Search" class="btn btn-outline-primary">
					</div>
			</form:form>
			 <hr />
				<table class="table table-hover">
					<thead class="thead-dark">
						<tr>
							<th>ID</th>
							<th>CODE</th>
							<th>SHIPMENT</th>
							<th>VENDOR</th>
							<th>REF NUM</th>
							<th>QUALITY CHECK</th>
							<th>STATUS</th>
							<th>NOTE</th>
							<th colspan="3"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.getContent()}" var="ob">
							<tr>
								<td><c:out value="${ob.orderId}" /></td>
								<td><c:out value="${ob.orderCode}" /></td>
								<td><c:out value="${ob.shipmentMode.shipmentCode}" /></td>
								<td><c:out value="${ob.vendor.userCode}" /></td>
								<td><c:out value="${ob.refernceNumber}" /></td>
								<td><c:out value="${ob.qualityCheck}" /></td>
								<td><c:out value="${ob.status}" /></td>
								<td><c:out value="${ob.description}" /></td>
								<c:if test="${'OPEN' eq ob.status || 'PICKING' eq ob.status}">
									<td><a href="addPoItems?poId=${ob.orderId}">Manage
											Items</a></td>
									<td><a href="edit?poId=${ob.orderId}">Edit Order</a></td>
									<td><a href="cancelOrder?poId=${ob.orderId}">Cancel
											Order</a></td>
								</c:if>
								<c:if test="${'ORDERED' eq ob.status}">
									<td><a href="poConfirm?poId=${ob.orderId}">Confirm
											(Invoice)</a></td>
									<td><a href="cancelOrder?poId=${ob.orderId}">Cancel
											Order</a></td>
								</c:if>
								<c:if test="${'INVOICED' eq ob.status}">
									<td><a href="poInvoceGen?poId=${ob.orderId}">Generate
											Invoice</a></td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div><!--CARD BODY END -->
			<div class="card-footer">
				<ul class="pagination">
					<c:choose>
						<c:when test="${!empty page.getContent()}">


							<!-- SHOW FIRST PAGE IF NOT ON FIRST PAGE -->
							<c:if test="${!page.isFirst()}">
								<li class="page-item"><a class="page-link" href="#"
									onclick="setParam('page','0')">First</a></li>
							</c:if>

							<!-- SHOW IF PREVIOUS -->
							<c:if test="${page.hasPrevious()}">
								<li class="page-item"><a class="page-link" href="#"
									onclick="setParam('page',${uoms.getNumber()-1})">Previous</a></li>
							</c:if>



							<!-- TO SHOW PAGINATION -->
							<c:forEach begin="0" end="${page.getTotalPages()-1}" var="i">

								<c:choose>
									<c:when test="${page.getNumber() eq i }">
										<li class="page-item active"><a class="page-link"
											href="#" onclick="setParam('page',${i})">${i+1}</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link" href="#"
											onclick="setParam('page',${i})">${i+1}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							<!-- SHOW IF NEXT -->
							<c:if test="${page.hasNext()}">
								<li class="page-item"><a class="page-link" href="#"
									onclick="setParam('page',${page.getNumber()+1})">Next</a></li>
							</c:if>

							<!-- SHOW LAST PAGE IF NOT ON LAST PAGE -->
							<c:if test="${!page.isLast()}">
								<li class="page-item"><a class="page-link" href="#"
									onclick="setParam('page',${page.getTotalPages()-1})">Last</a></li>
							</c:if>
						</c:when>
						<c:otherwise>
							<h2>No Records Found</h2>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			<!-- CARD FOOTER END -->
		</div>
	</div>
</body>
</html>