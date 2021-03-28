app.controller('teamCtrl', function($scope, filterFilter,$http) {
    $scope.nameDefault = "List Team";
    $scope.viewTeam = "file/team/listteam.html";
    $scope.sortType = 'name';
    $scope.sortReverse = false;
    $scope.students = [
        { name: 'Lien', ex: 20, position: "A" },
        { name: 'Linh', ex: 18, position: "CB" },
        { name: 'Hoa', ex: 15, position: "B" },
        { name: 'Nga', ex: 35, position: "M" },
        { name: 'Zoan', ex: 26, position: "D" },
    ];
    $scope.checkAll = checkAllScope;
    //View
    $scope.changeView = changeViewEvent;
    $scope.choseTeamEvent = choseTeam;
    debugger;
    _refreshEmployeeData();

    function _refreshEmployeeData(x) {
        $http({
            method: 'GET',
            url: 'position/{x}'
        }).then(
            function(res) { // success
                $scope.employees = res.data;
                window.location = "http://www.my-domain.com/login"
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
});

// app.controller('team-controller-edit',function($scope){
    
//   });
// app.controller('WizardController',function ($scope, $location) {   
//     $scope.button1 = 
//     $location.path('/test1.html');

//     $scope.button2 =
//     $location.path('/test2.html');
// });
    
