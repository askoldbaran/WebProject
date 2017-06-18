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

<h3>Login Form</h3>
<br/>
<form action="/login" method="post">
    <label>Email:<input type="text" name="login" placeholder="Enter email"/></label>
    <label>Password:<input type="text" name="password" placeholder="Enter password"/></label>
    <input type="submit" value="Submit"/>
</form>
</html>
