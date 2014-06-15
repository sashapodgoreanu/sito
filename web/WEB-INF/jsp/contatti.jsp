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
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <c:import url="template/head.jsp"/>
    </head>
    <body itemscope itemtype="http://schema.org/ContactPage">
        <header itemscope itemtype="http://schema.org/WPHeader">
            <c:import url="template/menu-nav.jsp"/>
        </header>
            <article class="container-fluid">
                <div class ="row">
                    <div class="col-md-1"></div>
                    <div class="col-md-5">
                    <div class ="row">
                        <div class="col-md-12" itemscope itemtype="http://schema.org/WebPageElement">
                            <div class="page-header" >
                                <h1>Contattaci,<small> oppure compila il modulo,<br/> ti contatteremo noi.</small></h1>
                            </div>
                            <p>Contattaci per ottenere un preventivo gratuito per la ristrutturazione o per una consulenza su come ottimizzare il tuo budget.
                                Se stai pensando di acquistrare un immobile per ristrutturarlo, possiamo anche aiutarti nel valutarne le caratteristiche
                                al fine di effettuare il migliore investimento simulando le possibili soluzioni di revisione del layout.
                            </p>
                        </div>
                    </div>
                    <br/>
                    <div class="row">
                        <div class="col-md-12">
                            <p class="bg-success text-center">${success}</p>
                            <p class="bg-warning text-center">${notSuccess}</p>
                            <sf:form action="${pageContext.request.getContextPath()}/contatti/send-contact" modelAttribute="contact" class="form-horizontal" role="form" method="POST">
                                <div class="form-group" style="margin-left:0px; margin-right: 0px">
                                    <label for="nome">Nome<small class="text-muted"> (obbligatorio)</small></label>
                                    <sf:input path="nome" type="text" class="form-control" id="nome"/>
                                    <sf:errors path="nome" cssClass="error"/>
                                </div>

                                    <div class="form-group" style="margin-left:0px; margin-right: 0px">
                                        <label for="telefono" >Telefono </label>
                                        <sf:input path="telefono" type="text" class="form-control" id="telefono" />
                                        <sf:errors path="telefono" cssClass="error"/>
                                    </div>

                                    <div class="form-group" style="margin-left:0px; margin-right: 0px">
                                        <label for="email" >Email<small class="text-muted"> (obbligatorio)</small></label>
                                        <sf:input path="email" type="email" class="form-control" id="email" placeholder="user@example.com"/>
                                        <sf:errors path="email" cssClass="error"/>
                                    </div>

                                <div class="form-group" style="margin-left:0px; margin-right: 0px">
                                    <label for="messaggio">Messaggio<small class="text-muted"> (obbligatorio)</small></label>
                                    <sf:textarea path="messaggio" type="text" class="form-control" id="messaggio"/>
                                    <sf:errors path="messaggio" cssClass="error"/>
                                </div>
                                <div class="form-group" style="margin-left:0px; margin-right: 0px">
                                    <button id="accedi" type="submit" class="btn btn-default">Invia</button>
                                </div>
                            </sf:form>
                        </div>
                    </div>
                </div>
                <div class="col-md-5">
                    <div class ="row">
                        <div class="col-md-12" itemscope itemtype="http://schema.org/WebPageElement">
                            <div itemscope itemprop="mainContentOfPage" itemtype="http://schema.org/WebPageElement">
                                <address class="lead  margin-40-top" itemscope itemtype="http://schema.org/Place">
                                    <span itemprop="address" itemscope itemtype="http://schema.org/PostalAddress">
                                        <span itemprop="name"><strong>Damici Ristrutturazioni</strong><br></span>
                                        Siamo in <span itemprop="streetAddress">Cso. Belgio, 16</span>
                                        - <span itemprop="postalCode">10153</span>
                                        <span itemprop="addressLocality">Torino</span>
                                        (<span itemprop="addressRegion">TO</span>)<br>
                                        <span itemprop="telephone"><abbr title="Cellulare">Tel:</abbr> 328 586 4500</span><br>
                                        <span itemprop="email"><a href="mailto:#">damicisorin@ymail.com</a></span>
                                    </span>
                                </address>
                            </div>
                        </div>
                    </div>
                    <div class ="row">
                        <div class="col-md-12" itemscope itemtype="http://schema.org/WebPageElement">
                            <div id="map_canvas" class ="map_google" style="height: 400px; width: 600px; max-width: 100%"></div>
                        </div>
                    </div>
                </div>
            </div>
        </article>
        <c:import url="template/read-more-script.jsp"/>
    </body>
</html>
