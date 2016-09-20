<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<body>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1 class="alert alert-danger"> Checkout cancelado</h1>
                    <p>Sua compra foi cancelada. Você pode continuar comprando.</p>
                </div>
            </div>
        </section>

        <section>
            <div class="container">
                <p>
                    <a href="<spring:url value="/product/productList" />" class="btn btn-default">
                        Produtos
                    </a>
                </p>
            </div>

        </section>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
