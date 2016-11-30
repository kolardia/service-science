<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

	<spring:url value="/?language=en" var="en" />
	<spring:url value="/?language=pl" var="pl" />
	*
	<a href="${en}">English</a>* *
	<a href="${pl}">Polski</a>*
	<br />

	<spring:url value="/publication/add" var="publicationAdd" />
	<spring:url value="/category/add" var="categoryAdd" />
	*
	<a href="${publicationAdd}">Add publication</a>* *
	<a href="${categoryAdd}">Add category</a>*
	<br />
	<spring:url value="/category" var="categoryUrl" />
	*
	<a href="${categoryUrl}">Category</a>*
	<spring:url value="/" var="publicationUrl" />
	*
	<a href="${publicationUrl}">Publication</a>*
	<h1>
		<strong>${message}</strong>
	</h1>
	<strong>${title}</strong>
	<br />
	<strong>${context}</strong>

	<c:forEach varStatus="status" var="publication"
		items="${collectionPublication}">
		publicaton: ${publication.id}: ${translation.text}<br />
	</c:forEach>


	<h1>
		<strong>${info}</strong>
	</h1>
</body>
</html>