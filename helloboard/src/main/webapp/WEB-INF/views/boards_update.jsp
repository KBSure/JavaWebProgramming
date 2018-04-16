<%--
  Created by IntelliJ IDEA.
  User: urstory
  Date: 2018. 4. 12.
  Time: AM 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update form</title>
</head>
<body>
<form method="post" action="update">
    name : <input type="text" name="name"><br>
    <input type="hidden" name="_method" value="put">
    <input type="submit">
</form>

</body>
</html>
