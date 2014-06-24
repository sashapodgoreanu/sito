<%-- 
    Document   : index
    Created on : 22-feb-2014, 12.40.14
    Author     : Sasha Alexandru Podgoreanu
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="it">
    <head>
        <c:import url="template/head.jsp"/>
        <script>
            $(document).ready(function() {
                $(".underconstruction").trigger('click');
            });
        </script>
    </head>
    <body>
        <header class="applybackground_grey">
            <c:import url="template/menu-nav.jsp"/>
            <!-- Fotorama SlideShow: Add images to <div class="fotorama"></div>. -->
            <div class ="container-fluid">
                <div class="row">
                    <div class="col-md-1">
                    </div>
                    <div class="col-md-10">
                        <div class="fotorama"
                             data-fit="cover"
                             data-nav="false"
                             data-autoplay="true"
                             data-loop="true"
                             data-width="100%"
                             data-height="60%"               
                             data-direction="ltr">   <!-- Photos article text direction -->
                            <img src="${pageContext.request.getContextPath()}/immagini/fotorama/cada.jpg"/>
                            <img src="${pageContext.request.getContextPath()}/immagini/test/2w.jpg" />
                            <img src="${pageContext.request.getContextPath()}/immagini/test/2w.jpg" />
                        </div>
                    </div>
                    <div class="col-md-1">
                    </div>
                </div>
            </div>
        </header>
        <article class="container-fluid">
            <div class="row applybackground_grey">
                <div class="col-md-2">
                </div>
                <div class="col-md-8">
                    <h3 class="text-center lead">
                        Serve un'impresa edile? 
                        <span class="glyphicon glyphicon-home"></span> 
                        Devi ristrutturare?
                        <span class="glyphicon glyphicon-hand-right"></span>
                        Fai un Preventivo Online <br>
                        Ottieni un PREVENTIVO GRATUITO entro 48 ore!
                    </h3>
                </div>
                <div class="col-md-2">  
                </div>
            </div>
            <div class="row applybackground_grey">
                <div class="col-md-1"></div>
                <!-- Panelli Notizia-->
                <div class="col-md-8">
                    <c:forEach items="${notizia}" var = "notizia">
                        <div class="row">
                            <div class="col-md-12">
                                <article class="panel panel-default margin-20-top">
                                    <!--Titolo-->
                                    <section class="panel-heading"><h3>${notizia.nome}</h3></section>
                                    <!--Immagini-->
                                    <div class="panel-body">
                                        <div class="fotorama"
                                             data-nav="thumbs"
                                             data-maxheight="300"
                                             data-allowfullscreen="true">
                                            <c:forEach items="${notizia.immagini}" var="i">
                                                <img src="${pageContext.request.getContextPath()}/immagini/<c:out value="${i.nome}"/>">
                                                <%-- <img src="${pageContext.request.getContextPath()}/images/<c:out value="${i.nome}"/>"> --%>
                                            </c:forEach>
                                        </div>
                                    </div>
                                    <!--Articolo-->
                                    <section class="panel-body leggitutto">
                                        ${notizia.testo}
                                    </section>
                                </article>
                            </div>
                        </div>
                    </c:forEach>
                </div><!-- fine Panelli Notizia-->

                <!-- Panelli laterali destra-->
                <div class="col-md-3">
                    <div class="panel panel-default margin-20-top">
                        <div class="panel-heading">Le notizie più popolari</div>
                        <div class="panel-body">
                            Panel content
                        </div>
                    </div>
                    <div class="panel panel-default margin-20-top">
                        <div class="panel-heading">Post in evidenza</div>
                        <div class="panel-body">
                            Panel content
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 applybackground">
                    Level 1: .col-md-9
                    <div class="row">
                        <div class="col-md-6">
                            Level 2: .col-md-6
                        </div>
                        <div class="col-md-6">
                            Level 2: .col-md-6
                        </div>
                    </div>
                </div>
            </div>
            <!-- Small modal -->
            <button class="btn btn-primary underconstruction" data-toggle="modal" data-target=".bs-example-modal-sm"></button>

            <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <p class = "lead text-center margin-20-top">Il Sito è In Costruzione</p>
                    </div>
                </div>
            </div>
        </article>
        <c:import url="template/read-more-script.jsp"/>
        <footer>
            <c:import url="template/footbar.jsp"/>
        </footer>
    </body>
</html>