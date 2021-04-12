/**
 * 
 */
(function() {
	'user strict';
	angular.module('myApp', ['ngRoute', 'ngMaterial', 'ui.bootstrap', 'angularUtils.directives.dirPagination']).config(function($routeProvider) {
		$routeProvider.otherwise({
			redirecTo: "/",
			controller: "employeeCtrl"
		});
	}).controller('appCtrl', appCtrl);
	function appCtrl($scope, $q, $http, $mdDialog) {
		$scope.username = "Administrator";
		$scope.hideShow = false;

		// Event open and close modal responsive
		$scope.openModal = openModalEvent;
		$scope.closeModal = closeModalEvent;
		// Check login
		if (!localStorage.user) {
			location.href = "http://localhost:8080/EmployeeManager/login";
		} else {
			$scope.dataUser = JSON.parse(localStorage.user);
		}
		// Event logout
		$scope.showConfirm = function(ev) {
			var confirm = $mdDialog.confirm()
				.title('Would you like logout ?')
				.targetEvent(ev)
				.ok('Ok')
				.cancel('Cancel');

			$mdDialog.show(confirm).then(function() {
				logoutEvent();
			});
		};

		$scope.checkRole = function() {
			let obj = checkRoleEvent();
		};

		function checkRoleEvent() {
			let roleName = ["ADMIN", "CEO", "BOD", "MANAGER", "ENGINEER"];
			if (localStorage.user) {
				let obj = JSON.parse(localStorage.user);
				$http({
					url: "http://localhost:8080/EmployeeManager/api/checkrole?email=" + obj.email,
					method: "GET"
				}).then(function(response) {
					let getName;
					for (let i = 0; i < roleName.length; i++) {
						if (roleName[i] == response.data.roleName) {
							getName = roleName[i];
						}
					}
					return getName;
				}, function(response) {
					console.log(response);
				});
			}
		}
	}
})();