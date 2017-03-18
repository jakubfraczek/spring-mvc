<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Student details</title>
</head>
<body>
<a href="/home">Home</a>

<table>
    <th>Index Number</th>
    <th>Login</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Gender</th>
    <th>Specialisation</th>
        <tr>
            <td><c:out value="${s.indexNumber}"/></td>
            <td><c:out value="${s.login}"/></td>
            <td><c:out value="${s.firstName}"/></td>
            <td><c:out value="${s.lastName}"/></td>
            <td><c:out value="${s.gender.gender}"/></td>
            <td><c:out value="${s.specialisation.specialisation}"/></td>
        </tr>
</table>

</body>
</html>
