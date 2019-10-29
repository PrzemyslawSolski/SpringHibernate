<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: psolski
  Date: 29.10.2019
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        function confirmDelete(id, name) {
            if (confirm("Do you want to delete a category '" + name + "'?")) {
                window.location.href = "/categories/delete/" + id;
            }
        }
    </script>
    <title>Categories</title>
</head>
<body>

<h2>Categories' list</h2>
<table border="2">
    <tbody>
    <tr>
        <th width="20">id</th>
        <th width="150">Name</th>
        <th width="150">Description</th>
        <th  width="150"colspan="2"> Action</th>
    </tr>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td align="center"><a href="/categories/edit/${category.id}">Edit</a></td>
            <td align="center"><a href="#" onclick="confirmDelete(${category.id}, '${category.name}')">Delete </a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
