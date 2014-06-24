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
    </head>
    <body>
        <header class="applybackground_grey">
            <c:import url="template/menu-nav.jsp"/>
        </header>
        <article class="container-fluid">
            <div class="row applybackground_grey">
                <div class="col-md-1"></div>
                <!-- Panelli Notizia-->
                <div class="col-md-8">
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
                </div><!-- fine Panelli Notizia-->
        </article>
        <footer>
            <c:import url="template/footbar.jsp"/>
        </footer>
    </body>
</html>