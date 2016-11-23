<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	<h3>${info}</h3>
	<br />

	<h3>${info}</h3>
	<form:form action="form" modelAttribute="form" method="get">
		<strong>Id</strong>
		<form:errors path="Id" cssclass="error" />
		<br />
		<input type="text" name="Id" />
		<br />

		<strong>Name</strong>
		<form:errors path="name" cssclass="error" />
		<br />
		<input type="text" name="name" />
		<br />

		<input type="submit" value="Submit form" />
	</form:form>


</body>
</html>