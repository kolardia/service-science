<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
	<spring:message code="admin.service.news.menu.organizer"
		var="menuOrganizer" />
	<spring:message code="admin.service.news.menu.editors"
		var="menuEditors" />
	<spring:message code="admin.service.news.menu.announcement"
		var="menuAnnouncement" />
	<spring:message code="admin.service.news.menu.important"
		var="menuImportant" />
	<spring:message code="admin.service.news.search.from.the.date"
		var="searchFromTheDate" />
	<spring:message code="admin.service.news.search.up.to.the.date"
		var="searchUpToDate" />



	<div class="row" style="margin-bottom: 5px; margin-top: 10px">
		<div class="col-md-7">
			<div class="btn-group btn-group-justified" role="group"
				aria-label="...">
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default"
						style="border-color: #FFF">
						<span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
						${menuOrganizer}
					</button>
				</div>
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default"
						style="border-color: #FFF">
						<span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
						${menuEditors}
					</button>
				</div>
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default"
						style="border-color: #FFF">
						<span class="glyphicon  glyphicon-plus" aria-hidden="true"></span>
						${menuAnnouncement}
					</button>
				</div>
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default"
						style="border-color: #FFF">
						<span class="glyphicon glyphicon-exclamation-sign"
							aria-hidden="true"></span> ${menuImportant}
					</button>
				</div>
			</div>
		</div>
		<div class="col-md-5 ">

			<div class="input-group input-group-sm">
				<input type="text" class="form-control"
					placeholder="${searchFromTheDate}"> <span
					class="input-group-btn">
					<button id="btnSearchResults" class="btn btn-default" type="button">
						<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
					</button>
				</span> <input type="text" class="form-control"
					placeholder="${searchUpToDate}">
			</div>

		</div>
	</div>
	<!-- Wykaz tabel -->
	<div class="panel panel-default"></div>
	<div class="row" style="margin-bottom: 5px; margin-top: 10px">
		<div class="col-md-6">
			<p
				style="font-size: 14px; margin-left: 15px; font-weight: 400; line-height: 1.42857; margin-top: -2px">
				OgÃÂoszenia: <span style="color: #C0C0CA;">organizatora</span>
			</p>
		</div>
		<div class="col-md-3"
			style="text-align: right; color: #C0C0CA; margin-top: -2px">
			<p>14.12.2015 - 16-12-2015</p>
		</div>
		<div class="col-md-3 pull-right text-center">
			<nav style="margin-bottom: -17px; margin-top: -30px">
				<ul class="pagination pagination-sm">
					<li><a href="#" aria-label="Previous" style="color: #757575">
							<span aria-hidden="true">&laquo;</span>
					</a></li>
					<li><a href="#" style="color: #757575">1</a></li>
					<li><a href="#" style="color: #757575">2</a></li>
					<li><a href="#" style="color: #757575">3</a></li>
					<li><a href="#" style="color: #757575">4</a></li>
					<li><a href="#" style="color: #757575">5</a></li>
					<li><a href="#" aria-label="Next" style="color: #757575">
							<span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>

	<div class="row" style="margin-top: 10px">
		<div class="col-sm-6 col-md-3">
			<div class="thumbnail ogloszenie">
				<p class="text-ogloszenie text-center"
					style="color: rgb(128, 125, 125); margin-top: 10px">Zmiana
					regulaminu konkursu</p>
				<div class="thumbnail">
					<p class="text-ogloszenie">
						<b>ProszÃÂ zapoznaÃÂ siÃÂ z nowym regulaminem, wytyczne
							dotyczÃÂ zmian kryteriÃÂ³w wieku odnaÃÂnie etapÃÂ³w
							rekrutacji. </b>
					</p>
					<p class="text-ogloszenie">
						<span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span><span
							style="color: rgba(76, 158, 217, 0.83);"> regulamin.pdf</span> <br />
						<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
						kolardia@gmail.com
					</p>

				</div>
				<p
					style="color: rgb(128, 125, 125); text-align: right; margin-right: 10px;">
					czytaj wiÃÂcej...</p>
			</div>
		</div>
		<div class="col-sm-6 col-md-3">
			<div class="thumbnail ogloszenie">
				<p class="text-ogloszenie text-center"
					style="color: rgb(128, 125, 125); margin-top: 10px">Zmiana
					regulaminu konkursu</p>
				<div class="thumbnail">
					<p class="text-ogloszenie">
						<b>ProszÃÂ zapoznaÃÂ siÃÂ z nowym regulaminem, wytyczne
							dotyczÃÂ zmian kryteriÃÂ³w wieku odnaÃÂnie etapÃÂ³w
							rekrutacji. </b>
					</p>
					<p class="text-ogloszenie">
						<span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span><span
							style="color: rgba(76, 158, 217, 0.83);"> regulamin.pdf</span> <br />
						<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
						kolardia@gmail.com
					</p>

				</div>
				<p
					style="color: rgb(128, 125, 125); text-align: right; margin-right: 10px;">
					czytaj wiÃÂcej...</p>
			</div>
		</div>
		<div class="col-sm-6 col-md-3">
			<div class="thumbnail ogloszenie">
				<p class="text-ogloszenie text-center"
					style="color: rgb(128, 125, 125); margin-top: 10px">Zmiana
					regulaminu konkursu</p>
				<div class="thumbnail">
					<p class="text-ogloszenie">
						<b>ProszÃÂ zapoznaÃÂ siÃÂ z nowym regulaminem, wytyczne
							dotyczÃÂ zmian kryteriÃÂ³w wieku odnaÃÂnie etapÃÂ³w
							rekrutacji. </b>
					</p>
					<p class="text-ogloszenie">
						<span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span><span
							style="color: rgba(76, 158, 217, 0.83);"> regulamin.pdf</span> <br />
						<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
						kolardia@gmail.com
					</p>

				</div>
				<p
					style="color: rgb(128, 125, 125); text-align: right; margin-right: 10px;">
					czytaj wiÃÂcej...</p>
			</div>
		</div>
		<div class="col-sm-6 col-md-3">
			<div class="thumbnail ogloszenie">
				<p class="text-ogloszenie text-center"
					style="color: rgb(128, 125, 125); margin-top: 10px">Zmiana
					regulaminu konkursu</p>
				<div class="thumbnail">
					<p class="text-ogloszenie">
						<b>ProszÃÂ zapoznaÃÂ siÃÂ z nowym regulaminem, wytyczne
							dotyczÃÂ zmian kryteriÃÂ³w wieku odnaÃÂnie etapÃÂ³w
							rekrutacji. </b>
					</p>
					<p class="text-ogloszenie">
						<span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span><span
							style="color: rgba(76, 158, 217, 0.83);"> regulamin.pdf</span> <br />
						<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
						kolardia@gmail.com
					</p>

				</div>
				<p
					style="color: rgb(128, 125, 125); text-align: right; margin-right: 10px;">
					czytaj wiÃÂcej...</p>
			</div>
		</div>
	</div>
</body>