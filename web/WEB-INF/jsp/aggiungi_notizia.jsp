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
                            <c:choose>
                                <c:when test = "${webAdminSession.valid == true}">   
                                    <form:form role="form" action="${pageContext.request.getContextPath()}/aggiungi-notizia/upload"  modelAttribute="uploadNotizia" method="post" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <table id="fileTable">
                                                <tr>
                                                    <td><label for="imageUpload">Upload</label>
                                                        <input id = "imageUpload" class="form-control" type="file" name="files[0]" accept="image/*"></td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="form-group">
                                            <button id="addImmagine" type="button" class="btn btn-default">Aggiungi un'altra immagine</button>
                                        </div>
                                        <div class="form-group">
                                            <label for="titoloNotizia">Tipo Articolo</label>
                                            <select class="form-control" required="true" name="tipo">
                                                <c:forEach items="${tipo}" var="i">
                                                    <option><c:out value="${i}"/></option>
                                                </c:forEach>  
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <label for="titoloNotizia">Titolo</label>
                                            <input id = "titoloNotizia" class="form-control" type="text" name="nome" required="true" pattern=".{5,128}" required title="da 5 a 128 caratteri">
                                        </div>

                                        <div class="form-group">
                                            <label for="corpoNotizia">Articolo</label>
                                            <textarea id = "corpoNotizia" class="form-control" rows="6" name="articolo" required="true" pattern=".{20,20000}" required title="da 20 a 20000 caratteri"></textarea>
                                        </div> 
                                        <button type="submit" class="btn btn-default">Submit</button>
                                    </form:form>
                                </c:when>
                                <c:otherwise>
                                    <c:redirect url="/login"></c:redirect>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                </div>
            </div>
        </article>
    </body>

</html>
