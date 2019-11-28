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
<title>Purchase Order Items Page</title>
</head>
<body>
	<%@include file="Menu.jsp"%>

	<div class="container">
		<div class="card">
			<div class="card-heading bg-primary text-white">
				<h1>Welcome to Purchase Order Items Page!!</h1>
			</div>
			<!-- CARD HEADING END -->
			<div class="card-body">
				<form:form action="poItemAdd" method="post" modelAttribute="poDtl">
					<form:hidden path="poHdrId" readonly="true" />

					<div class="row col-sm-5">
						<label class="col-sm-4 font-weight-bold">Order Code</label> <input
							type="text" value="${po.orderCode}" class="form-control col-sm-5"
							readonly="readonly" />
					</div>

				<hr />
					<table class="table table-hover">
						<thead class="thead-dark">
							<tr>
								<th>Sl No</th>
								<th>Select Item</th>
								<th>Quantity</th>
								<th colspan="3"></th>
							</tr>
						</thead>
						<tbody>
							<tr>

								<td><form:input path="slno" class="form-control"
										readonly="true" size="2" /></td>
								<td><form:select path="itemDetails" items="${venItems}"
										itemValue="itemId" itemLabel="itemCode" class="form-control" />
									<form:errors path="itemDetails" cssClass="text-danger"/>
								</td>
								<td><form:input path="itemsQty"
										class="form-control col-sm-6" />
									<form:errors path="itemsQty" cssClass="text-danger"/>		
								</td>
								<td><input type="submit" name="itemOpr" value="Add Item"
									class="btn btn-outline-success" /></td>

							</tr>
						</tbody>
					</table>
					<br />
					<hr />
					<table class="table table-hover">

						<thead class="thead-dark">
							<tr>
								<th>Sl No</th>
								<th>Item</th>
								<th>Base Cost</th>
								<th>Quantity</th>
								<th>Action</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${po.details}" var="dtl">
								<tr>
									<td>${dtl.slno}</td>
									<td>${dtl.itemDetails.itemCode}</td>
									<td>${dtl.itemDetails.baseCost}</td>
									<td>${dtl.itemsQty}</td>
									<td><a
										href="removeItem?slno=${dtl.slno}&poId=${dtl.poHdrId}"
										class="btn btn-outline-danger">Remove Item</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<br />
					<br />
					<c:if test="${!empty po.details}">
						<input type="submit" name="itemOpr" value="Save and Continue"
							class="btn btn-outline-success" />
					</c:if>
				</form:form>

			</div>
		</div>
	</div>
</body>
</html>