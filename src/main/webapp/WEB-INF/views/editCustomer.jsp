<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Editar usuário</h1>
            <p class="lead">Edite os valores desejados:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/customer/editCustomer"
                   method="post" commandName="customer"> <!-- customer is sent to AdminCustomerController-->

        <!-- This form is necessary in order for CustomerId to be != null-->
        <form:hidden path="customerId" value="${customer.customerId}" />

        <h3>Informações básicas</h3>

        <div class="form-group">
            <label for="name">Nome Completo</label><form:errors path="customerName" cssStyle="color:#ff0000" />
            <form:input path="customerName" id="name" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="email">Email</label><span style="color: #ff0000;">  ${emailMsg} </span><form:errors
                path="customerEmail" cssStyle="color: #ff0000;"/>
            <form:input path="customerEmail" id="email" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="phone">Telefone</label>
            <form:input path="customerPhone" id="phone" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="username">Nome de usuário</label><span style="color: #ff0000;">  ${usernameMsg}
        </span><form:errors path="username" cssStyle="color: #ff0000;"/>
            <form:input path="username" id="username" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="password">senha</label><form:errors
                path="password" cssStyle="color: #ff0000;"/>
            <form:password path="password" id="password" class="form-Control"/>
        </div>

        <br>


        <h3>Endereço de Cobrança</h3>

        <div class="form-group">
            <label for="billingStreet">Endereço</label>
            <form:input path="billingAddress.streetName" id="billingStreet" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingApartmentNumber">Número do Apartamento</label>
            <form:input path="billingAddress.apartmentNumber" id="billingApartmentNumber" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingCity">Cidade</label>
            <form:input path="billingAddress.city" id="billingCity" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingState">Estado</label>
            <form:input path="billingAddress.state" id="billingState" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingCountry">País</label>
            <form:input path="billingAddress.country" id="billingCountry" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="billingZip">CEP</label>
            <form:input path="billingAddress.zipCode" id="billingZip" class="form-Control"/>
        </div>
        <br>

        <h3>Endereço de Entrega</h3>

        <div class="form-group">
            <label for="shippingStreet">Endereço</label>
            <form:input path="shippingAddress.streetName" id="shippingStreet" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingApartmentNumber">Número do Apartamento</label>
            <form:input path="shippingAddress.apartmentNumber" id="shippingApartmentNumber" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingCity">Cidade</label>
            <form:input path="shippingAddress.city" id="shippingCity" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingState">Estado</label>
            <form:input path="shippingAddress.state" id="shippingState" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingCountry">País</label>
            <form:input path="shippingAddress.country" id="shippingCountry" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="shippingZip">CEP</label>
            <form:input path="shippingAddress.zipCode" id="shippingZip" class="form-Control"/>
        </div>

        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/admin/customer" />" class="btn btn-default">Cancelar</a>
        </form:form>


<%@include file="/WEB-INF/views/template/footer.jsp"%>