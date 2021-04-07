let app = angular.module('myApp', ['ngRoute', 'ngMaterial']);

app.controller('appCtrl', function($scope) {
    $scope.username = "Administrator";
    $scope.addEmployee = true;
    $scope.addTeam = false;
    $scope.addPosition = false;
    $scope.currentNav = currentNavEvent;
    $scope.hideShow = false;
    let url = window.location.href.split('#!/');
    $scope.currentNav(url[url.length - 1]);

    // Event open and close modal responsive
    $scope.openModal = openModalEvent;
    $scope.closeModal = closeModalEvent;
    $scope.dataUser = JSON.parse(sessionStorage.user);

});

app.config(function($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'file/employee/defaultemployee.html',
        controller: 'employeeCtrl'
    }).when('/team', {
        templateUrl: 'file/team/default.html',
        controller: 'teamCtrl'
    }).when('/position', {
        templateUrl: 'file/position/defaultposition.html',
        controller: 'positionCtrl'
    }).when('/addEmployee', {
        templateUrl: 'file/employee/addemployee.html',
        controller: 'RegisterCtrl'
    }).when('/:employeeID', {
    	 templateUrl: 'file/employee/detailsemployee.html',
         controller: 'detailEmployeeCtrl'
    });
});