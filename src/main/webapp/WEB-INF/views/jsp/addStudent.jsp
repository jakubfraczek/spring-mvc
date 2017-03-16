<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add student</title>
</head>
<body>

<form:form action="/addStudent" method="post" commandName="student">
    <div>
        <label>Login</label>
        <form:input path="login"></form:input>
    </div>
    <div>
        <form:label path="firstName">Name</form:label>
        <form:input path="firstName"/>
    </div>
    <div>
        <form:label path="lastName">Surname</form:label>
        <form:input path="lastName"/>

    </div>
    <div>
        <form:label path="indexNumber">Index Number</form:label>
        <form:input path="indexNumber"/>
    </div>
    <div>
        <form:label path="gender"/>
        <form:radiobuttons path="gender"/>
    </div>
    <div>
        <form:label path="specialisation">Specialization</form:label>
        <form:select path="specialisation">
            <form:options items="${specENUM}"/>
        </form:select>
    </div>
    <input type="submit" value="submit">
</form:form>

</body>
</html>
