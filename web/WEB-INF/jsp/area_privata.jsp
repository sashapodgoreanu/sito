<%-- 
    Document   : aggiungi_notizia
    Created on : 30-apr-2014, 0.09.04
    Author     : Sasha Alexandru Podgoreanu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="template/head.jsp"/>
    </head>
    <body>
        <header>
            <c:import url="template/menu-nav.jsp"/>
        </header>
        <article class="container-fluid applybackground_grey">
            <div class ="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <div class="panel panel-success" style="margin-top:100px">
                        <div class="panel-heading">Aggiungi Articolo</div>
                        <div class="panel-body">
                            <ul class="list-group">
                                <li class="list-group-item"><a href="${pageContext.request.getContextPath()}/create-tables/">Reset/Crea Tabele</a></li>
                                <li class="list-group-item">Dapibus ac facilisis in</li>
                                <li class="list-group-item">Morbi leo risus</li>
                                <li class="list-group-item">Porta ac consectetur ac</li>
                                <li class="list-group-item">Vestibulum at eros</li>
                            </ul>
                                <form:form action="${pageContext.request.getContextPath()}/login/logout/">
                                    <div class="row">
                                        <p  class="col-sm-8 control-label">Sei logato come ${webAdminSession.nome}. Vuoi uscire?</p>
                                        <div class=" col-sm-4">
                                            <button id="esci" type="submit" class="btn btn-default">Esci</button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                    <div class="col-md-3">
                    </div>
                </div>
            </div>
            <div class="row">
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
                                    <div class="panel-footer">
                                        <ul class="list-group">
                                            <li class="list-group-item">Id notizia: ${notizia.id}</li>
                                            <li class="list-group-item">Si trova in: ${notizia.tipo}</li>
                                            <li class="list-group-item">Data caricamento: ${notizia.dataCaricamento}</li>
                                            <li class="list-group-item">Priorita: ${notizia.priorita}</li>
                                            <li class="list-group-item">Numero visualizzazioni: ${notizia.numVis} (feature non abilitata)</li>
                                        </ul>
                                    </div>
                                </article>
                            </div>
                        </div>
                    </c:forEach>
                </div><!-- fine Panelli Notizia-->
            </div>
        </article>
    </body>
</html>
