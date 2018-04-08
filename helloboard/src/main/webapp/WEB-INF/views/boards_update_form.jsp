<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 수정하는 중</title>
</head>
<body>
<h1>글 수정</h1>

<pre>
    글 수정 중입니다.
</pre>

<form action="update" method="post">
    제목 : <input name="title" type="text" > <br>
    이름 : <input name="name" type="text" > <br>
    내용 : <textarea name="content"></textarea> <br>
    암호 : <input name="password" type="password" > <br>
    <input type="submit" value="수정"> </input>
</form>

</body>
</html>
