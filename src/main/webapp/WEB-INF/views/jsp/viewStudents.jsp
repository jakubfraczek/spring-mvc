<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Students View</title>
</head>
<body>

<table>

    <th>First Name</th>
    <th>Last Name</th>
    <th>Index Number</th>
    <th>Gender</th>
    <th>Specialisation</th>
    <c:forEach items="${students}" var="s">
        <tr>
            <td><c:out value="${s.firstName}"/></td>
            <td><c:out value="${s.lastName}"/></td>
            <td><c:out value="${s.indexNumber}"/></td>
            <td><c:out value="${s.gender.gender}"/></td>
            <td><c:out value="${s.specialisation.specialisation}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
