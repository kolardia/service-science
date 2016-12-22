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
<meta charset="utf-8">
<!-- Theme Made By www.w3schools.com - No Copyright -->
<title>service</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
	
</script>
<style>
ul.navLogoSerwis {
	list-style-type: none;
}

li.navInBloc {
	display: inline-block;
}
</style>
</head>
<body>
	<nav>
		<!-- container-fluid-->
		<div class="container-fluid">
			<!--MENU : Show a main menu.-->
			<div class="row">
				<div class=" bg-nav-menu" style="margin-top: 30px;">
					<!--NAV 1: Show a language navigation-->
					<spring:url value="/panel/?language=pl" var="pl" />
					<spring:url value="/panel/?language=en" var="en" />
					<div class="col-md-* pull-left">
						<div class="btn-group" role="group" aria-label="menuLanguage"
							style="padding-left: 35px; padding-right: 0px;">
							<button type="button" class="btn btn-default"
								onClick="location.href='${pl}'">PL</button>
							<button type="button" class="btn btn-default"
								onClick="location.href='${en}'">EN</button>
						</div>
					</div>
					<!--NAV 1: END-->
					<!--NAV 2:  Search an editorial section.-->
					<spring:message code="admin.header.nav.search.section"
						var="searchSection" />
					<div class="col-md-4"
						style="padding-left: 15px; padding-right: 0px;">
						<div class="input-group">
							<span class="input-group-btn">
								<button class="btn btn-default" type="button">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
								</button>
							</span> <input type="text" class="form-control"
								placeholder="${searchSection}">
						</div>
					</div>
					<!--NAV 2: END-->
					<!--NAV 3: Show an editorial section.-->
					<spring:message code="admin.header.nav.show.section"
						var="showSection" />
					<div class="col-md-4"
						style="padding-left: 15px; padding-right: 0px;">
						<div class="input-group" style="padding-left: 0px;">
							<button class="btn btn-default dropdown-toggle" type="button"
								data-toggle="collapse" data-target="#collapseSekcje"
								aria-expanded="false" aria-controls="collapseExample"
								style="color: #000">
								<span class="glyphicon glyphicon-eye-open" aria-hidden="true">
								</span> ${showSection}
							</button>
						</div>
					</div>
					<!--NAV 3: END-->
					<!--NAV 4: Show an editorial section.-->
					<spring:message code="admin.header.nav.logout" var="logout" />
					<spring:message code="admin.header.nav.preferences"
						var="preferences" />
					<spring:message code="admin.header.nav.help" var="help" />
					<div class="col-md-2 pull-right input-group">
						<div class="dropdown">
							<button class="btn btn-default dropdown-toggle" type="button"
								id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="true">
								<span class="glyphicon glyphicon-user"></span>
								kolardia@gmail.com <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownUser">
								<li><a href="#"><span class="glyphicon glyphicon-lock"
										aria-hidden="true"></span> ${logout}</a></li>
							</ul>
						</div>
					</div>
					<!--NAV 4: END -->
				</div>
				<!-- End of that main menu. -->

				<!-- List Organizer -->


				<div class="col-md-11"
					style="padding-left: 35px; margin-left: auto; margin-right: auto; margin-top: 10px;">

						<div class="collapse" id="collapseSekcje">

							<div class="list-group">
								<button type="button" class="list-group-item"
								style="border: 1px solid rgb(255, 255, 255); color:#4E84AB">
								<b>Sed ut perspiciatis unde omnis iste natus:</b>  error sit voluptatem accusantium doloremque laudantium, totam rem aperiam
							</button>

							<button type="button" class="list-group-item"
								style="border: 1px solid rgb(255, 255, 255); color:#4E84AB">
								<b>dolor sit amet, consectetur, adipisci velit:</b> dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaera
							</button>

						</div>

					</div>
					<!--END col-md-9-->
				</div>
				<!--END row -->
			</div>
			<!--END container-->
		</div>
	</nav>
</body>