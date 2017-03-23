
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<spring:message code="admin.editor.publications.menu.search.publication"
	var="menuSearchPublications" />

<spring:message code="admin.editor.publications.list.select"
	var="selectedPublications" />
<spring:message code="admin.editor.publications.list.all"
	var="allPublications" />
<spring:message code="admin.editor.publications.list.published"
	var="publishedPublications" />
<spring:message code="admin.editor.publications.list.sketches"
	var="sketchesPublication" />

<spring:message code="admin.editor.publications.table.title"
	var="publicationTitle" />
<spring:message code="admin.editor.publications.table.status"
	var="publicationStatus" />
<spring:message code="admin.editor.publications.table.category"
	var="publicationCategory" />
<spring:message code="admin.editor.publications.table.action"
	var="publicationAction" />

<div class="row" style="margin-bottom: 5px; margin-top: 10px">
	<div class="col-md-8">
		<div class="btn-group btn-group-justified" role="group"
			aria-label="...">
			<div class="btn-group" role="group">
				<button id="btnEPPublished" type="button" class="btn btn-default"
					style="border-color: #FFF" id="asdasd">
					<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
					${menuPublished}
				</button>
			</div>
			<div class="btn-group" role="group">
				<button id="btnEPAdd" type="button" class="btn btn-default"
					style="border-color: #FFF">
					<span class="glyphicon  glyphicon-plus" aria-hidden="true"></span>
					${menuAddPublication}
				</button>
			</div>
			<div class="btn-group" role="group">
				<button id="btnEPSketches" type="button" class="btn btn-default"
					style="border-color: #FFF">
					<span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
					${menuSketches}
				</button>
			</div>

			<div class="btn-group" role="group">
				<button id="btnEPType" type="button" class="btn btn-default"
					style="border-color: #FFF">
					<span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span>
					Typ publikacji
				</button>
			</div>
			<div class="btn-group" role="group">
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle"
						style="border-color: #FFF" type="button" id="dropdownPublications"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
						<span class="glyphicon glyphicon-flag" aria-hidden="true"></span>
						${menuLanguage}
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownPublications">
						<li><a id="btnEPAllPl" href="#"><b>PL</b> ${LanguageShowPL}</a></li>
						<li><a id="btnEPAllEn" href="#"><b>EN</b> ${LanguageShowEN}</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="search" class="col-md-4 pull-right">
		<div class="input-group input-group-sm">
			<span class="input-group-btn">
				<button id="btnEPSearchResults" class="btn btn-default" type="button">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
				</button>
			</span> <input type="text" class="form-control"
				placeholder="${menuSearchPublications}">
		</div>
	</div>
</div>
<div class="panel panel-default"></div>

<div id="publicationsPage"></div>
	