/**
 * 
 */
(function() {
	'user strict';
	angular.module('myApp', ['ngRoute', 'ngMaterial', 'ui.bootstrap']).config(function($routeProvider) {
		$routeProvider.otherwise({
			redirecTo: "/",
			controller: "employeeCtrl"
		});
	}).controller('appCtrl', appCtrl);
	function appCtrl($scope, $http) {
		$scope.username = "Administrator";
		$scope.hideShow = false;

		// Event open and close modal responsive
		$scope.openModal = openModalEvent;
		$scope.closeModal = closeModalEvent;
		$scope.logout = logoutEvent;
		if (!localStorage.user) {
			location.href = "http://localhost:8080/EmployeeManager/login";
		} else {
			$scope.dataUser = JSON.parse(localStorage.user);
		}

		$scope.test = function() {
			if (localStorage.user != localStorage.user) {
				console.log(true);
				location.href = "http://localhost:8080/EmployeeManager/login";
			} else {
				let obj = checkRole();
				console.log(checkRole());
			}
		};

		function checkRole() {
			let obj = JSON.parse(localStorage.user);
			return $http.get("http://localhost:8080/EmployeeManager/api/checkrole?email=" + obj.email)
				.then(function(response) { return response.data.roleName; });
			/*$http({
				method: "GET",
				url: "http://localhost:8080/EmployeeManager/api/checkrole?email=" + obj.email
			}).then(function(response) {
				console.log(response.data.roleName);
			}, function myError(response) {
				console.log(response);
			});*/
		}
	}
})();