<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2><spring:message code="web.layout.top.title" /></h2>
	<spring:url value="/?language=en" var="en" />
	<spring:url value="/?language=pl" var="pl" />
	<a href="${en}">English</a>
	<a href="${pl}">Polski</a>
	<spring:url value="/add" var="elementAdd" />
	<a href="${elementAdd}">Add publication</a>
	
	<h1><strong>${message}</strong></h1>
	<strong>${title}</strong> <br />
	<strong>${context}</strong>
	
	<c:forEach varStatus="status" var="element" items="${collection}">
		<spring:url value="/${element.id}" var="elementUrl" />
		<button onclick="location.href='${elementUrl}'">Query</button>
		Element: ${element.id}: ${element.title}<br />
	</c:forEach>
<h1><strong>${info}</strong></h1>
</body>
</html>