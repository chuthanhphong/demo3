<%--
  Created by IntelliJ IDEA.
  User: DEII
  Date: 12/3/2020
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body>
<div class="col-md-5">
    <form id="sky-form4" class="log-reg-block sky-form"
          action="register" method="post">
        <h2>Create New Account</h2>
<%--        <p>--%>
<%--            <c:if test='${requestScope["message"] != null}'>--%>
<%--                <span class="message">${requestScope["message"]}</span>--%>
<%--            </c:if>--%>
<%--        </p>--%>
<%--        <div class="login-input reg-input">--%>
<%--            <section>--%>
<%--                <label class="input"> <input type="text"--%>
<%--                                             name="name" placeholder="Your name"--%>
<%--                                             class="form-control">--%>
<%--                </label>--%>
<%--            </section>--%>
<%--            <section>--%>
<%--                <label class="input"> <input type="number"--%>
<%--                                             name="phone" placeholder="Your phone"--%>
<%--                                             class="form-control">--%>
<%--                </label>--%>
<%--            </section>--%>
<%--            <section>--%>
<%--                <label class="input"> <input type="email"--%>
<%--                                             name="email" placeholder="Email address"--%>
<%--                                             class="form-control">--%>
<%--                </label>--%>
<%--            </section>--%>
<%--            <section>--%>
<%--                <label class="input"> <input type="text"--%>
<%--                                             name="address" placeholder="Your address"--%>
<%--                                             class="form-control">--%>
<%--                </label>--%>
<%--            </section>--%>
<%--            <section>--%>
<%--                <label class="input"> <input type="text"--%>
<%--                                             name="username" placeholder="User name"--%>
<%--                                             class="form-control">--%>
<%--                </label>--%>
<%--            </section>--%>
<%--            <section>--%>
<%--                <label class="input"> <input type="password"--%>
<%--                                             name="password" placeholder="Confirm password"--%>
<%--                                             class="form-control">--%>
<%--                </label>--%>
<%--            </section>--%>
<%--        </div>--%>
<%--        <button class="btn-u btn-u-sea-shop btn-block margin-bottom-20"--%>
<%--                type="submit">Create Account</button>--%>
<%--    </form>--%>
<%--    <div class="margin-bottom-20"></div>--%>
<%--    <p class="text-center">--%>
<%--        Already you have an account? <a--%>
<%--            href="${pageContext.request.contextPath }/login">Sign In</a>--%>
<%--    </p>--%>
<%--</div>--%>
<%--</div>--%>
<%--<!--/end row-->--%>
<%--</div>--%>
<%--<!--/end container-->--%>
<%--</div>--%>
<%--<!--=== End Registre ===-->--%>




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
                        <label class="form-control"> <input type="text"
                                                     name="name" placeholder="Your name"
                                                     class="form-control">
                        </label>
                    </section>
                    <section>
                        <label class="form-control"> <input type="number"
                                                     name="phone" placeholder="Your phone"
                                                     class="form-control">
                        </label>
                    </section>
                    <section>
                        <label class="form-control"> <input type="email"
                                                     name="email" placeholder="Email address"
                                                     class="form-control">
                        </label>
                    </section>
                    <section>
                        <label class="form-control"> <input type="text"
                                                     name="address" placeholder="Your address"
                                                     class="form-control">
                        </label>
                    </section>
                    <section>
                        <label class="form-control"> <input type="text"
                                                     name="username" placeholder="User name"
                                                     class="form-control">
                        </label>
                    </section>
                    <section>
                        <label class="form-control"> <input type="password"
                                                     name="password" placeholder="Confirm password"
                                                     class="form-control">
                        </label>
                    </section>
                    <button class="btn btn-primary" type="submit">Create Account</button>
                </form>
                <div class="margin-bottom-20"></div>
                <p class="text-center">
                           Already you have an account? <a href="${pageContext.request.contextPath }/login">Sign In</a>
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
