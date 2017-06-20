<%--
  Created by IntelliJ IDEA.
  User: askol
  Date: 6/15/2017
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<html>
<hr/>
<h3 align="center">Sing up Form</h3>
<script src="JS/jquery-3.2.1.js"></script>
<body>
<div class="container">
    <form action="/registration" method="post">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">

            <label for="inputEmail">Email address:</label>
            <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email address" required
                   autofocus>

            <label for="inputPassword">Password:</label>
            <input type="password" id="inputPassword" name="psw" class="form-control" placeholder="Password" required>


            <label for="inputAge">Your age:</label>
            <input type="number" min="5" max="120" id="inputAge" name="age" class="form-control" placeholder="Your age"
                   required>


            <label for="inputName">Your name:</label>
            <input type="text" id="inputName" name="name" class="form-control" placeholder="Enter name" required>

            <label for="inputAddress">Your address:</label>
            <input type="text" id="inputAddress" name="address" class="form-control" placeholder="Enter address"
                   required>

            <button class="btn btn-lg btn-primary btn-block" type="submit" style="margin-top: 10px">Sign up</button>
        </div>
        <div class="col-sm-3"></div>

        <script type="text/javascript">
            $(document).ready(function () {
                $("#liLogin").removeClass("active");
                $("#liSign").addClass("active");
            });
        </script>
    </form>
</div>
</body>
</html>
