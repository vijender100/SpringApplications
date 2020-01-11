<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
        <%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="/update" modelAttribute="employee">
<div align="center">
<h1>WelCome to Update Page</h1>
<table>
<tr><th>EmpId:</th><td><form:input path="empId"  readonly="true"/></td></tr>
<tr><th>
EmpName:</th><td><form:input path="empName"/></td><form:errors path="empName"/></tr>
<tr><th>EmpSal:</th><td><form:input path="empSal"/></td><form:errors path="empSal"/></tr>
<tr><th>Phone:</th><td><form:input path="empPh"/></td><form:errors path="empPh"/></tr>
<tr><th colspan="2"><input type="submit" value="Update"></th></tr>
</table>
</div>
</form:form>
</body>
</html>