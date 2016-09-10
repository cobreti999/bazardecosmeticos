<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Inventário de Produtos</h1>
            <p class="lead">Esta é a página com o inventário de produtos do nosso site!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Imagem</th>
                <th>Nome do Produto</th>
                <th>Tipo</th>
                <th>Marca</th>
                <th>Preço Original</th>
                <th>Desconto</th>
                <th>Preço com Desconto</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image"
                        style="width:100%"/></td>
                    <td>${product.productName}</td>
                    <td>${product.productType}</td>
                    <td>${product.productBrand}</td>
                    <td>${product.productOriginalPrice} Reais</td>
                    <td>${product.productDiscount} %</td>
                    <td>${product.productDiscountedPrice} Reais</td>
                    <td><a href="<spring:url value="/productList/viewProduct/${product.productId}"/>">
                        <span class="glyphicon glyphicon-info-sign"></span></a>
                        <a href="<spring:url value="/admin/productInventory/deleteProduct/${product.productId}"/>">
                            <span class="glyphicon glyphicon-remove"></span></a>
                        <a href="<spring:url value="/admin/productInventory/editProduct/${product.productId}"/>">
                            <span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/admin/productInventory/addProduct"/>" class="btn btn-primary">Adicionar Produto</a>

<%@include file="/WEB-INF/views/template/footer.jsp"%>