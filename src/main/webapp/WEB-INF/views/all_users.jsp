<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>
<h2>Users</h2><br>
<table border="0.5" bgcolor="#b8860b">
    <tr>
        <th> Name</th>
        <th> Surname</th>
        <th> Age</th>
        <th> Operations</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <c:url var="updateButton" value="users/update">
            <c:param name="userId" value="${user.id}"/>
        </c:url>
        <c:url var="removeButton" value="users/remove">
            <c:param name="userId" value="${user.id}"/>
        </c:url>
        <tr>
            <td> ${user.firstname} </td>
            <td> ${user.lastname} </td>
            <td> ${user.age} </td>
            <td>
                <input type="button" value="Update" onclick="window.location.href = '${updateButton}'"/>
                <form>
                    <input type="button" value="Remove" onclick="window.location.href = '${removeButton}'"/>
                </form>

            </td>
        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Create new User" onclick="window.location.href = '/users/new'"/>
<input type="button" value="Exit" onclick="window.location.href = '/'"/>
</body>
</html>