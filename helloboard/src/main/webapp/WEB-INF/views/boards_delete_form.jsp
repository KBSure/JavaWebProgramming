<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글쓰는 중</title>
</head>
<body>
<h1>글 작성</h1>

<pre>
    글 작성 중입니다.
</pre>

<form action="write" method="post">
    제목 : <input name="title" type="text" > <br>
    내용 : <textarea name="content"></textarea> <br>
    암호 : <input name="password" type="password" > <br>
    <input type="submit" value="등록"> </input>
</form>

</body>
</html>
