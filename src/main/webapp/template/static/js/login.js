angular.module('loginApp', ['ngSanitize', 'ngMaterial']).controller('loginCtrl', function($scope, $http) {
	$scope.inputType = "password";
	$scope.icon = '<i class="fas fa-eye-slash"></i>';
	$scope.hideShow = function() {
		if ($scope.inputType == "password") {
			$scope.inputType = "text";
			$scope.icon = '<i class="fas fa-eye"></i>';
		} else {
			$scope.inputType = "password";
			$scope.icon = '<i class="fas fa-eye-slash"></i>';
		}
	};
	$scope.viewIndex = "file/login/login.html";
	var arr = ["file/login/login.html", "file/login/forgotpassword.html", "file/login/createpassword.html"];
	$scope.loadIndex = function(event) {
		$scope.viewIndex = arr[event];
	};
	$scope.email;
	$scope.password;
	$scope.error = true;
	$scope.onSubmit = function(email, password) {
		let login = {};
		login.email = email;
		login.password = password;
		$http({
			method: "POST",
			url: "http://localhost:8080/EmployeeManager/api/login",
			data: JSON.stringify(login)
		}).then(function (response) {
			if(response.data.message == "true"){
				location.href="http://localhost:8080/EmployeeManager/home";
				sessionStorage.setItem("user",JSON.stringify(response.data));
				$scope.error = true;
			}else{
				$scope.error = false;
			}
			
		}, function myError(response) {
			console.log(response);
		});
	}
});