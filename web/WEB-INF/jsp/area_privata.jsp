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
        <script>
            $(document).ready(
                    function() {
                        //add more file components if Add is clicked
                        $('#addImmagine').click(
                                function() {
                                    var fileIndex = $('#fileTable tr').children().length;
                                    $('#fileTable').append(
                                            '<tr><td>'
                                            + '   <input class="form-control" id = "imageUpload" type="file" name="files[' + fileIndex + ']" accept="image/*"/>'
                                            + '</td></tr>');
                                });
                    });
        </script>
    </head>
    <body>
        <header>
            <c:import url="template/menu-nav.jsp"/>
        </header>
        <article class="container-fluid">
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
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                </div>
            </div>
        </article>
    </body>

</html>
