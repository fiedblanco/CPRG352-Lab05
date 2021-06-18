<%-- 
    Document   : home
    Created on : Jun 10, 2021, 4:23:01 PM
    Author     : 854276
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h3>Hello ${sessionObject}. </h3>
          <a href="login?logout">Log out</a>
    </body>
</html>
