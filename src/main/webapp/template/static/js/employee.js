let app = angular.module('myApp', ['ngRoute', 'ngMaterial'])
app.controller('appCtrl', function($scope) {
    $scope.username = "Adminuser";
    $scope.addEmployee = true;
    $scope.addTeam = false;
    $scope.addPosition = false;
    $scope.currentNav = function(event) {
        switch (event) {
            case "employee":
                $scope.addEmployee = true;
                $scope.addTeam = false;
                $scope.addPosition = false;
                break;
            case "team":
                $scope.addEmployee = false;
                $scope.addTeam = true;
                $scope.addPosition = false;
                break;
            case "position":
                $scope.addEmployee = false;
                $scope.addTeam = false;
                $scope.addPosition = true;
                break;
        }
    }
    $scope.hideShow = false;
});
app.config(function($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'file/employee/listemployee.html',
        controller: 'employeeCtrl'
    }).when('/team', {
        templateUrl: 'file/team/default.html',
        controller: 'teamCtrl'
    }).when('/position', {
        templateUrl: 'file/position/listposition.html',
        controller: 'positionCtrl'
    });
});
app.controller('employeeCtrl', function($scope) {
    $scope.msg = "Employee";
    $scope.currentNav('#!/');
});
app.controller('teamCtrl', function($scope, filterFilter,$http) {
    $scope.nameDefault = "List Team";
    $scope.viewTeam = "file/team/listteam.html";
    $scope.sortType = 'name';
    $scope.sortReverse = false;
    /*$scope.students = [
        { name: 'Lien', ex: 20, position: "A" },
        { name: 'Linh', ex: 18, position: "CB" },
        { name: 'Hoa', ex: 15, position: "B" },
        { name: 'Nga', ex: 35, position: "M" },
        { name: 'Zoan', ex: 26, position: "D" },
    ];*/
    
    _loadDataTeam();
    function _loadDataTeam() {
        $http({
            method: 'GET',
            url: '/EmployeeManager/api/user'
        }).then(
            function(res) { // success
                $scope.users = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
    
    
    $scope.checkAll = function() {
        let checkboxs = document.getElementsByName("name[]");
        for (let i = 0; i < checkboxs.length; i++) {
            if (checkboxs[i].checked != true) {
                checkboxs[i].checked = true;
            } else {
                checkboxs[i].checked = false;
            }
        }
    };
    //View
    $scope.changeView = function(event) {
            $scope.viewTeam = event;
            if (event != "file/team/listteam.html") {
                $scope.hideShow = true;
            } else {
                $scope.hideShow = false;
            }
        }
        // Tabs
    let url = window.location.href.split('#!/');
    $scope.currentNav(url[url.length - 1]);
});

app.controller('positionCtrl', function($scope) {
    $scope.msg = "Position";
    let url = window.location.href.split('#!/');
    $scope.currentNav(url[url.length - 1]);
});