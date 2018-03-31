<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h2>list</h2>
<br>
<form method="post" action="/write">
    name : <input type="text" name="name"><br>
    <textarea cols="60" rows="7" name="content"></textarea><br>
    <input type="submit">
</form>
<br>
<c:forEach items="${iter}" var="g">
    name : ${g.name}<br>
    regdate : ${g.regdate}<br>
    <pre>
        ${g.content}<br>
    </pre>
    <hr><br>

</c:forEach>


</body>
</html>
