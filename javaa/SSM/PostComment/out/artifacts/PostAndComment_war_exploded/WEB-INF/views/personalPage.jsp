<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tianzhang
  Date: 3/9/18
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/Account/editAccountInfo">edit your account info</a>
<hr/>
Hello, ${requestScope.name}<br/>
Email:${requestScope.email}

<hr/>
<br/>
<c:if test="${empty requestScope.friends}">
    you dont have any friends yet
</c:if>

<c:if test="${!empty requestScope.friends}">
    <table>
        <tr>
            <th>friend_id</th>
            <th>operation</th>
        </tr>

        <c:forEach items="${requestScope.friends}" var="fri">
            <tr>
                <td><a href="/Friend/friendSeePage/${fri.account_id}">${fri.account_name}</a></td>
                <td><a>delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<form action="/Account/searchAccounts" method="post">
    <input type="text" name="s"/>
    <input type="submit" value="search"/>
</form>

<form action="/PostText/initNewTopic" method="post">
    <input type="hidden" name="Post_by" value=${sessionScope.current_Account_id}>
    <input type="text" name="Post_content"/>
    <input type="submit" value="ok"/>
</form>
</body>
</html>
