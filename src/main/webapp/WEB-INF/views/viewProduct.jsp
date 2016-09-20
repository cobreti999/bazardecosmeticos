<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<security:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin" />

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Detalhes do Produto</h1>
            <p class="lead">Aqui estão informações detalhadas sobre o produto.</p>
        </div>

        <div class="container" ng-app="cartApp">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image"
                         style="width:100%"/>
                </div>
                <div class="col-md-5">
                    <h3>${product.productName}</h3>
                    <p>${product.productDescription}</p>
                    <p><strong>Marca</strong> : ${product.productBrand}</p>
                    <p><strong>Tipo</strong> : ${product.productType}</p>
                    <p><strong>Preço original</strong> : ${product.productOriginalPrice} Reais</p>
                    <p><strong>Desconto</strong> : ${product.productDiscount} Reais</p>
                    <h4><strong>Preço final</strong> : ${product.productDiscountedPrice} Reais</h4>

                    <br>

                    <c:set var="url" scope="page" value="/product/productList" />
                    <c:if test="${isAdmin}">
                        <c:set var="url" scope="page" value="/admin/productInventory" />
                    </c:if>

                    <!-- If the user clicks the button back, he goes back to /productList but if the user
                    is the admin, he goes back to the /productInventory-->
                    <p ng-controller="cartCtrl">
                        <a href="<c:url value="${url}" />" class="btn btn-default">Voltar</a>
                        <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')">
                            <span class="glyphicon glyphicon-shopping-cart"></span>Adicionar ao Carrinho!</a>
                        <a href="<spring:url value="/customer/cart" />" class="btn btn-default">
                            <span class="glyphicon glyphicon-hand-right"></span>Ver Carrinho</a>
                    </p>

                </div>
            </div>
        </div>
<script src="<c:url value="/resources/js/controller.js"/>"></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>