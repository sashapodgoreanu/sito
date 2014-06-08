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
        <article class="container-fluid">
            <div class ="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <c:choose>
                        <c:when test = "${webAdminSession.nome != null || webAdminSession.valid == true}">   
                            <c:choose>
                                <c:when test = "${notizia != null}">
                                    <c:choose>
                                        <c:when test = "${success == true}">
                                            <div class="alert alert-success margin-20-top">
                                                <p>Articolo aggiunto con successo!</p>
                                            </div>
                                            <article class="panel panel-default margin-20-top">
                                                <section class="panel-heading"><h3>${notizia.nome}</h3></section>
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
                                                <section class="panel-body leggitutto">
                                                    ${notizia.testo}
                                                </section>
                                            </article>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="alert alert-info margin-20-top">
                                                <p>Ups, è stato un errore, riprova!</p>
                                            </div>

                                        </c:otherwise>
                                    </c:choose>
                                </c:when>
                                <c:otherwise>
                                    <c:redirect url="/aggiungi-notizia"></c:redirect>
                                </c:otherwise>
                            </c:choose>
                        </c:when>
                        <c:otherwise>
                            <c:redirect url="/login"></c:redirect>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="col-md-3">
                </div>
            </div>
        </article>
        <c:import url="template/read-more-script.jsp"/>
    </body>
</html>
