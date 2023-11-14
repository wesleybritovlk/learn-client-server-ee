<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Utilizando o JSTL - Condicionais</title>
</head>
<body>
<h1>JSTL - Condicionais</h1>
<h2>Condicional IF</h2>
<c:set var="salary" scope="session" value="${2000*2}"/>
O salário é: <c:out value="${salary}"/>
<c:if test="${salary >= 2000}">
    <p><c:out value="${'Salário maior ou igual a 2000'}"/></p>
</c:if>
<c:if test="${salary < 2000}">
    <p><c:out value="${'Salário menor do que 2000'}"/></p>
</c:if>
<h2>Condicional When</h2>
<c:choose>
    <c:when test="${salary <= 0}">
        Salário muito baixo para sobreviver.
    </c:when>
    <c:when test="${salary > 1000}">
        Salário está bom.
    </c:when>
    <c:otherwise>
        Qualquer outra condição que não foi atendida anteriormente.
    </c:otherwise>
</c:choose>
</body>
</html>