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
        function confirmDelete(id, title) {
            if (confirm("Do you want to delete an article '" + title + "'?")) {
                window.location.href = "/articles/delete/" + id;
            }
        }
    </script>
    <title>Articles</title>
</head>
<body>

<h2>Articles' list</h2>
<table border="2">
    <tbody>
    <tr>
        <th width="20">id</th>
        <th width="120">Title</th>
        <th width="200">Content</th>
        <th width="50">Created</th>
        <th width="50">Updated</th>
        <th  width="150"colspan="2"> Action</th>
    </tr>
    <c:forEach items="${articles}" var="article">
        <tr>
            <td>${article.id}</td>
            <td>${article.title}</td>
            <td>${article.content}</td>
            <td>${article.created}</td>
            <td>${article.updated}</td>
            <td align="center"><a href="/articles/edit/${article.id}">Edit</a></td>
            <td align="center"><a href="#" onclick="confirmDelete(${article.id}, '${article.title}')">Delete </a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
