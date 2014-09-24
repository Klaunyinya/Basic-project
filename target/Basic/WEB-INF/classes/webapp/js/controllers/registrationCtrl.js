/*var registrationCtrl = angular.module('registrationCtrl', []);

registrationCtrl.controller('registrationCtrl', ['$scope', '$http', 'userServices', 'md5',
function($scope, $http, userServices, md5) {
	$scope.newUser = {};
	
	$scope.registration = function() {
		$scope.newUser.password = md5.createHash($scope.newUser.password || '');
		userServices.saveUser($scope.newUser).success(function(status_message){
			if(status_message == "OK"){
                    alert("A regisztrációd mentettük.");
                } else {
					alert("Hiba történt regisztráció közben!");	
				}
		});
	};
}]);*/