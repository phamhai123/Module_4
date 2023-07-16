<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/12/2023
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="listStore" action="" method="post">
    language <br>
    <form:select path="language">
        <c:forEach items="${language}" varStatus="language">
            <form:option value="${language}">${language}</form:option>
        </c:forEach>
    </form:select>
    size <br>
    <form:select path="size">
        <c:forEach items="${size}" varStatus="size">
            <form:option value="${size}">${size}</form:option>
        </c:forEach>
    </form:select>
    filter <br>
    <form:checkboxes value="true" path="filter"/>
    signature <br>
    <form:input path="signature"/><br>
    <button>Save</button>
</form:form>
</body>
</html>
