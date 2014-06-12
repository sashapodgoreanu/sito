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
        <style>
            //GOOGLE INC: MAPS
            
        </style>
    </head>
    <body itemscope itemtype="http://schema.org/ContactPage">
        <header itemscope itemtype="http://schema.org/WPHeader">
            <c:import url="template/menu-nav.jsp"/>
        </header>
        <article>
            <div class ="row">
                <div class="col-md-1"></div>
                <div class="col-md-10" itemscope itemtype="http://schema.org/WebPageElement">
                    <div class="page-header" >
                        <h1>Contattaci,<small> oppure compila il modulo, ti contatteremo noi.</small></h1>
                    </div>
                    <p>Contattaci per ottenere un preventivo gratuito per la ristrutturazione o per una consulenza su come ottimizzare il tuo budget.
                        Se stai pensando di acquistrare un immobile per ristrutturarlo, possiamo anche aiutarti nel valutarne le caratteristiche
                        al fine di effettuare il migliore investimento simulando le possibili soluzioni di revisione del layout.
                    </p>
                    <div itemscope itemprop="mainContentOfPage" itemtype="http://schema.org/WebPageElement">

                        <address itemscope itemtype="http://schema.org/Place">
                            <span itemprop="address" itemscope itemtype="http://schema.org/PostalAddress">
                                <span itemprop="name"><strong>Damici Ristrutturazioni</strong><br></span>
                                Siamo in <span itemprop="streetAddress">Cso. Belgio, 16</span>
                                - <span itemprop="postalCode">10153</span>
                                <span itemprop="addressLocality">Torino</span>
                                (<span itemprop="addressRegion">TO</span>)<br>

                                <span itemprop="telephone"><abbr title="Cellulare">Tel:</abbr> 328 586 4500</span>
                                <span itemprop="email"><a href="mailto:#">damicisorin@ymail.com</a></span>

                            </span>
                        </address>
                    </div>

                </div>
                <div class="col-md-1">
                </div>
            </div>
            <div id="map_canvas" class ="map_google"></div>
        </article>
        <c:import url="template/read-more-script.jsp"/>
    </body>
</html>
