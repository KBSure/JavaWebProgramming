<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/boards/write"
      enctype="multipart/form-data">
     title : <input type="text" name="title"><br>
     <input type="file" name="file"><br>
    <input type="submit">
</form>

</body>
</html>
