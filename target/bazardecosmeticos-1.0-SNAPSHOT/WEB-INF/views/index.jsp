<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img class="first-slide home-image" src="<c:url value="/resources/images/carousel1.png"/>" alt="First slide">
                <div class="container">
                    <div class="carousel-caption">
                        <h1>Bem vinda ao Bazar de Cosméticos</h1>
                        <p>Aqui você encontra o preço mais baixo em cosméticos!</p>
                    </div>
                </div>
            </div>
            <div class="item">
                <img class="second-slide home-image" src="<c:url value="/resources/images/carousel2.png"/>" alt="Second slide">
                <div class="container">
                    <div class="carousel-caption">
                        <h1>Qualidade acima de tudo</h1>
                        <p>Trabalhamos com os melhores produtos do mercado.</p>
                    </div>
                </div>
            </div>
            <div class="item">
                <img class="third-slide home-image" src="<c:url value="/resources/images/carousel3.png"/>" alt="Third slide">
                <div class="container">
                    <div class="carousel-caption">
                        <h1>Escolha sua consultora favorita</h1>
                        <p>Nossas consultoras possuem os produtos com o preço mais baixo do mercado!</p>
                    </div>
                </div>
            </div>
        </div>
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div><!-- /.carousel -->


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">

        <!-- Three columns of text below the carousel -->
        <div class="row">
            <div class="col-lg-4">
                <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=Batom" />"
                   role="button">
                    <img class="img-circle"
                         src="<c:url value="/resources/images/batom.jpg" />"
                         alt="Generic placeholder image" width="140" height="140"></a>


                <h2>Batons</h2>

                <p>Lindos batons com as mais variadas cores.</p>

                <%--<p><a class="btn btn-default" href="<c:url value="/search/instrument" />" role="button">View details &raquo;</a></p>--%>

            </div>
            <!-- /.col-lg-4 -->
            <div class="col-lg-4">
                <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=Base" />"
                   role="button">
                    <img class="img-circle"
                         src="<c:url value="/resources/images/base.jpg" />"
                         alt="Generic placeholder image" width="140" height="140"></a>

                <h2>Bases</h2>

                <p>Encontre uma coleção diversa de bases e maquiagens.</p>

                <%--<p><a class="btn btn-default" href="<c:url value="/search/record" />" role="button">View details &raquo;</a></p>--%>
            </div>
            <!-- /.col-lg-4 -->
            <div class="col-lg-4">
                <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=Perfume" />"
                   role="button">
                    <img class="img-circle"
                         src="<c:url value="/resources/images/perfume.jpg" />"
                         alt="Generic placeholder image" width="140" height="140"></a>

                <h2>Perfumes</h2>

                <p>Grandes fragrâncias disponíveis a um preço abaixo do mercado.</p>

                <%--<p><a class="btn btn-default" href="<c:url value="/search/accessory" />" role="button">View details &raquo;</a></p>--%>
            </div>

        </div><!-- /.row -->

        <%@include file="/WEB-INF/views/template/footer.jsp"%>
