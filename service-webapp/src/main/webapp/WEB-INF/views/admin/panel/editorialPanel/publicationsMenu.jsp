<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
	<spring:message code="admin.editor.publications.menu.published"
		var="menuPublished" />
	<spring:message code="admin.editor.publications.menu.sketches"
		var="menuSketches" />
	<spring:message code="admin.editor.publications.menu.language"
		var="menuLanguage" />
	<spring:message
		code="admin.editor.publications.menu.language.dropdown.show.pl"
		var="LanguageShowPL" />
	<spring:message
		code="admin.editor.publications.menu.language.dropdown.show.en"
		var="LanguageShowEN" />
	<spring:message code="admin.editor.publications.menu.add.publication"
		var="menuAddPublication" />
		<spring:message code="admin.editor.publications.menu.search.publication" var="menuSearchPublication" />

	<div class="row" style="margin-bottom: 5px; margin-top: 10px">
		<div class="col-md-7">
			<div class="btn-group btn-group-justified" role="group"
				aria-label="...">
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default"
						style="border-color: #FFF">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
						${menuPublished}
					</button>
				</div>
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default"
						style="border-color: #FFF">
						<span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
						${menuSketches}
					</button>
				</div>
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default"
						style="border-color: #FFF">
						<span class="glyphicon  glyphicon-plus" aria-hidden="true"></span>
						${menuAddPublication}
					</button>
				</div>
				<div class="btn-group" role="group">
					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle"
							style="border-color: #FFF" type="button" id="dropdownMenu1"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
							<span class="glyphicon glyphicon-flag" aria-hidden="true"></span>
							${menuLanguage}
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownUser">
							<li><a href="#"><b>PL</b> ${LanguageShowPL}</a></li>
							<li><a href="#"><b>EN</b> ${LanguageShowEN}</a></li>
						</ul>
					</div>
				</div>

			</div>
		</div>
		<div class="col-md-5 pull-right">
			<div class="input-group input-group-sm">
				<span class="input-group-btn">
					<button id="btnSearchResults" class="btn btn-default" type="button">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</button>
				</span> <input type="text" class="form-control"
					placeholder="${menuSearchPublication}">
			</div>
		</div>

	</div>



	<div class="panel panel-default"></div>



	<div id="page">Panel redakcyjny wszystkie wyniki</div>
</body>