<%-- 
    Document   : Comfirm_JSP
    Created on : Feb 25, 2017, 3:18:43 AM
    Author     : zhangtian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title> shopping inventory </title>
        <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="js/shopping.js"></script>
        <style>
            table{         
                width: 100%;
                text-align: center;
            }
        </style>

    </head>

    <body>


        <div style="width: 80%;margin: 0 auto;height:590px;">

            <input id="logout" value="logout" type="button"/>
            <input id="history" style='float:right;' value="view history" type="button"/>
            <hr/><br/><br/>

            <div style="float: left;width: 100%;">
                <select id="type-change" style="float:right;">
                    <option value="all">all</option>
                    <option value="laptop">laptop</option>
                    <option value="desktop">desktop</option>
                    <option value="tablet">tablet</option>
                    <option value="phone">mobile</option>
                </select> 
                <input id="search" type="text" placeholder="search what you want" size="20"/><button id="searchb">OK</button>
                <hr/>
                <table id="sb" border="0">
                    <tr style="background-color: lightgrey">
                        <td>name</td>
                        <td>price</td>
                        <td>&nbsp;</td>
                    </tr>
                </table>


            </div>
        </div>
    </body>
</html>

