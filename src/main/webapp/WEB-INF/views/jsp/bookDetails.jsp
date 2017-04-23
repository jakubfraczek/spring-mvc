<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book details</title>
</head>
<body>

<table class="site-wrapper">
    <th>Signature</th>
    <th>Title</th>
    <th>Author</th>
    <th>Publication Year</th>
    <th>Current owner</th>
    <tr>
        <td><c:out value="${book.signature}"/></td>
        <td><c:out value="${book.title}"/></td>
        <td><c:out value="${book.authorName}"/> <c:out value="${book.authorSurname}"/></td>
        <td><c:out value="${book.publicationYear}"/></td>
        <td>
            <c:if test="${book.currentOwner != null}">
                <a href="/<c:out value="student/${book.currentOwner.login}"/>"><c:out
                        value="${book.currentOwner.firstName}"/> <c:out value="${book.currentOwner.lastName}"/></a>
            </c:if>

            <c:if test="${book.currentOwner == null}">
                <form:form action="/library/rent" method="post" commandName="book">
                    <form:select path="currentOwner" items="${students}" itemLabel="login"/>
                    <input type="submit" value="rent">
                </form:form>
            </c:if>
        </td>
    </tr>


</table>

</body>
</html>
