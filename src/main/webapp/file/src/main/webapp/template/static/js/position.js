/**
 * 
 */
angular.module('myApp').config(function($routeProvider) {
	$routeProvider.when('/position', {
		templateUrl: 'file/position/listposition.html',
		controller: 'positionCtrl'
	});
}).controller('positionCtrl', function($scope) {
	$scope.msg = "Position";
});