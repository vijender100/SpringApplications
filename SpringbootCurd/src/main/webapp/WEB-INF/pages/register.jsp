<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
  span.error{
    color: red;
    margin-left: 5px;
  }
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	/*  Submit form using Ajax */
	$('button[type=submit]').click(function(e) {
		
		//Prevent default submission of form
		e.preventDefault();
		
		//Remove all errors
		$('input').next().remove();
		
		$.post({
			url : 'save',
			data : $('form[name=employeeForm]').serialize(),
			success : function(res) {
				
				if(res.validated){
					//Set response
					$('#resultContainer pre code').text(JSON.stringify(res.employee));
					$('#resultContainer').show();
					
				}else{
					//Set error messages
					$.each(res.errorMessages,function(key,value){
						$('input[name='+key+']').after('<span class="error">'+value+'</span>');
					});
				}
			}
		})
	});
});
</script>
<body  style="border: yellow;">
<form:form action="/save" modelAttribute="employee" name="employeeForm">
<div align="center">
<h1>WelCome to Register Page</h1>
<table>
<tr><th>
EmpName:</th><td><form:input path="empName" /><form:errors path="empName"/></td></tr>
<tr><th>EmpSal:</th><td><form:input path="empSal"/><form:errors path="empSal"/></td></tr>
<tr><th>Phone:</th><td><form:input path="empPh"/><form:errors path="empPh"/></td></tr>
<tr><th colspan="2"><input type="submit" value="Register"></th></tr>
</table>
<h3>${msg}</h3>
<a href="select">Select All</a>
</div>
</form:form>
</body>
</html>