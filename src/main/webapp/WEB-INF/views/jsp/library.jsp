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
    <title>Library manage system</title>
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

            <h1>Choose what you want to do</h1>
            <a href="/library/addBook">Add Book</a><br>
            <a href="/library/bookList">See list of books</a>
        </div>
    </div>
</div>
</body>
</html>
