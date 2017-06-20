<%--
  Created by IntelliJ IDEA.
  User: askol
  Date: 6/18/2017
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script src="JS/jquery-3.2.1.js"></script>
    <link type="text/css" href="CSS/Bootsrap/css/bootstrap.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills pull-right">
                <li id="liHome" role="presentation"><a href="${pageContext.request.contextPath}/">Home</a>
                </li>
                <li id="liSign" role="presentation" class="active"><a
                        href="${pageContext.request.contextPath}/userPage">User page</a>
                </li>
                <li id="liLogin" role="presentation"><a href="${pageContext.request.contextPath}/login">Login</a>
                </li>
                <li id="liLogOut" role="presentation"><a href="${pageContext.request.contextPath}/doLogOut">Logout</a>
                </li>
            </ul>
        </nav>
        <h3 align="left">Web App</h3>
    </div>
</div>
<div class="container" align="center">
    <div class="row">
        <div class="col-sm-4"><h2><b>User Name: ${user.name}</b></h2></div>
        <div class="col-sm-4"><h2><b>User Age: ${user.age}</b></h2></div>
        <div class="col-sm-4"><h2><b>User Address: ${user.address}</b></h2></div>
    </div>
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <form action="/addItem" method="post">
                <button id="btnAddItem" type="submit" value="Add Item" class="btn btn-primary btn-lg center-block">Add
                    Item
                </button>
                <div id="addItem" hidden style="margin-top: 5px">
                    <input type="text" class="form-control" placeholder="Enter text" name="text" required>

                </div>
            </form>
        </div>
        <div class="col-sm-4"></div>
    </div>
</div>
<div class="container">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Text</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${itemList}" var="item">
            <tr>
                <td><c:out value="${item.getText()}"/></td>
                <td width="110px">
                    <a type="button" methods="post" href="deleteItem?id=${item.getId()}"
                       class="btn btn-primary center-block" style="margin-top: 5px">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        var check = false;
        $("#btnAddItem").click(function () {
            if (check == false) {
                $("#addItem").show();
                check = true;
            } else {
                $("#addItem").hide();
                check = false;
            }

        });
    });
</script>

</body>
</html>
