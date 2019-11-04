<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: psolski
  Date: 29.10.2019
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
</head>
<body>

<h2> Category</h2>
<form:form method="post" modelAttribute="category">
    <label>Name:
        <form:input path="name"></form:input>
        <form:errors path="name" element="div" cssStyle="color:red"></form:errors>
    </label><br><br>
    <label>Description:
        <form:input path="description"></form:input>
        <form:errors path="description" element="div" cssStyle="color:red"></form:errors>
    </label><br><br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
