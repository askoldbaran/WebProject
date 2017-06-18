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
    <title>Title</title>
</head>
<body>
<div style="padding: 5px;">

    <a href="${pageContext.request.contextPath}/">Home</a>
    |
    <a href="${pageContext.request.contextPath}/userPage">User page</a>
    |
    <a href="${pageContext.request.contextPath}/login">Login</a>
    |
    <a href="${pageContext.request.contextPath}/singup">Sign up</a>
    |
    <a href="${pageContext.request.contextPath}/doSignOut">Logout</a>
</div>
<br><br>
<h3>HELLO ${user.name}</h3>
<br/>
User Name: <b>${user.name}</b><br/>
User Age: <b>${user.age}</b><br/>
User Address: <b>${user.address}</b><br/><br/><br/>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Text</th>
        <%--<th>State</th>--%>
        <th>Delete</th>
    </tr>

    <c:forEach items="${itemList}" var="item" >
        <tr>
            <td> <c:out value="${item.getText()}"/></td>
            <%--<td>${item.state}</td>--%>
            <td>
                <form action="deleteItem" method="post">
                    <input type="submit" value="Delete" name="${item.getId()}"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action="/addItem" method="post">
    <input type="submit" value="Add Item"/>
</form>
</body>
</html>
