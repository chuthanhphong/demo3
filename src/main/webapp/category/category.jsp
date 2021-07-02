<%--
  Created by IntelliJ IDEA.
  User: DEII
  Date: 12/3/2020
  Time: 8:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Category Management Application</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body>
<center>
    <h1>Category Management</h1>
    <h2>
        <a href="/admin.jsp">Return </a>
    </h2>
    <h2>
        <a href="/category?action=create">Add Category</a>
    </h2>
</center>
<div align="center">
    <table class="table table-hover">
        <caption><h2>List of Category</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="category" items="${categoryList}">
            <tr>
                <td><c:out value="${category.categoryId}"/></td>
                <td><c:out value="${category.categoryName}"/></td>
                <td><c:out value="${category.categoryDescription}"/></td>
                <td>
                    <a href="/category?action=edit&id=${category.categoryId}">Edit</a>
                    <a href="/category?action=delete&id=${category.categoryId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>
