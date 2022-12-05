<%--
  Created by IntelliJ IDEA.
  User: tianzhang
  Date: 3/4/18
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>show all stuff info</title>
</head>
<body>
<form:form action="/Account/signIn" method="post" modelAttribute="Account">
    email:<form:input path="account_email"/><br/>
    password: <form:input path="account_password"/><br/>
    <input type="submit" value="go" />
</form:form>
<br/>
<br/>
<a href="/Account/signUp">sign up here</a>
</body>
</html>
