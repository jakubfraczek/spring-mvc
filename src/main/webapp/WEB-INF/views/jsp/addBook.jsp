<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <spring:url value="/resources/core/css/cover.css" var="cover"/>
    <link href="${cover}" rel="stylesheet"/>
    <title>Add Book Form</title>
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
            <form:form action="/library/addBook" method="post" commandName="book">
                <div>
                    <form:label path="signature">Signature</form:label>
                    <form:input path="signature"/>
                    <form:errors path="signature"/>
                </div>
                <div>
                    <form:label path="title">Title</form:label>
                    <form:input path="title"/>
                    <form:errors path="title"/>
                </div>
                <div>
                    <form:label path="authorName">Author First Name</form:label>
                    <form:input path="authorName"/>
                    <form:errors path="authorName"/>
                </div>
                <div>
                    <form:label path="authorSurname">Author Surname</form:label>
                    <form:input path="authorSurname"/>
                    <form:errors path="authorSurname"/>
                </div>
                <div>
                    <form:label path="publicationYear">Publication Year</form:label>
                    <form:input path="publicationYear"/>
                    <form:errors path="publicationYear"/>
                </div>
                <input type="submit" value="submit">
            </form:form>
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
