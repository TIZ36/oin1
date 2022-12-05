<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tianzhang
  Date: 3/13/18
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${empty accounts}">
    no accounts found!
</c:if>

<c:if test="${!empty accounts}">
    <table>
        <tr>
            <th>account_name</th>
            <th>account_email</th>
            <th>operation</th>
        </tr>

        <c:forEach items="${requestScope.accounts}" var="acc">
            <tr>
                <td>${acc.account_name}</td>
                <td>${acc.account_email}</td>
                <td><a>add or already added</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
