<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h2>Hello World!</h2>
<c:if test="${name != null}">
    <h3>${name}</h3>
</c:if>
<c:if test="${myNumber < 500}">
    <h3>True</h3>
</c:if>
<c:if test="${myNumber >=500}">
    <h3>False</h3>
</c:if>
</body>
</html>
