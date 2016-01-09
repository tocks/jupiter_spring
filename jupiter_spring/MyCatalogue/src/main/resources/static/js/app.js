var app=angular.module("MyCat", []);
app.controller("CatController", function($scope, $http) {
	$scope.produits = [];
	$scope.motCle=null;
	$scope.pageCourante=0;
	$scope.charcher=function(){
		$http.get("/produitsParMC?mc="+$scope.motCle+"&page="+$scope.pageCourante)
		.success(function(data) {
			$scope.produits = data;
			$scope.pages =  new Array(data.totalPages);
		});
	};
	
	$scope.gotoPage=function(p){
		$scope.pageCourante = p;
		$scope.charcher();
	};
	
});