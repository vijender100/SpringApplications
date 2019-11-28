<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="base">${pageContext.request.requestURL}</c:set>
<c:set var="url"
	value="${fn:replace(base, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<!-- <link rel="stylesheet" href="../bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<script type="text/javascript"
	src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../bootstrap/js/jquery-3.2.1.slim.min.js"></script>
<script type="text/javascript" src="../bootstrap/js/popper.min.js"></script> -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>


<nav class="navbar navbar-expand-sm bg-dark navbar-dark ">
	<!-- Brand -->
	<a class="navbar-brand " href="#">Logo</a>

	<!-- Links -->
	<ul class="navbar-nav">
		<!--   <li class="nav-item">
      <a class="nav-link" href="#">Link 1</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 2</a>
    </li> -->

		<!-- Dropdown -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown"> UOM </a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/uom/register">Register </a> <a
					class="dropdown-item" href="${url}/uom/all">View All</a> <a
					class="dropdown-item" href="${url}/uommultipart/show">Multipart</a>
			</div></li>


		<!-- Order Method -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown"> Order Method </a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/orderMethod/register">Register
				</a> <a class="dropdown-item" href="${url}/orderMethod/all">View All</a>
				<a class="dropdown-item" href="${url}/orderMethodMultipart/show">Multipart</a>
			</div></li>

		<!-- Shipment Type -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown"> Shipment Type </a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/shipmentType/register">Register
				</a> <a class="dropdown-item" href="${url}/shipmentType/all">View
					All</a> <a class="dropdown-item"
					href="${url}/shipmentTypeMultipart/show">Multipart</a>
			</div></li>


		<!-- WH USER TYPE -->

		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown"> Warehouse User </a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/whUserType/register">Register
				</a> <a class="dropdown-item" href="${url}/whUserType/all">View All</a>
				<a class="dropdown-item" href="${url}/whUserTypeMultipart/show">Multipart</a>
			</div></li>

		<!-- ITEM  -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown">Item</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/item/register">Register </a> <a
					class="dropdown-item" href="${url}/item/all">View All</a> <a
					class="dropdown-item" href="${url}/itemMultipart/show">Multipart</a>
			</div></li>
			
			<!-- PO -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown">Purchase Order</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${url}/po/register">Register </a> <a
					class="dropdown-item" href="${url}/po/all">View All</a> <a
					class="dropdown-item" href="${url}/po/multipart/save">Multipart</a>
			</div></li>

		<!-- SWAGGER -->
		<li class="nav-item"><a class="nav-link"
			href="${url}/swagger-ui.html">Swagger</a></li>
			
		<li class="nav-item"><a class="nav-link"
			href="${url}/../logout">logout</a></li>

	</ul>
</nav>