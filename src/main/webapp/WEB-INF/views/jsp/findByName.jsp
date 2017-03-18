<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: RENT
  Date: 2017-03-18
  Time: 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find students by name</title>
</head>
<body>
<form:form action="/student/findByName" method="post">
    <input type="text" id="name" name="name"/>
    <input type="submit" value="find">
</form:form>
</body>
</html>
