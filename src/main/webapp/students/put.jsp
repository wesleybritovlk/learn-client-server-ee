<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MVC - Update Student</title>
</head>
<body>
<div class="wrapper">
    <div class="header"><h2>MVC - Update Student</h2></div>
    <div class="container">
        <form action="students" method="get">
            <input type="hidden" name="command" value="put"/>
            <input type="hidden" name="id" value="${student.id}"/>
            <table>
                <tr>
                    <td><label>First name:  </label></td>
                    <td><input type="text" name="firstName" value="${student.firstName}"/></td>
                </tr>
                <tr>
                    <td><label>Last name: </label></td>
                    <td><input type="text" name="lastName" value="${student.lastName}"/></td>
                </tr>
                <tr>
                    <td><label>E-mail: </label></td>
                    <td><input type="text" name="email" value="${student.email}"/></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="save" name="save"/></td>
                </tr>
            </table>
        </form>
        <div style="clear: both;"></div>
        <p><a href="students">Back to list</a></p>
    </div>
</div>
</body>
</html>