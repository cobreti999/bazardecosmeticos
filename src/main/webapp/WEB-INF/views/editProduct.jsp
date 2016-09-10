<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Editar produto</h1>
            <p class="lead">Preencha os campos abaixo para editar os dados do produto.</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/productInventory/editProduct"
                   method="post" commandName="product" enctype="multipart/form-data"> <!-- product comes from the model-->
            <!-- This form is necessary in order for productId to be != null-->
            <form:hidden path="productId" value="${product.productId}" />
        <!-- Label and TextField -->
        <div class="form-group">
            <label for="name">Nome do Produto</label> <form:errors path="productName" cssStyle="color: #ff0000;" />
            <form:input path="productName" id="name" class="form-Control" />
            <!-- after submit, this field will bind to productName. form-Control controls the width -->
        </div>

        <!-- Label and TextField -->
        <div class="form-group">
            <label for="type">Tipo/Categoria</label>
            <form:input path="productType" id="type" class="form-Control" />
        </div>

        <!-- Label and TextField -->
        <div class="form-group">
            <label for="description">Descrição</label>
            <form:textarea path="productDescription" id="description" class="form-Control" />
        </div>

        <!-- Label and TextField -->
        <div class="form-group">
            <label for="originalPrice">Preço Original</label> <form:errors path="productOriginalPrice" cssStyle="color: #ff0000;" />
            <form:input path="productOriginalPrice" id="originalPrice" class="form-Control" />
        </div>

        <!-- Label and TextField -->
        <div class="form-group">
            <label for="discountedPrice">Preço com Desconto</label> <form:errors path="productDiscountedPrice" cssStyle="color: #ff0000;" />
            <form:input path="productDiscountedPrice" id="discountedPrice" class="form-Control" />
        </div>

        <!-- RadioButtons -->
        <div class="form-group">
            <label for="status">Status</label>
            <label class="checkbox-inline">
                <form:radiobutton path="productStatus" id="status" value="active"/>Disponível
            </label>
            <label class="checkbox-inline">
                <form:radiobutton path="productStatus" id="status" value="inactive"/>Não Disponível
            </label>
        </div>

        <!-- Label and TextField -->
        <div class="form-group">
            <label for="unitInStock">Unidades em Estoque</label> <form:errors path="unitInStock" cssStyle="color: #ff0000;" />
            <form:input path="unitInStock" id="unitInStock" class="form-Control" />
        </div>

        <!-- Label and TextField -->
        <div class="form-group">
            <label for="brand">Marca</label>
            <form:input path="productBrand" id="brand" class="form-Control" />
        </div>

        <!-- File upload-->
        <div class="form-group">
            <label class="control-label" for="productImage">Enviar Imagem</label>
            <form:input path="productImage" id="productImage" type="file" class="form:input-large"/>
        </div>

        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/admin/productInventory"/>" class="btn btn-default">Cancelar</a>

        </form:form>


<%@include file="/WEB-INF/views/template/footer.jsp"%>