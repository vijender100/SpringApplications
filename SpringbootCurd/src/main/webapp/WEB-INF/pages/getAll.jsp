<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Welcome To Data Page</h1>
<c:if test="${ not empty list }">
<table border="2">
					<tr>
						<th>EmpId</th>
						<th>EmpName</th>
						<th>EmpSal</th>
						<th>EmpPh</th>
						<th colspan="2">OPERATIONS</th>
					</tr>
					<c:forEach items="${list}" var="emp">
						<tr>
							<td><c:out value="${emp.empId}" /></td>
							<td><c:out value="${emp.empName}" /></td>
							<td><c:out value="${emp.empSal}" /></td>
							<td><c:out value="${emp.empPh}" /></td>
							
							<td><a href="delete?empId=${emp.empId}">DELETE</a></td>
							<td><a href="edit?empId=${emp.empId}">EDIT</a></td>
						</tr>
					</c:forEach>
				</table></c:if><c:if test="${empty list}"><h3 style="color: red;">NoRecords Found</h3></c:if>
				
			<a href="reg">Register Employee</a>
				
				
				</div>
</body>
</html>