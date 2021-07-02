<%--
  Created by IntelliJ IDEA.
  User: DEII
  Date: 12/3/2020
  Time: 8:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>qwe</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<center>
    <h1>Order Detail</h1>
</center>
<div align="center">
    <caption><h2>Order Detail</h2></caption>
    <table class="table table-hover">
        <tr>
            <th>OrderID</th>
            <th>ProductID</th>
            <th>Quantity</th>
            <th>Amount</th>
        </tr>
        <c:forEach items="${orderDetailList}" var="orderDetail">
            <tr>
                <td><c:out value="${orderDetail.orderId }"/></td>
                <td><c:out value="${orderDetail.productId}"/></td>
                <td><c:out value="${orderDetail.quantityOder}"/></td>
                <td><c:out value="${orderDetail.payAmount}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

