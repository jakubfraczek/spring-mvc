<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Students List</title>
</head>
<body>
<a href="/home">Home</a>
<table>

    <th>No.</th>
    <th>First Name</th>
    <th>Last Name</th>
    <c:forEach begin="0" step="1" varStatus="loopCounter" items="${students}" var="s">
        <tr>
            <td><c:out value="${loopCounter.count}"/></td>

                <td><a href="/<c:out value="student/${s.login}"/>"><c:out value="${s.firstName}"/></a></td>
                <td><a href="/<c:out value="student/${s.login}"/>"><c:out value="${s.lastName}"/></a></td>
            <form:form method="post" commandName="login">
                <td><button value="${s.login}" formaction="/student/${s.login}/remove" type="submit">remove</button></td>
                <td><button value="${s.login}" formaction="/student/${s.login}/update" type="submit">update</button></td>
            </form:form>
        </tr>


    </c:forEach>

</table>


</body>
</html>
