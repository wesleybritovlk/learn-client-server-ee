<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Utilizando o JSTL - SQL</title>
</head>
<body>
<h1>JSTL - SQL</h1>
<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/utilizando_jstl?useSSL=false"
                   user="" password=""/>
<sql:query var="result" dataSource="${snapshot}">select id, nome, email from agenda;</sql:query>
<table border="1" width="100%">
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>E-mail</th>
    </tr>
    <c:forEach var="rows" items="${result.rows}">
        <tr>
            <td><c:out value="${rows.id}"/></td>
            <td><c:out value="${rows.nome}"/></td>
            <td><c:out value="${rows.email}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
