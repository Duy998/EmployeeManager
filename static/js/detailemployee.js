app.controller('detailEmployeeCtrl', function ($scope, $http, $mdDialog) {

	$scope.detailUser = JSON.parse(sessionStorage.detailuser);
	
	$scope.advantageForm = {
		name: ""
	}

	$scope.advantages = [];

	$scope.selectCheck = [];

	// Click select row
	$scope.toggle = function (item, list) {
		var idx = list.indexOf(item);
		if (idx > -1) {
			list.splice(idx, 1);
		} else {
			list.push(item);
		}
	};

	// Check select row
	$scope.exists = function (item, list) {
		return list.indexOf(item) > -1;
	};

	// method GET data with API Technical
	function _loadAdvantageData(detailUser) {
		// Call API findAll Data
		$http({
			method: 'GET',
			url: '/EmployeeManager/' + $scope.detailUser.id + '/api/advantage'
		}).then(function (res) { // success
			$scope.advantages = res.data;

			// Check select all
			$scope.isIndeterminate = function () {
				return ($scope.selectCheck.length !== 0 &&
					$scope.selectCheck.length !== $scope.advantages.length);
			};

			// Check select all
			$scope.isChecked = function () {
				return $scope.selectCheck.length === $scope.advantages.length;
			};

			// Click select all
			$scope.toggleAll = function () {
				if ($scope.selectCheck.length === $scope.advantages.length) {
					$scope.selectCheck = [];
				} else if ($scope.selectCheck.length === 0 || $scope.selectCheck.length > 0) {
					$scope.selectCheck = $scope.advantages.slice(0);
				}
			};

		}, function (res) { // error
			console.log("Error: " + res.status + " : " + res.data);
		});
	}
	
	// Load the data Technical from server
	_loadAdvantageData($scope.detailUser);

	// Method Delete List Advantage
	$scope.deleteListAdvantage = function (selectCheck) {

		// array ID Advantage
		let idAdvantages = [];
		for (let i of selectCheck) {
			idAdvantages.push(i.id);
		}

		// Delete call API delete
		$http({
			method: 'DELETE',
			url: '/EmployeeManager/' + $scope.detailUser.id + '/api/advantage/' + idAdvantages,
		}).then(function (response) {
			_loadAdvantageData();
		}, function (response) {
			console.log(response + selectCheck);
		});
	};

	// method POST data with API Technical
	$scope.submitAdvantage = function () {
		if ($scope.advantageForm.name == ""){
			return alert("Blank Form!");
		} else {
			$http({
				method: 'POST',
				url: '/EmployeeManager/' + $scope.detailUser.id + '/api/advantage',
				data: angular.toJson($scope.advantageForm),
				headers: {
					'Content-Type': 'application/json'
				}
			}).then(_success, _error);
		}
	};
	  
	$scope.showAdvanced = function (ev) {
		$mdDialog.show({
			templateUrl: 'dialog1.tmpl.html',
			// Appending dialog to document.body to cover sidenav in docs app
			// Modal dialogs should fully cover application to prevent
			// interaction outside of dialog
			parent: angular.element(document.body),
			targetEvent: ev,
			clickOutsideToClose: true,
			fullscreen: $scope.customFullscreen, // Only for -xs, -sm
													// breakpoints.
			controller: function ($scope, $mdDialog) {
				$scope.dataValue = ev;
				$scope.hide = function () {
					$mdDialog.hide();
				};

				$scope.cancel = function () {
					$mdDialog.cancel();
				};

				$scope.answer = function (answer) {
					$mdDialog.hide(answer);
				};
				// edit Advantage
				$scope.editAdvantage = function (x) {
					debugger;
					console.log(x);
					$http({
						method: 'PUT',
						url: '/EmployeeManager/' + $scope.detailUser.id + '/api/advantage/' + x.id,
						data: angular.toJson(x),
						headers: {
							'Content-Type': 'application/json'
						}
					}).then(_success, _error);
				};
			}
		}).then(function (answer) {
			}, function () {
			});
	};

	function _clearFormData() {
	      $scope.advantageForm.name = ""
	   };
	    
	function _success(res) {
		_loadAdvantageData();
		_clearFormData();
	}
	
	function _error(res) {
		var data = res.data;
		var status = res.status;
		var header = res.header;
		var config = res.config;
		alert("Error: " + status + ":" + data);
	}

});
// Controller Technical
app.controller('detail_techskill_Ctrl', function ($scope, $http) {

	$scope.technicals = [];
	$scope.technicalForm = {
		id: -1,
		skill: "",
		level: ""
	};

	// When click edit
	$scope.getTechnical = function (x) {
		$scope.technicalForm.technicalSkill = $scope.skill;
		$scope.technicalLevel.technicalLevel = $scope.level;
	};

	// Load the data Technical from server
	_loadTechnicalData();

	// method GET data with API Technical
	function _loadTechnicalData() {
		$http({
			method: 'GET',
			url: '/EmployeeManager/api/technical'
		}).then(function (res) { // success
			$scope.technicals = res.data;
		}, function (res) { // error
			console.log("Error: " + res.status + " : " + res.data);
		});
	}

	// method POST data with API Technical
	$scope.submitTechnical = function () {
		var method = "";
		var url = "";
		if ($scope.technicalForm.id == -1) {
			method = "POST";
			url = '/EmployeeManager/api/technical';
		} else {
			method = "PUT";
			url = '/EmployeeManager/api/technical/' + x.id;
		}
		$http({
			method: method,
			url: url,
			data: angular.toJson($scope.technicalForm),
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(_success, _error);
	};

	$scope.deleteTechnical = function (x) {
		$http({
			method: "DELETE",
			url: '/EmployeeManager/api/technical'
		}).then(_success, _error);
	};


	function _success(res) {
		_loadTechnicalData();
	}

	function _error(res) {
		var data = res.data;
		var status = res.status;
		var header = res.header;
		var config = res.config;
		alert("Error: " + status + ":" + data);
	}
});

app.controller('detail_Advantages_Ctrl', function ($scope, $http) {

});
