<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Lista de Pedidos</h1>
            <p class="lead">Essa é a lista de pedidos realizados pelos clientes!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Nome do Cliente</th>
                <th>Endereço do Cliente</th>
                <th>Endereço de Entrega</th>
                <th>Itens</th>
                <th>Preço</th>
                <th>Ação</th>
            </tr>
            </thead>
            <c:forEach items="${customerOrderList}" var="customerOrder">
                <tr>
                    <td>${customerOrder.customer.customerName}</td>
                    <td>${customerOrder.billingAddress.streetName}</td>
                    <td>${customerOrder.shippingAddress.streetName}</td>
                    <c:forEach items="${customerOrder.}" var="items">
                        <td>${items.product.productName}</td>
                    </c:forEach>
                    <td>${customerOrder.cart.grandTotalDiscounted}</td>
                    <td><a href="<spring:url value="/admin/customerOrder/deleteCustomerOrder/${customerOrder.customerOrderId}"/>">
                        <span class="glyphicon glyphicon-remove"></span></a>
                        <a href="<spring:url value="/admin/customerOrder/editCustomerOrder/${customerOrder.customerOrderId}"/>">
                            <span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

<%@include file="/WEB-INF/views/template/footer.jsp"%>