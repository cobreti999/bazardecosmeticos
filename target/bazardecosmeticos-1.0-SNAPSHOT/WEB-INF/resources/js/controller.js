/** Created by Lailson Nogueira in 09/13/2016 **/

var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function($scope, $http){
    //gets the cart in the json format (ResponseBody in the getCartById method from CartResourcesController)
    //The data from the json cart will be stored in the 'data' variable
    //Finally the scope variable cart will get the data from the cart
    $scope.refreshCart = function () {
        $http.get('/rest/cart/' + $scope.cartId).success(function (data) {
            $scope.cart = data; //$scope.cart será a abstração a ser usada pela view
        });
    };

    $scope.clearCart = function () {
        $http.delete('/rest/cart/' + $scope.cartId).success($scope.refreshCart());
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function (productId) {
        $http.put('/rest/cart/add/'+productId).success(function () {
            alert("Produto adicionado ao carrinho com sucesso!");
        });
    };

    $scope.removeFromCart = function (productId) {
        $http.put('/rest/cart/remove/' + productId).success(function (data) {
            $scope.refreshCart();
        });
    };

    $scope.calcGrandTotalOriginalPrice = function() {
        var grandTotal=0;

        for (var i=0; i<$scope.cart.cartItems.length; i++) {
            grandTotal+=$scope.cart.cartItems[i].totalOriginalPrice;
        }

        return grandTotal;
    };

    $scope.calcGrandTotalDiscountedPrice = function() {
        var grandTotal=0;

        for (var i=0; i<$scope.cart.cartItems.length; i++) {
            grandTotal+=$scope.cart.cartItems[i].totalDiscountedPrice;
        }

        return grandTotal;
    };
    
});