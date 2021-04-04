app.config([ '$locationProvider', '$routeProvider',
		function($locationProvider, $routeProvider) {
			$routeProvider.when('/AddTeam', { 
				templateUrl : '/DoAn/file/team/editTeam.jsp',
				controller : 'teamCtrl'
			}).when('/UpdateTeam', { 
				templateUrl : 'file/team/updateTeam.jsp',
				controller : 'teamCtrl'
			}).when('/InformationTeam', {
				templateUrl : 'file/team/informationteam.jsp',
				controller : 'teamCtrl'})

		} ]);

app.controller('teamCtrl', function($scope, $http, $location, filterFilter,
		$routeParams) {
	$scope.showMe = false;
	/*loadAllTeam========================================*/
	_loadTeamData();

	function _loadTeamData() {
		$http({
			method : 'GET',
			url : '/DoAn/api/team'
		}).then(function(res) { // success
			$scope.teams = res.data;
		}, function(res) { // error
			console.log("Error: " + res.status + " : " + res.data);
		});
	}


	var ids = {};

	// select all items
	$scope.selectAll = function() {
		ids = $scope.teams;
		angular.forEach($scope.teams, function(item) {
			$scope.allteamid = item.id;
		});
	};

	// use the array "every" function to test if ALL items are checked
	$scope.checkIfAllSelected = function() {
		$scope.selectedAll = $scope.Items.every(function(item) {
			return item.Selected == true
		})
	};
	/*///////////loadAllTeam====================================================*/

	//     if(sessionStorage.length != 0){
	//     	$scope.item = JSON.parse(sessionStorage.item);
	//     }

	//    _loadUserData();
	//    
	//     function _loadUserData() {
	//        $http({
	//            method: 'GET',
	//            url: '/DoAn/api/user'
	//        }).then(
	//            function(res) { // success
	//                $scope.users = res.data;    
	//            },
	//            function(res) { // error
	//                console.log("Error: " + res.status + " : " + res.data);
	//            }
	//        );
	//    }
	//    
	//    $scope.selectd = [];
	//    $scope.exist = function(item){
	//    return $scope.selectd.indexOf(item) >-1;
	//    }
	//    
	//    $scope.toggleselectuser = function(item){
	//    	var idx = $scope.selectd.indexOf(item);
	//    	if(idx > -1){
	//    		$scope.selectd.splice(idx,1);
	//    	}else{
	//    		$scope.selectd.push(item);
	//    	}
	//    }
	//    $scope.loadteams = {
	//        Id: '',
	//        name: '',
	//        getidUsers: '',  
	//        countNumber:$scope.selectd
	//    };
	//    
	//     $scope.loadidss = {
	//     	ids:$scope.selectd
	//    }
	//    
	/*loadtoinsertupdate*/
	//	    $scope.load = function () {
	//	        debugger;
	//	        $http({
	//	            method: 'GET',
	//	            url: '/DoAn/api/user',
	//	        }).then(
	//	            function(res) { // success
	//	                $location.path('/AddTeam');
	//	            },
	//	            function(res) { // error
	//	                console.log("Error: " + res.status + " : " + res.data);
	//	            }
	//	        );
	//	    }
	/*insertTeam===============================================*/

	$scope.Add = function() {
		debugger;
		$http({
			method : 'POST',
			url : '/DoAn/api/team',
			data : $scope.loadteams
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
	$scope.loadbyid = function(loadteams) {
		debugger;
		$http({
			method : 'GET',
			url : '/DoAn/api/team/' + loadteams + ''
		}).then(function(res) { // success
			sessionStorage.setItem("item", JSON.stringify(res.data));
			$location.path('/UpdateTeam');

		}, function(res) { // error
			console.log("Error: " + res.status + " : " + res.data);
		});
	}

	/*deleteTeam================================================*/

	$scope.Delete = function() {
		
		debugger;
		$http({
			method : 'DELETE',
			url : '/DoAn/api/team',
			data : ids.id
		}).then(function(res) { // success
			$location.path('/AddTeam');
		}, function(res) { // error
			console.log("Error: " + res.status + " : " + res.data);
		});
	}

	/*detailsTeamByIDteam================================================*/
	
		$scope.Information = function(id) {
			debugger;
			$http({
				method : 'GET',
				url : '/DoAn/api/team/inforteam/'+id+'',
			}).then(function(res) { // success
				sessionStorage.setItem("inforname",JSON.stringify(res.data));
				$location.path('/InformationTeam');
				
			}, function(res) { // error
				console.log("Error: " + res.status + " : " + res.data);
			});
		}
		$scope.infornames;
		if(sessionStorage.inforname){
			$scope.infornames =JSON.parse(sessionStorage.inforname);
		}
		console.log($scope.infornames);
});
