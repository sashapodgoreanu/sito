<%-- 
    Document   : endpoints
    Created on : 8-giu-2014, 1.52.21
    Author     : SashaAlexandru
--%>
<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Endpoint list</title>
    </head>


    <body>
        <table>
            <thead>
                <tr>
                    <th>path</th>
                    <th>methods</th>
                    <th>consumes</th>
                    <th>produces</th>
                    <th>params</th>
                    <th>headers</th>
                    <th>custom</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${endPoints}" var="endPoint">
                    <tr>
                        <td>${endPoint.patternsCondition}</td>
                        <td>${endPoint.methodsCondition}</td>
                        <td>${endPoint.consumesCondition}</td>
                        <td>${endPoint.producesCondition}</td>
                        <td>${endPoint.paramsCondition}</td>
                        <td>${endPoint.headersCondition}</td>
                        <td>${empty endPoint.customCondition ? "none" : endPoint.customCondition}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>