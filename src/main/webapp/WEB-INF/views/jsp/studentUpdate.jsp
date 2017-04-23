<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add student</title>
</head>
<body>
<a href="/home">Home</a>
<form:form action="/student/update" method="post" commandName="student">
    <form:hidden path="id"></form:hidden>
    <div>
        <form:label path="login">Login</form:label>
        <form:input path="login"></form:input>
        <form:errors path="login"/>
    </div>
    <div>
        <form:label path="firstName">Name</form:label>
        <form:input path="firstName"/>
        <form:errors path="firstName"/>
    </div>
    <div>
        <form:label path="lastName">Surname</form:label>
        <form:input path="lastName"/>
        <form:errors path="lastName"/>
    </div>
    <div>
        <form:label path="indexNumber">Index Number</form:label>
        <form:input path="indexNumber"/>
        <form:errors path="indexNumber"/>
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
