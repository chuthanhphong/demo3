<%--
  Created by IntelliJ IDEA.
  User: DEII
  Date: 12/3/2020
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<body>
<center>
<div class="badge badge-primary text-wrap" style="width: 15rem; font-size: larger; text-align: center">
    Cart
</div>
<%
    int customerID = (int) session.getAttribute("customerID");
%>
<h2>
    <a href="/customer" class="btn btn-outline-info">Back</a>
</h2>
<table class="table table-hover">
    <thead>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Provide</td>
        <td>Description</td>
        <td>Price</td>
        <td>Quantity</td>
        <td>Image</td>
        <td>Category ID</td>
        <td>Xoa khoi gio hang</td>

    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items='${requestScope["list"]}' var="product">
    <tr>
        <td>${product.productID}</td>
        <td>${product.productName}</td>
        <td>${product.provide}</td>
        <td>${product.productDescription}</td>
        <td>${product.productPrice}</td>
        <td>${product.productQuantity}</td>
        <td>${product.productImage}</td>
        <td>${product.categoryId}</td>
        <td>
            <form action="/customer" method="post">
                <input type="hidden" name="customerID" value="<%=customerID%>">
                <input type="hidden" name="action" value="xoa">
                <input type="hidden" name="productID" value="${product.productID}">
                <button type="submit">Xoa</button>
            </form>
        </td>

    </tr>
    </c:forEach>
    </tr>
    </tbody>
</table>
<h1><laber>TOTAL : </laber><c:out value='${requestScope["total"]}' /></h1>
<form method="post" action="/customer">
    <input type="hidden" name="tongtien" value='${requestScope["total"]}'>
    <input type="hidden" name="customerID" value="<%=customerID%>">
    <input name="action" value="buy" type="hidden">
    <button type="submit" class="btn btn-success">MUA HANG</button>
</form>



<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</center>
</body>
</html>
