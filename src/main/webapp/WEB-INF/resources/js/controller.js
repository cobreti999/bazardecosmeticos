/** Created by Lailson Nogueira in 09/13/2016 **/

var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function($scope, $http){
    //gets the cart in the json format (ResponseBody in the read method from CartController)
    //The data from the json cart will be stored in the 'data' variable
    //Finally the scope variable cart will get the data from the cart
    $scope.refreshCart = function (cartId) {
        $http.get('/bazardecosmeticos/rest/cart/' + $scope.cartId).success(function (data) {
            $scope.cart = data; //$scope.cart será a abstração a ser usada pela view
        });
    };

    $scope.clearCart = function () {
        $http.delete('/bazardecosmeticos/rest/cart/' + $scope.cartId).success($scope.refreshCart($scope.cartId));
    };
    
    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };
    
    $scope.addToCart = function (productId) {
        alert("teste url: /bazardecosmeticos/rest/cart/add/"+productId);
        $http.put('/bazardecosmeticos/rest/cart/add/'+productId).success(function (data) {
            $scope.refreshCart($http.get('/bazardecosmeticos/rest/cart/cartId'));
            alert("Produto adicionado ao carrinho com sucesso!");
        });
    };
    
    $scope.removeFromCart = function (productId) {
        $http.put('/bazardecosmeticos/rest/cart/remove/' + productId).success(function (data) {
            $scope.refreshCart($http.get('/bazardecosmeticos/rest/cart/cartId'));
        });
    };
    
});