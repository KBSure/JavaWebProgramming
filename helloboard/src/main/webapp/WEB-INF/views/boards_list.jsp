<%--
  Created by IntelliJ IDEA.
  User: story
  Date: 2018-04-05
  Time: 오후 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1> list</h1>

1 <a href="/boards/1"> c언어 잘하는 법 </a> &nbsp;&nbsp; c언어고수 &nbsp;&nbsp; 2018-04-04 <br>
2 <a href="/boards/2?page=2&searchType=title&searchStr=java"> java 잘하는 법</a> &nbsp;&nbsp; java고수 &nbsp;&nbsp; 2018-04-05 <br>
3 <a href="/boards/3"> python 잘하는 법</a> &nbsp;&nbsp; python고수 &nbsp;&nbsp; 2018-04-06 <br>

<a href="/boards/?page=1">1</a> <a href="/boards/?page=2">2</a> <a href="/boards/?page=3">3</a><br>

검색 구현


<form action="/boards/writeform" method="get">

    <input type="submit" value="글쓰기"></input>
</form>


</body>
</html>
