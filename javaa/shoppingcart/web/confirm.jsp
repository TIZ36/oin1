<%-- 
    Document   : Comfirm_JSP
    Created on : Feb 25, 2017, 3:18:43 AM
    Author     : zhangtian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="js/confirm.js"></script>
    </head>
    <body>
        <input value="gotoshopping" id="gs" type="button"/>
        <div style="margin: 0 auto; width: 70%">
            <h1>Hello <span id="name"></span>,</h1>
            <h3>You have successfully registered!</h3>
            <h3>Please check your information:</h3>
            <table>
                <tr>
                    <td>username:</td>
                    <td id="username"></td>
                </tr>
                <tr>
                    <td>first name:</td>
                    <td id="fname"></td>
                </tr>
                <tr>
                    <td>last name:</td>
                    <td id="lname"></td>
                </tr>
                <tr>
                    <td>gender:</td>
                    <td id="gender"></td>
                </tr>
                <tr>
                    <td>E-Mail:</td>
                    <td id="email"></td>
                </tr>
                <tr>
                    <td>address:</td>
                    <td id="address"></td>
                </tr>
            </table>
        </div>
    </body>
</html>
