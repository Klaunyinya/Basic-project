var basic_app = angular.module('basic_app', [
	//'registrationCtrl',
    //'loginCtrl',
	'angular-md5',
	'services'
]);
/*
basic_app.config(function () {

});
*/
basic_app.run(function ($rootScope, md5, userServices) {
	$rootScope.loggedUser = {};
	$rootScope.newUser = {};
	$rootScope.user = {};
	$rootScope.users = [];
	$rootScope.isLoggedIn = false;
	$rootScope.showLoginForm = false;
	$rootScope.showRegForm = false;
		
	$rootScope.loginForm = function() {
		$rootScope.showLoginForm = !$rootScope.showLoginForm;
	};
	
	$rootScope.regForm = function() {
		$rootScope.showRegForm = !$rootScope.showRegForm;
	};
	
	$rootScope.login = function() {
			$rootScope.user.password = md5.createHash($rootScope.user.password || '');
			userServices.getUser($rootScope.user).success(function(result) {
				if(result) {
					$rootScope.loggedUser.id = result.id;
					$rootScope.loggedUser.username = result.userName;
					$rootScope.isLoggedIn = true;
					userServices.getAllUsers().success(function(userList) {
						$rootScope.users = userList;
					});
					//alert("Sikeres bejelentkezés!");
				} else {
					alert("Hiba történt bejelentkezés közben!");
				}
			});
		};
		
		$rootScope.logout = function() {
			$rootScope.loggedUser = null;
			$rootScope.newUser = {};
			$rootScope.user = {};
			$rootScope.users = [];
			$rootScope.isLoggedIn = false;
		};
			
	
	$rootScope.registration = function() {
		$rootScope.newUser.password = md5.createHash($rootScope.newUser.password || '');
		userServices.saveUser($rootScope.newUser).success(function(status_message){
			if(status_message == "OK"){
                    alert("A regisztrációd mentettük.");
                } else {
					alert("Hiba történt regisztráció közben!");	
				}
		});
	};
});