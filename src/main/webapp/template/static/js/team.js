
app.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
        
    $routeProvider.when('/AddTeam', { //Routing for show list of employee
        templateUrl: '/DoAn/file/team/editTeam.jsp',
        controller: 'teamCtrl'
    }).when('/UpdateTeam', { //Routing for add employee
        templateUrl: '/DoAn/file/team/updateTeam.jsp',
        controller: 'teamCtrl'
    })
    .when('/EditEmployee/:empId', { //Routing for geting single employee details
        templateUrl: '/App/Views/EditEmployee.html',
        controller: 'teamCtrl'
    })
    .when('/DeleteEmployee/:empId', { //Routing for delete employee
        templateUrl: '/App/Views/DeleteEmployee.html',
        controller: 'teamCtrl'
    })
    
}]);


app.controller('teamCtrl', function($scope,$http,$location,filterFilter,$routeParams) {
    /*loadAllTeam========================================*/
     _loadTeamData();
     if(sessionStorage.length != 0){
     	$scope.item = JSON.parse(sessionStorage.item);
     }
     
     function _loadTeamData() {
        $http({
            method: 'GET',
            url: '/DoAn/api/team'
        }).then(
            function(res) { // success
                $scope.teams = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
    
    _loadUserData();
    
     function _loadUserData() {
        $http({
            method: 'GET',
            url: '/DoAn/api/user'
        }).then(
            function(res) { // success
                $scope.users = res.data;    
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
    
      
    
    $scope.selectd = [];
    $scope.exist = function(item){
    return $scope.selectd.indexOf(item) >-1;
    }
    
    $scope.toggleselectuser = function(item){
    	var idx = $scope.selectd.indexOf(item);
    	if(idx > -1){
    		$scope.selectd.splice(idx,1);
    	}else{
    		$scope.selectd.push(item);
    	}
    }
    
    $scope.loadteams = {
        Id: '',
        name: '',
        getidUsers: '',  
        countNumber:$scope.selectd
    };
    
     $scope.loadidss = {
     	ids:$scope.selectd
    }
    
    
    /*loadtoinsertupdate*/
	    $scope.load = function (loadteams) {
	        debugger;
	        $http({
	            method: 'GET',
	            url: '/DoAn/api/user',
	            data: JSON.stringify(loadteams)
	        }).then(
	            function(res) { // success
	             	$scope.users = res.data;    
	                $location.path('/AddTeam');
	            },
	            function(res) { // error
	                console.log("Error: " + res.status + " : " + res.data);
	            }
	        );
	    }
     
    
    /*insertTeam===============================================*/
    
   		$scope.Add = function () {
   			
	        debugger;
	        $http({
	            method: 'POST',
	            url: '/DoAn/api/team',
	            data: $scope.loadteams
	        }).then(
	            function(res) { // success
	                $location.path('/AddTeam');
	            },
	            function(res) { // error
	                console.log("Error: " + res.status + " : " + res.data);
	            }
	        );
	    }
 	
    
   
    /*updateTeam==============================================*/
    /*loadbyidteam*/
	    $scope.loadbyid = function (loadteams) {
	        debugger;
	        $http({
	            method: 'GET',
	            url: '/DoAn/api/team/'+loadteams+''
	        }).then(
	            function(res) { // success
	            	sessionStorage.setItem("item",JSON.stringify(res.data));
	                $location.path('/UpdateTeam');
	                
	            },
	            function(res) { // error
	                console.log("Error: " + res.status + " : " + res.data);
	            }
	        );
	    }
    
    /*deleteTeam================================================*/

    $scope.Delete = function () {
	        debugger;
	        $http({
	            method: 'DELETE',
	            url: '/DoAn/api/team',
	            data: $scope.loadteams.countNumber
	        }).then(
	            function(res) { // success
	                $location.path('/AddTeam');
	            },
	            function(res) { // error
	                console.log("Error: " + res.status + " : " + res.data);
	            }
	        );
	    }
    
    
    /*detailsTeamByIDteam================================================*/
   });


    
