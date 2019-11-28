<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Po Import</title>
</head>
<body>
	<%@include file="Menu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-heading bg-primary text-white">
				<h1>Welcome To File Upload</h1>
			</div>
			<!-- CARD HEADING END -->
			<div class="card-body">
					<form action="save" method="post" enctype="multipart/form-data">
						<table>
							<tr>
								<td><label>File Name</label></td>
								<td><input type="file" name="poFile" class="form-control"></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<input type="submit" value="Upload" class="btn btn-outline-success">
									 <a href="download" class="btn btn-outline-primary"> Export </a>
								</td>
							</tr>
						</table>
					</form>			
			</div><!-- BODY END -->
			<c:if test="${!empty message}">
				<div class="card-footer">
					<h3><c:out value="${message}"></c:out></h3>
				</div>
			</c:if>
			
			<c:if test="${errorMap != null}">
				<div class="card-footer bg-light text-white">
					<table class="table table-hover">
						<thead class="thead-dark">
							<tr>
								<th>Row Number</th>
								<th>Error Details</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${errorMap}" var="err">
								<tr>
									<td class="text-danger"><c:out value="${err.key}" /></td>
									<td class="text-danger"><c:out value="${err.value}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>
			
		</div>
	</div>
</body>
</html>