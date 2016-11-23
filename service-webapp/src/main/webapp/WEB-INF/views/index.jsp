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
	<h2>
		<spring:message code="web.layout.top.title" />
	</h2>
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
		<spring:url value="/publication/${publication.id}" var="elementUrl" />
		<button onclick="location.href='${elementUrl}'">Query</button>
		Publication: ${publication.id}: ${publication.title}<br />
	</c:forEach>

	<c:forEach varStatus="status" var="category"
		items="${collectionCategory}">
		<spring:url value="/category/${category.id}" var="elementUrl" />
		<button onclick="location.href='${elementUrl}'">Query</button>
		Category:${category.id} : ${category.name}<br />
	</c:forEach>

	<c:forEach varStatus="status" var="translation"
		items="${collectionTranslation}">
		<spring:url value="/translation/${translation.id}" var="elementUrl" />
		<button onclick="location.href='${elementUrl}'">Update</button>
		Translation:${translation.id} : ${translation.polish}:  ${translation.english}<br />
	</c:forEach>

	<h1>
		<strong>${info}</strong>
	</h1>
</body>
</html>