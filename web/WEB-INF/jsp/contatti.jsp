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
                <div class="col-md-1"></div>
                <div class="col-md-10"> 

                    <div class="page-header">
                        <h1>Chi siamo:<small> Damici Ristrutturazioni</small></h1>
                    </div>
                    <p><strong>Damici Ristrutturazioni,</strong> team dinamico con una profonda esperienza professionale nel campo della progettazione e realizzazione di interventi di ristruDamici Ristrutturazionitturazione. Inoltre, realizziamo qualsiasi tipo di intervento che necessita un’impresa edile.<br/> 
                        La nostra attenzione non si limita all’aspetto estetico ma anche funzionale ed ergonomico.<br/><br/>

                        Il team è formato dalla impresa edile <strong>Damici Iosif Sorin e l’architetto Fabio Lanzoni.</strong><br/>
                    <strong>Damici Iosif Sorin</strong> si occupa della direzione e della realizzazione dei lavori dei progetti, con il continuo monitoraggio del cantiere per assicurare la fedele esecuzione di quanto progettato 
                        fornendovi ristrutturazioni chiavi in mano.<br/><br/>

                        <strong>L’arch. Fabio Lanzoni</strong> si occupa della progettazione, dagli aspetti più squisitamente architettonicialla scelta degli elementi d’arredo, fino al design dei componenti più ricercati.<br/><br/>

                        L’unione di queste due professionalità ha dato vita ad una Team in grado di fornire un servizio chiavi in mano, dalla progettazione alla realizzazione.
                    </p>
                    <p><a class="btn btn-primary btn-lg" role="button">Contattaci</a></p>
                </div>
            </div>
            <div class="col-md-1">
            </div>
        </div>
    </article>
    <c:import url="template/read-more-script.jsp"/>
</body>
</html>
