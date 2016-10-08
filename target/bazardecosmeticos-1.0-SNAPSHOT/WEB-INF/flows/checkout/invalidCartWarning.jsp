<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<body>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1 class="alert alert-danger"> Carrinho Inválido!!</h1>
                </div>
            </div>
        </section>

        <section>
            <div class="container">
                <p>
                    <a href="<spring:url value="/product/productList/all" />" class="btn btn-primary">
                        Produtos</a>
                </p>
            </div>

        </section>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
