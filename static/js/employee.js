angular.module('myApp').config(function($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'file/employee/listemployee.html',
        controller: 'employeeCtrl'
    });
}).controller('employeeCtrl', function($scope) {
    $scope.msg = "Employee";
});