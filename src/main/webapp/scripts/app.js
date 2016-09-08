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
                controller: 'loginCtrl'
            })
            .when("/adminLogin", {
                templateUrl : "views/adminScreenPartial.html",
                controller: 'adminCtrl'	
            })
            .when("/mentorLogin", {
                templateUrl : "views/mentorScreenPartial.html",
                controller: 'mentorCtrl'
            })
            .when("/menteeLogin", {
            	templateUrl : "views/menteeScreenPartial.html",
                controller: 'menteeCtrl'
            });
        });