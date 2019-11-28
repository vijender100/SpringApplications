<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
<title>OrderMethodData Page</title>
</head>
<body>
	<%@include file="Menu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info text-white">
				<h1>Welcome To OrderMethodData</h1>
			</div>
			<!-- CARD HEAD END -->
			<div class="card-body">
				<form:form cssClass="form-inline" action="all" method="get"
					modelAttribute="orderMethod">

					<div class="form-group">
						<label for="orderMode" class="control-label">Order Mode</label><br>
						<form:radiobuttons path="orderMode" items="${orderMode}"
							cssClass="radio offset-sm-1" />
					</div>

						<div class="form-group">
							<label for="orderCode" class="control-label">Order
								Code</label>
							<form:input path="orderCode" cssClass="form-control" />
						</div>

						<div class="form-group">
							<label for="orderMethd" class="control-label">Order
								Method</label>
							<form:select path="orderMethd" cssClass="form-control col-sm-4">
								<form:option value="">--Select--</form:option>
								<form:options items="${orderMethd}" />
							</form:select>
						</div>

						<div class="form-group">
							<label for="orderAccept" class="control-label">Order
								Accept</label><br>
							<form:checkboxes path="orderAccept" items="${orderAccept}"
								cssClass="checkbox offset-sm-1" />
						</div>

						<div class="form-group">
							<label for="description" class="control-label">Description</label>
							<form:textarea path="description"
								cssClass="form-control" />
						</div>

						<input type="submit" value="Search Shipment's"
							class="btn btn-success"> &nbsp;&nbsp;&nbsp;<input
							type="reset" value="Clear" class="btn btn-danger" />


				</form:form>
				<hr />
				<br>

				<table class="table table-hover ">
					<tr class="thead-dark">

						<th>ID</th>
						<th>Order Mode</th>
						<th>Order Code</th>
						<th>Order Method</th>
						<th>Order Accept</th>
						<th>Description</th>
						<th>CREATED</th>
						<th>MODIFIED</th>
						<th colspan=2>OPERATION</th>
					</tr>

					<%-- <c:forEach items="${orderMethodList}" var="orderMethod"> --%>
					<c:forEach items="${page.getContent()}" var="orderMethod">
						<tr>
							<td><c:out value="${orderMethod.orderMethdId}" /></td>
							<td><c:out value="${orderMethod.orderMode}" /></td>
							<td><c:out value="${orderMethod.orderCode}" /></td>
							<td><c:out value="${orderMethod.orderMethd}" /></td>
							<td><c:out value="${orderMethod.orderAccept}" /></td>
							<td><c:out value="${orderMethod.description}" /></td>
							<td><c:out value="${orderMethod.createdOn}" /></td>
							<td><c:out value="${orderMethod.modifiedOn}" /></td>
							<td><a
								href="delete?orderMethdId=${orderMethod.orderMethdId}"
								class="btn btn-danger">Delete</a></td>
							<td><a href="edit?orderMethdId=${orderMethod.orderMethdId}"
								class="btn btn-info">Edit</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<!--Card Body End  -->
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