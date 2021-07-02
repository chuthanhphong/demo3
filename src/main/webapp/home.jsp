<%--
  Created by IntelliJ IDEA.
  User: DEII
  Date: 12/2/2020
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body>
<%--<center>--%>
<%--    <h1>Home Page</h1>--%>
<%--    <h2>--%>
<%--        <a href="/login">Login</a>--%>
<%--        <a href="/register">Register</a>--%>
<%--    </h2>--%>

<%--</center>--%>
<%--&lt;%&ndash;private int productID;&ndash;%&gt;--%>
<%--&lt;%&ndash;private String productName;&ndash;%&gt;--%>
<%--&lt;%&ndash;private String provide;&ndash;%&gt;--%>
<%--&lt;%&ndash;private String productDescription;&ndash;%&gt;--%>
<%--&lt;%&ndash;private double productPrice;&ndash;%&gt;--%>
<%--&lt;%&ndash;private int productQuantity;&ndash;%&gt;--%>
<%--&lt;%&ndash;private String productImage;&ndash;%&gt;--%>
<%--&lt;%&ndash;private int categoryId;&ndash;%&gt;--%>
<%--<div align="center">--%>
<%--    <table border="1" cellpadding="5">--%>
<%--        <caption><h2>Products</h2></caption>--%>
<%--        <tr>--%>
<%--            <th>productID</th>--%>
<%--            <th>productName</th>--%>
<%--            <th>Provider</th>--%>
<%--            <th>Price</th>--%>
<%--            <th>Quantity</th>--%>
<%--            <th>Action</th>--%>
<%--        </tr>--%>
<%--        <c:forEach var="product" items="${products}">--%>
<%--            <tr>--%>
<%--                <td><c:out value="${product.productID}"/></td>--%>
<%--                <td><c:out value="${product.productName}"/></td>--%>
<%--                <td><c:out value="${product.provide}"/></td>--%>
<%--                <td><c:out value="${product.productPrice}"/></td>--%>
<%--                <td><c:out value="${product.productQuantity}"/></td>--%>
<%--                <td><a href=""></a></td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>


<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <div class="container">
        <a class="navbar-brand" href="/home"><img src="https://img.icons8.com/pastel-glyph/2x/shop.png" width="70" height="70" ></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div>
            <p2>VUI LÒNG ĐĂNG NHẬP ĐỂ MUA HÀNG</p2>
        </div>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/home">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login">Log In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/register">Register</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid" style="padding-top: 100px">
    <div id="carouselExampleFade" class="carousel slide carousel-fade" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://i1.wp.com/alireal.vn/wp-content/uploads/2020/03/khuyen-mai-cellphones-ma-giam-gia-cellphones-alireal.png?resize=800%2C300&ssl=1" sizes="100%" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="https://cellphones.com.vn/sforum/wp-content/uploads/2020/11/black-friday-cover-1-1.jpg" sizes="100%" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="https://cdn.cellphones.com.vn/media/ltsoft/promotion/IPHONE_XR_Sliding-1.png" sizes="100%" class="d-block w-100" alt="...">
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleFade" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleFade" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

<!-- Page Content -->
<section class="py-5">
    <div class="container">
        <h1 class="font-weight-light">BEST BUY</h1>
        <p class="lead"><a href="/home">Go to top</a>!</p>
    </div>
</section>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>
