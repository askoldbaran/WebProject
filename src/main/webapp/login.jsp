<%--
  Created by IntelliJ IDEA.
  User: askol
  Date: 6/15/2017
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="index.jsp" %>
<hr/>
<head>
    <link type="text/css" href="CSS/Bootsrap/css/bootstrap.css" rel="stylesheet">
    <script src="JS/jquery-3.2.1.js"></script>
</head>
<br/>
<form action="/login" method="post" class="form-signin">

    <div class="container">
        <h2 class="form-signin-heading" align="center">Please sign in</h2>
        <div class="row">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <div class="row">
                    <div>
                        <label for="inputEmail">Email address</label>
                        <input type="text" id="inputEmail" class="form-control" name="login" placeholder="Enter email"
                               required autofocus/>
                    </div>
                    <div>
                        <label for="inputPassword">Password:</label>
                        <input type="password" id="inputPassword" class="form-control"
                               name="password" placeholder="Enter password"/>
                    </div>
                </div>
                <div class="row" style="margin-top: 10px">
                    <div class="col-sm">
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in
                        </button>
                    </div>

                </div>
            </div>
            <div class="col-sm-4"></div>
        </div>

    </div>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#liLogin").addClass("active");
            $("#liSign").removeClass("active");
        });
    </script>
</form>
</html>
