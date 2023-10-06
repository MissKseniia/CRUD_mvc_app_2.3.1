<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>New User</title>
</head>
<body>
<h2>Create new User</h2><br>
<!--Вопрос ментору: Почему не срабатывают ошибки при некорректном вводе данных?-->
<form:form modelAttribute="user" action="/users/save">
    <form:hidden path="id"/>
    <h3>Name: </h3>
    <form:input path="firstname" placeholder="Kira"/>
    <form:errors path="firstname"/><br>
    <h3>Surname: </h3>
    <form:input path="lastname" placeholder="Loshkina"/>
    <form:errors path="lastname"/><br>
    <h3>Age: </h3>
    <form:input path="age" placeholder="20"/>
    <form:errors path="age"/><br><br>
    <input type="submit" value="Create or Update"/>
</form:form>

</body>
</html>