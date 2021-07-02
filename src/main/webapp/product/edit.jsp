<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/11/2020
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body>
<center>
<div class="badge badge-primary text-wrap" style="width: 15rem; font-size: larger; text-align: center">
    PRODUCT MANAGEMENT
</div>
<br><br>

<a href="/product" class="btn btn-outline-info">Back to list</a><br><br>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<div>

    <form method="post">
        <p>Product Information</p>
        <input type="hidden" id="id" name="id" value="${requestScope["product"].getProductID()}"><br>

        <label for="productName">Product Name:</label><br>
        <input type="text" id="productName" name="productName" value="${requestScope["product"].getProductName()}"><br>

        <label for="productProvide">Provide:</label><br>
        <input type="text" id="productProvide" name="provide" value="${requestScope["product"].getProvide()}"><br><br>

        <label for="productDescription">Description:</label><br>
        <input type="text" id="productDescription" name="productDescription" value="${requestScope["product"].getProductDescription()}"><br><br>

        <label for="productPrice">Price:</label><br>
        <input type="text" id="productPrice" name="productPrice" value="${requestScope["product"].getProductPrice()}"><br><br>

        <label for="productQuantity">Quantity:</label><br>
        <input type="text" id="productQuantity" name="productQuantity" value="${requestScope["product"].getProductQuantity()}"><br><br>

        <label for="productImage">Image:</label><br>
        <input type="text" id="productImage" name="productImage" value="${requestScope["product"].getProductImage()}"><br><br>

        <select  id="categoryId" name="categoryId">
            <c:forEach var="category" items="${categoryList}">
                <option  value="${category.categoryId}">${category.categoryId}</option>
            </c:forEach>
        </select><br><br>

        <input type="submit" value="Edit">
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</center>
</body>
</html>





