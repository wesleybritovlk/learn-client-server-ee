<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MVC - Students</title>
</head>
<body>
<div class="wrapper">
    <div class="header"><h2>MVC - Students</h2></div>
    <div class="container">
        <button class="post-student-button button"
                onclick="window.location.href='students/post.jsp'; return false;">
            Add Student
        </button>
        <table border="1">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>E-mail</th>
                <th>Action</th>
            </tr>
            <c:forEach var="students" items="${students}">
                <c:url var="put" value="students">
                    <c:param name="command" value="get"/>
                    <c:param name="id" value="${students.id}"/>
                </c:url>
                <c:url var="delete" value="students">
                    <c:param name="command" value="delete"/>
                    <c:param name="id" value="${students.id}"/>
                </c:url>
                <tr>
                    <td>${students.firstName}</td>
                    <td>${students.lastName}</td>
                    <td>${students.email}</td>
                    <td>
                        <button class="post-student-button button"
                                onclick="window.location.href='${put}'; return false;">
                            Update
                        </button>
                        <button class="delete-student-button button"
                                onclick="if(!(confirm('Are you sure you want to delete this student?'))) return false;">
                            <a href="${delete}">Delete</a>
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>