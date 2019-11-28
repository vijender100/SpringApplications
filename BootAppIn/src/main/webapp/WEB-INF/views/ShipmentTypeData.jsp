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
<script type="text/javascript" src="../bootstrap/js/SearchPageParam.js"></script>
<title>ShipmentType Data</title>
</head>
<body>
	<%@include file="Menu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info text-white">
				<h2>Welcome To ShipmentType Data Page</h2>
			</div>
			<!-- CARD HEAD ENDS -->
			<div class="card-body">
				<form:form cssClass="form-inline" action="all" method="get" modelAttribute="shipmentType">

					<div class="form-group">
						<label for="shipmentMode" class="control-label">Shipment
							Mode</label>
						<form:select path="shipmentMode" cssClass="form-control">
							<form:option value="">--SELECT--</form:option>
							<form:options items="${shipmentMode}" />
						</form:select>
						
					</div>

					<div class="form-group">
						<label for="shipmentCode" class="control-label col-sm-4">Shipment
							Code</label>
						<form:input path="shipmentCode" cssClass="form-control" />
						
					</div>

					<div class="form-group">
						<label for="enableShipment" class="control-label col-sm-2">Enable
							Shipment</label>
						<form:checkbox path="enableShipment" value="YES"
							cssClass="checkbox offset-sm-1" />
						YES
					</div>

					<div class="form-group">
						<label for=shipmentGrade class="control-label col-sm-4">Shipment
							Grade</label><br>
						<form:radiobuttons path="shipmentGrade" items="${shipmentGrade}"
							cssClass="radio offset-sm-1" />
						<br>
						<form:errors path="shipmentGrade" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for=description class="control-label col-sm-4">Description</label>
						<form:textarea path="description" cssClass="form-control col-sm-4" />
						<form:errors path="description" cssClass="text-danger" />
					</div>
					<div class="form-group">
					<input type="submit" value="Search Shipment's"
						class="btn btn-success">
			   	  &nbsp;&nbsp;&nbsp;<input type="reset" value="Clear"
						class="btn btn-danger" />
						</div>

				</form:form>
				<hr />
				<br>

				<table class="table table-hover">
					<tr class="thead-dark">
						<th>ID</th>
						<th>SHIP_MODE</th>
						<th>SHIP_CODE</th>
						<th>ENABLE_SHIP</th>
						<th>SHIP_GRADE</th>
						<th>SHIP_DESC</th>
						<th>CREATED</th>
						<th>MODIFIED</th>
						<th colspan="2">OPERATIONS</th>
					</tr>
					<c:forEach items="${page.getContent()}" var="shipmentType">
						<tr>
							<td><c:out value="${shipmentType.shipmentTypeId}" /></td>
							<td><c:out value="${shipmentType.shipmentMode}" /></td>
							<td><c:out value="${shipmentType.shipmentCode}" /></td>
							<td><c:out value="${shipmentType.enableShipment}" /></td>
							<td><c:out value="${shipmentType.shipmentGrade}" /></td>
							<td><c:out value="${shipmentType.description}" /></td>
							<td><c:out value="${shipmentType.createdOn}" /></td>
							<td><c:out value="${shipmentType.modifiedOn}" /></td>
							<td><a
								href="edit?shipmentTypeId=${shipmentType.shipmentTypeId}"
								class="btn btn-info">EDIT</a></td>
							<td><a
								href="delete?shipmentTypeId=${shipmentType.shipmentTypeId}"
								class="btn btn-info">DELETE</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<!-- CARD BODY END -->
			<div class="card-footer text-white">
				<ul class="pagination">
					<c:if test="${!page.isFirst()}">
						<li class="page-item"><a class="page-link" href="#"
							onclick="setParam('page',0)">First</a></li>
					</c:if>
					<!-- End of  First link -->

					<c:if test="${page.hasPrevious()}">
						<li class="page-item"><a class="page-link" href="#"
							onclick="setParam('page',${page.getNumber()-1})">Previous</a></li>
					</c:if>
					<!-- End of Previous link -->

					<c:if test="${!empty page.getContent()}">
						<c:forEach begin="0" end="${page.getTotalPages()-1}" var="i">
							<c:choose>
								<c:when test="${page.getNumber() eq i}">
									<li class="page-item active"><a class="page-link" href="#">${i+1}</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link" href="#"
										onclick="setParam('page',${i})">${i+1}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
					<!-- End of Pagination Order -->


					<c:if test="${page.hasNext()}">
						<li class="page-item"><a class="page-link" href="#"
							onclick="setParam('page',${page.getNumber()+1})">Next</a></li>
					</c:if>
					<!-- End of Next link -->

					<c:if test="${!page.isLast()}">
						<li class="page-item"><a class="page-link" href="#"
							onclick="setParam('page',${page.getTotalPages()-1})">Last</a></li>
					</c:if>

				</ul>
			</div>
			<!-- CARD FOOTER END -->
		</div>
		<!-- CARD END -->
	</div>
	<!-- CONTAINER END -->
</body>
</html>