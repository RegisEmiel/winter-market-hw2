angular.module('app', []).controller('indexController', function ($scope, $http) {
    $scope.loadProducts = function () {
        $http.get('http://localhost:8189/winter/api/v1/products').then(function (response) {
            $scope.productsList = response.data;
        });
    }

    $scope.showProductInfo = function (productId) {
        $http.get('http://localhost:8189/winter/api/v1/products/' + productId).then(function (response) {
            alert(response.data.title);
        });
    }

    $scope.deleteProductById = function (productId) {
        $http.delete('http://localhost:8189/winter/api/v1/products/' + productId).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.addToCart = function (productId) {
        $http.get('http://localhost:8189/winter/api/v1/cart/add/' + productId).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.loadCart = function () {
        $http.get('http://localhost:8189/winter/api/v1/cart').then(function (response) {
            $scope.cart = response.data;
        });
    }

    $scope.clearCart = function(){
        $http.get('http://localhost:8189/winter/api/v1/cart/clear').then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.removeFromCart = function (productId){
        $http.get('http://localhost:8189/winter/api/v1/cart/remove?productId='+ productId).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.incrementProduct = function (productId) {
        $http.get('http://localhost:8189/winter/api/v1/cart/add/' + productId).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.decrementProduct = function (productId) {
        $http.get('http://localhost:8189/winter/api/v1/cart/decrement/' + productId).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.loadProducts();
    $scope.loadCart();
});