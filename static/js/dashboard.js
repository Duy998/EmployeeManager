(function() {
    'user strict';
    angular.module('myApp', ['ngRoute', 'ngMaterial']).config(function($routeProvider) {
        $routeProvider.otherwise({
            redirecTo: "/",
            controller: "employeeCtrl"
        });
    }).controller('appCtrl', appCtrl);

    function appCtrl($scope) {
        $scope.username = "Administrator";
        $scope.hideShow = false;

        // Event open and close modal responsive
        $scope.openModal = openModalEvent;
        $scope.closeModal = closeModalEvent;
    }
})();