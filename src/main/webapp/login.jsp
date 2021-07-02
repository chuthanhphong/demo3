<%--
  Created by IntelliJ IDEA.
  User: DEII
  Date: 12/3/2020
  Time: 7:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<div class="log-reg-v3 content-md" >
    <div class="container" style="border: solid 3px cornflowerblue; background-color: rgb(182, 213, 250)" >
        <div class="row">
            <div class="col-md-5">
                <form id="sky-form1" class="log-reg-block sky-form" action="/login" method="post">
                    <h2>Log in to your account</h2>
                    <h3>${alertMsg }</h3>
                    <section>
                        <label class="input login-input">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                <input type="text" placeholder="User name" name="username"
                                       class="form-control">
                            </div>
                        </label>
                    </section>
                    <section>
                        <label class="input login-input no-border-top">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                <input type="password" placeholder="Password" name="password"
                                       class="form-control">
                            </div>
                        </label>
                    </section>
                    <button class="btn btn-primary"
                            type="submit">Log in</button>
                </form>
                <div class="margin-bottom-20"></div>
                <p class="text-center">
                    Don't have account yet? Learn more and <a
                        href="${pageContext.request.contextPath }/register" style="text-decoration: blue">Sign Up</a>
                </p>
            </div>
        </div>
        <!--/end row-->
    </div>
    <!--/end container-->
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>
