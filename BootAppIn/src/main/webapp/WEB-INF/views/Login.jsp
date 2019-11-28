<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>


<title>Login User</title>
<style type="text/css">
.login-form {
	width: 340px;
	margin: 50px auto;
}

.login-form form {
	margin-bottom: 15px;
	background: #f7f7f7;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.login-form h2 {
	margin: 0 0 15px;
}

.form-control, .btn {
	min-height: 38px;
	border-radius: 2px;
}

.btn {
	font-size: 15px;
	font-weight: bold;
}
</style>
</head>
<body>
	<%-- <form action="login" method="post">
<pre>
Enter Email Id : <input type="text" name="username"/>
Enter Password : <input type="password" name="password"/>
<input type="submit" value="Login"/>
</pre>
</form>
<c:if test="${param.error}">  Invalid inputs.. </c:if>
<c:if test="${param.logout}"> Logout successful... </c:if><br/>
No Account?? <a href="register">Register</a> --%>

	
	<div class="login-form">
		<form action="login" method="post">
			<h2 class="text-center">Log in</h2>
			<div class="form-group">
				<input type="text" name="username" class="form-control"
					placeholder="Username" required="required">
			</div>
			<div class="form-group">
				<input type="password" name="password" class="form-control"
					placeholder="Password" required="required">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block">Log in</button>
			</div>
			
			<c:if test="${param.error}">
			<b class="text-danger">Invalid inputs..</b>
		</c:if>
		<c:if test="${param.logout}"> <b>Logout successful... </b></c:if>
		<p class="text-center">
			<a href="register"><b>Create an Account</b></a>
		</p>
		</form>
		
	</div>
</body>
</html>