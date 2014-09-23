/*var loginCtrl = angular.module('loginCtrl', []);

loginCtrl.controller('loginCtrl', ['$scope', '$http', 'userServices', '$rootScope', 'md5',
	function($rootScope, $scope, $http, userServices, md5) {
		$scope.user = {};
		
		$scope.login = function() {
			$scope.user.password = md5.createHash($scope.user.password || '');
			console.log("?");
			userServices.getUser($scope.user).success(function(result) {
				if(result) {
					$rootScope.loggedUser.id = result.id;
					$rootScope.loggedUser.username = result.userName;
					$rootScope.isLoggedIn = true;
					//$scope.user = {};
					alert("Sikeres bejelentkezés!");
				} else {
					alert("Hiba történt bejelentkezés közben!");
				}
			});
		};
		
		$scope.logout = function() {
			$rootScope.loggedUser = null;
			$rootScope.isLoggedIn = false;
		};
			
}]);*/