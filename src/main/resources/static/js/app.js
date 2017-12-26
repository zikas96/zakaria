var app=angular.module("MyApp",['ui.router']);

app.config(function($stateProvider,$urlRouterProvider) {
	$stateProvider.state('home',{
		url:'/home',
		templateUrl: "views/home.html",
		controller: 'HomeController'
	});
	$stateProvider.state('chercher',{
		url:'/chercher',
		templateUrl: "views/chercher.html",
		controller: 'MyController'
	});
	$stateProvider.state('newProduit',{
		url:'/newProduit',
		templateUrl: "views/NewProduit.html",
		controller: 'NewProduitController'
	});
});

app.controller('HomeController' , function() {
	
});

app.controller('NewProduitController', function($scope,$http) {
	$scope.produit={};
	$scope.mode=0;
	$scope.saveProduit=function(){
		$http.post("http://localhost:8080/produits",$scope.produit)
		.then(function(response){
			$scope.produit=response.data;
			$scope.mode=1;
			})
			.catch(function(response){
				console.log(response.err);
			});
	}
	$scope.modeForm=function(){
		$scope.produit={designation:"",prix:0.0, quantite:0};
		$scope.mode=0;
	}
	
});


app.controller("MyController",function($scope,$http){
	$scope.pageProduits=null;
	$scope.motCle="";
	$scope.pageCourante=0;
	$scope.size=4;
	$scope.pages=[];

	$scope.chercherProduits=function(){
		$http.get("http://localhost:8080/chercherProduits?mc="+$scope.motCle+"&page="+$scope.pageCourante+"&size="+$scope.size)
		.then(function(response){
		$scope.pageProduits=response.data;
		$scope.pages=new Array(response.data.totalPages)
			
		})
		.catch(function(response){
			console.log(response.err);
		});
	}
	$scope.getProduits=function(){
		$scope.pageCourante=0;
		$scope.chercherProduits();
	}
	$scope.gotoPage=function(p){
		$scope.pageCourante=p;
		$scope.chercherProduits();
		
	}

});