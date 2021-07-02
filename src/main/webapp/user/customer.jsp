<%--
  Created by IntelliJ IDEA.
  User: DEII
  Date: 12/3/2020
  Time: 8:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/admin.jsp" class="btn btn-outline-info">Return </a>
    </h2>
</center>
<div align="center">
    <caption><h2>List of Users</h2></caption>
    <table class="table table-hover">
        <tr>
            <th>UserCode</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>User Name</th>
            <th>Password</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td><c:out value="${user.customerId }"/></td>
                <td><c:out value="${user.customerName}"/></td>
                <td><c:out value="${user.customerPhone}"/></td>
                <td><c:out value="${user.customerEmail}"/></td>
                <td><c:out value="${user.customerAddress}"/></td>
                <td><c:out value="${user.userName}"/></td>
                <td><c:out value="${user.password}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
