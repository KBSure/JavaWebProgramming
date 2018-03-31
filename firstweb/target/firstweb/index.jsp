<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h2>Hello World!</h2>
<c:if test="${name != null}">
    <h3>${name}</h3>
</c:if>

<c:forEach items="${iter}" var="item">
    ${item}<br>
</c:forEach>

<c:choose>
    <c:when test="${myNumber < 500}">
        TRUE
    </c:when>
    <c:when test="${myNumber >= 500}">
        FALSE
    </c:when>
</c:choose>

<c:if test="${myNumber < 500}">
    TRUE
</c:if>
<c:if test="${myNumber >= 500}">
    FALSE
</c:if>
</body>
</html>
