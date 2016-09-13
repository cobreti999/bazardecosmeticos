<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Carrinho</h1>
                    <p>Todos os produtos selecionados no seu carrinho</p>
                </div>
            </div>
        </section>

        <section class="container" ng-app="cartApp">
            <!-- this cartId comes from the cartItemController (model.addAtribute) -->
            <div ng-controller = "cartCtrl" ng-init="initCartId('${cartId}')">
                <div>
                    <a class="btn btn-danger pull-left" ng-click="clearCart()">
                        <span class="glyphicon glyphicon-remove-sign"></span>Limpar Carrinho</a>
                </div>

                <table class="table table-hover">
                    <tr>
                        <th>Produto</th>
                        <th>Preço Unitário Original</th>
                        <th>Preço Unitário Com Desconto</th>
                        <th>Quantidade</th>
                        <th>Preço total Original</th>
                        <th>Preço total Com Desconto</th>
                        <th>Ação</th>
                    </tr>
                    <!-- cart. comes from the controller.js. Iterate over the cartItems inside the cart -->
                    <tr ng-repeat = "item in cart.cartItems">
                        <td>{{item.product.productName}}</td>
                        <td>{{item.product.productOriginalPrice}}</td>
                        <td>{{item.product.productDiscountedPrice}}</td>
                        <td>{{item.quantity}}</td>
                        <td>{{item.totalOriginalPrice}}</td>
                        <td>{{item.totalDiscountedPrice}}</td>
                        <!-- ng-click = action: call removeFromCart and refresh the cart from the js controller-->
                        <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
                            <span class="glyphicon glyphicon-remove"></span>remove</a></td>
                    </tr>
                    <tr>
                        <th></th>
                        <th></th>
                        <th>Preço Final Original</th>
                        <th>{{cart.grandTotalOriginalPrice}}</th>
                        <th>Preço Final Com Desconto</th>
                        <th>{{cart.grandTotalDiscountedPrice}}</th>
                        <th></th>
                    </tr>
                </table>
                <a href="<spring:url value="/productList"/>" class="btn btn-default">Continuar Comprando</a>
            </div>
        </section>
    </div>
</div>

<script src="<c:url value="/resources/js/controller.js"/>"></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>
