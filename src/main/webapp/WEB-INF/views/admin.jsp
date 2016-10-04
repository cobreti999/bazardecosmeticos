<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Página do Administrador</h1>
            <p class="lead">Essa é a página do administrador!</p>
        </div>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>
                Bem vindo: ${pageContext.request.userPrincipal.name} |
                <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
            </h2>
        </c:if>

        <h3>
            <a href="<c:url value="/admin/productInventory"/>"> Inventário de Produtos</a>
        </h3>

        <p>Aqui você pode gerenciar todo o inventário de produtos disponíveis!</p>

        <br><br>

        <h3>
            <a href="<c:url value="/admin/customer"/>"> Gerenciamento de Clientes</a>
        </h3>

        <p>Aqui você pode gerenciar todos os clientes cadastrados!</p>

        <br><br>

        <h3>
            <a href="<c:url value="/admin/customerOrder"/>"> Gerenciamento de Pedidos</a>
        </h3>

        <p>Aqui você pode gerenciar todos os pedidos realizados pelos clientes!</p>


<%@include file="/WEB-INF/views/template/footer.jsp"%>