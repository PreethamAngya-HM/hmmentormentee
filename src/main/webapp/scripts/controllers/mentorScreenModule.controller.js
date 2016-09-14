angular.module("mentorScreenModule.controller",["ngRoute","ngMessages","logInModule.controller"])
.service("mentorService",function($http,$location){
	var mentorMenteeNamesUrl = '/getMentorMenteeNamesForMentor/';
	var objUrl = '/getObjectives/';
	var evalMenteeByMentorUrl = '/getEvalMenteeByMentor/';
	var evalMentorByMenteeUrl = '/getEvalMentorByMentee/';
	this.objectives = {};
	this.evalMenteeByMentor = {};
	this.evalMentorByMentee = {};
	this.menteeObj = {};
	this.getMentorMenteeNamesForMentor = function(menteeObj){
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

.service("mentorUpdateService",function($http){
	var objUrlObjReviewed = '/setObjectivesObjReviewed/';
	var objUrlActionPlan = '/setObjectivesActionPlan/';
	var evalMenteeByMentorUrl = '/setEvalMenteeByMentor/';
	this.setObjectivesObjReviewed = function(menteeObj,objectives){
		var menteeReq = {"menteeObj":menteeObj,"objectivesObj":objectives};
		return $http({
		 method:'POST',
		 url : objUrlObjReviewed,
		 data : menteeReq
		}).then(function successCallback(response) {
			console.log("Service Success Response: "+ response.statusText);
			return response.data;
		}, function errorCallback(response) {
			console.log("Service Error Response: "+ response.statusText);
			return response.data;
		});
	}
	this.setObjectivesActionPlan = function(menteeObj,objectives){
		var menteeReq = {"menteeObj":menteeObj,"objectivesObj":objectives};
		return $http({
		 method:'POST',
		 url : objUrlActionPlan,
		 data : menteeReq
		}).then(function successCallback(response) {
			console.log("Service Success Response: "+ response.statusText);
			return response.data;
		}, function errorCallback(response) {
			console.log("Service Error Response: "+ response.statusText);
			return response.data;
		});
	}
	this.evalMenteeByMentor = {};
	this.setEvalMenteeByMentor = function(menteeObj,evalMenteeByMentor){
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
})
.controller("mentorCtrl",function($scope,mentorService,$rootScope,mentorUpdateService){
	console.log("mentorCtrl");
	console.log($scope.$id);
	$scope.mentorObj={};
	var temp = mentorService.getMentorMenteeNamesForMentor($scope.mentorObj);
	temp.then(function(data){
		$scope.mentorObj = data;
	});
	$scope.objectives = {};
	$scope.evalMenteeByMentorObj = {};
	$scope.evalMentorByMenteeObj = {};
	$scope.mentorGoBtnClick = function(){
		var temp = mentorService.getMentorMenteeNamesForMentor($scope.mentorObj);
		temp.then(function(data){
			console.log("MMANUM Set");
			//$scope.mentorObj = data;
		});
		var temp = mentorService.getObjectives($scope.mentorObj,$scope.objectives);
		temp.then(function(data){
			$scope.objectives = data;
		});
		var temp1 = mentorService.getEvalOfMenteeByMentor($scope.mentorObj,$scope.evalMenteeByMentorObj);
		temp1.then(function(data){
			$scope.evalMenteeByMentorObj = data;
		});
		var temp2 = mentorService.getEvalMentorByMentee($scope.mentorObj,$scope.evalMentorByMenteeObj);
		temp2.then(function(data){
			$scope.evalMentorByMenteeObj = data;
		});
		$scope.afterGo = true;
		$scope.updateObjReviewedShow = true;
		$scope.updateActionPlanShow = true;
		$scope.updateResultsShow = false;
		$scope.updateEvalOfMentorShow = true;
		$scope.updateEvalOfMenteeShow = false;
	};
	$scope.objUpdateBtnClickObjReviewed = function(){
		var temp = mentorUpdateService.setObjectivesObjReviewed($scope.mentorObj,$scope.objectives);
		temp.then(function(data){
			$scope.objectives = data;
		});
	};
	$scope.objUpdateBtnClickActionPlan = function(){
		var temp = mentorUpdateService.setObjectivesActionPlan($scope.mentorObj,$scope.objectives);
		temp.then(function(data){
			$scope.objectives = data;
		});
	};
	$scope.evalMenteeByMentorBtnClick = function(){
		var temp = mentorUpdateService.setEvalMenteeByMentor($scope.mentorObj,$scope.evalMenteeByMentorObj);
		temp.then(function(data){
			$scope.evalMenteeByMentorObj = data;
		});
	};
});