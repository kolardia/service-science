<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

</head>
<spring:message code="admin.service.help.title" var="title" />
<spring:message code="admin.service.help.introduction"
	var="introduction" />
<spring:message code="admin.service.help.subtitle" var="subtitle" />

<spring:message code="admin.service.help.section" var="section" />
<spring:message code="admin.service.help.description.section"
	var="descriptionSection" />

<spring:message code="admin.service.help.news" var="news" />
<spring:message code="admin.service.help.description.news"
	var="descriptionNews" />

<spring:message code="admin.service.help.resources" var="resources" />
<spring:message code="admin.service.help.description.resources"
	var="descriptionResources" />

<spring:message code="admin.service.help.base.adrress" var="baseAdrress" />
<spring:message code="admin.service.help.description.base.adrress"
	var="descriptionBaseAdrress" />

<spring:message code="admin.service.help.cooperation" var="cooperation" />
<spring:message code="admin.service.help.description.cooperation"
	var="descriptionCooperation" />


<body>
	<div role="tabpanel" class="tab-pane HelpPage">
		<div class="row EHInitialField">
			<div class="col-md-6">
				<h4 class="HTitle">
					<span id="SHBtnBack"
						class="glyphicon glyphicon-arrow-left HBtnBack" aria-hidden="true"></span>
					<b> ${title}</b>
				</h4>
			</div>
			<div class="col-md-3 pull-right text-center HInstructionBox">
				<a><span class="glyphicon glyphicon-floppy-save"
					aria-hidden="true">Instrukcja.pdf</span></a>
			</div>
		</div>

		<p>${introduction}</p>
		<p>
			<b>${subtitle} </b>
		</p>
		<div class="list-group">
			<button type="button" class="list-group-item">

				<p>

					<b> ${section} </b> ${descriptionSection}
				</p>
			</button>
			<button type="button" class="list-group-item">
				<p>

					<b> ${news} </b> ${descriptionNews}
				</p>
			</button>
			<button type="button" class="list-group-item">
				<p>
					<b> ${cooperation} </b> ${descriptionCooperation}
				</p>
			</button>
			<button type="button" class="list-group-item">
				<p>
					<b> ${baseAdrress} </b> ${descriptionBaseAdrress}
				</p>
			</button>
		</div>

	</div>
</body>