<%--
  Created by IntelliJ IDEA.
  User: DEII
  Date: 12/3/2020
  Time: 8:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body>
<a href="/admin.jsp" class="btn btn-outline-info">Back to ADMIN</a><br><br>
<div align="center">
    <caption><h2>List of Order</h2></caption>
    <table class="table table-hover">
        <tr>
            <th>orderID</th>
            <th>customerID</th>
            <th>orderDATE</th>
        </tr>
        <c:forEach items="${orders}" var="order" >
            <tr>
                <td>
                    <a href="/orderdetail?id=${order.orderID}">
                        <c:out value="${order.orderID}"/>
                    </a>
                </td>
                <td><c:out value="${order.customerID}"/></td>
                <td><c:out value="${order.orderDate}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>