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
        <p><label>Email <input type="email" placeholder="Enter Email" name="email" required></label></p>

        <p><label>Password <input type="text" placeholder="Enter Password" name="psw" required></label></p>

        <p><label>Repeat Password <input type="text" placeholder="Repeat Password" name="psw-repeat" required></label></p>
        <%--<input type="checkbox" checked="checked"> Remember me--%>
        <p><label>Enter age <input type="number" placeholder="Your age" name="age" required></label></p>

        <p><label>Enter your name <input type="text" placeholder="Enter name" name="name" required></label></p>

        <p><label>Enter address <input type="text" placeholder="Enter address" name="address" required></label></p>

        <div class="clearfix">
            <%--<button type="button"  class="cancelbtn">Cancel</button>--%>
            <p></p><input type="submit" value="submit"/>
        </div>
    </div>
</form>
<body>

</body>
</html>
