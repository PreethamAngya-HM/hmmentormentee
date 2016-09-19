angular.module("menteeScreenModule.controller",["ngRoute","ngMessages","logInModule.controller"])
.service("menteeService",function($http,$location){
	var mentorMenteeNamesUrl = '/MentorMentee/getMentorMenteeNames/';
	var objUrl = '/MentorMentee/getObjectives/';
	var evalMenteeByMentorUrl = '/MentorMentee/getEvalMenteeByMentor/';
	var evalMentorByMenteeUrl = '/MentorMentee/getEvalMentorByMentee/';
	this.objectives = {};
	this.evalMenteeByMentor = {};
	this.evalMentorByMentee = {};
	this.menteeObj = {};
	this.getMentorMenteeNames = function(menteeObj){
		return $http({
		 method:'POST',
		 url : mentorMenteeNamesUrl,
		 data : menteeObj
		}).then(function successCallback(response) {
			console.log("Service Success Response: "+ response.statusText);
			return response.data;
		}, function errorCallback(response) {
			console.log("Service Error Response: "+ response.statusText);
			return response.data;
		});
	}
	this.getObjectives = function(menteeObj,objectives){
		var menteeReq = {"menteeObj":menteeObj,"objectivesObj":objectives};
		return $http({
		 method:'POST',
		 url : objUrl,
		 data : menteeReq
		}).then(function successCallback(response) {
			console.log("Service Success Response: "+ response.statusText);
			return response.data;
		}, function errorCallback(response) {
			console.log("Service Error Response: "+ response.statusText);
			return response.data;
		});
	}
	this.getEvalOfMenteeByMentor = function(menteeObj,evalMenteeByMentor){
		var menteeReq = {"menteeObj":menteeObj,"evalMenteeByMentorObj":evalMenteeByMentor};
		return $http({
		 method:'POST',
		 url : evalMenteeByMentorUrl,
		 data : menteeReq
		}).then(function successCallback(response) {
			console.log("Service Success Response: "+ response.statusText);
			return response.data;
		}, function errorCallback(response) {
			console.log("Service Error Response: "+ response.statusText);
			return response.data;
		});
	}
	this.getEvalMentorByMentee = function(menteeObj,evalMentorByMentee){
		var menteeReq = {"menteeObj":menteeObj,"evalMentorByMenteeObj":evalMentorByMentee};
		return $http({
		 method:'POST',
		 url : evalMentorByMenteeUrl,
		 data : menteeReq
		}).then(function successCallback(response) {
			console.log("Service Success Response: "+ response.statusText);
			return response.data;
		}, function errorCallback(response) {
			console.log("Service Error Response: "+ response.statusText);
			return response.data;
		});
	}
})

.service("menteeUpdateService",function($http){
	var objUrl = '/MentorMentee/setObjectives/';
	var evalMentorByMenteeUrl = '/MentorMentee/setEvalMentorByMentee/';
	this.setObjectives = function(menteeObj,objectives){
		var menteeReq = {"menteeObj":menteeObj,"objectivesObj":objectives};
		return $http({
		 method:'POST',
		 url : objUrl,
		 data : menteeReq
		}).then(function successCallback(response) {
			console.log("Service Success Response: "+ response.statusText);
			return response.data;
		}, function errorCallback(response) {
			console.log("Service Error Response: "+ response.statusText);
			return response.data;
		});
	}
	this.evalMentorByMentee = {};
	this.setEvalMentorByMentee = function(menteeObj,evalMentorByMentee){
		var menteeReq = {"menteeObj":menteeObj,"evalMentorByMenteeObj":evalMentorByMentee};
		return $http({
		 method:'POST',
		 url : evalMentorByMenteeUrl,
		 data : menteeReq
		}).then(function successCallback(response) {
			console.log("Service Success Response: "+ response.statusText);
			return response.data;
		}, function errorCallback(response) {
			console.log("Service Error Response: "+ response.statusText);
			return response.data;
		});
	}
})
.controller("menteeCtrl",function($scope,menteeService,$rootScope,menteeUpdateService,$location){
	console.log("menteeCtrl");
	console.log($scope.$id);
	$scope.menteeObj={};
	var temp = menteeService.getMentorMenteeNames($scope.menteeObj);
	temp.then(function(data){
		$scope.menteeObj = data;
		if(data.menteeName==null){
			$location.path('/sessionExpired');
		}
	});
	$scope.objectives = {};
	$scope.evalMenteeByMentorObj = {};
	$scope.evalMentorByMenteeObj = {};
	$scope.menteeGoBtnClick = function(){
		var temp = menteeService.getObjectives($scope.menteeObj,$scope.objectives);
		temp.then(function(data){
			$scope.objectives = data;
		});
		var temp1 = menteeService.getEvalOfMenteeByMentor($scope.menteeObj,$scope.evalMenteeByMentorObj);
		temp1.then(function(data){
			$scope.evalMenteeByMentorObj = data;
		});
		var temp2 = menteeService.getEvalMentorByMentee($scope.menteeObj,$scope.evalMentorByMenteeObj);
		temp2.then(function(data){
			$scope.evalMentorByMenteeObj = data;
		});
		$scope.afterGo = true;
		$scope.updateObjReviewedShow = false;
		$scope.updateActionPlanShow = false;
		$scope.updateResultsShow = true;
		$scope.updateEvalOfMentorShow = false;
		$scope.updateEvalOfMenteeShow = true;
	};
	$scope.objUpdateBtnClick = function(){
		var temp = menteeUpdateService.setObjectives($scope.menteeObj,$scope.objectives);
		temp.then(function(data){
			$scope.objectives = data;
		});
	};
	$scope.evalMentorByMenteeBtnClick = function(){
		var temp = menteeUpdateService.setEvalMentorByMentee($scope.menteeObj,$scope.evalMentorByMenteeObj);
		temp.then(function(data){
			$scope.evalMentorByMenteeObj = data;
		});
	};
});