<%-- 
    Document   : register
    Created on : Feb 25, 2017, 5:12:15 AM
    Author     : zhangtian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Login_Page </title>
        <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="js/register.js"></script>
    </head>
    <body>
        <div>

            <input id="register" style="float: right" type="submit" value="register"/>

        </div>
        <div style="margin:0 auto;width: 80%" id="test">
            <div style="margin: 0 auto;text-align: center">

                <h2> Login </h2>
                <table style="margin: 0 auto;">
                    <tr>
                        <td>username:</td>
                        <td><input id="name" type="text" size="20"/></td>
                    </tr>
                    <tr>
                        <td>password:</td>
                        <td><input id="pwd1" type="password" size="20"/></td>
                        <td><button id="hint">show hint</button></td>
                    </tr>                  
                    <tr>
                        <td></td>
                        <td><input id="login" type="submit" size="20" name="submit" style="float: right"/></td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
