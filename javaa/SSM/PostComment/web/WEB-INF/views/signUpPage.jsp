<%--
  Created by IntelliJ IDEA.
  User: tianzhang
  Date: 3/9/18
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>sign up here</title>
</head>
<body>

<form:form action="/Account/signUp" method="post" modelAttribute="newAccount">
    Full Name: <form:input path="account_name"/> <br/>
    Email: <form:input path="account_email"/><br/>
    Password: <form:input path="account_password"/>
    Address: <form:input path="account_address"/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
