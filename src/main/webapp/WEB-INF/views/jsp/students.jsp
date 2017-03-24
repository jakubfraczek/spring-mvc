<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <spring:url value="/resources/core/css/cover.css" var="cover"/>
    <link href="${cover}" rel="stylesheet"/>
    <title>Student managment system</title>
</head>
<body>
<a href="/home">Home</a><br><br>
<a href="/student/addStudent">Add Student</a><br>
<a href="/student/studentsList">View Students</a><br>
<a href="/student/findByName">Find students by name</a>
</body>
</html>
