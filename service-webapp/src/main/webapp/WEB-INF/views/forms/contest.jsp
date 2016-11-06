<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Form</h2>
	<h3>${info}</h3>
	<br />
	<form:form action="form" modelAttribute="form" method="get">
		<strong>Id</strong>
		<form:errors path="Id" cssclass="error" /><br />
		<input type="text" name="Id" /><br />
		
		<strong>Title</strong>
		<form:errors path="title" cssclass="error" /><br />
		<input type="text" name="title" /><br />
		
		<strong>Content</strong>
		<form:errors path="contents" cssclass="error" /><br />
		<input type="text" name="contents" /><br />
		
		
		<input type="submit" value="Submit form" />
	</form:form>

</body>
</html>