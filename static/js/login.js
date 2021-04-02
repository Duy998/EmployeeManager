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
        console.log(email, password);
        $http({
            method: "GET",
            url: "http://localhost:8080/EmployeeManager/api/login/" + email + "/" + password,
        }).then(function(response) {
            console.log(response.data);
            if (response.data == true) {
                location.href = "http://localhost:8080/EmployeeManager/home";
            } else {
                $scope.error = false;
            }

        }, function myError(response) {
            console.log(response);
        });
    }
});