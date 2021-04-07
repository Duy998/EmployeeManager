app.config(['$locationProvider', '$routeProvider',
	function($locationProvider, $routeProvider) {

		$routeProvider.when('/AddTeam', { //Routing for show list of employee
			templateUrl: '/DoAn/file/team/editTeam.jsp',
			controller: 'teamCtrl'
		}).when('/UpdateTeam', { //Routing for add employee
			templateUrl: 'file/team/updateTeam.jsp',
			controller: 'teamCtrl'
		}).when('/InformationTeam', {
			templateUrl: 'file/team/informationteam.jsp',
			controller: 'teamCtrl'
		})

	}]);

app.controller('teamCtrl', function($scope, $http, $location, filterFilter,
	$routeParams) {
	$scope.showMe = false;
	if (sessionStorage.loadbyids) {
		$scope.loadteamss = JSON.parse(sessionStorage.loadbyids);
	}


	/*==========================================================================*/
	/*$(function() {

		window.pagObj = $('#pagination').twbsPagination({
			totalPages: 10,
			visiblePages: 5,
			startPage: 1,
			onPageClick: function(event, page) {
				console.info(page + ' (from event listening)');
			}
		}).on('page', function(event, page) {


		});
	});*/
	/*============================*/

	/*loadAllTeam========================================*/
	_loadTeamData();
	$scope.teams;
	function _loadTeamData() {
		$http({
			method: 'GET',
			url: '/DoAn/api/team?page=1&limit=2'
		}).then(function(res) { // success
			$scope.teams = res.data;
			$(function() {
		window.pagObj = $('#pagination').twbsPagination({
			totalPages: 10,
			visiblePages: 5,
			startPage: res.data.id,
			onPageClick: function(event, page) {
				console.info(page + ' (from event listening)');
			}
		}).on('page', function(event, page) {


		});
	});
		}, function(res) { // error
			console.log("Error: " + res.status + " : " + res.data);
		});
	}

	/*///////////loadAllTeam====================================================*/
	/*=========checked================*/
	$scope.userChecked = [];
	$scope.checkedAll = false;

	$scope.checkItem = function(id, checked) {
		if (checked) {
			$scope.userChecked.push(id);
		} else {
			$scope.userChecked.pop();
			if ($scope.userChecked.length < 1) {
				$scope.checkedAll = true;
			}
		}

		console.log('$scope.userChecked', $scope.userChecked);
	};

	$scope.checkAll = function(checked) {
		$scope.userChecked = [];

		angular.forEach($scope.teams.listresult, function(value, key) {
			value.selected = checked;
			$scope.userChecked.push(value.id);
		});

		if (!checked) {
			$scope.userChecked = [];
		}

		console.log('$scope.userChecked', $scope.userChecked);
	};




	/*insertTeam===============================================*/

	$scope.Add = function() {
		debugger;
		$http({
			method: 'POST',
			url: '/DoAn/api/team',
			data: $scope.loadteams
		}).then(function(res) { // success
			$location.path('/AddTeam');
			$scope.success = "insert success";
			$scope.showMe = !$scope.showMe;

		}, function(res) { // error
			console.log("Error: " + res.status + " : " + res.data);
		});
	}

	/*updateTeam==============================================*/
	/*loadbyidteam*/
	$scope.loadupdateteam;
	$scope.loadbyid = function(loadteams) {
		debugger;
		$http({
			method: 'GET',
			url: '/DoAn/api/team/loadteam/' + loadteams + ''
		}).then(function(res) { // success
			$location.path('/UpdateTeam');
			sessionStorage.setItem("loadbyids", JSON.stringify(res.data));
		}, function(res) { // error
			console.log("Error: " + res.status + " : " + res.data);
		});
	}
	if (sessionStorage.loadbyids) {
		$scope.loadupdateteam = JSON.parse(sessionStorage.loadbyids);
		$scope.idTeam = $scope.loadupdateteam.idTeam;
		$scope.nameTeam = $scope.loadupdateteam.nameTeam;
	}
	$scope.managername;
	/*=updateTeam=*/
	$scope.GetValue = function() {

		$scope.message = [];
		$scope.managername;
		$scope.nameTeam;
		$scope.idTeam;
		for (var i = 0; i < $scope.loadupdateteam.listallUser.length; i++) {
			if ($scope.loadupdateteam.listallUser[i].Selected || $scope.loadupdateteam.listallUser[i].checked != null) {
				var fruitId = $scope.loadupdateteam.listallUser[i].id;
				$scope.message.push(fruitId);
			}
		}

		$scope.result = {
			checkeds: $scope.message,
			managername: $scope.managername,
			nameTeam: $scope.nameTeam,
			idTeam: $scope.idTeam
		};

		debugger;
		$http({
			method: 'PUT',
			url: '/DoAn/api/team',
			data: $scope.result
		}).then(function(res) { // success
			/*$location.path('/AddTeam');*/
			$scope.success = "insert success";
			$scope.showMe = !$scope.showMe;

		}, function(res) { // error
			console.log("Error: " + res.status + " : " + res.data);
		});

	}

	/*deleteTeam================================================*/

	$scope.Delete = function() {
		debugger;
		$http({
			method: 'DELETE',
			url: '/DoAn/api/team/' + $scope.userChecked
		}).then(function(res) { // success
			$scope.deletesuccsess = "xoa thanh cong";
			$location.path('/team');
		}, function(res) { // error
			console.log("Error: " + res.status + " : " + res.data);
		});
	}

	/*detailsTeamByIDteam================================================*/


	/*inforteam=====================================================================*/
	$scope.Information = function(id) {
		debugger;
		$http({
			method: 'GET',
			url: '/DoAn/api/team/inforteam/' + id + '',
		}).then(function(res) { // success
			sessionStorage.setItem("inforname", JSON.stringify(res.data));
			$location.path('/InformationTeam');

		}, function(res) { // error
			console.log("Error: " + res.status + " : " + res.data);
		});
	}
	$scope.infornames;
	if (sessionStorage.inforname) {
		$scope.infornames = JSON.parse(sessionStorage.inforname);
	}
	console.log($scope.infornames);

});