<%-- 
    Document   : login
    Created on : Jun 10, 2021, 4:07:41 PM
    Author     : 854276
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
            <form method="post" action="login">
            <label>Username:</label>
            <input type="text" name="username" value="${user.username}" >
            <br>
            <label>Password:</label>
            <input type="password" name="password" value="${user.password}">
            <br>
            <input type="submit" value="Log in">
             <p> ${logoutmessage}</p>
             <p> ${slogoutmessage}</p>
        </form>
    </body>
</html>
