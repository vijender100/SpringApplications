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

<title>WhUserTypeData</title>
</head>
<body>
<%@include file="Menu.jsp" %>
<div class="container">

		<div class="card">

			<div class="card-header bg-primary text-white">
				<h2>WELCOME TO WHUSER DATA PAGE</h2>
			</div>
			<div class="card-body">

				<form:form cssClass="form-inline" action="all" method="get" modelAttribute="whUserType">

					<div class="form-group">
						<label for="userType" class="control-label">User Type</label>
						<form:radiobuttons path="userType" items="${userType}" cssClass="radio-inline" />
					</div>
					
					<div class="form-group">
						<label for="userCode" class="control-label">User Code</label>
						<form:input path="userCode" />
					</div>
						
						  &nbsp;&nbsp;&nbsp;
						<input type="submit" value="Search" class="btn btn-success" />
						
						&nbsp;&nbsp;<input type="reset" value="Clear" class="btn btn-danger" />
				</form:form>
	<hr/>

				<table class="table table-hover">
					<tr class="thead-dark">

						<th>ID</th>
						<th>USER TYPE</th>
						<th>USER CODE</th>
					<!--<th>USER FOR</th>
						<th>USER EMAIL</th>
						<th>USER CONTACT</th>
						<th>USER IDTYPE</th>
						<th>USER IDNUMBER</th>
						<th>CREATED</th>
						<th>MODIFIED</th> -->
						<th colspan="2">OPERATION</th>
					</tr>

		<c:forEach items="${page.getContent()}" var="whUserType">
			<tr>
    			<td><a href="view?whUserTypeId=${whUserType.whUserTypeId}">
    			<c:out value="${whUserType.whUserTypeId}" /></a></td>
				<td><c:out value="${whUserType.userType}" /></td>
				<td><c:out value="${whUserType.userCode}" /></td>
							<%-- <td><c:out value="${whUserType.userFor }" /></td>
							<td><c:out value="${whUserType.userEmail }" /></td>
							<td><c:out value="${whUserType.userContact }" /></td>
							<td><c:out value="${whUserType.userIdType }" /></td>
							<td><c:out value="${whUserType.idNumber }" /></td>
							<td><c:out value="${whUserType.createdOn }" /></td>
							<td><c:out value="${whUserType.modifiedOn }" /></td> --%>
							<td><a href="delete?whUserTypeId=${whUserType.whUserTypeId}" class="btn btn-danger">DELETE</a>
							<a href="edit?whUserTypeId=${whUserType.whUserTypeId}" class="btn btn-info">EDIT</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<!-- CARD BODY END -->
			<div class="card-footer text-white">
				<ul class="pagination">
					<c:if test="${!page.isFirst()}">
						<li class="page-item"><a class="page-link" href="#" onclick="setParam('page',0)">First</a></li>
					</c:if>
					<!-- End of  First link -->

					<c:if test="${page.hasPrevious()}">
						<li class="page-item"><a class="page-link"
							href="#" onclick="setParam('page',${page.getNumber()-1})">Previous</a></li>
					</c:if> 
					<!-- End of Previous link -->

					<c:if test="${!empty page.getContent()}">
					<c:forEach begin="0" end="${page.getTotalPages()-1}" var="i">
						<c:choose>
							<c:when test="${page.getNumber() eq i}">
								<li class="page-item active"><a class="page-link" href="#">${i+1}</a></li>
							</c:when> 
						<c:otherwise>
							<li class="page-item"><a class="page-link" href="#" onclick="setParam('page',${i})">${i+1}</a></li>
						</c:otherwise>
					   </c:choose>
					</c:forEach>
					</c:if>
					<!-- End of Pagination Order -->


					<c:if test="${page.hasNext()}">
						<li class="page-item"><a class="page-link"
							href="#" onclick="setParam('page',${page.getNumber()+1})">Next</a></li>
					</c:if>
					<!-- End of Next link -->

					<c:if test="${!page.isLast()}">
						<li class="page-item"><a class="page-link"
							href="#" onclick="setParam('page',${page.getTotalPages()-1})">Last</a></li>
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