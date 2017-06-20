<%--
  Created by IntelliJ IDEA.
  User: askol
  Date: 6/19/2017
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/addItem">
    <label>Text: <input type="text" placeholder="Enter text" name="text" required></label>
    <input type="submit" value="Submit">
    <a href="/userPage">Cancel</a>
    <br><br>
</form>
</body>
</html>
