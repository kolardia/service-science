<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title>service</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#servicePanel").hide();
		$("#editorPanel").hide();

		$("#btnService").click(function() {
			var panel = $(servicePanel).html();
			$("#pagePanel").html(panel);
		});

		$("#btnEditor").click(function() {
			var panel = $(editorPanel).html();
			$("#pagePanel").html(panel);
		});

	});
</script>
<style>
body {
	overflow-y: scroll;
}

ul.navLogoSerwis {
	list-style-type: none;
}

li.navInBloc {
	display: inline-block;
}
</style>
</head>
<body>
	<spring:url value="editor" var="btnEditor" />
	<div id="contents">
		<jsp:include page="panel/header.jsp" />
		<div class="row"
			style="margin-top: 25px; margin-right: 20px; margin-left: 20px;">

			<div class="col-md-3">
				<div class="thumbnail">

					<div class="caption text-center">
						<img
							src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTy-NVHk0hv_HZBxaDxYXKk8OTef912WZsJRFseTs3C_hYC6COP">
						<h3>voluptatem sequi</h3>
						<p>
							s qui ratione voluptatem sequi nesciunt. Neque porro quisquam
							est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci
							veniam, quis nostrum exer <br /> <a href="#">
								Nequeporro@quisquam.com</a>
						</p>
						<spring:message code="admi.nav.editorial.work" var="editorialWork" />
						<spring:message code="admi.nav.service" var="service" />
						<div class="btn-group" role="group" aria-label="menuSection"
							style="margin-bottom: 25px;">
							<a id="btnEditor" type="button" class="btn btn-default"
								onClick="location.href='${btnEditor}'"><span
								class=" glyphicon glyphicon-pencil" aria-hidden="true"></span>
								${editorialWork} </a>
							<button id="btnService" type="button" class="btn btn-default">
								<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
								${service}
							</button>
						</div>
					</div>

				</div>
			</div>

			<div class="col-md-9 ">


				<div id="pagePanel"><jsp:include
						page="panel/editorialNavigation.jsp" /></div>

			</div>
			<!--col-sm-9-->
		</div>

		<jsp:include page="panel/footer.jsp" />
	</div>

	<div id="servicePanel">
		<jsp:include page="panel/serviceNavigation.jsp" /></div>

	<div id="editorPanel">
		<jsp:include page="panel/editorialNavigation.jsp" />
	</div>
</body>
</html>
