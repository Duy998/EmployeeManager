angular.module('loginApp', ['ngSanitize', 'ngMaterial']).controller('loginCtrl', function($scope) {
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
    $scope.loadIndex = function() {
        if ($scope.viewIndex == "file/login/login.html") {
            $scope.viewIndex = "file/login/forgotpassword.html";
        } else {
            $scope.viewIndex = "file/login/login.html";
        }
    };
});