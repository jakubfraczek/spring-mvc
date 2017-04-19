<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <spring:url value="/resources/core/css/cover.css" var="cover"/>
    <link href="${cover}" rel="stylesheet"/>
    <title>List of books</title>
</head>
<body>
<div class="site-wrapper">
    <div class="site-wrapper-inner">

        <div class="cover-container">

            <div class="masthead clearfix">
                <div class="inner">
                    <h3 class="masthead-brand">My Library</h3>
                    <nav>
                        <ul class="nav masthead-nav">
                            <li><a href="/home">Home</a></li>
                            <li><a href="/student">Students</a></li>
                            <li class="active"><a href="/library">Library</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
            <table class="site-wrapper">
                <th>Signature</th>
                <th>Title</th>
                <th>Author</th>
                <th>Publication Year</th>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td><c:out value="${book.signature}"/></td>
                        <td><c:out value="${book.title}"/></td>
                        <td><c:out value="${book.authorName}"/> <c:out value="${book.authorSurname}"/></td>
                        <td><c:out value="${book.publicationYear}"/></td>
                        <td><c:if test="${book.currentOwner == null}"><a href="/library/rent">RENT</a> </c:if></td>
                    </tr>

                </c:forEach>

            </table>

        </div>
    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs"/>
<script src="${bootstrapJs}"></script>
<spring:url value="/resources/core/js/jquery.min.js" var="jqueryJS"/>
<script>window.jQuery || document.write('<script src="${jqueryJS}"><\/script>')</script>
</body>
</html>
