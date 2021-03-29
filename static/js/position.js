app.controller('positionCtrl', function ($scope, filterFilter) {
    $scope.sortType = 'name';
    $scope.sortReverse = false;
    $scope.checkPosition = checkAllScope;
    $scope.students = [
        { name: 'Lien', age: 20, nickname: "Line", position: "A" },
        { name: 'Linh', age: 18, nickname: "Linh", position: "CB" },
        { name: 'Hoa', age: 15, nickname: "Hoa", position: "B" },
        { name: 'Nga', age: 35, nickname: "Nga", position: "M" },
        { name: 'Zoan', age: 26, nickname: "Zoan", position: "Y" },
    ];
    $scope.position = [
        {
            id: 1,
            names: "CEO"
        },
        {
            id: 2,
            names: "Manager"
        },
        {
            id: 3,
            names: "Admin"
        }
    ]
});