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
				<button type="button" class="btn btn-default"
					style="border-color: #FFF">
					<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
					${menuPublished}
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
				<button type="button" class="btn btn-default"
					style="border-color: #FFF">
					<span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
					${menuSketches}
				</button>
			</div>

			<div class="btn-group" role="group">
				<button type="button" class="btn btn-default"
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
						<li><a href="#"><b>PL</b> ${LanguageShowPL}</a></li>
						<li><a href="#"><b>EN</b> ${LanguageShowEN}</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="search" class="col-md-4 pull-right">
		<div class="input-group input-group-sm">
			<span class="input-group-btn">
				<button id="btnSearchResults" class="btn btn-default" type="button">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
				</button>
			</span> <input type="text" class="form-control"
				placeholder="${menuSearchPublications}">
		</div>
	</div>
</div>
<div class="panel panel-default"></div>
<div class="publicationsPage">
	<!-- xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxOPUBLIKOWANExxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx -->

	<!-- xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxREDAGOWANAxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx -->
	<p class="info">
		${selectedPublications}: <span class="info">${allPublications}</span>
	</p>
	<table class="table" style="margin-left: 20px; width: 95%;">
		<thead style="color: #C0C0C0;">
			<tr>
				<th>ID</th>
				<th>Forma wydarzenia</th>
				<th>${publicationTitle}</th>
				<th>${publicationStatus}</th>
				<th>Język</th>
				<th>${publicationAction}</th>
			</tr>
		</thead>
		<tr class="accent">
			<td>1</td>
			<td>Wykłady otwarte</td>
			<td>Tytul publikacji -zazwyczaj długi</td>
			<td>nie zatwierdzona</td>
			<td>EN</td>
			<td>
				<button class="btn buttonLink btn-info "
					onclick="location.href='${userUrl}'">przegląd publikacji</button>
				<button class="btn buttonLink btn-success "
					onclick="location.href='${userUrl}'">Redaguj</button>
			</td>
		</tr>
		<tr class="accent">
			<td>1</td>
			<td>Konferencja</td>
			<td>Tytul publikacji -zazwyczaj długi</td>
			<td>szkic</td>
			<td>PL</td>
			<td>
				<button class="btn buttonLink btn-info "
					onclick="location.href='${userUrl}'">przegląd publikacji</button>
				<button class="btn buttonLink btn-success "
					onclick="location.href='${userUrl}'">Redaguj</button>
			</td>
		</tr>
		<tr class="accent">
			<td>1</td>
			<td>Konkurs</td>
			<td>Tytul publikacji -zazwyczaj długi</td>
			<td>szkic</td>
			<td>PL</td>
			<td>
				<button class="btn buttonLink btn-info "
					onclick="location.href='${userUrl}'">przegląd publikacji</button>
				<button class="btn buttonLink btn-success "
					onclick="location.href='${userUrl}'">Redaguj</button>
			</td>
		</tr>
		<tr class="accent">
			<td>1</td>
			<td>Warsztaty</td>
			<td>Tytul publikacji -zazwyczaj długi</td>
			<td>oczekująca</td>
			<td>EN</td>
			<td>
				<button class="btn buttonLink btn-info "
					onclick="location.href='${userUrl}'">przegląd publikacji</button>
				<button class="btn buttonLink btn-success "
					onclick="location.href='${userUrl}'">Redaguj</button>
			</td>
		</tr>
	</table>
	</div>