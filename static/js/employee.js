app.controller('employeeCtrl', function ($scope, filterFilter) {
    $scope.sortType = 'name';
    $scope.sortReverse = false;
    $scope.checkPosition = checkAllScope;
    $scope.employee = [
        { name: 'Nguyen', age: 20, nickname: "Line", position: "A" },
        { name: 'Linh', age: 18, nickname: "Linh", position: "CB" },
        { name: 'Hoa', age: 15, nickname: "Hoa", position: "B" },
        { name: 'Nga', age: 35, nickname: "Nga", position: "M" },
        { name: 'Zoan', age: 26, nickname: "Zoan", position: "Y" },
    ];
    // $scope.success = false;
    //         $scope.register = function () {
    //            $scope.success = true;
    //         }
});

