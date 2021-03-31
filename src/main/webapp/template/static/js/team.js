app.controller('teamCtrl', function($scope, filterFilter) {
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
});