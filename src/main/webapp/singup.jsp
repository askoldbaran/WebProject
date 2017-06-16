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
<h3>Sing up Form</h3>
<%
//    String profile_msg=(String)request.getAttribute("profile_msg");
//    if(profile_msg!=null){
//        out.print(profile_msg);
//    }
    String singup_msg=(String)request.getAttribute("singup_msg");
    if(singup_msg!=null){
        out.print(singup_msg);
    }
%>
<form action="/registration" method="post">
    <div class="container">
        <p><label>Email </label>
        <input type="text" placeholder="Enter Email" name="email" required></p>

        <p><label>Password </label>
        <input type="password" placeholder="Enter Password" name="psw" required></p>

        <p><label>Repeat Password </label>
        <input type="password" placeholder="Repeat Password" name="psw-repeat" required></p>
        <%--<input type="checkbox" checked="checked"> Remember me--%>
        <p><label>Enter age </label>
            <input type="age" placeholder="Your age" name="age" required></p>

        <p><label>Enter your name </label>
            <input type="name" placeholder="Enter name" name="name" required></p>

        <p><label>Enter address </label>
            <input type="address" placeholder="Enter address" name="address" required></p>

        <div class="clearfix">
            <%--<button type="button"  class="cancelbtn">Cancel</button>--%>
            <p></p><input type="submit" value="submit"/>
        </div>
    </div>
</form>
<body>

</body>
</html>
