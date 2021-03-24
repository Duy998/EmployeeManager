<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 	<link rel="shortcut icon" href='<c:url value = "/template/static/images/icon/icon-employee.png"/>'>
    <!-- Link Default, Bootstrap 4 -->
    <link rel="stylesheet" type="text/css" href='<c:url value = "/template/static/libs/angular-material.min.css"/>'>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,400italic">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" />
    <link rel="stylesheet" type="text/css" href='<c:url value = "/template/static/libs/bootstrap.min.css"/>'>
    <!-- Link CSS custom -->
    <link rel="stylesheet" type="text/css" href='<c:url value = "/template/static/css/employee.css"/>'>
    <link rel="stylesheet" type="text/css" href='<c:url value = "/template/static/css/team.css"/>'>
    <!-- AngularJS (Default, animation, messages, sanitize, route) -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-animate.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-aria.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-messages.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-sanitize.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-route.js"></script>
    <script src='<c:url value = "/template/static/libs/angular-material.min.js"/>'></script>
</head>
<body ng-app="myApp" ng-controller="appCtrl" ng-cloak>
    <!-- Header -->
    <header class="header">
        <div class="header__logout">
            <label class="m-0">Hi, {{username}}</label>
            <a href="#"><i class="fas fa-sign-out-alt"></i></a>
        </div>
        <div class="layout-row">
            <div class="flex-70 header__left">
                <h3 class="m-0">Employee Manager</h3>
            </div>
            <div class="flex-30 header__right">
                <ul class="header__nav">
                    <li><a class="navItem" ng-class="{currentNavItem : addEmployee}" ng-click="currentNav('employee')" href="#!">Employee</a></li>
                    <li><a class="navItem" ng-class="{currentNavItem : addTeam}" ng-click="currentNav('team')" href="#!team">Team</a></li>
                    <li><a class="navItem" ng-class="{currentNavItem : addPosition}" ng-click="currentNav('position')" href="#!position">Position</a></li>
                </ul>
            </div>
        </div>
    </header>
    <!-- Body -->
    <div class="main">
        <div class="main__app" ng-view></div>
    </div>
    <!-- Footer -->
    <footer class="footer">
        <div class="footer__title">
            <label>Employee Manager</label>
        </div>
    </footer>

    <!-- Bootstrap 4 -->
    <script src='<c:url value = "/template/static/libs/jquery-3.5.1.slim.min.js"/>'></script>
    <script src='<c:url value = "/template/static/libs/bootstrap.min.js"/>'></script>
    <script src='<c:url value = "/template/static/libs/popper.min.js"/>'></script>
    <!-- JavaScript -->
    <script src='<c:url value = "/template/static/js/employee.js"/>'></script>
</body>
</html>