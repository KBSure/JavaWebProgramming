<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read</title>
</head>
<body>
<h1>게시물</h1>

제목 : c언어 잘하는 법
작성자 : c언어고수
<pre>
    안녕하세요
    제가 쓴 글이고, 내용입니다.
</pre>


<form action="/boards/updateform" method="get">
    <input type="submit" value="수정">
</form>
<form action="/boards/deleteform" method="get">
    <input type="submit" value="삭제">
</form>

</body>
</html>
