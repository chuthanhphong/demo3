<%--
  Created by IntelliJ IDEA.
  User: DEII
  Date: 12/3/2020
  Time: 8:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <style type="text/css">
        .page-holder {
            background: url(https://cutewallpaper.org/21/tech-background-hd/1920x1080-Hd-Tech-Background-Phonebookofgrenoble.xyz.jpg);
        }
    </style>
</head>
<body>
<p style="font-weight: bolder; font-size: larger; text-decoration: royalblue; text-align: center">ADMIN MANAGEMENT</p>
<br><br>
<center><a href="/home" class="btn btn-outline-info">Back to Home</a></center>
<br><br>


<%--<h1>--%>
<%--    <a href="/category">Quản lý category</a>--%>
<%--</h1>--%>
<%--<h1>--%>
<%--    <a href="/product">Quản lý product</a>--%>
<%--</h1>--%>
<%--<h1>--%>
<%--    <a href="/order">Quản lý order</a>--%>
<%--</h1>--%>
<%--<h1>--%>
<%--    <a href="/customer">Quản lý customer</a>--%>
<%--</h1>--%>
<div class="container" style="background: darkgray; size: 500px">
<table class="table table-hover table-dark">
    <thead>
    <tr>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row" class="bg-primary">Category Management</th>
        <td class="bg-primary"><a href="/category" class="btn btn-light" role="button">Access</a></td>
    </tr>
    <tr>
        <th scope="row">Product Management</th>
        <td><a href="/product" class="btn btn-primary" role="button">Access</a></td>
    </tr>
    <tr>
        <th scope="row" class="bg-primary">Order Management</th>
        <td class="bg-primary"><a href="/order" class="btn btn-light" role="button">Access</a></td>

    </tr>
    <tr>
        <th scope="row">Customer Management</th>
        <td><a href="/user" class="btn btn-primary" role="button">Access</a></td>

    </tr>
    </tbody>
</table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>
