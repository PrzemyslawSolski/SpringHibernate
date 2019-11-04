<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: psolski
  Date: 29.10.2019
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>.error{color : red;font-size: smaller;font-family: Arial, Helvetica, sans-serif}</style>
    <title>Article</title>
</head>
<body>

<form:form method="post" modelAttribute="article">
    <label>Title:
        <form:input path="title"></form:input>
        <form:errors path="title" element="div" class="error"></form:errors>
    </label><br><br>
    <form:hidden path="created"></form:hidden>
    <label>Content:
        <form:textarea rows="4" cols="50" path="content"></form:textarea>
        <form:errors path="content" element="div" class="error"></form:errors>
    </label><br><br>
    <label>
        <form:select path="author.id" items="${authors}"
                     itemValue="id" itemLabel="fullName"/>
        <form:errors path="author" element="div" class="error"></form:errors>
    </label><br><br>
    <label>Categories:
        <form:select path="categories" items="${categories}"
                     itemValue="id" itemLabel="name">
            <form:option value="-" label="--Please Select--"/>
            <form:options items="${categories.id}"/>
        </form:select>
        <form:errors path="categories" element="div" class="error"></form:errors>
    </label><br>

    <input type="submit" value="Save">
</form:form>


</body>
</html>
