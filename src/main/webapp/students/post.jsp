<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>MVC - Add Student</title>
</head>
<body>
<div class="wrapper">
    <div class="header"><h2>MVC - Add Student</h2></div>
    <div class="container">
        <form action="../students" method="get">
            <input type="hidden" name="command" value="post"/>
            <table>
                <tr>
                    <td><label>First name: </label></td>
                    <td><input type="text" name="firstName"/></td>
                </tr>
                <tr>
                    <td><label>Last name: </label></td>
                    <td><input type="text" name="lastName"/></td>
                </tr>
                <tr>
                    <td><label>E-mail: </label></td>
                    <td><input type="text" name="email"/></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="save" name="save"/></td>
                </tr>
            </table>
        </form>
        <div style="clear: both;"></div>
        <p><a href="../students">Back to list</a></p>
    </div>
</div>
</body>
</html>