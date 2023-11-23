<%--
  Created by IntelliJ IDEA.
  User: Judit
  Date: 2023. 11. 17.
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Hallgatóink</title>
    <style>
        table th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        tr:nth-child(odd){
            background-color: beige;
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>


<c:if test="${empty hallgatok}">
    <h1>Nincs hallgatónk</h1>
</c:if>
<c:if test="${!empty hallgatok}">
    <h1>Hallgatóink:</h1>
<br>

    <table>
        <tr>
            <th>Azonosító</th>
            <th>Név</th>
            <th>Neptun kód</th>
            <th></th>
        </tr>
        <c:forEach items="${hallgatok}" var="hallgato">
            <tr onclick="window.location='${pageContext.servletContext.contextPath}/hallgato/${hallgato.id}';">
                <td>
                    ${hallgato.id}
                </td>
                <td>${hallgato.teljesNev}</td>
                <td>${hallgato.neptunKod}</td>
                <td><i class="fa fa-car"></i> </td>
            </tr>
        </c:forEach>
    </table>


</c:if>
</body>
</html>
