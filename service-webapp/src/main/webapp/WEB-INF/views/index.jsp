<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<a href="http://localhost:8080/service-webapp/add">Add publication</a>
	
	<h1><strong>${message}</strong></h1>
	<strong>${title}</strong> <br />
	<strong>${context}</strong>
	
	<c:forEach varStatus="status" var="element" items="${collection}">
		Element #${varstatus.index}: ${element.title}<br />
	</c:forEach>

</body>
</html>