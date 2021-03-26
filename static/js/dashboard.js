let app = angular.module('myApp', ['ngRoute', 'ngMaterial']);

app.controller('appCtrl', function($scope) {
    $scope.username = "Administrator";
    $scope.addEmployee = true;
    $scope.addTeam = false;
    $scope.addPosition = false;
    $scope.currentNav = currentNavEvent;
    $scope.hideShow = false;
    let url = window.location.href.split('#!/');
    $scope.currentNav(url[url.length - 1]);

    // Event open and close modal responsive
    $scope.openModal = openModalEvent;
    $scope.closeModal = closeModalEvent;

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
});
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
app.controller('positionCtrl', function($scope) {
    $scope.msg = "Position";
});

// Custom function.

function getFeatures(scopeFeatures) {
    let features = scopeFeatures.map(key => {
        let keys = [];
        if (key.match(/add/g) !== null) {
            keys.push(key)
        }
        return keys;
    });
    features = [].concat(...features);
    return features;
}

// Current Navigation Event
function currNavEvent(event) {
    let features = getFeatures(Object.keys(this.$parent));

    // return false into all feature
    features.forEach(feature => this[feature] = false);
    console.log(features);
    let name = "add" + event[0].toUpperCase() + event.slice(1, event.length);
    this[name] = true;
    console.log(this[name]);
}

function currentNavEvent(event) {
    switch (event) {
        case "employee":
            this.addEmployee = true;
            this.addTeam = false;
            this.addPosition = false;
            break;
        case "team":
            this.addEmployee = false;
            this.addTeam = true;
            this.addPosition = false;
            break;
        case "position":
            this.addEmployee = false;
            this.addTeam = false;
            this.addPosition = true;
            break;
    }
}

function checkAllScope() {
    let checkboxs = document.getElementsByName("name[]");
    for (let i = 0; i < checkboxs.length; i++) {
        checkboxs[i].checked = !checkboxs[i].checked;
    }
}

function changeViewEvent(event) {
    this.viewTeam = event;
    if (event != "file/team/listteam.html") {
        this.nameDefault = "Detail team";
        this.hideShow = true;
    } else {
        this.nameDefault = "List team";
        this.hideShow = false;
    }
}

function choseTeam(event) {
    this.viewTeam = "file/team/inforteam.html";
    if (this.viewTeam != "file/team/inforteam.html") {
        this.hideShow = true;
    } else {
        this.hideShow = false;
    }
}

function openModalEvent() {
    $('.navbars').css({
        'width': '%',
        'transition': '.5s'
    });
}

function closeModalEvent() {
    $('.navbars').css({
        'width': '0%',
        'transition': '.5s'
    });
}