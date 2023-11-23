<%--
  Created by IntelliJ IDEA.
  User: Judit
  Date: 2023. 11. 17.
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
<tr>
  <th>Azonosító</th>
  <th>Név</th>
  <th>Neptun kód</th>
  <th>Email</th>
  <th>Születési dátum</th>
  <th>Nem</th>
</tr>
<tr>
<td>${hallgato.id}</td>
  <td>${hallgato.teljesNev}</td>
  <td>${hallgato.neptunKod}</td>
  <td>${hallgato.email}</td>
  <td>${hallgato.szuletesiDatum}</td>
  <td>${hallgato.nem}</td>
</tr>
</table>

</body>
</html>
