<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 삭제 확인 중</title>
</head>
<body>
<h1>글 삭제 확인</h1>

<pre>
    글 삭제 여부를 묻고 있습니다.
    암호를 입력하세요.
</pre>

<form action="delete" method="post">
    암호 : <input name="password" type="password" > <br>
    <input type="submit" value="확인"> </input>
</form>

</body>
</html>
