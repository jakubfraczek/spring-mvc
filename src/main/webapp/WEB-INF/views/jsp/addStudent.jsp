<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add student</title>
</head>
<body>

<form:form action="/studentform" method="post">
    <div>
        <form:label path="login">Login</form:label>
        <form:input path="login"/>
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
        <form:radiobutton path="gender" value="F"/>female
        <form:radiobutton path="gender" value="M"/>male
    </div>
    <div>
        <form:label path="specialisation">Specialization</form:label>
        <form:select path="specialisation">
            <option value="MED">MEDICINE</option>
            <option value="IT">IT</option>
            <option value="MGMT">MANAGEMENT</option>
            <option value="LAW">LAW</option>
        </form:select>
    </div>
</form:form>

</body>
</html>
