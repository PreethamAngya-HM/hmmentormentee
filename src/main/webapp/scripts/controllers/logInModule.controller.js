angular.module("logInModule.controller",["ngRoute","ngMessages"])
.service("dataServiceLogin",function($http,$location){
	var authUser = '/MentorMentee/authenticateUser/';
	var logoutUser = '/MentorMentee/logoutUser/';
	this.authenticateUser = function(loginObj){
		return $http({
		 method:'POST',
		 url : authUser,
		 data : loginObj
		}).then(function successCallback(response) {
			console.log("Service Success Response: "+ response.statusText);
			return response.data;
		}, function errorCallback(response) {
			console.log("Service Error Response: "+ response.statusText);
			return response.data;
		});
	}
	this.logoutUser = function(){
		console.log("Inside Logout User");
		return $http({
		 method:'POST',
		 url : logoutUser
		}).then(function successCallback(response) {
			console.log("Service Success Response: "+ response.statusText);
			return response.data;
		}, function errorCallback(response) {
			console.log("Service Error Response: "+ response.statusText);
			return response.data;
		});
	}
})
.controller("loginCtrl",function($scope, $rootScope, $location, dataServiceLogin){
	console.log("loginCtrl");
	dataServiceLogin.logoutUser();
	$rootScope.loginAuthenticationError = "";
	$scope.roleNames = ["Role","Admin","Mentor","Mentee"];
	$scope.userName = ''; 
	$scope.password = '';
	$scope.loginAction = function (){
		var role = $scope.login.role ;
		var temp = dataServiceLogin.authenticateUser($scope.login);
		temp.then(function(data){
			if(data.authenticated){
				if(role == 'Admin' ){//&& data.role == 'Admin'){
					$location.path('/adminLogin');
				}
				else if(role == 'Mentor' ){//&& data.role == 'Mentor'){
					$location.path('/mentorLogin');
				}
				else if(role == 'Mentee' ){//&& data.role == 'Mentee'){
					$location.path('/menteeLogin');
				}
				else{
					$rootScope.loginAuthenticationError = 'Role dosen\'t match';
				}
			}
			else{
				$rootScope.loginAuthenticationError = 'Authentication Failed';
			}
		});
	};
});