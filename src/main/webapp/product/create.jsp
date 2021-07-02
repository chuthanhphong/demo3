<%--
  Created by IntelliJ IDEA.
  User: DEII
  Date: 12/3/2020
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create new product</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<center>
<h1>Create new product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/product">back to product list</a>
</p>
<form method="post" >
    <fieldset>
        <legend>product info</legend>
        <table class="card text-white bg-dark mb-3">
            <label for="productName">Product Name:</label><br>
            <input type="text" id="productName" name="productName" ><br>
            <label for="provide">Provide:</label><br>
            <input type="text" id="provide" name="provide" ><br><br>
            <label for="productDescription">Description:</label><br>
            <input type="text" id="productDescription" name="productDescription" ><br><br>
            <label for="productPrice">Price:</label><br>
            <input type="text" id="productPrice" name="productPrice" ><br><br>
            <label for="productQuantity">Quantity:</label><br>
            <input type="text" id="productQuantity" name="productQuantity" ><br><br>
            <label for="productImage">Image:</label><br>
            <input type="text" id="productImage" name="productImage" ><br><br>
            <label for="categoryId">Category Id:</label><br>

            <select  id="categoryId" name="categoryId">
                <c:forEach var="category" items="${categoryList}">
                    <option  value="${category.categoryId}">${category.categoryId}</option>
                </c:forEach>
            </select><br><br>

            <input type="submit" value="Create product">
        </table>
    </fieldset>
</form>
</center>
</body>
</html>
</body>
</html>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

