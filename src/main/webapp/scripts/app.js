angular.module(
		"myApp", 
		["ngRoute",
		 "ngMessages",
		 "logInModule.controller",
		 "objectivesModule.controller",
		 "mentorScreenModule.controller",
		 "menteeScreenModule.controller"]
		)

		.config(function($routeProvider) {
            $routeProvider
            .when("/", {
                templateUrl : "views/loginPartial.html",
            })
            .when("/adminLogin", {
                templateUrl : "views/adminScreenPartial.html",	
            })
            .when("/mentorLogin", {
                templateUrl : "views/mentorScreenPartial.html",
                controller : "mentorCtrl"
            })
            .when("/menteeLogin", {
            	templateUrl : "views/menteeScreenPartial.html",
            	controller : "menteeCtrl"
            })
            .when("/Logout", {
            	templateUrl : "views/loginPartial.html",
            	controller : "mainCtrl"
            })
            .when("/sessionExpired", {
            	templateUrl : "views/sessionExpired.html"
            });
        })
        
        .controller("mainCtrl",function($scope,$rootScope,dataServiceLogin){
        	var temp = dataServiceLogin.logoutUser($scope.login);
    		temp.then(function(data){
    			$rootScope.loginAuthenticationError = "Logged out successfully";
    		});
        	
        });