/**
 * 
 */
angular.module('myApp').config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl: 'file/employee/defaultemployee.html',
		controller: 'employeeCtrl'
	});
}).controller('employeeCtrl', function($scope, $http) {
	$scope.sortType = 'name';
	$scope.nameDefault = "Employee";
	$scope.sortReverse = false;
	$scope.viewEmployee = "file/employee/listemployee.html";
	/*$scope.checkPosition = checkAllScope;*/
	$scope.changeViewEmployee = changeViewEventEmployee;
	$scope.choseEventEmployee = choseTeamEmployee;
	$scope.employees;
	//Now load the data from server
	_refreshEmployeeData();
	_refreshPositionData();
	$scope.employeeForm = {
		id: 1,
		name: "",
		nickName: "",
		age: "",
		profile: "not",
		status: 0,
		email: "",
		password: "",
		sex: 0,
		idRole: 0,
		dayStart: new Date()
	};
	$scope.positiones = [];
	$scope.positionForm = {
		id: "",
		name: ""
	};

	$scope.selectCheck = [];
	$scope.toggle = function(item, list) {
		var idx = list.indexOf(item);
		if (idx > -1) {
			list.splice(idx, 1);
		} else {
			list.push(item);
		}
	};
	$scope.exists = function(item, list) {
		return list.indexOf(item) > -1;
	};


	$scope.submitEmployee = function(employeeForm) {
		console.log(employeeForm);

		var method = "POST";
		var url = "http://localhost:8080/EmployeeManager/api/user";

		$http({
			method: method,
			url: url,
			data: JSON.stringify(employeeForm)
		}).then(_success, _error);
	};

	$scope.createEmployee = function() {
		_clearFormData();
	}


	//Delete data form client
	/*$scope.deleteEmployee = function(employee) {
		$http({
			method: 'DELETE',
			url: 'http://localhost:8080/EmployeeManager/api/user/' + employee.id
		}).then(_success, _error);
	};*/


	//Method Delete
	$scope.deleteEmployee = function(selectCheck) {
		let arr = [];
		for (let i of selectCheck) {
			arr.push(i.id);
		}
		$http({
			method: 'DELETE',
			url: 'http://localhost:8080/EmployeeManager/api/user/' + arr,
		}).then(function(response) {
			_refreshEmployeeData();
		}, function(response) {
			console.log(response + selectCheck);
		});

	};

	//////////


	// In case of edit
	$scope.editEmployee = function(employeess) {
		$scope.employeeForm.name = employeess.name;
		$scope.employeeForm.age = employeess.age;
		$scope.employeeForm.nickname = employeess.nickname;
		$scope.employeeForm.position = employeess.position;
		$scope.employeeForm.email = employeess.email;
		$scope.employeeForm.password = employeess.password;
		$scope.employeeFrom.status = employeess.status;
		$scope.employeeFrom.sex = employeess.sex;
	};


	// method GET data with API Technical
	function _refreshEmployeeData() {
		$http({
			method: 'GET',
			url: 'http://localhost:8080/EmployeeManager/api/user'
		}).then(function(res) { // success
			$scope.employees = res.data;

			$scope.isIndeterminate = function() {
				return ($scope.selectCheck.length !== 0 &&
					$scope.selectCheck.length !== $scope.employees.length);
			};

			$scope.isChecked = function() {
				return $scope.selectCheck.length === $scope.employees.length;
			};

			$scope.toggleAll = function() {
				if ($scope.selectCheck.length === $scope.employees.length) {
					$scope.selectCheck = [];
				} else if ($scope.selectCheck.length === 0 || $scope.selectCheck.length > 0) {
					$scope.selectCheck = $scope.employees.slice(0);
				}
			};

		}, function(res) { // error
			console.log("Error: " + res.status + " : " + res.data);
		});
	}

	//Http GET user
	/*function _refreshEmployeeData() {
		$http({
			method: 'GET',
			url: 'http://localhost:8080/EmployeeManager/api/user'
		}).then(
			function(res) {
				$scope.employees = res.data;
			},
			function(res) {
				console.log("Error: " + res.status + " : " + res.data);
			}
		);
	}*/

	//Http GET position
	function _refreshPositionData() {
		$http({
			method: 'GET',
			url: 'http://localhost:8080/EmployeeManager/api/position'
		}).then(
			function(res) {
				$scope.positiones = res.data;
			},
			function(res) {
				console.log("Error: " + res.status + " : " + res.data);
			}
		);
	}

	function _success(res) {
		_refreshEmployeeData();
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
		$scope.employeeForm.name = "";
		$scope.employeeForm.age = "";
		$scope.employeeForm.nickname = "";
		$scope.employeeForm.position = "";
		$scope.employeeForm.email = "";
		$scope.employeeForm.password = "";
		$scope.employeeForm.status = "";
		$scope.employeeForm.sex = "";
	};
});