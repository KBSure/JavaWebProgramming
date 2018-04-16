<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginform</title>
</head>
<body>
<h1>로그인 폼</h1>
<form method="post" action="/users/login">
    id : <input type="text" name="id"><br>
    password : <input type="password" name="passwd"><br>
    <input type="hidden" name="referer" value="${referer}">
    <input type="submit">
</form>
</body>
</html>
