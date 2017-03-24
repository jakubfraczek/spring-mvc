<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Maven + Spring MVC</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<link href="${coreCss}" rel="stylesheet" />
	<%--<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />--%>
	<%--<link href="${bootstrapCss}" rel="stylesheet" />--%>
</head>
<body>

Hello ${msg}!

<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<script src="${coreJs}"></script>
<%--<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />--%>
<%--<script src="${bootstrapJs}"></script>--%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>