<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<jsp:useBean id="now" class="java.util.Date"/>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Pedido</h1>
            <p class="lead">Confirmação do seu pedido</p>
        </div>

        <div class="container">

            <div class="row">

                <form:form commandName="order" class="form-horizontal"> <!-- order comes from the model/checkout-flow-->

                    <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">

                        <div class="text-center">
                            <h1>Resumo da Compra</h1>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <strong>Endereço de Entrega</strong><br>
                                    ${order.cart.customer.shippingAddress.streetName}
                                    <br>
                                    ${order.cart.customer.shippingAddress.apartmentNumber}
                                    <br>
                                    ${order.cart.customer.shippingAddress.city}, ${order.cart.customer.shippingAddress.state}
                                    <br>
                                    ${order.cart.customer.shippingAddress.country}, CEP: ${order.cart.customer.shippingAddress.zipCode}
                                    <br>
                                </address>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                                <p>
                                    <em>Data de Envio: <fmt:formatDate type="date" value="${now}"/></em>
                                </p>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <strong>Endereço de Cobrança</strong> <br>
                                        ${order.cart.customer.billingAddress.streetName}
                                    <br>
                                        ${order.cart.customer.billingAddress.apartmentNumber}
                                    <br>
                                        ${order.cart.customer.billingAddress.city},${order.cart.customer.billingAddress.state}
                                    <br>
                                        ${order.cart.customer.billingAddress.country},${order.cart.customer.billingAddress.zipCode}
                                </address>
                            </div>
                        </div>

                        <div class="row">

                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>Produto</th>
                                    <th>Quantidade</th>
                                    <th class="text-center">Preço Unitário</th>
                                    <th class="text-center">Total</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="cartItem" items="${order.cart.cartItems}">
                                    <tr>
                                        <td class="col-md-9"><em>${cartItem.product.productName}</em></td>
                                        <td class="col-md-1" style="text-align: center">
                                                ${cartItem.quantity}</td>
                                        <td class="col-md-1 text-center">$${cartItem.product.productDiscountedPrice}</td>
                                        <td class="col-md-1 text-center">$${cartItem.totalDiscountedPrice}</td>
                                    </tr>
                                </c:forEach>

                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td class="text-right"><h4>
                                        <strong>Total: </strong>
                                    </h4></td>
                                    <td class="text-center text-danger"><h4>
                                        <strong>$${order.cart.grandTotalDiscounted}</strong>
                                    </h4></td>
                                </tr>
                                </tbody>
                            </table>

                            <button id="back" class="btn btn-default"
                                    name="_eventId_backToCollectShippingDetail">Voltar
                            </button>

                            <button type="submit" class="btn btn-success"
                                    name="_eventId_orderConfirmed">
                                Confirmar Pedido! <span class="glyphicon glyphicon-chevron-right"></span>
                            </button>

                            <button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Cancelar</button>

                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>
