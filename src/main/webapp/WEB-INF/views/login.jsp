<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Employee</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Icon Employee -->
<link rel="shortcut icon" href="<c:url value="/template/static/images/icon/icon-employee.png"/>">
<!-- Link Default -->
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/template/static/libs/angular-material.min.css"/>">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,400italic">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" />
<!-- Link CSS custom -->
<link rel="stylesheet" type="text/css" href="<c:url value="/template/static/css/login.css"/>">
<!-- AngularJS (Default, animation, messages, sanitize, route) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-animate.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-aria.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-messages.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-sanitize.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-route.js"></script>
<script src="<c:url value="/template/static/libs/angular-material.min.js"/>"></script>
</head>

<body>

	<!-- Login Employee -->

	<div class="container" ng-app="loginApp" ng-controller="loginCtrl"
		ng-cloak>
		<section class="form" ng-include="viewIndex"></section>
	</div>
	<script src="<c:url value="/template/static/js/config.js"/>"></script>
	<script src="<c:url value="/template/static/js/login.js"/>"></script>
</body>

</html>