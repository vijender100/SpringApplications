<%@ page language="java" contentType="text/html;charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>


<title>User Register</title>
<script type="text/javascript">
	/* window.onload = function() {
		var txtPassword = document.getElementById("txtPassword");
		var txtConfirmPassword = document.getElementById("txtConfirmPassword");
		txtPassword.onchange = ConfirmPassword;
		txtConfirmPassword.onkeyup = ConfirmPassword;
		function ConfirmPassword() {
			txtConfirmPassword.setCustomValidity("");
			if (txtPassword.value != txtConfirmPassword.value) {
				txtConfirmPassword.setCustomValidity("Passwords do not match.");
			}
		}
	} */
	
	function checkPass()
	{
	    //Store the password field objects into variables ...
	    var pass1 = document.getElementById('txtPassword');
	    var pass2 = document.getElementById('txtConfirmPassword');
	    //Store the Confimation Message Object ...
	    var message = document.getElementById('confirmMessage');
	    //Set the colors we will be using ...
	    var goodColor = "#66cc66";
	    var badColor = "#ff6666";
	    //Compare the values in the password field 
	    //and the confirmation field
	    if(pass1.value == pass2.value){
	        //The passwords match. 
	        //Set the color to the good color and inform
	        //the user that they have entered the correct password 
	        pass2.style.backgroundColor = goodColor;
	        message.style.color = goodColor;
	        message.innerHTML = "Passwords Match"
	    }else{
	        //The passwords do not match.
	        //Set the color to the bad color and
	        //notify the user.
	        pass2.style.backgroundColor = badColor;
	        message.style.color = badColor;
	        message.innerHTML = "Passwords Do Not Match!"
	    }
	} 
</script>
</head>
<body>
	
<%-- 	<form action="saveUser" method="post">
<pre>
Enter Name  : <input type="text" name="userName"/>
Enter Email : <input type="text" name="userEmail"/>
Enter Password : <input type="password" name="password"/>
Select Roles : <select name="rolesData" multiple="multiple">
				<option>ADMIN</option>
				<option>USER</option>
			   </select>
<input type="submit" value="Register User"/>
</pre>
</form>
${message}
<br/>
Having account? <a href="login">Login</a> --%>


	<div class="container">
		<div class="card" style="max-width: 80%;">
			<div class="card-heading bg-primary text-white">
				<h1>User Registration</h1>
			</div>
			<div class="card-body">
				<form:form method="post" action="saveUser" id="form1" modelAttribute="user">
					<div style="max-width: 400px;">
						<div class="form-group">
							<form:label path="userName" class="control-label col-sm-offset-4"><b>Username</b></form:label>
							<form:input path="userName" type="text" id="userName"
								class="form-control" placeholder="Enter UserName" />
							<form:errors path="userName" cssClass="text-danger"/>
						</div>

						<div class="form-group">
							<form:label path="userEmail" class="control-label col-sm-offset-4"><b>Email</b></form:label>
							<form:input path="userEmail" type="email" id="txtEmail" class="form-control"
							placeholder="Enter Email"/>
							<form:errors path="userEmail" cssClass="text-danger"/>
						</div>
							<!-- title="Password must contain: Minimum 8 characters atleast 1 Alphabet and 1 Number" -->
							<!-- pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$"  -->
						<div class="form-group">
							<form:label path="password" cssClass="control-label col-sm-offset-4"><b>Password</b></form:label>
							<form:input path="password" type="password" id="txtPassword"
								cssClass="form-control" />
							<form:errors path="password" cssClass="text-danger"/>
						</div>

						<div class="form-group">
							<label for="txtConfirmPassword"
								class="control-label col-sm-offset-4"><b>Confirm Password</b></label> 
							<input name="txtConfirmPassword" type="password" 
								id="txtConfirmPassword" class="form-control" onkeyup="checkPass(); return false;"/>
							<span id="confirmMessage" class="confirmMessage"></span>
						</div>

						<div class="form-group">
							<form:label path="roles" cssClass="control-label col-sm-offset-4"><b>Select
									Roles</b></form:label> 
									<%-- <form:select path="roles" multiple="true" cssClass="form-control col-sm-4">
										<form:option value="ADMIN">ADMIN</form:option>
										<form:option value="USER">USER</form:option>
										<form:options items="${roles}"/>
									</form:select> --%>
									
									 <select name="rolesData" multiple="multiple" class="form-control col-sm-4">
										<option>ADMIN</option>
										<option>USER</option>
			   						 </select>
			   				<%-- <form:errors path="roles" cssClass="text-danger"/> --%>
						</div>
						
						<div class="form-group">
							<input type="submit" name="btnSignup" value="Sign up"
								id="btnSignup" class="btn btn-primary" />
						</div>
					</div>
				</form:form>
				
				<div class="form-group">
					Having account? <a href="login">Login</a> 
				</div>
				
			</div><!-- BODY END -->
			<c:if test="${null!=message}">
				<div class="card-footer bg-success text-white">
					<b>${message}</b>
				</div>
				<!--CARD FOOTER END -->
			</c:if>
		</div>
	</div>
</body>
</html>