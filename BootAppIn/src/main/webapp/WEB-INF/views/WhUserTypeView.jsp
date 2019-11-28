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

<title>Insert title here</title>
</head>
<body>
<%@include file="Menu.jsp" %>
<div class="container">

		<div class="card">

			<div class="card-header bg-primary text-white">
				<h2>WHUSER DATA</h2>
			</div>

			<div class="card-body">
				<table class="table table-hover">
					<tr class="thead-dark">
						<td>ID</td>
						<td><c:out value="${whUserType.whUserTypeId}" /></td>
					</tr>

					<tr class="thead-dark">
						<td>TYPE</td>
						<td><c:out value="${whUserType.userType}" /></td>
					</tr>

					<tr class="thead-dark">
						<td>CODE</td>
						<td><c:out value="${whUserType.userCode}" /></td>
					</tr>							
								
					<tr>
						<td>USED FOR</td>
						<td><c:out value="${whUserType.userFor}" /></td>
						</tr>
					
					<tr>
						<td>EMAIL</td>
						<td><c:out value="${whUserType.userEmail}" /></td>
					</tr>

					<tr>
						<td>CONTACT</td>
						<td><c:out value="${whUserType.userContact}" /></td>
					</tr>

					<tr>
						<td>ID TYPE</td>
						<td><c:out value="${whUserType.userIdType}" /></td>
					</tr>

					<tr>
						<td>ID NUMBER</td>
						<td><c:out value="${whUserType.idNumber}" /></td>
					</tr>

					<tr>
						<td>CREATED</td>
						<td><c:out value="${whUserType.createdOn}" /></td>
					</tr>

					<tr>
						<td>MODIFIED</td>
						<td><c:out value="${whUserType.modifiedOn}" /></td>
					</tr>

			</table>
					<a href="http://localhost:2018/whUserType/all"><input type="button" value="Back" class="btn btn-success" /></a>
			</div>
		</div>
	</div>

</body>
</html>