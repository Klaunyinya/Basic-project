var services = angular.module('services', ['ngResource']);

services.factory('userServices', function($http) {
	var user = {};
	
	user.getAllUsers = function() {
		return $http({
			url : 'api/getAllUserRequest',
			method : "GET",
			contentType : "application/json"
		});
	};
	
	user.getUser = function(user) {
		return $http({
			url : 'api/loginRequest',
			data : {
				"userName" : user.username,
				"password" : user.password
			},
			method : "POST",
			contentType : "application/json"
		});
	};
	
	user.saveUser = function(user) {
		return $http({
			url : 'api/registrationRequest',
			data : {
				"userName" : user.username,
                "fullName" : user.fullname,
				"password" : user.password,
				"email" : user.email,
            },
			method : "POST",
			contentType : "application/json"
		});
	};
	return user;
});