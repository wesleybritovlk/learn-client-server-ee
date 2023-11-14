<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Utilizando o JSTL - Formatador</title>
</head>
<body>
<h1>JSTL - Formatador</h1>
<h2>Formatando Datas</h2>
<c:set var="now" value="<%=new Date()%>"/>
<c:out value="${now}"/>
<p>Formatando Hora:
    <fmt:formatDate type="time" value="${now}"/></p>
<p>Formatando Data:
    <fmt:formatDate type="date" value="${now}"/></p>
<p>Formatando Data e Hora:
    <fmt:formatDate type="both" value="${now}"/></p>
<p>Formatando Data para Dia, Mês, Ano:
    <fmt:formatDate pattern="dd-MM-yyyy" value="${now}"/></p>
<h2>Formatando Moedas/Numeros</h2>
<c:set var="balance" value="120000.2309"/>
<c:set var="porc" value="10"/>
<p>Modea local:
    <fmt:formatNumber type="currency" value="${balance}"/></p>
<p>Porcentagem:
    <fmt:formatNumber type="percent" groupingUsed="true" value="${porc}"/></p>
<p>Formatada com notação exponencial:
    <fmt:formatNumber type="number" pattern="###.###E0" value="${balance}"/></p>
<p>Moeda local americana:
    <fmt:setLocale value="en_US"/>
    <fmt:formatNumber type="currency" value="${balance}"/></p>
</body>
</html>
