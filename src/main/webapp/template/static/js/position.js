/**
 * 
 */
angular.module('myApp').config(function($routeProvider) {
	$routeProvider.when('/position', {
		templateUrl: 'file/position/defaultposition.html',
		controller: 'positionCtrl'
	});
}).controller('positionCtrl', function($scope, $http) {
	$scope.sortType = 'name';
	$scope.nameDefault = "Position";
	$scope.viewPosition = "file/position/listposition.html";
	$scope.sortReverse = false;
	$scope.checkPosition = checkAllScope;
	$scope.changeViewPosition = changeViewEventPosition;
	$scope.choseEventPosition = choseTeamPosition;

	$scope.employees;
	$scope.positiones;
	$scope.positionForm = {
		id: -1,
		name: ""
	};
	$scope.employeeForm = {
		id: "",
		name: "",
		nickname: "",
		email: "",
		status: "",
		sex: "",
		dayStart: ""

	};
	//load data
	_refreshPositionData();
	_refreshEmployeeData();




	//Get Position
	function _refreshPositionData() {
		$http({
			method: 'GET',
			url: '/EmployeeManager/api/position'
		}).then(
			function(res) {
				$scope.positiones = res.data;
			},
			function(res) {
				console.log("Error: " + res.status + " : " + res.data);
			}
		);
	}



	//Get employee

	function _refreshEmployeeData() {
		$http({
			method: 'GET',
			url: '/EmployeeManager/api/user'
		}).then(
			function(res) {
				$scope.employees = res.data;
			},
			function(res) {
				console.log("Error: " + res.status + " : " + res.data);
			}
		);
	}


	//
	$scope.roleID;
	$scope.deletePosition = function(roleID) {
		console.log(roleID);
		$http({
			method: 'DELETE',
			url: '/EmployeeManager/api/position/' + roleID
		}).then(_success, _error);
	};
	//===================================




	/*$scope.submitPosition = function(positionForm) {
		console.log(positionForm);

		var method = "POST";
		var url = "/EmployeeManager/api/position";

		$http({
			method: method,
			url: url,
			data: JSON.stringify(positionForm)
		}).then(_success, _error);
	};

	$scope.createPosition = function() {
		_clearFormData();
	}*/




	//=============================================

	$scope.submitPosition = function() {
		console.log($scope.positionForm);
		var method = "";
		var url = "";

		if ($scope.positionForm.id == -1) {
			method = "POST";
			url = '/EmployeeManager/api/position';
		} else {
			method = "PUT";
			url = '/EmployeeManager/api/position/' + $scope.positionForm.id;
		}

		$http({
			method: method,
			url: url,
			data: angular.toJson($scope.positionForm),
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(_success, _error);
	};




	function _success(res) {
		_refreshPositionData();
		_clearFormData();
	}
	function _error(res) {
		var data = res.data;
		var status = res.status;
		var header = res.header;
		var config = res.config;
		alert("Error: " + status + ":" + data);
	}




	//clear form


	function _clearFormData() {
		$scope.positionForm.id = -1;
		$scope.positionForm.name = "";
	};
	$scope.createPosition = function() {
		_clearFormData();
	}
	$scope.editPosition = function(position) {
		console.log(position);
		$scope.positionForm.id = position.id;
		$scope.positionForm.name = position.name;
	};
	//


	//
});