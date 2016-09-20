<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<body>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1 class="alert alert-success"> Pedido realizado com sucesso!!</h1>
                    <p>Recebemos seu pedido e ele será enviado em 2 dias úteis.</p>
                </div>
            </div>
        </section>

        <section>
            <div class="container">
                <p>
                    <a href="<spring:url value="/" />" class="btn btn-primary">
                        Voltar para página inicial
                    </a>
                </p>
            </div>

        </section>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
