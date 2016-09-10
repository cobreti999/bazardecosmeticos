<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Detalhes do Produto</h1>
            <p class="lead">Aqui estão informações detalhadas sobre o produto.</p>
        </div>

        <div class="container">
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

                </div>
            </div>
        </div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>