
<%--
  Created by IntelliJ IDEA.
  User: Judit
  Date: 2023. 11. 17.
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Hallgató felvitele</title>
  <meta charset="UTF-8">
</head>
<body>
<h2>Hallgató adatai:</h2>
<form:form method="post" action="ujhallgato" modelAttribute="hallgato">
<fieldset>
    <legend>Azonosítók</legend>
    <form:label path="id" for="azonosito">Azonosító</form:label>
    <form:input path="id" type="text" id="azonosito"/>
    <form:errors path="id"></form:errors>
    <h6 style="color: red">${message}</h6>


<br>
    <form:label path="neptunKod">Neptun Kód</form:label>
    <form:input path="neptunKod" type="text"/>
    <form:errors path="neptunKod"></form:errors>

</fieldset>
    <fieldset>
        <legend>Alap adatok</legend>
        <form:label path="teljesNev">Teljes név</form:label>
        <form:input path="teljesNev" type="text"/>
        <form:errors path="teljesNev"></form:errors>
<br>
        <form:label path="email">Email</form:label>
        <form:input path="email" type="text"/>
        <form:errors path="email"></form:errors>
<br>
        <form:label path="szuletesiDatum">Születési dátum</form:label>
        <form:input path="szuletesiDatum" type="date"/>
        <form:errors path="szuletesiDatum"></form:errors>
<br>
        <form:label path="Nem" for="nem">Nem</form:label>
        <form:select path="nem">
            <form:options/>
        </form:select>
<br>

    </fieldset>
        <input type="submit" value="Hozzáadás">


</form:form>

</body>
</html>
